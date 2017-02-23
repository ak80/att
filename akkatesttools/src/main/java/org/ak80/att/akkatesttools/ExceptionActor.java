package org.ak80.att.akkatesttools;

import akka.actor.AbstractActor;
import akka.actor.Status;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.pf.ReceiveBuilder;
import scala.PartialFunction;
import scala.runtime.BoxedUnit;

/**
 * Exception with the received message
 */
public class ExceptionActor extends AbstractActor {

  private LoggingAdapter log = Logging.getLogger(this);

  @Override
  public PartialFunction<Object, BoxedUnit> receive() {
    return ReceiveBuilder.matchAny(this::fail)
        .build();
  }

  private void fail(Object msg) {
    log.error("fail: {}", msg);
    sender().tell(new Status.Failure(new Exception(msg.toString())), self());
    throw new RuntimeException(msg.toString());
  }

}