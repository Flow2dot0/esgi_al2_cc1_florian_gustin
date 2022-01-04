package com.amazen._core.marshaller.deserialization;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Objects;

final class JSONDeserializationEngine<T> implements DeserializationEngine<T> {

    private final Gson gson;

    JSONDeserializationEngine(Gson gson) {
        this.gson = gson;
    }

    @Override
    public T apply(String s) {
        Objects.requireNonNull(s);
        Type typeToken = new TypeToken<T>() { }.getType();
        return gson.fromJson(s, typeToken);
    }
}
