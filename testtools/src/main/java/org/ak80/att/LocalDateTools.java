package org.ak80.att;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

/**
 * Tools for LocalDate(Time)
 */
public class LocalDateTools {

  public static LocalDate $Today() {
    return LocalDate.now();
  }

  public static LocalDate $Yesterday() {
    return LocalDate.now().minus(1, ChronoUnit.DAYS);
  }

  public static LocalDate $Tomorrow() {
    return LocalDate.now().plus(1, ChronoUnit.DAYS);
  }

}
