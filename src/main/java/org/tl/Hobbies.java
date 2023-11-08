package org.tl;

import java.io.*;
import java.util.*;

public class Hobbies {


    /**
     * Collect lines from the given file into a list.
     *
     * @param filePath The path to the file to read.
     * @return A list of lines from the file.
     */
    public List<String> createListFromFile(String filePath) {
        List<String> lines = new ArrayList<>();
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lines.add(line);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.printf("Error occurred %s%n", e.getMessage());
        }
        return lines;
    }


    /**
     * Create a dictionary of people's hobbies from the given file.
     *
     * @param filePath The path to the file to read.
     * @return A map where each person's name is associated with a list of their hobbies.
     */
    public Map<String, List<String>> createDictionary(String filePath) {
        Map<String, List<String>> result = new HashMap<>();
        try {
            FileReader fileReader = new FileReader(filePath);
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(":");
                String name = parts[0].trim();
                String[] hobbies = parts[1].split(",");
                List<String> hobbyList = new ArrayList<>(Arrays.asList(hobbies));
                result.put(name, hobbyList);
            }
            scanner.close();
        } catch (FileNotFoundException ex) {
            throw new RuntimeException("File not found:" + filePath);
        }
        return result;
    }


    /**
     * Find the person (or people) who have more hobbies than others.
     *
     * @param filePath The path to the file containing hobby data.
     * @return A list of people with the most hobbies.
     */
    public List<String> findPersonWithMostHobbies(String filePath) {
        Map<String, List<String>> dictionary = createDictionary(filePath);
        int maxHobbies = 0;
        String result = null;
        for (String name : dictionary.keySet()) {
            int hobbiesCount = dictionary.get(name).size();
            if (hobbiesCount > maxHobbies) {
                maxHobbies = hobbiesCount;
                result = name;
            }
        }
        return Collections.singletonList(result);
    }


    /**
     * Find the person (or people) who have fewer hobbies than others.
     *
     * @param filePath The path to the file containing hobby data.
     * @return A list of people with the fewest hobbies.
     */
    public List<String> findPersonWithLeastHobbies(String filePath) {
        Map<String, List<String>> dictionary = createDictionary(filePath);
        int minHobbies = 1;
        String result = null;
        for (String name : dictionary.keySet()) {
            int hobbiesCount = dictionary.get(name).size();
            if (!(hobbiesCount > minHobbies)) {
                minHobbies = hobbiesCount;
                result = name;
            }
        }
        return Collections.singletonList(result);
    }


    /**
     * Find the most popular hobby among all people.
     *
     * @param filePath The path to the file containing hobby data.
     * @return The most popular hobby.
     */
    public List<String> findMostPopularHobby(String filePath) {
        Map<String, List<String>> dictionary = createDictionary(filePath);
        createDictionary(filePath);
        Map<String, String> hobbyCount = new HashMap<>();

        for (List<String> hobbies : dictionary.values()) {
            for (String hobby : hobbies) {
                hobbyCount.put(hobby, hobbyCount.getOrDefault(hobby, String.valueOf(0)) + 1);
            }
        }

        int maxCount = 1;
        List<String> result = new ArrayList<>();

        for (Map.Entry<String, String> entry : hobbyCount.entrySet()) {
            int count = Integer.parseInt(entry.getValue());

            if (count > maxCount) {
                maxCount = count;
                result.clear();
                result.add(entry.getKey());
            } else if (count == maxCount) {
                result.add(entry.getKey());
            }
        }

        return result;
    }


    /**
     * Find the least popular hobby among all people.
     *
     * @param filePath The path to the file containing hobby data.
     * @return The least popular hobby.
     */
    public List<String> findLeastPopularHobby(String filePath) {
        Map<String, List<String>> dictionary = createDictionary(filePath);
        createDictionary(filePath);
        Map<String, String> hobbyCount = new HashMap<>();

        for (List<String> hobbies : dictionary.values()) {
            for (String hobby : hobbies) {
                hobbyCount.put(hobby, hobbyCount.getOrDefault(hobby, String.valueOf(0)) + 1);
            }
        }

        int minCount = 1;
        List<String> result = new ArrayList<>();

        for (Map.Entry<String, String> entry : hobbyCount.entrySet()) {
            int count = Integer.parseInt(entry.getValue());

            if (count < minCount) {
                minCount = count;
                result.clear();
                result.add(entry.getKey());
            } else if (count == minCount) {
                result.add(entry.getKey());
            }
        }

        return result;
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
        Map<String, List<String>> dictionary = createDictionary(filePath);
        try {
            FileWriter fileWriter = new FileWriter(fileToWrite);

            StringBuilder database = new StringBuilder();
            database.append("Name, Hobbies\n");

            for (Map.Entry<String, List<String>> entry : dictionary.entrySet()) {
                String name = entry.getKey();
                List<String> hobbies = entry.getValue();
                Collections.sort(hobbies);
                String hobbiesString = String.join(",", hobbies);
                database.append(name).append(",").append(hobbiesString).append("\n");
            }
            fileWriter.write(database.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


