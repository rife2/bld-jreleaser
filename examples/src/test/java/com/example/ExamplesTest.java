package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExamplesTest {
    @Test
    void verifyHello() {
        assertEquals("Hello World!", new Examples().getMessage());
    }
}
