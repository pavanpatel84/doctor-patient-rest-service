package com.doctorpatient.exception;

public class EntityNotFoundException extends EntityException {

    public EntityNotFoundException(Class clazz, String... searchParamsMap) {
        super(clazz, " was not found for parameters ", searchParamsMap);
    }
}
