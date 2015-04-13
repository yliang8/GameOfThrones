import java.util.LinkedList;

public class Territory {
	private String name;
	private int supply; //number of supplies
	private int crown; //number of crowns
	private int castle;//castle = 1, stronghold = 2, no castle or stronghold = 0;
	private boolean landOrSea; //true(1) = sea, false(0) = land
	private Territory[] adjTerrs; //name of its adjacent areas
	private LinkedList<Unit> units = new LinkedList<Unit> (); //the units in this territory
	private Order order;
	private boolean neutral = false;
	 
	public Territory(){
		
	}
	
	public Territory(String name, int supply, int crown, int castle, boolean landOrSea){
		this.name = name;
		this.supply = supply;
		this.crown = crown;
		this.castle = castle; 
		this.landOrSea = landOrSea;
	}
	
	public void deleteAllUnits(){
		units.clear();
	}
	public String getName(){
		return name;
	}
	public int getSupply(){
		return supply;
	}
	public int getCrown(){
		return crown;
	}
	public int getCastle(){
		return castle;
	}
	public boolean getLandOrSea(){
		return landOrSea;
	}
	public Territory[] getAdj(){
		return adjTerrs;
	}
	public LinkedList<Unit> getUnits(){
		return units;
	}
	public Order getOrder(){
		return order;
	}
	public boolean getNeutral(){
		return neutral;
	}
	
	public void setName(String n){
		name = n;
	}
	public void setSupply(int s){
		supply = s;
	}
	public void setCrown(int c){
		crown = c;
	}
	public void setCastle(int c){
		castle = c;
	}
	public void setLandOrSea(boolean info){
		landOrSea = info;
	}
	public void setAdj(Territory[] adj){
		adjTerrs = adj;
	}
	public void addUnits(Unit u){
		units.add(u);
	}
	public void setOrder(Order o){
		order = o;
	}
	public void setNeutral(boolean n){
		neutral= n;
	}
	
	public void deleteOrder(){
		order = null;
	}	
	public void deleteUnit(Unit u){
		units.remove(u);
	}
	
	public String toString() {
		return String.format("%s, %d, %d, %d, %b, %s, %s\n", name, supply, crown, castle, landOrSea, units, order);
	}
}
