package com.alz.mytime.domain.dto;

import com.alz.mytime.domain.entity.Task;
import lombok.Getter;
import org.apache.tomcat.jni.Local;

import java.time.LocalDateTime;

@Getter
public class TaskDTO {
    private final Integer id;
    private final String taskName;
    private final String description;

    private final LocalDateTime startTime;
    private final Integer completedTime;

    // changeable fields

    private final Integer accumulatedRunningTime;
    private final Integer accumulatedPauseTime;
    private final boolean running;
    private final boolean pause;
    private final LocalDateTime tmpStartTime;

    public TaskDTO(Task t) {
        this.id = t.getId();
        this.taskName = t.getTaskName();
        this.description = t.getDescription();
        this.startTime = t.getStartTime();
        this.completedTime = t.getCompletedTime();
        this.accumulatedRunningTime = t.getAccumulatedRunningTime();
        this.accumulatedPauseTime = t.getAccumulatedPauseTime();
        this.running = t.isRunning();
        this.pause = t.isPause();
        this.tmpStartTime = t.getTmpStartTime();

    }
}
