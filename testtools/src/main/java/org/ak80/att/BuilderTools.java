package org.ak80.att;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Utilities supporting the use of {@link Builder}s
 */
public class BuilderTools {

  public static <T> T a(Builder<T> builder) {
    return builder.build();
  }

  public static <T> T an(Builder<T> builder) {
    return builder.build();
  }

  public static <T> List<T> all(List<Builder<T>> builderList) {
    return builderList.stream()
        .map(builder -> (T) builder.build())
        .collect(Collectors.toList());
  }

  public static <T> List<T> all(Builder<T>... builders) {
    return Arrays.stream(builders)
        .map(builder -> (T) builder.build())
        .collect(Collectors.toList());
  }

}
