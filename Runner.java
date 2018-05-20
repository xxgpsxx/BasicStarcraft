import java.util.ArrayList;
public class Runner
{
	public Runner()
	{
		Map map = new Map();
		map.add(new Player(1, map));
		map.add(new Player(2, map));
		map.add(new Building(1000, 3, new Location(200, 200), 1, 5, 5));
		map.add(new Building(1000, 3, new Location(800, 200), 2, 5, 5));
	}
	public static void main(String args[])
	{
		Runner app = new Runner();
	}
}