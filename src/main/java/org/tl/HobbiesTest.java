package org.tl;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@RequiredArgsConstructor
public class HobbiesTest {

    private Hobbies hobbies;
    private String testFilePath;


    @BeforeEach
    void setUp() {
        hobbies = new Hobbies();
        testFilePath = "src/test/resources/hobbies.txt";
    }

    @Test
    void testCreateListFromFile() {
        List<String> actualResult = hobbies.createListFromFile(testFilePath);
        assertEquals(200, actualResult.size());

    }

    @Test
    void testCreateDictionary() {
        Map<String, List<String>> actualResult = hobbies.createDictionary(testFilePath);
        Map<String, List<String>> expectedResult = Map.of("Ava", List.of("Drawing"));
        assertEquals(actualResult.get("Ava"), expectedResult.get("Ava"));

    }

    @Test
    void testFindPersonWithMostHobbies() {
        List<String> actual = hobbies.findPersonWithMostHobbies(testFilePath);
        List<String> expected = List.of("Olivia");
        assertEquals(expected, actual);

    }

    @Test
    void testFindPersonWithLeastHobbies() {
        List<String> actual = hobbies.findPersonWithLeastHobbies(testFilePath);
        List<String> expected = List.of("Sophia");
        assertEquals(expected, actual);
    }


    @Test
    void testFindMostPopularHobby() {
        List<String> actual = hobbies.findMostPopularHobby(testFilePath);
        List<String> expected = List.of("Cycling", "Skiing", "Traveling");
        assertEquals(expected, actual);
    }

    @Test
    void testFindLeastPopularHobby() {
        List<String> actual = hobbies.findLeastPopularHobby(testFilePath);
        List<String> expected = List.of("Drawing", "Playing Guitar", "Cooking", "Hiking");
        assertEquals(expected, actual);

    }
}
