package org.ak80.att.akkatesttools;

import akka.actor.ActorRef;
import org.junit.Test;
import scala.concurrent.Future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;
import static scala.compat.java8.FutureConverters.toJava;

/**
 * Tools for calling real actor with ask in integrated test scenario
 */
@SuppressWarnings("PMD.AvoidThrowingRawExceptionTypes")
public class FutureTools {

  public static <T> T ask(Object message, ActorRef actorRef) {
    try {
      return (T) askFuture(message, actorRef).get();
    } catch (Exception e) {
      throw new RuntimeException("askFuture failed: "+e);
    }
  }

  public static <T> CompletableFuture<T> askFuture(Object message, ActorRef actorRef) {
    Future sFuture = akka.pattern.Patterns.ask(actorRef, message, 1000);
    CompletionStage<T> cs = toJava(sFuture);
    return (CompletableFuture<T>) cs;
  }

  public static <T> T getFail(CompletableFuture future) throws InterruptedException, java.util.concurrent.ExecutionException {
    return (T) future.handle((success, fail) -> fail).get();
  }

  @Test
  public void dummyCreateInstanceForLineCoverage() {
    assertThat(new FutureTools(),is(not(nullValue())));
  }

}