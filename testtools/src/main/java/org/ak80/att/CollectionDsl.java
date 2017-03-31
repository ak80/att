package org.ak80.att;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static org.ak80.att.BuilderDsl.a;

/**
 * DSL supporting the use of collections
 */
public class CollectionDsl {

  private final static Random random = new Random();

  public static <T> T any(List<T> list) {
    return list.get(random.nextInt(list.size()));
  }

  public static <T> T any(T... array) {
    return array[random.nextInt(array.length)];
  }

  public static <T> T anyExcept(List<T> list, Collection<T> exceptionCollection) {
    return any(filterList(list, item -> !exceptionCollection.contains(item)));
  }

  public static <T> List<T> filterList(List<T> list, Predicate<T> predicate) {
    return list.stream()
        .filter(predicate)
        .collect(Collectors.toList());
  }

  public static <T> List<T> listOf(T... array) {
    return Arrays.asList(array);
  }

  public static <T> Set<T> setOf(T... array) {
    return new HashSet<>(listOf(array));
  }

  public static <T> List<T> $listOf(int count, Builder<T> $builder) {
    List<T> list = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      list.add(a($builder));
    }
    return list;
  }

  public static <T> Set<T> $setOf(int count, Builder<T> $builder) {
    Set<T> set = new HashSet<>();
    for (int i = 0; i < count; i++) {
      set.add(a($builder));
    }
    return set;
  }

  public static <T> List<T> listOfSupplied(int count, Supplier<T> supplier) {
    List<T> list = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      list.add(supplier.get());
    }
    return list;
  }

  public static <T> Set<T> setOfSupplied(int count, Supplier<T> supplier) {
    return new HashSet<>(listOfSupplied(count, supplier));
  }

}
