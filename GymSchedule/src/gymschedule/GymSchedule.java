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
public class GymSchedule {

    /**
     * @param args the command line arguments
     */
        
    public static void main(String[] args) {
        
        ArrayList<FootballGame> footballGames = new ArrayList();
        ArrayList<SoccerGame> soccerGames = new ArrayList();
        ArrayList<KickballGame> kickballGames = new ArrayList();
        
        ArrayList<Referee> referees = loadAvailibilty();
        
        /*
        for testing
        */      
        for(int i = 7; i <= 10; i++){
            
            SoccerGame game1 = new SoccerGame(Day.MONDAY, i);
            SoccerGame game2 = new SoccerGame(Day.TUESDAY, i);
            SoccerGame game3 = new SoccerGame(Day.WEDNESDAY, i);
            SoccerGame game4 = new SoccerGame(Day.THURSDAY, i);
            
            soccerGames.add(game1);
            soccerGames.add(game2);
            soccerGames.add(game3);
            soccerGames.add(game4);
        }
        //***********************************************
        
        scheduleFootball(footballGames, referees);
        scheduleSoccer(soccerGames, referees);
        scheduleKickball(kickballGames, referees);
           
        printSchedule(referees);
    }
 
    private static ArrayList<Referee> loadAvailibilty() {
        
        //not implemented yet
        
        return getTestRefs();
    }
    
    private static void scheduleFootball(ArrayList<FootballGame> footballGames, ArrayList<Referee> referees){
        //not implemented yet
    }
    
    private static void scheduleSoccer(ArrayList<SoccerGame> soccerGames, ArrayList<Referee> referees){
        for(SoccerGame game : soccerGames){
            for(Referee ref : referees){
                if(ref.isFree(game.getDay(), game.getTime(), game.getGameLength()) && ref.canRef(Sport.SOCCER)){
                    if(game.getRef1() == null){
                        game.setRef1(ref);
                    }else{
                        if(game.getRef2() == null){
                            game.setRef2(ref);
                        }else{
                            break;
                        }
                    }
                }
            }
            //ADD HERE WHAT HAPPENS WHEN NO REFEREE IS FREE
        }
    }
        
    private static void scheduleKickball(ArrayList<KickballGame> KickballGames, ArrayList<Referee> referees){
        //not implemented yet
    }
    
    private static void printSchedule(ArrayList<Referee> referees){
        for(Referee ref : referees){
            System.out.print(ref.getName() + ": ");
            for(Availability schedule : ref.getScheduled()){
                System.out.print(schedule.toString());
            }
            System.out.println();
        }
    }
    
    private static ArrayList<Referee> getTestRefs(){
        
        ArrayList<Referee> refs = new ArrayList();
        
        Referee ryan = new Referee("Ryan");
        ryan.addSport(Sport.SOCCER);
        Referee amanda = new Referee("Amanda");
        amanda.addSport(Sport.SOCCER);
        Referee jenn = new Referee("Jenn");
        jenn.addSport(Sport.SOCCER);
        Referee steph = new Referee("Steph");
        steph.addSport(Sport.SOCCER);
        
        Availability monday = new Availability(Day.MONDAY, 7, 11);
        Availability tuesday = new Availability(Day.TUESDAY, 7, 11);
        Availability wednesday = new Availability(Day.WEDNESDAY, 7, 11);
        Availability thursday = new Availability(Day.THURSDAY, 7, 11);
        
        Availability mondayA = new Availability(Day.MONDAY, 7, 11);
        Availability tuesdayA = new Availability(Day.TUESDAY, 7, 11);
        Availability wednesdayA = new Availability(Day.WEDNESDAY, 7, 11);
        Availability thursdayA = new Availability(Day.THURSDAY, 7, 11);
        
                
        refs.add(ryan);
        refs.add(amanda);
        refs.add(jenn);
        refs.add(steph);
        
        ryan.addAvailablity(monday);
        ryan.addAvailablity(tuesday);
        ryan.addAvailablity(wednesday);
        ryan.addAvailablity(thursday);
        
        amanda.addAvailablity(mondayA);
        amanda.addAvailablity(tuesdayA);
        amanda.addAvailablity(wednesdayA);
        amanda.addAvailablity(thursdayA);
        
        return refs;
    }
   
}
