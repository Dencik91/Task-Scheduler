package taskManager.dataTransferObject;

import lombok.Getter;
import lombok.Setter;
import taskManager.Status;

import java.time.LocalDateTime;

@Getter
@Setter
public class TaskDTO {
    private String taskName;
    private LocalDateTime executionTime;
    private Status taskStatus;

    public TaskDTO(String taskName, LocalDateTime executionTime) {
        this.taskName = taskName;
        this.executionTime = executionTime;
        this.taskStatus = Status.IN_PROGRESS;
    }

}
