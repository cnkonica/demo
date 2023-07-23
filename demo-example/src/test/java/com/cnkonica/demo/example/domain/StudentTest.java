package com.cnkonica.demo.example.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StudentTest {

    private Student studentUnderTest;

    @BeforeEach
    void setUp() {
        studentUnderTest = new Student();
    }

    @Test
    void testEquals() {
        assertThat(studentUnderTest.equals("o")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(studentUnderTest.hashCode()).isNotEqualTo(0);
    }
}
