package edu.au.cpsc.todo;


/**
 * A class for the To Do Item. Each item will have a required label,
 * an optional description, and a required priority. The priority
 * can be set to low, normal, high, or urgent. Each item will have an
 * incomplete or complete status that is initially set to false or incomplete.
 *
 * @author
 * @since 
 */
public class ToDoItem {
  private String label;
  private String description;
  private Priority priority;
  private boolean complete;

  /**
   * Creates an object for the ToDoItem class.
   *
   * @param label       A String that holds the label of the item and cannot be empty.
   * @param description A String that holds the description of the item and can be empty.
   * @param priority    The Priority of the item, which and cannot be empty
   */
  public ToDoItem(String label, String description, Priority priority) {
    this.priority = priority;
    this.label = label;
    this.description = description;
    this.complete = false;
  }

  /** A method to get the ToDoItem label.
     *
     * @return A String containing the label of the item
     */
  public String getLabel() {
    return label;
  }

  /**
   * A method to set the label of the ToDoItem object.
   *
   * @param label A String that holds the label of the ToDoItem
   * @throws NullPointerException if label is empty or null
   */

  public void setLabel(String label) throws NullPointerException {
    if (label.trim().equals("")) {
      throw new NullPointerException("Label is required");
    }
    this.label = label.trim();
  }

  /**
   * A method to get the ToDoItem description.
   *
   * @return A String containing the description of the item
   */

  public String getDescription() {
    return description;
  }

  /** A method to set the description of the ToDoItem, which may be empty or one line of text.
   *
   * @param description A String that holds the description of the ToDoItem object
   */

  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * A method to get the priority of the ToDoItem, which cannot be empty or null.
   *
   * @return the priority of the ToDoItem as Priority object
   */

  public String getPriority() {
    return priority.name().toLowerCase();
  }

  /** A method to set the priority of a ToDoItem.
     *
     * @param priority The priority of the ToDoItem
     * @throws NullPointerException if empty or null
     */

  public void setPriority(Priority priority) throws NullPointerException {
    if (priority.name().equals("")) {
      throw new NullPointerException("Priority is required");
    }
    this.priority = priority;
  }

  /** A method to get complete status of a ToDoItem.
     *
     * @return true: if item is completed, otherwise the method will return false
     */

  public boolean isComplete() {
    return this.complete;
  }

  /** A method to update the item as complete.
     *
     * @return true if item is update to complete
     */

  public boolean updateCompleted() {
    this.complete = true;
    return this.complete;
  }



  /** Priority that can be used.
     *
     * @see #LOW
     * @see #NORMAL
     * @see #HIGH
     * @see #URGENT
     */
  public enum Priority {
        /** Low Priority.
         */
        LOW,
        /** Normal Priority.
         */
        NORMAL,
        /** High Priority.
         */
        HIGH,

        /** Urgent Priority.
         */
        URGENT

  }
}
