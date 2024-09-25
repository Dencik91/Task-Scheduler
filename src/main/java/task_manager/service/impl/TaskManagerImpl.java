package task_manager.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import task_manager.Status;
import task_manager.dataTransferObject.TaskDTO;
import task_manager.service.face.TaskManager;

import java.time.LocalDateTime;
import java.util.List;


public class TaskManagerImpl implements TaskManager {
    private final List<TaskDTO> listAllTasks;
    private final Logger logger = LoggerFactory.getLogger(TaskManagerImpl.class);

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
        PostgresConnector.taskCompleted(task.getTaskName());
    }

    public void showTaskCompleted(TaskDTO task) {
        if(task.getTaskStatus() == Status.COMPLETED) {
            logger.info("Task {} is completed", task.getTaskName());
        }
    }

}
