package com.alz.mytime.domain.dto;

import com.alz.mytime.domain.entity.Task;
import com.alz.mytime.domain.entity.TaskRecord;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
public class TaskRecordDTO {
    private final Integer id;

    private final LocalDateTime startTime;

    private final LocalDateTime completeTime;

    private final Integer durationSecond;

    private final Integer accumulatedPauseTime;

    public TaskRecordDTO(TaskRecord tr) {
        this.id = tr.getId();
        this.startTime = tr.getStartTime();
        this.completeTime = tr.getCompleteTime();
        this.durationSecond = tr.getDurationSecond();
        this.accumulatedPauseTime = tr.getAccumulatedPauseTime();
    }
}
