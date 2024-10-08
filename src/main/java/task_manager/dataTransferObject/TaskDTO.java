package task_manager.dataTransferObject;

import lombok.Getter;
import lombok.Setter;
import task_manager.Status;

import java.time.LocalDateTime;

@Getter
@Setter
public class TaskDTO {
    private String taskName;
    private LocalDateTime executionTime;
    private Status taskStatus;

    public TaskDTO(String taskName, LocalDateTime executionTime, Status taskStatus) {
        this.taskName = taskName;
        this.executionTime = executionTime;
        this.taskStatus = taskStatus;
    }

}
