package main.java;

import java.util.HashMap;

public class HashDictionary {

    // public attributes for testing
    public String name;
    public HashMap<String, HashMap<String, String>> hashmap;

    public HashDictionary(String n) {
        this.name = n;
        this.hashmap = new HashMap<>();
    }

    public String getDicName() {
        return this.name;
    }

    public String getHash(String word, String algorithm) {

        if (!this.hashmap.containsKey(word)) {
            throw new NullPointerException(String.format("Element (%s) doesn't exist in the dictionary.", word));
        }

        return this.hashmap.get(word).get(algorithm);
    }

    public void addHashEquivalence(String word, String algorithm, String hashValue) {

        if (word == null || hashValue == null) {
            throw new IllegalArgumentException("null value passed in argument.");
        }

        if (this.hashmap.containsKey(word)) {
            throw new IllegalArgumentException(String.format("The element (%s) already exists in the dictionary.", word));
        }

        //this.hashmap.put(word, hashValue);

    }


}
