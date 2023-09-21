package ToDoList;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		TaskList tasks = new TaskList();
		
		System.out.println("Bienvenue dans le gestionnaire de tâches !");
		
		while(true) {
			System.out.println("\nMenu :");
            System.out.println("1. Ajouter une tâche");
            System.out.println("2. Afficher les tâches");
            System.out.println("3. Marquer une tâche comme terminée");
            System.out.println("4. Quitter");

            System.out.print("Choisissez une option : ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
			case 1: {
				System.out.println("Entrez la description de la tâche :");
				String description = scanner.nextLine();
				Task task = new Task(tasks.size() + 1, description);
				tasks.addTask(task);
				System.out.println("Tâche ajouté avec succès");
				break;
			}
			
			case 2:{
				tasks.displayTasks();
				break;
			}
			
			case 3:
                System.out.print("Entrez le numéro de la tâche à marquer comme terminée : ");
                int taskId = scanner.nextInt();
                boolean marked = tasks.markTaskAsCompleted(taskId);
                if (marked) {
                    System.out.println("Tâche marquée comme terminée avec succès !");
                } else {
                    System.out.println("La tâche avec l'ID spécifié n'a pas été trouvée.");
                }
                break;
            case 4:
                System.out.println("Au revoir !");
                scanner.close();
                System.exit(0);
            default:
                System.out.println("Option non valide. Veuillez choisir une option valide.");
			
			}
		}

	}

}
