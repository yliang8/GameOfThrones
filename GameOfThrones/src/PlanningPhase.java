import java.util.LinkedList;
import java.util.Random;


public class PlanningPhase {
	/*
	 * PLANNING PHASE : 
	 * Each house place down their order tokens
	 */
	
	public void placeTokens(House lannister, House baratheon, House stark, House greyjoy, House tyrell, House martell){ 
		//completely at random for now (ignore the power track)
		for (int i = 0 ; i<6 ;i++){
			House house = new House();
			LinkedList<Territory> terrLL = new LinkedList<Territory> ();
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
			terrLL = house.getTerrs();
			for (Territory t: terrLL){
				String order = getRandomOrder(house);
				Order o = house.getOrder(order);
				t.setOrder(o); //place token down to the map
				house.getOrders().remove(o); //remove this token from the player's collections
			}
		}
	}
	
	public String getRandomOrder(House h){ 
		//no special order for now 
		Random rand = new Random();
		int i = rand.nextInt(6);
		switch (i){
		case 0:
			if(h.containsOrder("raid")) return "raid";
			break;
		case 1:
			if(h.containsOrder("march0")) return "march0";
			break;
		case 2:
			if(h.containsOrder("marchn")) return "marchn";
			break;
		case 3:
			if(h.containsOrder("defense")) return "defense";
			break;
		case 4:
			if(h.containsOrder("support")) return "support";
			break;
		case 5:
			if(h.containsOrder("consolidate")) return "consolidate";
			break;
		}
		return getRandomOrder(h);
	}
}
