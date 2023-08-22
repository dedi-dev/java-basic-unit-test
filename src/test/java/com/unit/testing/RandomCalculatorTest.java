package com.unit.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;

import com.unit.testing.resolver.RandomParameterResolver;

@Extensions({
    @ExtendWith(RandomParameterResolver.class)
})
public class RandomCalculatorTest {
    private Calculator calculator = new Calculator();

    @Test
    void testRandomAdd(Random random){
        int a = random.nextInt();
        int b = random.nextInt();
        assertEquals(a+b, calculator.add(a, b));
    }
}
