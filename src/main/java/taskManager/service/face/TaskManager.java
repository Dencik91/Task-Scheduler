package taskManager.service.face;

import taskManager.service.impl.ServerNotification;

import java.util.ArrayList;

public interface TaskManager {
    ArrayList<ServerNotification> listAllTasks();
    void checkAllTasks();
    void changeTaskCompleted(ServerNotification task);
    void showTaskCompleted(ServerNotification task);
}
