package com.epat2.fileManagement.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sivaprakash on 1/25/15.
 */
public class Employe {
    private String id;
    private String firstName;

    List<WeekAttendance> weekAttendance = new ArrayList<WeekAttendance>();

    public Map<String, List<DayProjectTaskActivity>> getDayProjectTask() {
        return dayProjectTask;
    }

    public void setDayProjectTask(Map<String, List<DayProjectTaskActivity>> dayProjectTask) {
        this.dayProjectTask = dayProjectTask;
    }

    Map<String,List<DayProjectTaskActivity>> dayProjectTask = new HashMap<String,List<DayProjectTaskActivity>>();





  /*  List<DayProjectTaskActivity> sunday= new ArrayList<DayProjectTaskActivity>();

    List<DayProjectTaskActivity> monday= new ArrayList<DayProjectTaskActivity>();

    List<DayProjectTaskActivity> tuesday= new ArrayList<DayProjectTaskActivity>();

    List<DayProjectTaskActivity> wensday= new ArrayList<DayProjectTaskActivity>();
    List<DayProjectTaskActivity> thursday= new ArrayList<DayProjectTaskActivity>();
    List<DayProjectTaskActivity> friday= new ArrayList<DayProjectTaskActivity>();
    List<DayProjectTaskActivity> saturday= new ArrayList<DayProjectTaskActivity>();

    public List<DayProjectTaskActivity> getMonday() {
        return monday;
    }

    public void setMonday(List<DayProjectTaskActivity> monday) {
        this.monday = monday;
    }

    public List<DayProjectTaskActivity> getSunday() {
        return sunday;
    }

    public void setSunday(List<DayProjectTaskActivity> sunday) {
        this.sunday = sunday;
    }
 */

    public List<WeekAttendance> getWeekAttendance() {
        return weekAttendance;
    }

    public void setWeekAttendance(List<WeekAttendance> weekAttendance) {
        this.weekAttendance = weekAttendance;
    }

    /*

    public WeekAttendance[] getWeekAttendance() {
        return weekAttendance;
    }

    public void setWeekAttendance(WeekAttendance[] weekAttendance) {
        this.weekAttendance = weekAttendance;
    }

*/
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }



}
