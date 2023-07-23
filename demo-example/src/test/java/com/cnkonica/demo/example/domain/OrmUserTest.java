package com.cnkonica.demo.example.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OrmUserTest {

    private OrmUser ormUserUnderTest;

    @BeforeEach
    void setUp() {
        ormUserUnderTest = new OrmUser();
    }

    @Test
    void testEquals() {
        // Setup
        // Run the test
        final boolean result = ormUserUnderTest.equals("that");

        // Verify the results
        assertThat(result).isFalse();
    }

    @Test
    void testHashCode() {
        // Setup
        // Run the test
        final int result = ormUserUnderTest.hashCode();

        // Verify the results
        assertThat(result).isNotZero();
    }

    @Test
    void testToString() {
        // Setup
        // Run the test
        final String result = ormUserUnderTest.toString();

        // Verify the results
        assertThat(result).isNotBlank();
    }
}
