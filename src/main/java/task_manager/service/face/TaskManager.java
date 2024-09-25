package task_manager.service.face;

import task_manager.dataTransferObject.TaskDTO;

public interface TaskManager {
    void checkAllTasks();
    void changeTaskCompleted(TaskDTO task);
    void showTaskCompleted(TaskDTO task);
}
