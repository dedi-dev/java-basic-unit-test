package com.unit.testing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

public class ConditionTest {
    @Test
    @EnabledOnOs({OS.LINUX})
    public void testEnableOnOsLinux() {
        System.out.println("Enable Linux");
    }

    @Test
    @DisabledOnOs({OS.LINUX})
    public void testDisableOnOsLinux() {
        System.out.println("Disable Linux");
    }
}
