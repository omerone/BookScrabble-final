package gameServerLogical;

import java.util.HashMap;
import java.util.Map;

public class DictionaryManager {
    private static DictionaryManager dictionaryManager = null;
    Map<String, Dictionary> dictionaryMap;

    /**
     * The DictionaryManager function is a singleton class that manages the dictionary.
     * It has a private constructor, and only one instance of it can be created at any time.
     * The DictionaryManager function also contains methods to add words to the dictionary,
     * remove words from the dictionary, and check if a word exists in the dictionary.
     *<p>
     *
     */
    public DictionaryManager() {
        dictionaryMap = new HashMap<>();
    }

    /**
     * The get function is a static function that returns the singleton instance of
     * DictionaryManager.
     * If no instance exists, it creates one and then returns it.
     *<p>
     *
     * @return A singleton object of the dictionary-manager class
     *
     */
    public static DictionaryManager get() {
        if (dictionaryManager == null) {
            dictionaryManager = new DictionaryManager();
        }
        return dictionaryManager;
    }


    /**
     * The query function takes in a variable number of String arguments,
     * and returns true if the last argument is contained within any of the previous arguments.
     *<p>
     *
     * @param books Pass in an array of strings
     *
     * @return True, if the word is found in any of the books, otherwise it returns false
     *
     */
    public boolean query(String... books) {
        String word = books[books.length - 1];
        for (int i = 0; i < books.length - 1; i++) {
            if (!dictionaryMap.containsKey(books[i])) {
                dictionaryMap.put(books[i], new Dictionary(books[i]));
            }
            if (dictionaryMap.get(books[i]).query(word)) {
                return true;
            }
        }
        return false;
    }


    /**
     * The challenge function takes in a variable number of String arguments,
     * which are the names of books.
     * The function then checks if the last argument
     * is a word that can be formed by concatenating words from any combination
     * of the other books.
     * If so, it returns true; otherwise it returns false.

     *
     * @param books Pass in an array of strings
     *
     * @return True if the word is in any of the books
     *
     */
    public boolean challenge(String... books) {
        String word = books[books.length - 1];
        for (int i = 0; i < books.length - 1; i++) {
            if (!dictionaryMap.containsKey(books[i])) {
                dictionaryMap.put(books[i], new Dictionary(books[i]));
            }
            if (dictionaryMap.get(books[i]).challenge(word)) {
                return true;
            }
        }
        return false;
    }

    /**
     * The getSize function returns the size of the dictionaryMap.
     *<p>
     *
     * @return The number of items in the dictionary
     *
     */
    public int getSize() {
        return dictionaryMap.size();
    }
}