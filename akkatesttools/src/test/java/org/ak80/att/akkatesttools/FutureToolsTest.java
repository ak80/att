package org.ak80.att.akkatesttools;

import akka.actor.ActorRef;
import akka.actor.Props;
import org.hamcrest.core.Is;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.concurrent.CompletableFuture;

import static org.ak80.att.akkatesttools.FutureTools.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class FutureToolsTest extends AkkaTest {

  @Rule
  public ExpectedException expectedException = ExpectedException.none();

  @Test
  public void ask_reply_from_echo_actor_then_reply_is_message() {
    // Given
    ActorRef actorRef = system.actorOf(Props.create(EchoActor.class));
    String message = "message";

    // When
    String reply = FutureTools.ask(message, actorRef);

    // Then
    assertThat(reply, is(message));
  }

  @Test
  public void ask_with_exception_then_runtime_exception() {
    // Given
    ActorRef actorRef = spy(system.actorOf(Props.create(EchoActor.class)));
    doThrow(new IllegalStateException("failed")).when(actorRef).tell(eq("message"), any());

    // Expect
    expectedException.expect(RuntimeException.class);
    expectedException.expectMessage("askFuture failed: java.lang.IllegalStateException: failed");

    // When
    FutureTools.ask("message", actorRef);
  }

  @Test
  public void ask_from_actor_then_future_has_reply() throws Exception {
    // Given
    ActorRef actorRef = system.actorOf(Props.create(EchoActor.class));
    String message = "message";

    // When
    CompletableFuture future = askFuture(message, actorRef);

    // Then
    assertThat(future.get(), is(message));
  }

  @Test
  public void ask_reply_from_actor_then_has_reply() throws Exception {
    // Given
    ActorRef actorRef = system.actorOf(Props.create(EchoActor.class));
    String message = "message";

    // When
    String replyMessage = askReply(message, actorRef);

    // Then
    assertThat(replyMessage, is(message));
  }

  @Test
  public void get_fail_from_failed_ask_then_has_exception() throws Exception {
    // Given
    ActorRef actorRef = system.actorOf(Props.create(ExceptionActor.class));
    String message = "message";

    // When
    CompletableFuture future = askFuture(message, actorRef);

    // Then
    Exception failure = getFail(future);
    assertThat(failure.getMessage(), is(message));
  }

  @Test
  public void dummyCreateInstanceForLineCoverage() {
    assertThat(new FutureTools(), Is.is(not(nullValue())));
  }

}