package com.codecool.bfsexample;

import com.codecool.bfsexample.model.UserNode;

import java.util.*;

public class BFSExample {
    
    private static List<UserNode> users;
    private static GraphPlotter graphPlotter;
    

    private static void populateDB() {
        RandomDataGenerator generator = new RandomDataGenerator();
        users = generator.generate();
    }

    public static void main(String[] args) {
        populateDB();
        graphPlotter = new GraphPlotter(users);

        System.out.println("Done!");
        mainMenu();
    }

    private static void printMenu(Map<Integer, String> menuItems) {
        for (Integer key: menuItems.keySet()) {
            System.out.println(key + ") " + menuItems.get(key));
        }
        System.out.println();
    }

    private static void mainMenu() {
        Map<Integer, String> menuItems = new HashMap<>();
        menuItems.put(1, "Distance between");
        menuItems.put(2, "Friends of friends");
        menuItems.put(3, "Shortest paths");
        printMenu(menuItems);
        Integer choose = chooseMenuItem(menuItems.keySet());
        switch (choose) {
            case 1: distanceBetween();
                break;
            case 2: friendsOfFriends();
                break;
            case 3: shortestPaths();
                break;
        }
    }

    private static void distanceBetween() {
    }

    private static void friendsOfFriends() {
    }

    private static void shortestPaths() {
    }

    private static int getIntegerAsInput() {
        Integer choose = null;
        while (choose == null) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Choose from the menu: ");
                choose = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Not valid form.");
                choose = null;
            }
        }
        return choose;
    }

    private static int chooseMenuItem(Set<Integer> selectable) {
        Integer choose = null;
        while (true) {
            choose = getIntegerAsInput();
            if (selectable.contains(choose)) return choose;
            System.out.println("Not a valid option.");
            choose = null;
        }
    }
}
