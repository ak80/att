package org.ak80.att;

import org.hamcrest.core.Is;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;


public class LocalDateToolsTest {

  @Test
  public void dummyCreateInstanceForLineCoverage() {
    assertThat(new LocalDateTools(), Is.is(not(nullValue())));
  }

}