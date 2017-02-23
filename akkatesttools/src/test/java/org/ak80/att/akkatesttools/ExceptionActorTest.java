package org.ak80.att.akkatesttools;

import akka.actor.Props;
import akka.testkit.TestActorRef;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ExceptionActorTest extends AkkaTest {

  @Rule
  public ExpectedException expectException = ExpectedException.none();

  @Test
  public void receive_any_Message_return_to_sender() {
    // Given
    TestActorRef<ExceptionActor> actorRef = TestActorRef.create(system, Props.create(ExceptionActor.class));
    String message = "message";

    // Expect
    expectException.expect(RuntimeException.class);
    expectException.expectMessage(message);

    // When
    actorRef.receive(message);
  }

}