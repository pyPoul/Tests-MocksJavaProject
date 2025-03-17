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

    /**
     * @return the name of the dictionary.
     */
    public String getDicName() {

        return this.name;
    }

    /**
     * Takes a value (word) and returns its equivalence hash given by the algorithm.
     * @param word The value to get equivalence hash.
     * @param algorithm Used algorithm to get the hash value.
     * @return The hash value of the word.
     * @throws IllegalArgumentException When a null value is passed as an argument.
     * @throws NullPointerException When the word doesn't exist in the dictionary.
     * @throws NullPointerException When the word doesn't have a hash equivalence with the algorithm.
     */
    public String getHash(String word, String algorithm) {

        // ignore null values
        if (word == null || algorithm == null) {
            throw new IllegalArgumentException("null value passed in argument.");
        }

        // word isn't in the dictionary
        if (!this.hashmap.containsKey(word)) {
            throw new NullPointerException(String.format("Element (%s) doesn't exist in the dictionary.", word));
        }

        // the algorithm isn't in the word's dictionary
        if (!this.hashmap.get(word).containsKey(algorithm)) {
            throw new NullPointerException(String.format("Element (%s) doesn't have an equivalent hash for the algorithm (%s).", word, algorithm));
        }

        // returns the hash value
        return this.hashmap.get(word).get(algorithm);
    }

    /**
     * Takes a value (word) and returns a hashmap of its equivalent hashes given by associated algorithm.
     * @param word The value to get equivalent hashes.
     * @return The hashmap of hashes associated to their algorithm of the word or null if there isn't.
     * @throws IllegalArgumentException When a null value is passed as an argument.
     */
    public HashMap<String, String> getAllHashes(String word) {

        // ignore null value
        if (word == null) {
            throw new IllegalArgumentException("null value passed in argument.");
        }

        // returns the hashmap
        return this.hashmap.get(word);
    }

    /**
     * Takes a hash value and returns its clear equivalence
     * @param hashValue The value to get clear equivalence
     * @return The clear equivalence or null if there isn't.
     * @throws IllegalArgumentException When a null value is passed as an argument.
     */
    public String getWord(String hashValue) {

        if (hashValue == null) {
            throw new IllegalArgumentException("null value passed in argument.");
        }

        for (String word: this.hashmap.keySet()) {
            if (this.hashmap.get(word).containsValue(hashValue)) {
                return word;
            }
        }
        return null;
    }

    /**
     * Add a word to the dictionary with an algorithm and its equivalent hash.
     * @param word The value to add.
     * @param algorithm The algorithm to add.
     * @param hashValue The hash equivalent of the word using the algorithm.
     * @throws IllegalArgumentException When a null value is passed as an argument.
     * @throws IllegalArgumentException When the algorithm is already in the word's dictionary.
     */
    public void addHashEquivalence(String word, String algorithm, String hashValue) {

        // ignore null values
        if (word == null || algorithm == null || hashValue == null) {
            throw new IllegalArgumentException("null value passed in argument.");
        }

        // add word to the dictionary if isn't in
        HashMap<String, String> hm = this.hashmap.get(word);
        if (hm == null) {
            hm = new HashMap<>();
        }

        // check if the algorithm already exists for this word
        if (hm.containsKey(algorithm)) {
            throw new IllegalArgumentException(String.format("The hash value of the word (%s) for the algorithm (%s) already exists in the dictionary.", word, algorithm));
        }

        // associates the algorithm with the hash value
        hm.put(algorithm, hashValue);

        // associates the word with its hash equivalent
        this.hashmap.put(word, hm);
    }

}
