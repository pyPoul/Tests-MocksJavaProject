package main.java;

import java.util.HashMap;

public class HashDictionary {

    // public attributes for testing
    public String name;
    public HashMap<String, String> hashmap;

    public HashDictionary(String n) {
        this.name = n;
        this.hashmap = new HashMap<>();
    }

    public String getDicName() {
        return this.name;
    }

    public String getHash(String word) {

        return this.hashmap.get(word);
    }

    public void addHashEquivalence(String word, String sha3_512) {

        if (word == null || sha3_512 == null) {
            throw new IllegalArgumentException("null value passed in argument.");
        }

        if (this.hashmap.containsKey(word)) {
            throw new IllegalArgumentException(String.format("The element (%s) already exists in the dictionary.", word));
        }

        this.hashmap.put(word, sha3_512);

    }


}
