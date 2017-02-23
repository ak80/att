package org.ak80.att;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static org.ak80.att.LocalDateTools.$Today;
import static org.ak80.att.LocalDateTools.$Tomorrow;
import static org.ak80.att.LocalDateTools.$Yesterday;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;


public class LocalDateToolsTest {

  @Test
  public void today_returns_date_now() {
    assertThat($Today(),is(LocalDate.now()));
  }

  @Test
  public void yesterday_returns_date_now_minus_one() {
    assertThat($Yesterday(),is(LocalDate.now().minus(1, ChronoUnit.DAYS)));
  }

  @Test
  public void tomorrow_returns_date_now_plus_one() {
    assertThat($Tomorrow(),is(LocalDate.now().plus(1, ChronoUnit.DAYS)));
  }

  @Test
  public void dummyCreateInstanceForLineCoverage() {
    assertThat(new LocalDateTools(), Is.is(not(nullValue())));
  }

}