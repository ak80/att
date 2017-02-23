package org.ak80.att;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.ak80.att.CollectionTools.*;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;


public class CollectionToolsTest {

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
  public void dummyCreateInstanceForLineCoverage() {
    assertThat(new CollectionTools(), is(not(nullValue())));
  }

}