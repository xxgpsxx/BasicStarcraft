import java.util.ArrayList;

public class Player
{
	private int number;
	private ArrayList <Building> buildings = new ArrayList <Building>();
	//private ArrayList <MainBuilding> mainBuildings = new ArrayList <MainBuilding>();
	private ArrayList <Unit> armyUnits = new ArrayList <Unit>();
	private ArrayList <Worker> worker = new ArrayList <Worker>();
	private int minerals;
	private int[] supply = new int[2];
	private ArrayList <Thing> selection = new ArrayList <Thing>();
	private Map map;
	public Player(int number, Map map)
	{
		this.number = number;
		this.map = map;
	}
	public Map getMap() { return map; }
	public int getNumber() { return number; }
	public ArrayList <Building> getBuildings() { return buildings; }
	public ArrayList <Unit> getArmyUnits() { return armyUnits; }
	public ArrayList <Worker> getWorkers() { return worker; }
	public int getMinerals() { return minerals; }
	public int getAvailableSupply() { return supply[1]; }
	public int getUsedSupply() { return supply[0]; }
	public ArrayList <Thing> getSelection() { return selection; }
}