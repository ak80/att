package org.ak80.att;

import java.util.concurrent.atomic.AtomicInteger;

import static org.ak80.att.BuilderDsl.an;

/**
 * Test Data Factories for (unique) values
 */
public class ValueTdf {

  private static int SAFE_STARTING_POINT_TO_AVOID_CACHED_EQUALITY = 128 + 1;

  private static AtomicInteger uniqueInt = new AtomicInteger(SAFE_STARTING_POINT_TO_AVOID_CACHED_EQUALITY);

  public static Builder<Integer> $Integer() {
    return () -> uniqueInt.getAndIncrement();
  }

  public static Builder<Integer> $Id() {
    return $Integer();
  }

  public static Builder<String> $Name() {
    return () -> "Name_" + an($Integer());
  }

  public static Builder<String> $String() {
    return () -> "String_" + an($Integer());
  }

}
