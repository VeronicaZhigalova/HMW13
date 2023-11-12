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
    public Map<String, Set<String>> createDictionary(String filePath) {

        Map<String, Set<String>> result = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length != 2) {
                    throw new IllegalArgumentException("Invalid format in the input file");
                }
                String name = parts[0];
                String[] hobbyArray = parts[1].split(",");
                Set<String> hobbies = new HashSet<>(Arrays.asList(hobbyArray));
                result.merge(name, hobbies, (existingHobbies, newHobbies) -> {
                    existingHobbies.addAll(newHobbies);
                    return existingHobbies;
                });
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading the input file", e);
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
        Map<String, Set<String>> dictionary = createDictionary(filePath);
        int maxHobbies = Integer.MIN_VALUE;
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Set<String>> entry : dictionary.entrySet()) {
            int hobbiesCount = entry.getValue().size();
            if (hobbiesCount > maxHobbies) {
                maxHobbies = hobbiesCount;
                result.clear();
                result.add(entry.getKey());
            } else if (hobbiesCount == maxHobbies) {
                result.add(entry.getKey());
            }
        }
        return result;
    }


    /**
     * Find the person (or people) who have fewer hobbies than others.
     *
     * @param filePath The path to the file containing hobby data.
     * @return A list of people with the fewest hobbies.
     */
    public List<String> findPersonWithLeastHobbies(String filePath) {
        Map<String, Set<String>> dictionary = createDictionary(filePath);
        int minHobbies = Integer.MAX_VALUE;
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Set<String>> entry : dictionary.entrySet()) {
            int hobbiesCount = entry.getValue().size();
            if (hobbiesCount < minHobbies) {
                minHobbies = hobbiesCount;
                result.clear();
                result.add(entry.getKey());
            } else if (hobbiesCount == minHobbies) {
                result.add(entry.getKey());
            }
        }
        return result;
    }


    /**
     * Find the most popular hobby among all people.
     *
     * @param filePath The path to the file containing hobby data.
     * @return The most popular hobby.
     */
    public List<String> findMostPopularHobby(String filePath) {

        Map<String, Set<String>> dictionary = createDictionary(filePath);
        Map<String, Integer> hobbyCount = new HashMap<>();


        for (Set<String> hobbies : dictionary.values()) {
            for (String hobby : hobbies) {
                hobbyCount.put(hobby, hobbyCount.getOrDefault(hobby, 0) + 1);
            }
        }

        int maxCount = Integer.MIN_VALUE;
        List<String> result = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : hobbyCount.entrySet()) {
            int count = entry.getValue();

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

        Map<String, Set<String>> dictionary = createDictionary(filePath);
        Map<String, Integer> hobbyCount = new HashMap<>();

        for (Set<String> hobbies : dictionary.values()) {
            for (String hobby : hobbies) {
                hobbyCount.put(hobby, hobbyCount.getOrDefault(hobby, 0) + 1);
            }
        }

        int minCount = Integer.MAX_VALUE;
        List<String> result = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : hobbyCount.entrySet()) {
            int count = entry.getValue();

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
        Map<String, Set<String>> dictionary = createDictionary(filePath);
        try {
            FileWriter fileWriter = new FileWriter(fileToWrite);

            StringBuilder database = new StringBuilder();
            database.append("Name, Hobbies\n");

            for (Map.Entry<String, Set<String>> entry : dictionary.entrySet()) {
                String name = entry.getKey();
                Set<String> hobbies = entry.getValue();
                List<String> sortedHobbies = new ArrayList<>(hobbies);
                Collections.sort(sortedHobbies);
                String hobbiesString = String.join(",", sortedHobbies);
                database.append(name).append(",").append(hobbiesString).append("\n");
            }
            fileWriter.write(database.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


