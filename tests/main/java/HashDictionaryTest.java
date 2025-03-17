package main.java;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;


public class HashDictionaryTest {

    String WORD = "bonjour";
    String SHA3_512 = "sha3_512";
    String SHA1 = "sha1";
    String SHA3_512_VALUE = "fba980ee3cbd5d2c9d308dd8047577232f5e9508f7b3767730a3429634bb5950026829c7c038b5fb070ea90dae22c88416aae14c98fb7bc261def5984a9a7bdd";
    String SHA1_VALUE = "1f71e0f4ac9b47cd93bf269e4017abaab9d3bd63";

    String dName = "dictionary name";
    HashDictionary d;

    @BeforeEach
    void setUp() {

        d = new HashDictionary(dName);
    }

    @Test
    void constructorTest() {

        // instance exists
        assertNotNull(d);
        // dic has a name
        assertEquals(dName, d.name);
        // dic hashmap extists
        assertNotNull(d.hashmap);
        // dic is empty
        assertEquals(0, d.hashmap.size());
    }

    @Test
    void getDicNameTest() {
        assertEquals(dName, d.getDicName());
    }

    @Test
    void addHashEquivalenceTest() {

        // dic is empty
        assertEquals(0, d.hashmap.size());

        d.addHashEquivalence(WORD, SHA3_512, SHA3_512_VALUE);

        // dic has 1 element (element successfully added)
        assertEquals(1, d.hashmap.size());
        // word's dic has 1 element
        assertEquals(1, d.hashmap.get(WORD).size());

        d.addHashEquivalence(WORD, SHA1, SHA1_VALUE);

        // dic has still 1 element
        assertEquals(1, d.hashmap.size());
        // word's dic has 2 element
        assertEquals(2, d.hashmap.get(WORD).size());

        // hash already exists
        try {
            d.addHashEquivalence(WORD, SHA3_512, SHA3_512_VALUE);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals(
                    String.format("The hash value of the word (%s) for the algorithm (%s) already exists in the dictionary.", WORD, SHA3_512),
                    e.getMessage()
            );
        }

        // null passed as an argument
        try {
            d.addHashEquivalence("stringTest1", "stringTest2", null);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("null value passed in argument.", e.getMessage());
        }
        try {
            d.addHashEquivalence(null, "stringTest3", "stringTest4");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("null value passed in argument.", e.getMessage());
        }
        try {
            d.addHashEquivalence("stringTest5", null, "stringTest6");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("null value passed in argument.", e.getMessage());
        }try {
            d.addHashEquivalence(null, null, "stringTest7");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("null value passed in argument.", e.getMessage());
        }
        try {
            d.addHashEquivalence("stringTest8", null, null);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("null value passed in argument.", e.getMessage());
        }
        try {
            d.addHashEquivalence(null, "stringTest9", null);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("null value passed in argument.", e.getMessage());
        }
        try {
            d.addHashEquivalence(null, null, null);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("null value passed in argument.", e.getMessage());
        }
    }

    @Test
    void getHashTest() {

        d.addHashEquivalence(WORD, SHA3_512, SHA3_512_VALUE);

        String randomStr = "kjrhgnvq";

        // get element
        assertEquals(SHA3_512_VALUE, d.getHash(WORD, SHA3_512));

        // element doesn't exist
        try {
            d.getHash(randomStr, SHA1);
            fail();
        } catch (NullPointerException e) {
            assertEquals(String.format("Element (%s) doesn't exist in the dictionary.", randomStr), e.getMessage());
        }

        // element exists but not the algorithm
        try {
            d.getHash(WORD, SHA1);
            fail();
        } catch (NullPointerException e) {
            assertEquals(String.format("Element (%s) doesn't have an equivalent hash for the algorithm (%s)", WORD, SHA1), e.getMessage());
        }

        // null passed as an argument
        try {
            d.getHash("stringTest1", null);
            fail();
        } catch (NullPointerException e) {
            assertEquals("null value passed in argument.", e.getMessage());
        }
        try {
            d.getHash(null, "stringTest2");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("null value passed in argument.", e.getMessage());
        }
        try {
            d.getHash(null, null);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("null value passed in argument.", e.getMessage());
        }
    }

}