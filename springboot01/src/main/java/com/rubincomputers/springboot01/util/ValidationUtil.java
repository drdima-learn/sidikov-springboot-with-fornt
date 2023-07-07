package com.rubincomputers.springboot01.util;

import org.springframework.core.NestedExceptionUtils;
import org.springframework.lang.NonNull;

public class ValidationUtil {
    @NonNull
    public static Throwable getRootCause(@NonNull Throwable t) {
        Throwable rootCause = NestedExceptionUtils.getRootCause(t);
        return rootCause != null ? rootCause : t;
    }
}
