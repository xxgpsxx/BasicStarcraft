public class Thing
{
	private int health = 0;
	private int armor = 0;
	private Boolean alive = true;
	private int owner = 0;
	private Location location = new Location();
	private Map map;
	public Thing(Map map, int health, int armor, Location location, int owner)
	{
		this.map = map;
		this.health = health;
		this.armor = armor;
		this.owner = owner;
		this.location = location;
	}
	public Thing(Map map, int health, int armor, Location location)
	{
		this.map = map;
		this.health = health;
		this.armor = armor;
		this.location = location;
	}
	public Location teleportTo(Location location) { this.location = location; return location; }
	public Map getMap() { return map; }
	public int getOwner() { return owner; }
	public Location getLocation() { return location; }
	public int getHealth() { return health; }
	public int getArmor() { return armor; }
	public int receiveDamage(int damage) { health -= (damage - armor); return health; }
	public int receiveDamage(int damage, int attacks) { health -= attacks * (damage - armor); return health; }
}
