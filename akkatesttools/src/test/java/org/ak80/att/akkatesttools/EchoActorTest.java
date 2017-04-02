package org.ak80.att.akkatesttools;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.testkit.JavaTestKit;
import akka.testkit.TestActorRef;
import org.junit.Test;

public class EchoActorTest extends AkkaTest {

  private final JavaTestKit probe = new JavaTestKit(actorSystem);
  private final ActorRef replyReceiver = probe.getTestActor();

  @Test
  public void receive_any_Message_return_to_sender() {
    // Given
    TestActorRef<EchoActor> actorRef = TestActorRef.create(actorSystem, Props.create(EchoActor.class));

    // When
    actorRef.tell("message", replyReceiver);

    // Then
    probe.expectMsgEquals("message");
  }

}