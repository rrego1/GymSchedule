/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymschedule;

/**
 *
 * @author reggs
 */
public class Availability {
    
    private Day day;
    private int startTime;
    private int endTime;
    
    public Availability(){
        
    }
    
    public Availability(Day day, int startTime, int endTime){
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }
    
    public void combine(Availability timeslot){
        this.endTime = timeslot.endTime;
    }
}
