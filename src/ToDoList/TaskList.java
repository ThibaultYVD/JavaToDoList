package ToDoList;

import java.util.ArrayList;
import java.util.List;

public class TaskList {

	private List<Task> tasks;
	
	public TaskList () {
		tasks = new ArrayList<>();
	}
	
	public void addTask(Task task) {
		tasks.add(task);
	}
	
	public void displayTasks() {
		if(tasks.isEmpty()) {
			System.out.println("La liste de tâche est vide");
		}else {
			System.out.println("Liste de tâches : ");
			for(Task task : tasks) {
				System.out.println(task);
			}
		}
	}
	
	public boolean markTaskAsCompleted(int taskId) {
        for (Task task : tasks) {
            if (task.getId() == taskId) {
                task.setAsCompleted();
                return true;
            }
        }
        return false;
    }
	
	public int size() {
        return tasks.size();
    }
}
