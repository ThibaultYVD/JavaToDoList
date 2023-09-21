package ToDoList;

import java.util.List;

public class Task {

	private int id;
	private String description;
	private boolean isCompleted;
	private Task task;
	
	public Task(int id, String description) {
		this.id = id;
		this.description = description;
		this.isCompleted = false;
	}
	
	public int getId() {
		return id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public boolean getIsCompleted() {
		return isCompleted;
	}
	
	public void setAsCompleted() {
		isCompleted = true;
	}
	

	public String toString() {
		return "- " + description + " | " + isCompleted;
	}
	
	
}
