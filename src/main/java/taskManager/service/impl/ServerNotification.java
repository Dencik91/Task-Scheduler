package taskManager.service.impl;

import lombok.Getter;
import lombok.Setter;
import taskManager.Status;

@Getter
@Setter
public class ServerNotification {
    private String taskName;
    private int taskTime;
    private Status taskStatus;
}
