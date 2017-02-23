package org.ak80.att;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Tools for (unique) values
 */
public class ValueTools {

  private static int SAFE_STARTING_POINT_TO_AVOID_CACHED_EQUALITY = 128 + 1;

  private static AtomicInteger uniqueInt = new AtomicInteger(SAFE_STARTING_POINT_TO_AVOID_CACHED_EQUALITY);

  public static Integer $Integer() {
    return uniqueInt.getAndIncrement();
  }

  public static Integer $Id() {
    return $Integer();
  }

  public static String $Name() {
    return "Name_"+ $Integer();
  }

}
