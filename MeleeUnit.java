public class MeleeUnit extends Unit
{
	public MeleeUnit(Map map, int health, int armor, Location location, int owner, double speed, int damage, double radius)
	{
		super(map, health, armor, location, owner, speed, damage, radius);
	}
	public MeleeUnit(Map map, int health, int armor, Location location, double speed, int damage, double radius)
	{
		super(map, health, armor, location, speed, damage, radius);
	}
	public Boolean inContact(Unit other) { return super.getRadius() + other.getRadius() <= super.getLocation().distanceFrom(other.getLocation()); }

}

