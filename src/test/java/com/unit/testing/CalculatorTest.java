package com.unit.testing;

import org.junit.jupiter.api.Test;
import org.opentest4j.TestAbortedException;

import com.unit.testing.generator.SimpleDisplayNameGenerator;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayNameGeneration;

// import org.junit.jupiter.api.DisplayName;

@DisplayNameGeneration(SimpleDisplayNameGenerator.class)
// @DisplayName("Unit Test Class Calculator")
public class CalculatorTest {
    private Calculator calculator = new Calculator();

    @BeforeAll
    public static void beforeAll(){
        System.out.println("Before All");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("After All");
    }

    @BeforeEach
    public void setUp() {
        System.out.println("Setup");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Tear Down");
    }

    @Test
    // @DisplayName("Success skenario method add(integer, integer)")
    public void testAddSuccess() {
        Integer result = calculator.add(20, 10);

        // if (result != 30) {
        //     throw new RuntimeException("Test add gagal");
        // }

        assertEquals(30, result);
    }

    @Test
    // @DisplayName("Success skenario method divide(integer, integer)")
    public void testDivideSuccess() {
        assertEquals(10, calculator.divide(100, 10));
    }

    @Test
    @Disabled
    // @DisplayName("Failed skenario method divide(integer, integer)")
    public void testDivideFailed() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(100, 0);
        });
    }

    @Test
    public void testAborted() {
        String profile = System.getenv("PROFILE");
        if (!"DEV".equals(profile)) {
            throw new TestAbortedException("Profile is not DEV");
        }

        // unit test akan dilanjutkan
        System.out.println("Sukses not aborted");
    }

    @Test
    public void testAssumptions() {
        assumeTrue("DEV".equals(System.getenv("PROFILE")));

        // unit test akan dilanjutkan
        System.out.println("test assume");
    }

}
