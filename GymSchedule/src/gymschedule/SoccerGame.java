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
public class SoccerGame {
    
    private Referee ref1;
    private Referee ref2;
    private Day day;
    private int time;
    
    private static final int GAME_LENGTH = 1;
    
    public SoccerGame(){
        
    }
    
    public SoccerGame(Day day, int time){
        this.day = day;
        this.time = time;
    }
    
    public void setRef1(Referee ref1){
        this.ref1 = ref1;
        ref1.scheduleHours(GAME_LENGTH);
        ref1.updateAvailability(day, time, GAME_LENGTH);
        ref1.addGame(day, time, GAME_LENGTH);
    }
    
    public Referee getRef1(){
        return ref1;
    }
    
    public void setRef2(Referee ref2){
        this.ref2 = ref2;
        ref2.scheduleHours(GAME_LENGTH);
        ref2.updateAvailability(day, time, GAME_LENGTH);
        ref2.addGame(day, time, GAME_LENGTH);
    }
    
    public Referee getRef2(){
        return ref2;
    }
    
    public void setDay(Day day){
        this.day = day;
    }
    
    public Day getDay(){
        return day;
    }
    
    public void setTime(int time){
        this.time = time;
    }
    
    public int getTime(){
        return time;
    }
    
    public int getGameLength(){
        return GAME_LENGTH;
    }
    
    public boolean isFull(){
        if(ref1 == null && ref2 == null){
            return false;
        }
        
        return true;
    }
    
    public boolean isReffing(Referee ref){
        if(ref1.equals(ref) || ref2.equals(ref)){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean addRef(Referee ref){
        if(ref1 == null){
            this.setRef1(ref);
        }else{
            if(ref2 == null){
                this.setRef2(ref);
            }else{
                return false;
            }
        }      
        return true;
    }
    
    public void removeRef(Referee ref){
        
        if(ref.equals(ref1)){
            ref1 = null;
        }else if(ref.equals(ref2)){
            ref2 = null;
        }
        
        ref.removeGame(day, time, GAME_LENGTH);
    }
}
