package org.tl;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Hobbies hobbies = new Hobbies();
        final List<String> lines = hobbies.createListFromFile("src/main/resources/hobbies.txt");
        System.out.println(lines);
    }
}
