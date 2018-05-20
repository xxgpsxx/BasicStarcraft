public class Location
{
	private int x = 0;
	private int y = 0;
	public Location() {}
	public Location(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	public int getX() { return x; }
	public int getY() { return y; }
	public double distanceFrom(Location other)
	{
		int x2 = other.getX();
		int y2 = other.getY();
		return Math.sqrt(((x - x2) * (x - x2)) + ((y - y2) * (y - y2)));
	}
}