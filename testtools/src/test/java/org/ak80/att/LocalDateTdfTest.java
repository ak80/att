package org.ak80.att;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static org.ak80.att.LocalDateTdf.*;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;


public class LocalDateTdfTest {

  @Test
  public void today_returns_date_now() {
    assertThat(dateToday(), is(LocalDate.now()));
  }

  @Test
  public void yesterday_returns_date_now_minus_one() {
    assertThat(dateYesterday(), is(LocalDate.now().minus(1, ChronoUnit.DAYS)));
  }

  @Test
  public void tomorrow_returns_date_now_plus_one() {
    assertThat(dateTomorrow(), is(LocalDate.now().plus(1, ChronoUnit.DAYS)));
  }

  @Test
  public void dummyCreateInstanceForLineCoverage() {
    assertThat(new LocalDateTdf(), Is.is(not(nullValue())));
  }

}