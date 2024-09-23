package taskManager.service.impl;

import taskManager.Status;
import taskManager.dataTransferObject.TaskDTO;
import taskManager.service.face.TaskManager;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class TaskManagerImpl implements TaskManager {
    private List<TaskDTO> listAllTasks = new ArrayList<>();
    private final Logger logger = Logger.getLogger(TaskManagerImpl.class.getName());

    public TaskManagerImpl(List<TaskDTO> listAllTasks) {
        this.listAllTasks = listAllTasks;
    }

    public void checkAllTasks() {
        for (TaskDTO task : listAllTasks) {
            if(task.getExecutionTime().isBefore(LocalDateTime.now()) && task.getTaskStatus() == Status.IN_PROGRESS) {
                changeTaskCompleted(task);
                showTaskCompleted(task);
            }
        }
    }

    public void changeTaskCompleted(TaskDTO task) {
        task.setTaskStatus(Status.COMPLETED);
    }

    public void showTaskCompleted(TaskDTO task) {
        if(task.getTaskStatus() == Status.COMPLETED) {
            logger.info("Task " + task.getTaskName() + " is completed");
        }
    }
}
