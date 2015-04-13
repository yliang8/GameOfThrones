import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;

import jxl.read.biff.BiffException;

public class ActionPhase {
	
	/*
	 * ACTION PHASE : 
	 * Each house reveal and resolve order tokens
	 * Assume we only have march order now
	 */
	
	public void resolveMarchOrders() throws BiffException, IOException{
		for(int i = 0; i<Tracks.ironThrone.length;i++){
			House house = Tracks.ironThrone[i];
			LinkedList<Territory> terrs = house.getTerrs();
			LinkedList<Territory> conquerredTerrs = new LinkedList<Territory> ();
			for (Territory T : terrs){
				String orderName = "";
				if(T.getOrder()!=null){
					orderName = T.getOrder().getName();
				}
				if (orderName.equals("march0") || orderName.equals("marchn")){					
					// get the adjacent territories that the current units are moving into
					conquerredTerrs = getConquerredTerritory(house, T, T.getOrder());
					T.deleteOrder();
				}
			}
			// move random units to the conquerred areas
			for (Territory T: conquerredTerrs){
				if(!house.getTerrs().contains(T)) house.getTerrs().add(T);
			}
		}
	}
	
	public int randomInt(int max){ 
		Random rand = new Random ();
		int i = rand.nextInt(max + 1); //return [0 - max]
		//random.nextInt(max - min + 1) + min === > return [min, max]
		return i;
	}
	
	// randomly choose several adjacent territories that the current units are moving into
	public LinkedList<Territory> getConquerredTerritory(House house, Territory terr, Order order) throws BiffException, IOException{
		LinkedList<Territory> conquerred = new LinkedList<Territory> ();
		Territory[] adjT = terr.getAdj();
		
		LinkedList<Unit> unitList = terr.getUnits();
		LinkedList<Unit> unitToDelete = new LinkedList<Unit> ();
		int random = randomInt(adjT.length-1);
		for(Unit unit: unitList){
			if (adjT[random].getUnits().isEmpty()&&adjT[random].getNeutral()==false){
					adjT[random].addUnits(unit.clone());
					conquerred.add(adjT[random]);
					unitToDelete.add(unit);
			}
		}
		for(Unit unit: unitToDelete){
			terr.deleteUnit(unit);
		}
		return conquerred;
	}
}
