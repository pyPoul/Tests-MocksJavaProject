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

        if (word == null || algorithm == null) {
            throw new IllegalArgumentException("null value passed in argument.");
        }

        if (!this.hashmap.containsKey(word)) {
            throw new NullPointerException(String.format("Element (%s) doesn't exist in the dictionary.", word));
        }

        if (!this.hashmap.get(word).containsKey(algorithm)) {
            throw new NullPointerException(String.format("Element (%s) doesn't have an equivalent hash for the algorithm (%s).", word, algorithm));
        }

        return this.hashmap.get(word).get(algorithm);
    }

    public HashMap<String, String> getAllHashes(String word) {

        return this.hashmap.get(word);
    }

    public void addHashEquivalence(String word, String algorithm, String hashValue) {

        if (word == null || algorithm == null || hashValue == null) {
            throw new IllegalArgumentException("null value passed in argument.");
        }

        HashMap<String, String> hm = this.hashmap.get(word);
        if (hm == null) {
            hm = new HashMap<>();
        }

        if (hm.containsKey(algorithm)) {
            throw new IllegalArgumentException(String.format("The hash value of the word (%s) for the algorithm (%s) already exists in the dictionary.", word, algorithm));
        }

        hm.put(algorithm, hashValue);

        this.hashmap.put(word, hm);

    }


}
