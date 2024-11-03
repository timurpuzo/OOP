package org.example.week3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataStructures {
    private List<TaskItem> tasks = new ArrayList<>();

    public DataStructures() {
        tasks = Arrays.asList(
                new TaskItem(1, "Push lab code to the github", Status.TO_DO),
                new TaskItem(2, "Prepare for the quiz", Status.IN_PROGRESS),
                new TaskItem(3, "Go over tasks from lab2", Status.COMPLETED));
    }
    
    public List<TaskItem> getAllTasks() {
        return this.tasks;
    }

}



enum Status{
    TO_DO,
    IN_PROGRESS,
    COMPLETED
}