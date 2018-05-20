public class Unit extends Thing
{
	private double speed = 0;
	private int damage = 0;
	private double radius = 0.0;
	private boolean attacking = false;
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
	public Map getMap() { return super.getMap(); }
	public boolean isAttacking() { return attacking; }
	public double getRadius() { return radius; }
	public double getSpeed() { return speed; }
	public int getDamage() { return damage; }
}

