package taskManager.service.impl;


import taskManager.dataTransferObject.TaskDTO;

import java.time.LocalDateTime;
import java.util.List;

public class ServerNotification {
    private static TaskManagerImpl taskManager;
    static boolean isRunning = true;

    public static void startServer() {
        taskManager = new TaskManagerImpl(List.of(new TaskDTO("Task1", LocalDateTime.now())));
        while (isRunning) {
            taskManager.checkAllTasks();
        }
    }

    public static void main(String[] args) {
        startServer();
    }
}
