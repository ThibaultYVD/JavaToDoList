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
				Methodes crud = new Methodes();
				crud.INSERT();
				break;
			}
			
			case 2:{
				Methodes crud = new Methodes();
				crud.SELECT();
				break;
			}
			
			case 3:
                System.out.print("Entrez le numéro de la tâche à marquer comme terminée : ");
                int taskId = scanner.nextInt();
                Methodes crud = new Methodes();
				crud.UPDATEIsCompleted(taskId);

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
