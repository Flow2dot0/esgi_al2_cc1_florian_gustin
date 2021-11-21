package com.amazen.core.entities;

import com.amazen.core.exceptions.ExceptionUtils;
import com.amazen.core.exceptions.ValueObjectException;
import com.amazen.core.interfaces.UniqueIdObject;
import com.amazen.core.value_objects.ValueObjectAbstract;
import com.amazen.core.value_objects.ValueObjectFactory;

import java.util.Random;

public class UniqueId implements UniqueIdObject {

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
