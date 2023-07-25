package com.cnkonica.demo.example.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Student1Test {

    private Student1 student1UnderTest;

    @BeforeEach
    void setUp() {
        student1UnderTest = new Student1();
    }

    @Test
    void testEquals() {
        assertThat(student1UnderTest.equals("o")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(student1UnderTest.hashCode()).isNotEqualTo(0);
    }
}
