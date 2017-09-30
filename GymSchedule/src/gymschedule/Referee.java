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

    /*public void setAvailable(ArrayList<Availability> available) {
        this.available = available;
    }*/

    public ArrayList<Availability> getScheduled() {
        return scheduled;
    }

    /*public void setScheduled(ArrayList<Availability> scheduled) {
        this.scheduled = scheduled;
    }*/

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
}
