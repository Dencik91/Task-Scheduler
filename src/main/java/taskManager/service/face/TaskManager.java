package taskManager.service.face;

import taskManager.dataTransferObject.TaskDTO;

import java.util.ArrayList;
import java.util.List;

public interface TaskManager {
    void checkAllTasks();
    void changeTaskCompleted(TaskDTO task);
    void showTaskCompleted(TaskDTO task);
}
