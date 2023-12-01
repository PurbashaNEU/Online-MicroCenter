package com.neu.factory_pattern;

import com.neu.builder_pattern.*;

//Defines a general interface for creating objects.
public abstract class AbstractFactory<T> {
    //Takes in a parameter of type 'BuilderAPI<T>' then return an object of type 'T'.
    public abstract T getObject(BuilderAPI<T> builder);
}
