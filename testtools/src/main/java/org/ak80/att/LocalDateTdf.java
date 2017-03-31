package org.ak80.att;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Test Data Factories for LocalDate(Time)
 */
public class LocalDateTdf {

  public static LocalDate dateToday() {
    return LocalDate.now();
  }

  public static LocalDate dateYesterday() {
    return LocalDate.now().minus(1, ChronoUnit.DAYS);
  }

  public static LocalDate dateTomorrow() {
    return LocalDate.now().plus(1, ChronoUnit.DAYS);
  }

}
