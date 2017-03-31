package org.ak80.att.akkatesttools;

import akka.actor.ActorRef;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;

/**
 * Tools for calling real actor with ask in integrated test scenario
 */
@SuppressWarnings("PMD.AvoidThrowingRawExceptionTypes")
public class FutureTools {

  /**
   * Send message and wait for result
   *
   * @param message  the message to send
   * @param actorRef the actor to send message to
   * @param <T>      the type of the reply
   * @return the reply
   */
  public static <T> T ask(Object message, ActorRef actorRef) {
    try {
      return (T) askFuture(message, actorRef).get();
    } catch (Exception e) {
      throw new RuntimeException("askFuture failed: " + e);
    }
  }

  /**
   * Send message and get future for result
   *
   * @param message  the message to send
   * @param actorRef the actor to send message to
   * @param <T>      the type of the reply
   * @return the future
   */
  public static <T> CompletableFuture<T> askFuture(Object message, ActorRef actorRef) {
    CompletionStage<Object> completionStage = akka.pattern.PatternsCS.ask(actorRef, message, 1000);
    return (CompletableFuture<T>) completionStage;
  }

  /**
   * Send message and wait for result
   *
   * @param message  the message to send
   * @param actorRef the actor to send message to
   * @param <T>      the type of the reply
   * @return the reply
   */
  public static <T> T askReply(Object message, ActorRef actorRef) {
    try {
      return (T) askFuture(message, actorRef).get();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    } catch (ExecutionException e) {
      throw new RuntimeException(e);
    }
  }


  public static <T> T getFail(CompletableFuture future) throws InterruptedException, java.util.concurrent.ExecutionException {
    return (T) future.handle((success, fail) -> fail).get();
  }

}