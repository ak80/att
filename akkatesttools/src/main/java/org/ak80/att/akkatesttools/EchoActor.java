package org.ak80.att.akkatesttools;

import akka.actor.AbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.pf.ReceiveBuilder;
import scala.PartialFunction;
import scala.runtime.BoxedUnit;

/**
 * Echo the received message to the sender
 */
public class EchoActor extends AbstractActor {

  private LoggingAdapter log = Logging.getLogger(this);

  @Override
  public PartialFunction<Object, BoxedUnit> receive() {
    return ReceiveBuilder.matchAny(this::reply).build();
  }

  private void reply(Object msg) {
    log.info("received: {}", msg);
    sender().tell(msg, self());
  }

}