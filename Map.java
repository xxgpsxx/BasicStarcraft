import java.util.ArrayList;
public class Map
{
	private int x = 2000;
	private int y = 2000;
	private ArrayList <Building> buildings = new ArrayList <Building>();
	private ArrayList <Player> players = new ArrayList <Player>();
	private ArrayList <Unit> units = new ArrayList <Unit>();
	public Map(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	public Map()
	{
	}
	public Player add(Player player) { players.add(player); return player; }
	public int getX() { return x; }
	public int getY() { return y; }
	public ArrayList <Unit> getUnits() { return units; }
	public ArrayList <Player> getPlayers() { return players; }
	public ArrayList <Building> getBuildings() { return buildings; }
	public Player getPlayerByNumber(int number)
	{
		for(Player player : players)
			if(player.getNumber() == number)
				return player;
		return null;
	}
	public Building add(Building building) { buildings.add(building); return building; }
}