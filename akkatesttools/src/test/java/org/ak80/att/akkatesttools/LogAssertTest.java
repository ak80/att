package org.ak80.att.akkatesttools;

import akka.actor.ActorKilledException;
import akka.actor.ActorRef;
import akka.actor.Kill;
import akka.actor.Props;
import org.junit.Test;

public class LogAssertTest extends AkkaTest {

  @Test
  public void assertLogInfo_then_send_message_and_assert() {
    // Given
    ActorRef actorRef = system.actorOf(Props.create(EchoActor.class));
    LogAssert logAssert = new LogAssert(system);
    String message = "message";

    // When
    logAssert.whenTell(actorRef, message);

    // Then
    logAssert.thenAssertLogInfo("received: " + message);
  }

  @Test
  public void assertException_then_send_message_and_assert() {
    // Given
    ActorRef actorRef = system.actorOf(Props.create(EchoActor.class));
    LogAssert logAssert = new LogAssert(system);

    // When
    logAssert.whenTell(actorRef, Kill.getInstance());

    // Then
    logAssert.thenAssertException(ActorKilledException.class);
  }
}