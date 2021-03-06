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
public class FootballGame {
    
    private Referee head;
    private Referee line;
    private Referee back;
    private Day day;
    private int time;
    
    private static final int GAME_LENGTH = 1;
    
    public FootballGame(){

    }
    
    public FootballGame(Day day, int time){
        this.day = day;
        this.time = time;
    }
    
    public void setHead(Referee head){
        this.head = head;
    }
    
    public Referee getHead(){
        return head;
    }
    
    public void setLine(Referee line){
        this.line = line;
    }
    
    public Referee getLine(){
        return line;
    }
    
    public void setBack(Referee back){
        this.back = back;
    }
    
    public Referee getBack(){
        return back;
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
        if(back == null && line == null && head == null){
            return false;
        }
        
        return true;
    }
    
    public boolean isReffing(Referee ref){
        if(head.equals(ref) || line.equals(ref) || back.equals(ref)){
            return true;
        }else{
            return false;
        }
    }
    
    public void removeRef(Referee ref){
        
        if(ref.equals(head)){
            head = null;
        }else if(ref.equals(line)){
            line = null;
        }else if(ref.equals(back)){
            back = null;
        }    
        ref.removeGame(day, time, GAME_LENGTH);
    }
}
