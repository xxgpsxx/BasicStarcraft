public class Building extends Thing
{
	private int[] size = new int[2];
	public Building(Map map, int health, int armor, Location location, int owner, int x, int y)
	{
		super(map, health, armor, location, owner);
		size[0] = x;
		size[1] = y;
	}
	public Building(Map map, int health, int armor, Location location, int x, int y)
	{
		super(map, health, armor, location);
		size[0] = x;
		size[1] = y;
	}
	public Map getMap() { return super.getMap(); }
	public int getWidth() { return size[0]; }
	public int getHeight() { return size[1]; }
}