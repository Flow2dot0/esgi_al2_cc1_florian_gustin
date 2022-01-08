package com.amazen._old._core.marshaller.deserialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;

public final class DeserializationEngineFactory {
    private DeserializationEngineFactory() {
        throw new AssertionError();
    }

    public static <T> DeserializationEngine<T> withJSONDeserialization(Class<T> classz, TypeAdapter<T> typeAdapter) {
        Gson gson = new GsonBuilder()
                .registerTypeHierarchyAdapter(classz, typeAdapter)
                .disableHtmlEscaping()
                .setPrettyPrinting()
                .create();
        return new JSONDeserializationEngine<>(gson);
    }
}
