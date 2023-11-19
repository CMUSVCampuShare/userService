package com.campushare.userservice.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "schedule")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {
    private String scheduleName; //corresponding to username
    private Date mondayEntry;
    private Date mondayExit;
    private Date tuesdayEntry;
    private Date tuesdayExit;
    private Date wednesdayEntry;
    private Date wednesdayExit;
    private Date thursdayEntry;
    private Date thursdayExit;
    private Date fridayEntry;
    private Date fridayExit;

}