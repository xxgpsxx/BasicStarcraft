public class Worker extends MeleeUnit
{
	private int cargo = 0;
	private boolean building = false;

	public Worker(Map map, int health, int armor, Location location, int owner, double speed)
	{
		super(map, health, armor, location, owner, speed, 5, 1.5);
	}
	public Worker(Map map, int health, int armor, Location location, double speed, int damage, double radius)
	{
		super(map, health, armor, location, speed, 5, 1.5);
	}
	public Map getMap() { return super.getMap(); }
}