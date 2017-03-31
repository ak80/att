package org.ak80.att;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * DSL supporting the use of {@link Builder}s
 */
public class BuilderDsl {

  public static <T> T a(Builder<T> builder) {
    return builder.build();
  }

  public static <T> T an(Builder<T> builder) {
    return builder.build();
  }

  public static <T> List<T> all(List<Builder<T>> builderList) {
    return builderList.stream()
        .map(builder -> builder.build())
        .collect(Collectors.toList());
  }

  public static <T> List<T> all(Builder<T>... builders) {
    return Arrays.stream(builders)
        .map(builder -> builder.build())
        .collect(Collectors.toList());
  }

  public static int few() {
    return 3;
  }

  public static int several() {
    return 10;
  }

  public static int many() {
    return 100;
  }

}
