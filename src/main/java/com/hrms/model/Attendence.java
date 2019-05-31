package com.hrms.model;

import java.util.Date;

public class Attendence {
    private Integer attendenceId;

    private Date attendenceDate;

    private Integer employeeId;

    private Date workTime;

    private Date offTime;

    public boolean isLate() {
        return isLate;
    }

    public void setLate(boolean late) {
        isLate = late;
    }

    public boolean isAbsence() {
        return isAbsence;
    }

    public void setAbsence(boolean absence) {
        isAbsence = absence;
    }

    private boolean isLate;

    private  boolean isAbsence;

    public Integer getAttendenceId() {
        return attendenceId;
    }

    public void setAttendenceId(Integer attendenceId) {
        this.attendenceId = attendenceId;
    }

    public Date getAttendenceDate() {
        return attendenceDate;
    }

    public void setAttendenceDate(Date attendenceDate) {
        this.attendenceDate = attendenceDate;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Date getWorkTime() {
        return workTime;
    }

    public void setWorkTime(Date workTime) {
        this.workTime = workTime;
    }

    public Date getOffTime() {
        return offTime;
    }

    public void setOffTime(Date offTime) {
        this.offTime = offTime;
    }
}