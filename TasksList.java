import java.io.*;
import java.util.*;

public class TasksList {
    public static final String FILE_PATH = "src/Task.txt";

    Tasks[] TODOTasks;
    int totalTasks;

    public TasksList() throws IOException{
        TODOTasks = new Tasks[10];
        totalTasks = 0;
        readFromFile();
    }

    public void readFromFile() throws IOException{
        Scanner fileReader = new Scanner(new File(FILE_PATH));
        String task, status = "";
        int dayUtilDue;
        while (fileReader.hasNextLine()) {
            task = fileReader.nextLine();
            if (!fileReader.hasNextLine()) {
                System.out.println("Error : Invalid File Formatting");
                break;
            }
            status = fileReader.nextLine();
            if (!fileReader.hasNextLine()) {
                System.out.println("Error : Invalid File Formatting");
                break;
            }
            
            String dueLine = fileReader.nextLine();
            try {
                dayUtilDue = Integer.parseInt(dueLine);
                TODOTasks[totalTasks] = new Tasks(task, status, dayUtilDue);
                totalTasks++;
            } catch (NumberFormatException e) {
                System.out.println("Error : Invalid day value: " + dueLine);
            }
        }
        fileReader.close();
    }


    public void addTask(Tasks newTask) throws IOException{
        if (totalTasks < 10) {
            TODOTasks[totalTasks] = newTask;
            totalTasks++;
            saveToFile();
        } else {
            System.out.println("Book list is full!");
        }
    }

    public void saveToFile() throws IOException {
        BufferedWriter writer = new BufferedWriter (new FileWriter(FILE_PATH));
        
        for (int i = 0; i < totalTasks; i++) {
            writer.write(TODOTasks[i].getTaskName() + "\n");
            writer.write(TODOTasks[i].getStatus() + "\n");
            writer.write(TODOTasks[i].getDueDate() + "\n");
        }
        writer.close();
    }

    public int getTotalTask() {
        return totalTasks;
    } 

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < totalTasks; i++) {
            result.append(i).append(". ").append(TODOTasks[i].getTaskName()).append("\n");
        }
        return result.toString();
    }

    public String printAll() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < totalTasks; i++) {
            result.append(i).append(") ").append(TODOTasks[i].getTaskName()).append(" ").append(TODOTasks[i].getStatus()).append(" with ").append(TODOTasks[i].getDueDate()).append(" days left. \n");
        }
        return result.toString();
    }

      public Tasks getTask(int index) {
        if (index >= 0 && index < totalTasks) {
            return TODOTasks[index];
        } else {
            System.out.println("Invalid book index.");
            return null;
        }
    }

    public void finishTask(int index) {
        if (index >= 0 && index < totalTasks) {
            for (int i = index; i < totalTasks - 1; i++) {
                TODOTasks[i] = TODOTasks[i + 1];
            }
            TODOTasks[totalTasks - 1] = null;
            totalTasks--;
        }
    }
}
