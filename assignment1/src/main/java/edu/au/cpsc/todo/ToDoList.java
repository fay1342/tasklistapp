package edu.au.cpsc.todo;

import java.util.ArrayList;
import java.util.List;

/**
 * A class for the ToDoList. This class contains the List of ToDoItems.
 * Each list will have a name set to default and may have a ToDoItem object.
 *
 * @author 
 * @since 
 */
public class ToDoList {
  private static String name = "default";
  private static List<ToDoItem> toDoItems;

  /** Creates the ToDoList object.
     *
     */
  public ToDoList() {

    this.toDoItems = new ArrayList<>();
  }

  /**
     * A method to get the ToDoList.
     *
     * @return a list of ToDoItems
     */
  public List<ToDoItem> getToDoList() {
    return toDoItems;
  }

  /**
     * A method to get the ToDoList name.
     *
     * @return a String containing the name of a ToDoList
     */

  public String getName() {
    return name;
  }

  /** A method to set the name of a ToDoList.
     *
     * @param name A String that holds the name of a ToDoList
     * @throws NullPointerException if name is empty
     */

  public void setName(String name) throws NullPointerException {
    if (name.trim().equals("")) {
      throw new NullPointerException("Name is required");
    }
    this.name = name.trim();
  }

  /**
     * A method to add ToDoItems objects to the ToDoList.
     *
     * @param label A String that holds the label of the item, it cannot be empty
     * @param description A String that holds the description of the item that may be empty
     * @param priority The priority of the item, it cannot be empty
     */

  public void addItem(String label, String description, ToDoItem.Priority priority) {
    toDoItems.add(new ToDoItem(label, description, priority));
  }


}






