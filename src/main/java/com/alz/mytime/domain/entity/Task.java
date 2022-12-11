package com.alz.mytime.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "task")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @OneToMany(mappedBy = "task",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TaskRecord> taskRecords = new ArrayList<>();


    @Column(name = "task_name")
    private String taskName;

    @Column
    private String description;

    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    @Column(name = "start_time")
    private LocalDateTime startTime;
    @Column(name = "completed_time")
    private Integer completedTime;
    // changeable fields
    @Column(name = "accumulated_running_time")
    private Integer accumulatedRunningTime;
    @Column(name = "accumulated_pause_time")
    private Integer accumulatedPauseTime;
    @Column
    private boolean running;
    @Column
    private boolean pause;

    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    @Column(name = "tmp_start_time")
    private LocalDateTime tmpStartTime;


}
