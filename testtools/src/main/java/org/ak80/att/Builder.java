package org.ak80.att;

/**
 * Common interface for a builder
 */
public interface Builder<T> {

  /**
   * Builds instance with values from builder
   * @param <T> the type of the instance
   * @return the instance
   */
  <T> T build();

}
