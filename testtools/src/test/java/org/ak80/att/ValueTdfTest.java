package org.ak80.att;

import org.junit.Test;

import static org.ak80.att.BuilderDsl.a;
import static org.ak80.att.BuilderDsl.an;
import static org.ak80.att.ValueTdf.*;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;


public class ValueTdfTest {

  @Test
  public void integer_get_increments() {
    // Given
    Integer integer = an($Integer());

    // When Then
    assertThat(an($Integer()), is(integer + 1));
  }

  @Test
  public void id_get_incrementsFromInteger() {
    // Given
    Integer integer = an($Integer());

    // When Then
    assertThat(an($Id()), is(integer + 1));
  }

  @Test
  public void name_get_incrementsFromInteger() {
    // Given
    Integer integer = an($Integer());

    // When Then
    assertThat(a($Name()), is("Name_" + (integer + 1)));
  }

  @Test
  public void string_get_incrementsFromInteger() {
    // Given
    Integer integer = an($Integer());

    // When Then
    assertThat(an($String()), is("String_" + (integer + 1)));
  }

  @Test
  public void dummyCreateInstanceForLineCoverage() {
    assertThat(new ValueTdf(), is(not(nullValue())));
  }

}