package org.ak80.att;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Utilities supporting the use of collections
 */
public class CollectionTools {

  private final static Random random = new Random();

  public static <T> T any(List<T> list) {
    return list.get(random.nextInt(list.size()));
  }

  public static <T> T any(T ... array) {
    return array[random.nextInt(array.length)];
  }

  public static <T> T anyExcept(List<T> list, Collection<T> exceptionCollection) {
    return any(filterList(list,item -> !exceptionCollection.contains(item)));
  }

  public static <T> List<T> filterList(List<T> list, Predicate<T> predicate) {
    return list.stream()
        .filter(predicate)
        .collect(Collectors.toList());
  }

  public static <T> List<T> listOf(T ... array) {
    return Arrays.asList(array);
  }

  public static <T> Set<T> setOf(T ... array) {
    return new HashSet<T>(listOf(array));
  }

}
