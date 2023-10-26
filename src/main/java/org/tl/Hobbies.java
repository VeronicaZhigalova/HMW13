package org.tl;

import java.util.List;
import java.util.Map;

public class Hobbies {

    /**
     * Collect lines from the given file into a list.
     *
     * @param filePath The path to the file to read.
     * @return A list of lines from the file.
     */
    public List<String> createListFromFile(String filePath) {
        return null;
    }

    /**
     * Create a dictionary of people's hobbies from the given file.
     *
     * @param filePath The path to the file to read.
     * @return A map where each person's name is associated with a list of their hobbies.
     */
    public Map<String, List<String>> createDictionary(String filePath) {
        return null;
    }

    /**
     * Find the person (or people) who have more hobbies than others.
     *
     * @param filePath The path to the file containing hobby data.
     * @return A list of people with the most hobbies.
     */
    public List<String> findPersonWithMostHobbies(String filePath) {
        return null;
    }

    /**
     * Find the person (or people) who have fewer hobbies than others.
     *
     * @param filePath The path to the file containing hobby data.
     * @return A list of people with the fewest hobbies.
     */
    public List<String> findPersonWithLeastHobbies(String filePath) {
        return null;
    }

    /**
     * Find the most popular hobby among all people.
     *
     * @param filePath The path to the file containing hobby data.
     * @return The most popular hobby.
     */
    public List<String> findMostPopularHobby(String filePath) {
        return null;
    }

    /**
     * Find the least popular hobby among all people.
     *
     * @param filePath The path to the file containing hobby data.
     * @return The least popular hobby.
     */
    public List<String> findLeastPopularHobby(String filePath) {
        return null;
    }

    /**
     * Write correct database to the csv file
     * <p>
     * Since this is a csv file, then the output should be like:
     * Name,Hobbies
     * Bob,skiing
     * Alice,dancing-programming
     * <p>
     * Hobbies have to be sorted in alphabetic order
     *
     * @param filePath    The path to the file containing hobby data
     * @param fileToWrite Path to the new file with correct data
     */
    public void writeCorrectedDatabase(String filePath, String fileToWrite) {

    }
}
