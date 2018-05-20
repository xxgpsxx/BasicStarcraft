public class RangedUnit extends Unit
{
	private double range = 0;
	public RangedUnit(Map map, int health, int armor, Location location, int owner, double speed, int damage, double radius, double range)
	{
		super(map, health, armor, location, owner, speed, damage, radius);
		this.range = range;
	}
	public RangedUnit(Map map, int health, int armor, Location location, double speed, int damage, double radius, double range)
	{
		super(map, health, armor, location, speed, damage, radius);
		this.range = range;
	}
	public Map getMap() { return super.getMap(); }
	public double getRange() { return range; }
	public Boolean inRange(Unit other) { return range >= super.getLocation().distanceFrom(other.getLocation()); }

}

