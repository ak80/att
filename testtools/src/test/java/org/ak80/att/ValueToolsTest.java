package org.ak80.att;

import org.junit.Test;

import static org.ak80.att.ValueTools.$Id;
import static org.ak80.att.ValueTools.$Integer;
import static org.ak80.att.ValueTools.$Name;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;


public class ValueToolsTest {

  @Test
  public void integer_get_increments() {
    // Given
    Integer integer = $Integer();

    // When Then
    assertThat($Integer(),is(integer+1));
  }

  @Test
  public void id_get_incrementsFromInteger() {
    // Given
    Integer integer = $Integer();

    // When Then
    assertThat($Id(),is(integer+1));
  }

  @Test
  public void name_get_incrementsFromInteger() {
    // Given
    Integer integer = $Integer();

    // When Then
    assertThat($Name(),is("Name_"+(integer+1)));
  }

  @Test
  public void dummyCreateInstanceForLineCoverage() {
    assertThat(new ValueTools(),is(not(nullValue())));
  }

}