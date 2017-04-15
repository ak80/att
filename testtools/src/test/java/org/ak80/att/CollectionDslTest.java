package org.ak80.att;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import static org.ak80.att.BuilderDsl.*;
import static org.ak80.att.CollectionDsl.*;
import static org.ak80.att.ValueTdf.$Integer;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;


public class CollectionDslTest {

  @Test
  public void any_returns_a_random_item_from_list() {
    // Given
    List<Integer> list = Arrays.asList(0, 1, 2, 3);

    // When
    Set<Integer> returned = new HashSet<>();
    for (int i = 0; i < 100; i++) {
      Integer integer = any(list);
      assertThat(list, hasItem(integer));
      returned.add(integer);
    }
    assertThat(returned, containsInAnyOrder(list.toArray()));
  }

  @Test
  public void any_returns_a_random_item_from_array() {
    // Given
    Integer array[] = new Integer[]{0, 1, 2, 3};

    // When
    Set<Integer> returned = new HashSet<>();
    for (int i = 0; i < 100; i++) {
      Integer integer = any(array);
      assertThat(Arrays.asList(array), hasItem(integer));
      returned.add(integer);
    }

    // Then
    assertThat(returned, containsInAnyOrder(array));
  }

  @Test
  public void anyExcept_returns_a_random_item_from_list_but_not_the_except() {
    // Given
    List<Integer> list = Arrays.asList(0, 1, 2, 3);
    List<Integer> expectList = Arrays.asList(1);
    List<Integer> filteredList = Arrays.asList(0, 2, 3);

    // When
    Set<Integer> returned = new HashSet<>();
    for (int i = 0; i < 100; i++) {
      Integer integer = anyExcept(list, expectList);
      assertThat(filteredList, hasItem(integer));
      returned.add(integer);
    }

    // Then
    assertThat(returned, containsInAnyOrder(filteredList.toArray()));
  }

  @Test
  public void filterList_keeps_items_that_match_predicate() {
    // Given
    List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7);

    // When
    List<Integer> filteredList = filterList(list, i -> i % 2 == 0);

    // Then
    assertThat(filteredList, contains(0, 2, 4, 6));
  }

  @Test
  public void listOf_creates_list_from_array() {
    // Given
    Integer array[] = new Integer[]{0, 1, 2, 3};

    // When
    List<Integer> list = listOf(array);

    // Then
    assertThat(list, contains(array));
  }

  @Test
  public void setOf_creates_set_from_array() {
    // Given
    Integer array[] = new Integer[]{0, 1, 2, 3};

    // When
    Set<Integer> set = setOf(array);

    // Then
    assertThat(set, containsInAnyOrder(array));
  }

  @Test
  public void listOf_with_count_and_builder_creates_list() {
    // Given
    int start = an($Integer());

    // When
    List<Integer> list = $listOf(5, $Integer());

    // Then
    assertThat(list, contains(start + 1, start + 2, start + 3, start + 4, start + 5));
  }

  @Test
  public void listOf_with_concrete_class_cast_to_object_list() {
    // Given
    int start = an($Integer());

    // When
    List<Object> list = $listOf(5, $Integer());

    // Then
    assertThat(list, contains(start + 1, start + 2, start + 3, start + 4, start + 5));
  }

  @Test
  public void setOf_with_count_and_builder_creates_set() {
    // Given
    int start = an($Integer());

    // When
    Set<Integer> set = $setOf(5, $Integer());

    // Then
    assertThat(set, containsInAnyOrder(start + 1, start + 2, start + 3, start + 4, start + 5));
  }

  @Test
  public void setOf_with_concrete_class_cast_to_object_set() {
    // Given
    int start = an($Integer());

    // When
    Set<Object> set = $setOf(5, $Integer());

    // Then
    assertThat(set, containsInAnyOrder(start + 1, start + 2, start + 3, start + 4, start + 5));
  }

  @Test
  public void listOfSupplied_creates_list_from_supplier() {
    // Given
    AtomicInteger integer = new AtomicInteger(0);

    // When
    List<Integer> list = listOfSupplied(5, () -> integer.getAndIncrement());

    // Then
    assertThat(list, contains(0, 1, 2, 3, 4));
  }

  @Test
  public void listOfSupplied_concrete_creates_list_for_object() {
    // Given
    AtomicInteger integer = new AtomicInteger(0);

    // When
    List<Object> list = listOfSupplied(5, () -> integer.getAndIncrement());

    // Then
    assertThat(list, contains(0, 1, 2, 3, 4));
  }

  @Test
  public void setOfSupplied_creates_set_from_supplier() {
    // Given
    AtomicInteger integer = new AtomicInteger(0);

    // When
    Set<Integer> set = setOfSupplied(5, () -> integer.getAndIncrement());

    // Then
    assertThat(set, contains(0, 1, 2, 3, 4));
  }

  @Test
  public void setOfSupplied_concrete_creates_set_for_object() {
    // Given
    AtomicInteger integer = new AtomicInteger(0);

    // When
    Set<Object> set = setOfSupplied(5, () -> integer.getAndIncrement());

    // Then
    assertThat(set, contains(0, 1, 2, 3, 4));
  }

  @Test
  public void few_return_few() {
    // Then
    assertThat(few(), is(3));
  }


  @Test
  public void several_return_several() {
    // Then
    assertThat(several(), is(10));
  }


  @Test
  public void many_return_many() {
    // Then
    assertThat(many(), is(100));
  }

  @Test
  public void dummyCreateInstanceForLineCoverage() {
    assertThat(new CollectionDsl(), is(not(nullValue())));
  }

}