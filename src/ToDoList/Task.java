package ToDoList;

import java.util.List;

public class Task {

	private int id;
	private String description;
	private String isCompleted;
	private Task task;
	
	public Task(int id, String description, String isCompleted) {
		this.id = id;
		this.description = description;
		this.isCompleted = isCompleted;
	}
	
	public int getId() {
		return id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getIsCompleted() {
		return isCompleted;
	}
	
	public void setAsCompleted() {
		isCompleted = "Fait";
	}
	

	public String toString() {
		return "- " + description + " | " + isCompleted;
	}
	
	
}
