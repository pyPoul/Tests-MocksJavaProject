package main.java;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class HashDictionaryTest {

    String dName = "dictionary name";
    HashDictionary d;

    @BeforeEach
    void setUp() {

        d = new HashDictionary(dName);
    }

    @Test
    void constructorTest() {
        assertNotNull(d);
    }

    @Test
    void getDicNameTest() {
        assertEquals(dName, d.getDicName());
    }
}