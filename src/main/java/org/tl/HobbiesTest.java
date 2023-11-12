package org.tl;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@RequiredArgsConstructor
public class HobbiesTest {

    private Hobbies hobbies;
    private String testFilePath;


    @BeforeEach
    void run() {
        hobbies = new Hobbies();
        testFilePath = "src/test/resources/hobbiess.txt";
    }

    @Test
    void testCreateListFromFile() {
        List<String> actual = hobbies.createListFromFile(testFilePath);
        assertEquals(15, actual.size());

    }

    @Test
    void testCreateDictionary() {
        Map<String, Set<String>> actual = hobbies.createDictionary(testFilePath);
        Map<String, Set<String>> expected = Map.of("Sophia", Set.of("Traveling", "Singing", "Dancing"));
        assertEquals(actual.get("Sophia"), expected.get("Sophia"));

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
        List<String> expected = List.of("Isabella", "Jackson", "Liam");
        assertEquals(expected, actual);
    }


    @Test
    void testFindMostPopularHobby() {
        List<String> actual = hobbies.findMostPopularHobby(testFilePath);
        List<String> expected = List.of("Yoga", "Dancing");
        assertEquals(expected, actual);
    }

    @Test
    void testFindLeastPopularHobby() {
        List<String> actual = hobbies.findLeastPopularHobby(testFilePath);
        List<String> expected = List.of("Chess", "Photography", "Cycling", "Cooking", "Singing", "Skiing", "Knitting", "Traveling", "Hiking", "Painting");
        assertEquals(expected, actual);

    }
}
