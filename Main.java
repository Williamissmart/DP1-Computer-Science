import java.util.*; 
import java.io.*;
 public class Main { 
    public static void main(String[] args) throws IOException { 
        Scanner sc = new Scanner(System.in);

        int choice, dayUtilDue;
        String task, status;
        TasksList TODOList = new TasksList();

        //TODOList.readFromFile();

        while (true) {

            System.out.println();
            System.out.println("What would you like to do?");
            System.out.println("1. Add a new task TODO)");
            System.out.println("2. List all the TODO lists");
            System.out.println("3. Update the status of a task");
            System.out.println("4. Finished a task");
            System.out.println("5. Exit the program");
            System.out.println();
            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {

                System.out.println("What is the task you would like to add");
                task = sc.nextLine();
                System.out.println("What is the status of this task?");
                status = sc.nextLine();
                System.out.println("How many days until it's due?");
                dayUtilDue = sc.nextInt();
                sc.nextLine();
                Tasks newTask = new Tasks (task, status, dayUtilDue);
                TODOList.addTask(newTask);

            } else if (choice == 2) {

                System.out.println();
                System.out.println(TODOList.printAll());

            } else if (choice == 3) {
                
                System.out.println("What tasks status would you like to update?");
                System.out.println(TODOList.toString());
                int index = sc.nextInt();
                sc.nextLine();

                String newStatus;
                if (index >= 0 && index <= TODOList.getTotalTask()) {
                    System.out.println("What is the new status of this task?");
                    newStatus = sc.nextLine();
                    Tasks selectedTasks = TODOList.getTask(index);
                    selectedTasks.changeStatus(index, newStatus);
                    TODOList.saveToFile();
                }

            } else if (choice == 4) {

                System.out.println("What task are you finished with?");
                System.out.println(TODOList.toString());
                int index = sc.nextInt();
                sc.nextLine();
                if (index >= 0 && index < TODOList.getTotalTask()) {
                    TODOList.finishTask(index); 
                    TODOList.saveToFile();
                } else {
                    System.out.println("Invalid book index.");
                }

            } else if (choice == 5) {
                break;
            }

        }

        sc.close();

    }
}

