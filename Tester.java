public class Tester
{
	public Tester()
	{
		Location initial = new Location(0, 0);
		Location next = initial.getLocationByDistance(5.0, 315);
		double angle = initial.getAngleTo(next);
		double angle2 = next.getAngleTo(initial);
		System.out.println("Initial: " + initial);
		System.out.println("Next: " + next);
		System.out.println("Angle from Initial to Next: " + angle);
		System.out.println("Angle from Next to Initial: " + angle2);

	}
	public static void main(String args[])
	{
		Tester app = new Tester();
	}
}
