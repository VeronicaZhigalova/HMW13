package org.tl;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
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
        Map<String, List<String>> expectedResult = new HashMap<>();
        expectedResult.put("Sophia", Arrays.asList("Traveling"));
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testFindPersonWithMostHobbies() {
        List<String> actual = hobbies.findPersonWithMostHobbies(testFilePath);
        List<String> expected = List.of("Sophia");
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
        List<String> expected = List.of("Traveling");
        assertEquals(expected, actual);
    }

    @Test
    void testFindLeastPopularHobby() {
        List<String> actual = hobbies.findLeastPopularHobby(testFilePath);
        List<String> expected = List.of("Traveling");
        assertEquals(expected, actual);

    }
}
