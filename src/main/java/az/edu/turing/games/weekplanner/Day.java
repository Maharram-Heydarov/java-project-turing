package az.edu.turing.games.weekplanner;

public class Day {
    private String name;
    private String task;

    public Day(String name, String tasks) {
        this.name = name;
        this.task = tasks;
    }

    public String getName() {
        return name;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
}
