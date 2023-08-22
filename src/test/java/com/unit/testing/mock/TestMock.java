package com.unit.testing.mock;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TestMock {
    
    @Test
    void mockTest() {
        List<String> list = Mockito.mock(List.class);

        Mockito.when(list.get(0)).thenReturn("dedi");
        Mockito.when(list.get(100)).thenReturn("Azmi");

        System.out.println(list.get(0));
        System.out.println(list.get(100));

        Mockito.verify(list, Mockito.times(1)).get(0);
    }
}
