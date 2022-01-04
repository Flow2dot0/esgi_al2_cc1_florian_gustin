package com.amazen._core.entities;

import com.amazen._core.exceptions.ExceptionUtils;
import com.amazen._core.exceptions.ValueObjectException;
import com.amazen._core.interfaces.ValueObjectId;
import com.amazen._core.value_objects.ValueObjectAbstract;
import com.amazen._core.value_objects.ValueObjectFactory;

import java.util.Random;

public class UniqueId implements ValueObjectId {

    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    private Integer id;

    private UniqueId(int id) {
        this.id = id;
    }

    public static UniqueId withId(int id) throws ValueObjectException {
        ValueObjectAbstract<Integer> valueObject = ValueObjectFactory.withIdValidator(id);
        if(valueObject.isValid()){
            return new UniqueId(valueObject.get());
        }
        throw valueObject.createException(ExceptionUtils.ID);
    }

    public static UniqueId randomId() {
        return new UniqueId(new Random().nextInt(1000));
    }

}
