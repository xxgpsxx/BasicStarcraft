import java.util.ArrayList;

public class MainBuilding extends Building
{
	private final static int[] size = {75, 75};
	public MainBuilding(Map map, Location location, int owner)
	{
		super(map, 1500, 3, location, owner, size[0], size[1]);
	}
	public MainBuilding(Map map, Location location)
	{
		super(map, 1500, 3, location, size[0], size[1]);
	}
}