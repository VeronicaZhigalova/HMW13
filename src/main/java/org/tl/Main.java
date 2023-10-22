package org.tl;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        final List<String> lines = Hobbies.createListFromFile("src/main/resources/hobbies.txt");
        System.out.println(lines);
    }
}
