package mx.edu.greengates.ane.computerscienceiastudymanagement.model;

import android.app.Application;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudyManagement extends Application implements Serializable {

    private List<Reward> rewards;
    private List<Task> tasks;
    private List<TaskLog> taskLogs;

    private int progress;
    private long timer;

    public StudyManagement(){
        this.rewards = new ArrayList<>();
        this.tasks = new ArrayList<>();
        this.progress = 0;
        this.timer = 0;
        this.taskLogs = new ArrayList<>();
    }

    public StudyManagement(List<Reward> rewards, List<Task> tasks, int progress, long timer) {
        this.rewards = rewards;
        this.tasks = tasks;
        this.progress = progress;
        this.timer = timer;
        this.taskLogs = new ArrayList<>();
    }

    public void insertTask(Task task){
        this.tasks.add(task);

    }

    public void study(Task task){

    }

    public List<Reward> getRewards() {
        return rewards;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public int getProgress() {
        return progress;
    }

    public long getTimer() {
        return timer;
    }

    public void setTask(Task task){this.tasks.add(task);}

    public List<TaskLog> getTaskLogs() {
        return taskLogs;
    }

    public TaskLog getTaskLog(int index) {
        return taskLogs.get(index);
    }

    public void setTaskLog(TaskLog taskLog){
        this.taskLogs.add(taskLog);
    }

    public long updateProgress(){
        long totalTime = 0;
        for (Task task: tasks){
            long time = task.getTotalTime();
            totalTime = totalTime + time;
        }

        long studyTime = 0;
        for(TaskLog taskLog:taskLogs){
            long time = taskLog.getStopTime();
            studyTime = studyTime + time;
        }

        long progress = studyTime/totalTime;
        this.progress = (int) progress;
        return progress;
    }

}
