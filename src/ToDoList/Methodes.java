package ToDoList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Methodes implements CRUD{

	@Override
	public void SELECT() {
		String jdbcUrl = "jdbc:mysql://localhost:3306/javatodolist"; // URL de la base de données (changez-la en fonction de votre configuration)
        String user = "root"; // Nom d'utilisateur MySQL
        String password = ""; // Mot de passe MySQL

		

		try {
        	// Charger le pilote
        	try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	// Etablir la connexion à la DB
        	Connection conn = DriverManager.getConnection(jdbcUrl, user, password);
        	
        	// Requête
        	String sql = "SELECT * FROM tasks";
        	
        	
        	Statement stmt = conn.createStatement();
        	ResultSet res = stmt.executeQuery(sql);
        	
        	TaskList tasks = new TaskList();
        	
        		while (res.next()) {
              	  int resId = res.getInt("id");
              	  String resDescription = res.getString("description");
              	  String resIsCompleted = res.getString("isCompleted");
              		  
              		  
              	  Task task = new Task(resId, resDescription, resIsCompleted);
              	  tasks.addTask(task);
              	  tasks.displayTasks();
            		}

        	
        	
        
        	
        }catch (SQLException e){
        	e.printStackTrace();
        }
		
	}

	@Override
	public void INSERT() {
		String jdbcUrl = "jdbc:mysql://localhost:3306/javatodolist"; // URL de la base de données (changez-la en fonction de votre configuration)
        String user = "root"; // Nom d'utilisateur MySQL
        String password = ""; // Mot de passe MySQL
        
        
        
        try {
        	// Charger le pilote
        	try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	// Etablir la connexion à la DB
        	Connection conn = DriverManager.getConnection(jdbcUrl, user, password);
        	
        	// Requête d'insertion
        	String sql = "INSERT INTO tasks (description, isCompleted) "
        			+ "VALUES (?,?)";
        	
        	PreparedStatement prepState = conn.prepareStatement(sql);
        	
        	Scanner scanner = new Scanner(System.in);
        	System.out.println("Entrez la description de la tâche :");
			String description = scanner.nextLine();
			
        	prepState.setString(1,description);
        	prepState.setString(2,"A faire");

        	// Excécuter
        	int lignesAffectees = prepState.executeUpdate();
        	
        	if(lignesAffectees > 0) {
        		System.out.println("La tâche " + description + " a été ajouté avec succès");
        	}else {
        		System.out.println("L'insertion a échoué");
        		prepState.close();
        		conn.close();
        	}
        	
        	
        }catch (SQLException e){
        	e.printStackTrace();
        }
		
	}

	@Override
	public void UPDATEIsCompleted(int id) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/javatodolist"; // URL de la base de données (changez-la en fonction de votre configuration)
        String user = "root"; // Nom d'utilisateur MySQL
        String password = ""; // Mot de passe MySQL
        
        
        
        try {
        	// Charger le pilote
        	try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	// Etablir la connexion à la DB
        	Connection conn = DriverManager.getConnection(jdbcUrl, user, password);
        	
        	// Requête
        	String sql = "UPDATE tasks SET isCompleted=? WHERE id=" + id;
        	
        	PreparedStatement prepState = conn.prepareStatement(sql);
        	
        	prepState.setString(1,"Fait");

        	
        	// Excécuter
        	int lignesAffectees = prepState.executeUpdate();
        	
        	if(lignesAffectees > 0) {
        		System.out.println("La mise à jour a réussi");
        	}else {
        		System.out.println("La mise à jour a échoué");
        		prepState.close();
        		conn.close();
        	}
        	
        	
        }catch (SQLException e){
        	e.printStackTrace();
        }
		
	}

	@Override
	public void DELETE(int id) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/jdbc"; // URL de la base de données (changez-la en fonction de votre configuration)
        String user = "root"; // Nom d'utilisateur MySQL
        String password = ""; // Mot de passe MySQL
        
               
        try {
        	// Charger le pilote
        	try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	// Etablir la connexion à la DB
        	Connection conn = DriverManager.getConnection(jdbcUrl, user, password);
        	
        	// Requête d'insertion
        	String sql = "DELETE FROM etudiants WHERE `id`="+ id;
        	
        	PreparedStatement prepState = conn.prepareStatement(sql);
        	
        	// Excécuter
        	int lignesAffectees = prepState.executeUpdate();
        	
        	if(lignesAffectees > 0) {
        		System.out.println("La suppression a réussi");
        	}else {
        		System.out.println("La suppression a échoué");
        		prepState.close();
        		conn.close();
        	}
        	
        	
        }catch (SQLException e){
        	e.printStackTrace();
        }
		
	}

	@Override
	public void UPDATE(int id) {
		// TODO Auto-generated method stub
		
	}


}