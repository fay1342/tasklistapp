package edu.au.cpsc.todo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * A class for the ToDoListCollection that contains a list of ToDoList instances.
 * This class has methods to add, remove and get the ToDoListCollection.
 * As well as methods to change the name, add a new item, update and get
 * the completed status of items in a list.
 *
 * @author 
 * @since 
 */
public class ToDoListCollection {
  private static List<ArrayList<ToDoItem>> listOfLists;
  private ToDoList toDoList;
  private ToDoItem toDoItem;

  /** Creates a ToDoCollections objects. A List of ArrayList of ToDoItems.
     *
     * @param toDoList a ToDoList object for the ToDoListCollection list
     */
  public ToDoListCollection(ToDoList toDoList) {
    this.listOfLists = new ArrayList<ArrayList<ToDoItem>>();
    this.toDoList = new ToDoList();
    this.toDoItem = new ToDoItem(null, null, null);

  }

  /**
     * A method to add a ToDoList to the ToDoListCollection.
     * The user will be asked to input a name for the ToDoList added.
     */
  public void addList() {
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter the name of this new ToDo list>");
    String name = scan.nextLine();
    if (!(name.trim().equals(""))) {
      ToDoItem toDoItem = new ToDoItem(null, null, null);
      ToDoList toDoList = new ToDoList();
      toDoList.setName(name);
      listOfLists.add(new ArrayList<ToDoItem>(Collections.<ToDoItem>nCopies(1, toDoItem)));


      System.out.println();
      System.out.println("Created and selected your " + name + " list");
    } else if (name.equals("")) {
      System.out.println("Invalid name, must contain at least 1 non-blank character");
    } else if (listOfLists.contains(name)) {
      System.out.println("There is already a list with that name");
    }

  }


  /**
     * A method to change the name of the current ToDoList.
     */
  public void newName() {
    Scanner scan = new Scanner(System.in);
    System.out.println("Current name is " + toDoList.getName() + ". Enter new name>");
    String name = scan.next();
    toDoList.setName(name);
  }

  /**
     * A method to remove a ToDoList.
     */
  public void removeList() {
    listOfLists.remove(0);
  }


  /**
     * A method to get the names each ToDoList in the ToDoListCollection.
     */
  public void currentLists() {
    System.out.println("Current lists:");
    System.out.println("");


    listOfLists.stream().forEach(list -> System.out.println(listOfLists.indexOf(list)
                + ") " + toDoList.getName()));


  }

  /**
     * A method to get the ToDoListCollection.
     * @return the ToDoListCollection
     */
  public List<ArrayList<ToDoItem>> getToDoListCollection() {
    return listOfLists;
  }

  /**
     * A method to get each item's priority in the current ToDoList.
     */
  public void priorityList() {
    System.out.println("URGENT (" + " items):");
    System.out.println("HIGH (" + " items):");
    System.out.println("MEDIUM (" + " items):");
    System.out.println("LOW (" + " items):");

  }

  /**
     * A method to add an Item to the current ToDoList.
     * @return false if item was not added, true if item was added
     */
  public boolean addNewItem() {


    Scanner scan = new Scanner(System.in);

    try {

      System.out.println("Creating ToDo item");
      System.out.println("Enter label");
      String label = scan.nextLine();
      System.out.println("Enter description");
      String description = scan.nextLine();

      System.out.println("Enter priority");
      ToDoItem.Priority priority = ToDoItem.Priority.valueOf(scan.nextLine().toUpperCase());
      this.toDoList.addItem(label, description, priority);
      System.out.println("ToDo item created.");
      System.out.print("");
      return true;
    } catch (Exception e) {
      return false;
    }
  }


  /**
     * A method to list the items in the current ToDoList with an incompleted status,
     * and their labels, descriptions, and priorities.
     */
  public void incompleteItems() {
    if (toDoItem.isComplete() == false) {
      System.out.println("Currently " + toDoList.getToDoList().size() + " incomplete items in your "
                    + toDoList.getName());
      System.out.println("\t" + toDoItem.getLabel() + " -- "
                    + toDoItem.getDescription()
                    + " (" + toDoItem.getPriority());
    }
  }

  /**
     * A method to update the selected item and update the item's complete status to complete.
     */
  public void updateCompleteItem() {
    Scanner scan = new Scanner(System.in);
    System.out.println("Current item:");
    System.out.println("Enter the number of the item to complete>");
    Integer itemInt = scan.nextInt();
    System.out.println("Completed");
    ToDoItem item = toDoList.getToDoList().get(itemInt);
    item.isComplete();
  }

  /**
     * A method to list the items of the current ToDoList if item are completed.
     */

  public void listCompletedItem() {
    if (toDoItem.isComplete() == true) {
      System.out.println("Currently " + toDoList.getToDoList().size() + " incomplete items in your "
                + toDoList.getName());
      System.out.println("\t" + toDoItem.getLabel() + " -- "
                + toDoItem.getDescription()
                + " (" + toDoItem.getPriority());
    }
  }

  /**
   * A method to load the file ToDo.dat and create a ToDoListCollection from the file.
   *
   * @param fileName A String for the name of the data file
   */
  public static void load(String fileName) {

    boolean loadBoolean = false;
    try {
      if (!Files.isReadable(Paths.get(fileName))) {
        return;
      }


      FileInputStream fileInput = new FileInputStream(fileName);
      ObjectInputStream objectInput = new ObjectInputStream(fileInput);

      ArrayList<ToDoItem> item;
      item = (ArrayList<ToDoItem>) objectInput.readObject();

      for (int i = 0; i < item.size(); i++) {
        listOfLists.add(item);
      }


      objectInput.close();
      fileInput.close();

    } catch (Exception e) {
    }
  }

  /**
     * A method to write and save the data of the ToDoListCollection to the data file ToDo.dat.
     * @param fileName a String for the name of the data file
     * @return true is file was succesfully saved, otherwise false
     */

  public boolean save(String fileName) {

    try {
      FileOutputStream fileOutput = new FileOutputStream(fileName);
      ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
      objectOutput.writeObject(listOfLists);
      objectOutput.close();
      fileOutput.close();
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}












