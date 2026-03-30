import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Task {
    private String title;
    private boolean completed;

    public Task(String title) {
        this.title = title;
        this.completed = false;
    }

    public void markCompleted() {
        this.completed = true;
    }

    public String toString() {
        return (completed ? "[✔] " : "[ ] ") + title;
    }
}

public class TaskManager {
    private static List<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Task");
            System.out.println("2. Show Tasks");
            System.out.println("3. Complete Task");
            System.out.println("4. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter task title: ");
                    String title = sc.nextLine();
                    tasks.add(new Task(title));
                    break;

                case 2:
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks.");
                    } else {
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println(i + ": " + tasks.get(i));
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter task index: ");
                    int index = sc.nextInt();
                    if (index >= 0 && index < tasks.size()) {
                        tasks.get(index).markCompleted();
                    } else {
                        System.out.println("Invalid index.");
                    }
                    break;

                case 4:
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
