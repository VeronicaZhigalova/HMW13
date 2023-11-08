package org.tl;


import java.util.List;

public class Main {

    public static void main(String[] args) {

        Hobbies hobbies = new Hobbies();

        final List<String> lines = hobbies.createListFromFile("src/main/resources/hobbies.txt");
        System.out.println(lines);


        final List<String> findPersonWithMostHobbies = hobbies.findPersonWithMostHobbies("src/main/resources/hobbies.txt");
        System.out.println(findPersonWithMostHobbies);

        final List<String> findPersonWithLeastHobbies = hobbies.findPersonWithLeastHobbies("src/main/resources/hobbies.txt");
        System.out.println(findPersonWithLeastHobbies);

        final List<String> findMostPopularHobby = hobbies.findMostPopularHobby("src/main/resources/hobbies.txt");
        System.out.println(findMostPopularHobby);

        final List<String> findLeastPopularHobby = hobbies.findLeastPopularHobby("src/main/resources/hobbies.txt");
        System.out.println(findLeastPopularHobby);
    }
}
