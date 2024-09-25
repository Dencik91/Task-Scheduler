package task_manager.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServerNotification {
    private static TaskManagerImpl taskManager;
    static boolean isRunning = true;
    static Logger logger = LoggerFactory.getLogger(ServerNotification.class);

    public static void startServer() {
        while (isRunning) {
            taskManager = new TaskManagerImpl(PostgresConnector.connect());
            taskManager.checkAllTasks();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                logger.info("Server interrupted");
            }
        }
    }

    public static void main(String[] args) {
        startServer();
    }
}
