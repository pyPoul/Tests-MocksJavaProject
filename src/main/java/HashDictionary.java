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
        return "";
    }

    public void addHashEquivalence(String word, String sha3_512) {

        this.hashmap.put(word, sha3_512);

    }


}
