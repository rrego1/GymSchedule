/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymschedule;

import java.util.ArrayList;

/**
 *
 * @author reggs
 */
public class Referee {
    
    private String name;
    private ArrayList<Sport> sports;
    private ArrayList<Availability> available;
    private ArrayList<Availability> scheduled;
    private int availableHours;
    private int scheduledHours;
    
    public Referee(){
        sports = new ArrayList();
        available = new ArrayList();
        scheduled = new ArrayList();
        availableHours = 0;
        scheduledHours = 0;
    }
    
    public Referee(String name){
        this.name = name;
        sports = new ArrayList();
        available = new ArrayList();
        scheduled = new ArrayList();
        availableHours = 0;
        scheduledHours = 0;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Sport> getSports() {
        return sports;
    }

    public void setSports(ArrayList<Sport> sports) {
        this.sports = sports;
    }

    public ArrayList<Availability> getAvailable() {
        return available;
    }

    public void setAvailable(ArrayList<Availability> available) {
        this.available = available;
    }
    
    public void addAvailablity(Availability availability){
        int hoursFree = availability.getEndTime() - availability.getStartTime();
        availableHours = availableHours + hoursFree;
        available.add(availability);
    }

    public ArrayList<Availability> getScheduled() {
        return scheduled;
    }

    public void setScheduled(ArrayList<Availability> scheduled) {
        this.scheduled = scheduled;
    }

    public int getAvailableHours() {
        return availableHours;
    }

    public void setAvailableHours(int availableHours) {
        this.availableHours = availableHours;
    }

    public int getScheduledHours() {
        return scheduledHours;
    }

    public void setScheduledHours(int scheduledHours) {
        this.scheduledHours = scheduledHours;
    }
    
    public boolean isFree(Day day, int time, int gameLength){
        boolean free = false;
        
        for(Availability timeslot : available){
            if(timeslot.getDay() == day){
                if(timeslot.getStartTime() <= time && timeslot.getEndTime() >= time + gameLength){
                    return true;
                }
            }
        }
        return free;
    }
    
    public void updateAvailability(Day day, int time, int gameLength){
        for(Availability timeslot : available){
            if(timeslot.getDay() == day){
                if(timeslot.getStartTime() <= time && timeslot.getEndTime() >= time - gameLength){
                    int oldStart = timeslot.getStartTime();
                    int oldEnd = timeslot.getEndTime();
                    if(time - oldStart == 0 && oldEnd - time == 0){
                        //fills up the whole block of time
                        available.remove(timeslot);
                    }
                    else if(time - oldStart == 0){
                        //start of the time block
                        timeslot.setStartTime(oldStart + gameLength);
                    }else if(oldEnd - time == 0){
                        //ends of the time block
                        timeslot.setEndTime(oldEnd - gameLength);
                    }else{
                        //middle of the time block - hopefully never really used
                        Availability newSlot = new Availability();
                        newSlot.setDay(day);
                        newSlot.setStartTime(oldStart);
                        newSlot.setEndTime(time);
                        
                        timeslot.setEndTime(time + gameLength);
                        
                        available.add(newSlot);
                    }
                    break;
                }
            }
        }
    }

    public void scheduleHours(int gameLength) {
        this.scheduledHours = this.scheduledHours + gameLength;
    }
    
    public boolean canRef(Sport sport){
        for(Sport spt : sports){
            if(spt.equals(sport)){
                return true;
            }
        }
        return false;
    }

}
