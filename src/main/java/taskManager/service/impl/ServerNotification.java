package taskManager.service.impl;


import taskManager.Status;
import taskManager.dataTransferObject.TaskDTO;

import java.time.LocalDateTime;
import java.util.List;

public class ServerNotification {
    private static TaskManagerImpl taskManager;
    static boolean isRunning = true;

    public static void startServer() {
        while (isRunning) {
            taskManager = new TaskManagerImpl(PostgresConector.connect());
            taskManager.checkAllTasks();

            try {
                // Așteaptă 5 secunde înainte de a verifica din nou
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restartează flag-ul de întrerupere
                System.out.println("Server interrupted");
            }
        }
    }

    public static void main(String[] args) {
        startServer();
    }
}
