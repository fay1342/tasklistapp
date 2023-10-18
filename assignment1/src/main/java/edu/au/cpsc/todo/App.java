package edu.au.cpsc.todo;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * The App class that is the main class. If there is no ToDo.dat file,
 * a ToDo.dat file is created an saved with a ToDoCollection that has a
 * ToDoList named "default". This class will have a menu that will ask
 * the user for input in order for the user to manipulate their to do lists.
 *
 * @author 
 * @since 
 */

public class App {

  public static String fileName = "ToDo.dat";

  /**
     * A main method to run the ToDoList menu.
     *
     * @param args array of String of command line parameters
     * @throws IOException throws IOException
     */

  public static void main(String args []) throws IOException {


    ToDoListCollection toDoListCollection = new ToDoListCollection(new ToDoList());
    ToDoList toDoList = new ToDoList();


    String choice = "y";

    File file = new File("ToDo.dat");

    if (file.createNewFile()) {
      System.out.println("Welcome to ToDo list manager. I did not find "
                    + " a save file so I've created an empty ToDo list for you.");
      System.out.println();
      System.out.println();

    }


    try {
      Scanner input = new Scanner(System.in);

      ToDoListCollection.load(fileName);
      while (!choice.equals("q")) {

        System.out.println("--------------------------------------------------");
        System.out.println("Main menu (current ToDo list: " + toDoList.getName() + ")");
        System.out.println();
        System.out.println("a) Create ToDo list");
        System.out.println("r) Rename current ToDo List");
        System.out.println("s) Select ToDoList");
        System.out.println("l) List incomplete ToDo items on current list");
        System.out.println("p) List incomplete ToDo items by priority");
        System.out.println("c) List completed ToDo items");
        System.out.println("t) Create ToDo item");
        System.out.println("f) Complete ToDo item");
        System.out.println("q) Quit");
        System.out.println();

        System.out.println("Enter your selection");
        choice = input.next();

        switch (choice) {
          case "a" -> toDoListCollection.addList();
          case "r" -> toDoListCollection.newName();
          case "s" -> toDoListCollection.currentLists();
          case "l" -> toDoListCollection.incompleteItems();
          case "p" -> toDoListCollection.priorityList();
          case "c" -> toDoListCollection.listCompletedItem();
          case "t" -> toDoListCollection.addNewItem();
          case "f" -> toDoListCollection.updateCompleteItem();
          case "q" -> System.out.println("Come back soon!");
          case "m" -> toDoListCollection.removeList();
          default -> {
          }
        }
      }
      toDoListCollection.save(fileName);

    } catch (Exception e) {
      toDoListCollection.save(fileName);
    }
  }
}


