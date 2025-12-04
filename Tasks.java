public class Tasks {
    private String Task, Status;
    private int dayUtilDue;

    public Tasks(String t, String s, int d) {
        Task = t;
        Status = s;
        dayUtilDue = d;
    }

    public void changeStatus(int index, String newStatus) {
        Status = newStatus;
    }

    public String getTaskName() {
        return Task;
    }

    public String getStatus() {
        return Status;
    }

    public int getDueDate() {
        return dayUtilDue;
    }

}
