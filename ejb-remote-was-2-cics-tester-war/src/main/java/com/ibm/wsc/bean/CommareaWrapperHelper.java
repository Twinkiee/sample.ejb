package com.ibm.wsc.bean;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CommareaWrapperHelper {

  @SuppressWarnings("unchecked")
  public <T> T getValue(Map<String, Object> inputMap, String mapKey, Class<T> clazz) {
    final Object o = inputMap.get(mapKey);
    if (o != null) {
      return (T) o;
    }

    if (Objects.equals(clazz, String.class)) {
      return (T) " ";
    }

    if (Objects.equals(clazz, Integer.class)) {
      return (T) Integer.valueOf(0);
    }

    if (Objects.equals(clazz, BigDecimal.class)) {
      return (T) BigDecimal.ZERO;
    }

    if (Objects.equals(clazz, Long.class)) {
      return (T) Long.valueOf(0L);
    }

    throw new IllegalStateException("Unhandled class " + clazz);
  }
}
