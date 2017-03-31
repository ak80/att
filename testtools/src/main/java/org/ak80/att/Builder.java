package org.ak80.att;

/**
 * Common interface for a builder
 */
public interface Builder<T> {

  /**
   * Builds instance with values from builder
   *
   * @return the instance
   */
  T build();

}
