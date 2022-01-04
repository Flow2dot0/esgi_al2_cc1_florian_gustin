package com.amazen._core.marshaller.serialization;

import java.util.function.Function;

public interface SerializationEngine<T> extends Function<T, String> {
}
