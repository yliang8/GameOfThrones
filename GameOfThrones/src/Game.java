import java.io.IOException;
import java.util.Hashtable;

import jxl.read.biff.BiffException;


public class Game{
	
	public House lannister = new House ("lannister");
	public House baratheon = new House ("baratheon");
	public House stark = new House ("stark");
	public House greyjoy = new House ("greyjoy");
	public House tyrell = new House ("tyrell");
	public House martell = new House ("martell");
	
	public void play() throws BiffException, IOException{
		// GETTING START PHASE
		SetUpPhase setUp = new SetUpPhase();
		// Initialize the map
		setUp.initializeTerrList(); 
		// Each house put down their starting units
		setUp.initializeUnits(lannister, baratheon, stark, greyjoy, tyrell, martell);  
		// Each house mark down their position on power tracks
		setUp.initializePowerTrack(lannister, baratheon, stark, greyjoy, tyrell, martell); 
		// Each house get 15 order tokens
		setUp.initializeHouseOrders(lannister, baratheon, stark, greyjoy, tyrell, martell);
		// Wildling track on position 0, Round tracks at position 1
		setUp.initializeWildingAndRoundTrack();
		// Initialize House Cards
		setUp.initializeHouseCards(lannister, baratheon, stark, greyjoy, tyrell, martell); 
		//Place down neutral force token for 6 players
		setUp.intiailizeNeutralTokens(6); 
		
		// PLANNING PHASE AND ACTION PHASE
		PlanningPhase pp = new PlanningPhase ();
		ActionPhase ap = new ActionPhase();
		for (int i = 0;i<10;i++){
			pp.placeTokens(lannister, baratheon, stark, greyjoy, tyrell, martell); //Each house place down their order tokens
			ap.resolveMarchOrders();
			lannister.deleteOrders();
			lannister.addOrders();
			baratheon.deleteOrders();
			baratheon.addOrders();
			stark.deleteOrders();
			stark.addOrders();
			greyjoy.deleteOrders();
			greyjoy.addOrders();
			tyrell.deleteOrders();
			tyrell.addOrders();
			martell.deleteOrders();
			martell.addOrders();
		}	
	}
	
	public String getWinner(){
		int castleTerr = 0;
		int max = 0;
		String houseName = "";
		for (int i = 0; i<6 ; i++){
			castleTerr = 0;
			House house = new House();
			switch (i){
			case 0: 
				house = lannister;
				break;
			case 1:
				house = baratheon;
				break;
			case 2:
				house = stark;
				break;
			case 3:
				house = greyjoy;
				break;
			case 4:
				house = tyrell;
				break;
			case 5:
				house = martell;
				break;
			}
			for(Territory T: house.getTerrs()){
				if(T.getCastle()==1 || T.getCastle() == 2){ //castle = 1, stronghold = 2, no castle or stronghold = 0;
					 castleTerr+=1;
				}
			}
			if(castleTerr> max){
				max = castleTerr;
				houseName = house.getName();
			}
			
		}
		return houseName;
	}
	
}
