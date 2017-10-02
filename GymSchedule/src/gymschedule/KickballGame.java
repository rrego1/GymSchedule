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
public class KickballGame {
    
    private Referee ref;
    private Day day;
    private int time;
    
    private static final int GAME_LENGTH = 1;
    
    public KickballGame(){
        
    }
    
    public KickballGame(Day day, int time){
        this.day = day;
        this.time = time;
    }
    
    public void setRef(Referee ref){
        this.ref = ref;
    }
    
    public Referee getRef(){
        return ref;
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
        if(ref == null){
            return false;
        }
        
        return true;
    }
    
    public boolean isReffing(Referee ref){
        if(this.ref.equals(ref)){
            return true;
        }else{
            return false;
        }
    }
    
    public void removeRef(Referee ref){
        
        if(ref.equals(this.ref)){
            this.ref = null;
        }
        
        ref.removeGame(day, time, GAME_LENGTH);
    }
}
