package org.ak80.att;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.ak80.att.BuilderTools.*;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

public class BuilderToolsTest {

  @Test
  public void a_builds_object() {
    // Given
    Builder<String> builder = getBuilder("test");

    // When Then
    assertThat(a(builder), is("test"));
  }

  @Test
  public void an_builds_object() {
    // Given
    Builder<String> builder = getBuilder("test");

    // When Then
    assertThat(an(builder), is("test"));
  }

  @Test
  public void all_from_list_builds_all_object() {
    // Given
    Builder<String> builder0 = getBuilder("test0");
    Builder<String> builder1 = getBuilder("test1");

    // When
    List<String> list = all(Arrays.asList(builder0, builder1));

    // Then
    assertThat(list, contains("test0", "test1"));
  }

  @Test
  public void all_from_array_builds_all_object() {
    // Given
    Builder<String> builder0 = getBuilder("test0");
    Builder<String> builder1 = getBuilder("test1");

    // When
    List<String> list = all(builder0, builder1);

    // Then
    assertThat(list, contains("test0", "test1"));
  }

  private <T> Builder<T> getBuilder(T object) {
    return new Builder<T>() {
      @Override
      public T build() {
        return object;
      }
    };
  }

  @Test
  public void dummyCreateInstanceForLineCoverage() {
    assertThat(new BuilderTools(), Is.is(not(nullValue())));
  }

}