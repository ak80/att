package org.ak80.att.akkatesttools;

import akka.actor.ActorSystem;
import akka.testkit.JavaTestKit;
import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 * Base class for using Akka, with a
 */
public class AkkaTest {

  protected static ActorSystem actorSystem;

  @BeforeClass
  public static void createActorSystem() {
    actorSystem = ActorSystem.create();
  }

  @AfterClass
  public static void shutdownActorSystem() {
    JavaTestKit.shutdownActorSystem(actorSystem);
    actorSystem = null;
  }

}
