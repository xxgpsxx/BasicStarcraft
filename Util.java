public class Unit extends Thing
{
	private double speed = 0;
	private int damage = 0;
	private double radius = 0.0;
	private boolean attacking = false;
	private Location target;
	private double direction = 90.0;
	private boolean moving = false;
	public Unit(Map map, int health, int armor, Location location, int owner, double speed, int damage, double radius)
	{
		super(map, health, armor, location, owner);
		this.speed = speed;
		this.damage = damage;
		this.radius = radius;
	}
	public Unit(Map map, int health, int armor, Location location, double speed, int damage, double radius)
	{
		super(map, health, armor, location);
		this.speed = speed;
		this.damage = damage;
		this.radius = radius;
	}
	public Location moveTo(Location target)
	{
		direction = this.getLocation().getAngleTo(target);
		double distance = this.getLocation().distanceFrom(target);
		double remainder = distance % speed;
		double modified = distance - remainder;
		target = this.getLocation().getLocationByDistance(
			modified,
			direction); //works
		moving = true;
		System.out.println(target);
		System.out.println(direction);
		return target;
	}
	public double setDirection(double x)
	{
		direction = x;
		return x;
	}
	public Location setLocation(Location location)
	{
		this.teleportTo(location);
		if(super.getLocation() == target)
			moving = false;
		if(this.getLocation() != null)
			direction = this.getLocation().getAngleTo(target);
		return location;
	}
	public double turn(double direction) { this.direction = direction; return direction; }
	public boolean isMoving() { return moving; }
	public double getDirection() { return direction; }
	public Location getTarget() { return target; }
	public Map getMap() { return super.getMap(); }
	public boolean isAttacking() { return attacking; }
	public double getRadius() { return radius; }
	public double getSpeed() { return speed; }
	public int getDamage() { return damage; }
}

