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

    
    static ArrayList<Referee> referees;
        
    public static void main(String[] args) {
        
        ArrayList<FootballGame> footballGames = new ArrayList();
        ArrayList<SoccerGame> soccerGames = new ArrayList();
        ArrayList<KickballGame> kickballGames = new ArrayList();
        
        ArrayList<Referee> referees = loadAvailibilty();
        
        scheduleFootball(footballGames, referees);
        scheduleSoccer(soccerGames, referees);
        scheduleKickball(kickballGames, referees);
           
    }
 
    private static ArrayList<Referee> loadAvailibilty() {
        
        //not implemented yet
        
        return null;
    }
    
    private static void scheduleFootball(ArrayList<FootballGame> footballGames, ArrayList<Referee> referees){
        //not implemented yet
    }
    
    private static void scheduleSoccer(ArrayList<SoccerGame> SoccerGames, ArrayList<Referee> referees){
        for(SoccerGame game : SoccerGames){
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
}
