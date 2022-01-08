package com.amazen._old._core.marshaller.deserialization;

import java.util.function.Function;

public interface DeserializationEngine<T> extends Function<String, T> {
}
