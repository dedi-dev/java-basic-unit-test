package com.unit.testing.resolver;

import java.util.Random;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class RandomParameterResolver implements ParameterResolver{

    private Random random = new Random();

    @Override
    public Object resolveParameter(ParameterContext arg0, ExtensionContext arg1) throws ParameterResolutionException {
        return random;
    }

    @Override
    public boolean supportsParameter(ParameterContext arg0, ExtensionContext arg1) throws ParameterResolutionException {
        return arg0.getParameter().getType() == Random.class;
    }
    
}
