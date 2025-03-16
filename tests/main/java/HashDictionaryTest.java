package main.java;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class HashDictionaryTest {

    String dName = "dictionary name";
    HashDictionary d;

    String[] hash1 = new String[]{
            "bonjour",
            "fba980ee3cbd5d2c9d308dd8047577232f5e9508f7b3767730a3429634bb5950026829c7c038b5fb070ea90dae22c88416aae14c98fb7bc261def5984a9a7bdd"
    };

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

        d.addHashEquivalence(hash1[0], hash1[1]);

        // dic has 1 element (element successfully added)
        assertEquals(1, d.hashmap.size());

        // element already exists
        try {
            d.addHashEquivalence(hash1[0], hash1[1]);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals(String.format("The element (%s) already exists in the dictionary.", hash1[0]), e.getMessage());
        }

        // null passed as an argument
        try {
            d.addHashEquivalence("stringTest1", null);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("null value passed in argument.", e.getMessage());
        }
        try {
            d.addHashEquivalence(null, "stringTest2");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("null value passed in argument.", e.getMessage());
        }
        try {
            d.addHashEquivalence(null, null);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("null value passed in argument.", e.getMessage());
        }
    }

    @Test
    void getHashTest() {

        d.addHashEquivalence(hash1[0], hash1[1]);

        String randomStr = "kjrhgnvq";

        // get element
        assertEquals(hash1[1], d.getHash(hash1[0]));

        // element doesn't exist
        try {
            d.getHash(randomStr);
            fail();
        } catch (NullPointerException e) {
            assertEquals(String.format("Element (%s) doesn't exist in the dictionary.", randomStr), e.getMessage());
        }
        try {
            d.getHash(null);
            fail();
        } catch (NullPointerException e) {
            assertEquals(String.format("Element (%s) doesn't exist in the dictionary.", null), e.getMessage());
        }
    }

}