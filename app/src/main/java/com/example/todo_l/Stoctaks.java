package com.example.todo_l;

import com.example.todo_l.Module.Task;

import java.util.ArrayList;

public class  Stoctaks{
    public static ArrayList<Task> taskList = new ArrayList<>();
    public static ArrayList<Task> delitList = new ArrayList<>();

    public static ArrayList<Task> add(Task task) {
        taskList.add(task);
        return taskList;
    }

    public static void dremove(int i) {
        delitList.add(taskList.get(i));
        taskList.remove(i);
    }

    public static ArrayList<Task> search(String p) {
        ArrayList<Task> tasks = new ArrayList<>();
        for (Task task : taskList) {
            if (String.valueOf(task.getPrp()).equals(p)) {
                boolean taskExists = false;
                for (Task t : tasks) {
                    if (t.equalTo(task)) {
                        taskExists = true;
                        break;
                    }
                }if (!taskExists) {
                    tasks.add(task);
                }
            }
        }
        return tasks;
    }

}
