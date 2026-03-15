import java.util.ArrayList;
import java.util.Scanner;

class TaskManager {

    ArrayList<Task> tasks = new ArrayList<>();

    void addTask(String title) {
        tasks.add(new Task(title));
        System.out.println("Task added successfully.");
    }

    void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    void markTaskComplete(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markCompleted();
            System.out.println("Task marked as completed.");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    void deleteTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            System.out.println("Task deleted.");
        } else {
            System.out.println("Invalid task number.");
        }
    }
}
class Task {

    String title;
    boolean isCompleted;

    Task(String title) {
        this.title = title;
        this.isCompleted = false;
    }

    void markCompleted() {
        isCompleted = true;
    }

    public String toString() {
        return title + " - " + (isCompleted ? "Completed" : "Pending");
    }
}
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        TaskManager manager = new TaskManager();

        while (true) {

            System.out.println("\nTask Manager");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task Complete");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");

            int choice;

            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid input.");
                scanner.nextLine();
                continue;
            }

            switch (choice) {

                case 1:
                    System.out.print("Enter task: ");
                    String task = scanner.nextLine();
                    manager.addTask(task);
                    break;

                case 2:
                    manager.viewTasks();
                    break;

                case 3:
                    System.out.print("Enter task number: ");
                    int completeIndex = scanner.nextInt();
                    manager.markTaskComplete(completeIndex - 1);
                    break;

                case 4:
                    System.out.print("Enter task number: ");
                    int deleteIndex = scanner.nextInt();
                    manager.deleteTask(deleteIndex - 1);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}