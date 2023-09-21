package ToDoList;

public interface CRUD {
	void SELECT();
	void INSERT();
	void UPDATE(int id);
	void UPDATEIsCompleted(int id);
	void DELETE(int id);
}
