import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.*;
import javafx.scene.media.AudioClip;
import java.net.URL;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.event.*;
import javafx.scene.input.*;
import javafx.scene.text.*;
import java.util.Scanner;
public class Runner extends Application implements EventHandler<InputEvent>
{
	GraphicsContext gc;
	Image unit = new Image("trooper.jpg");
	int[] canvasSize = {1200, 700};
	int gridSize = 100;
	AnimateObjects animate;
	Map map;
	Color[] color = {Color.BLUE, Color.RED, Color.YELLOW};
	int players = 0;
	int x = 0;
	int y = 0;
	Scanner reader = new Scanner(System.in);

	public static void main(String[] args)
	{
		launch();
	}
	public void drawMap()
	{
		gc.setFill(Color.GREEN);
		gc.fillRect(0, 0, canvasSize[0], canvasSize[1]);

		gc.setFill(Color.WHITE);

		for(int x = 0; x < canvasSize[0]/gridSize; x++)
			gc.fillRect(x * gridSize, 0, 1, canvasSize[1]);

		for(int y = 0; y < canvasSize[1]/gridSize; y++)
			gc.fillRect(0, y * gridSize, canvasSize[0], 1);
	}
	public void start(Stage stage)
	{
		stage.setTitle("Basic Starcraft");
		Group root = new Group();

		Canvas canvas = new Canvas(canvasSize[0], canvasSize[1]);
		root.getChildren().add(canvas);

		Scene scene = new Scene(root);
		stage.setScene(scene);
		scene.addEventHandler(KeyEvent.KEY_PRESSED,this);
		scene.addEventHandler(MouseEvent.MOUSE_CLICKED, this);

		gc = canvas.getGraphicsContext2D();

		map = new Map();
		map.add(new Player(1, map));
		map.add(new Player(2, map));

		players = map.numPlayers();

		//map.add(new MainBuilding(map, new Location(200, 200), 1));
		//map.add(new MainBuilding(map, new Location(500, 500), 2));

		map.getPlayers().get(0).add(new Unit(map, 200, 3, new Location(0, 0), map.getPlayers().get(0).getNumber(), 15.0, 5, 50));

		map.getPlayers().get(0).getArmyUnits().get(0).moveTo(new Location(500, 500));
		animate = new AnimateObjects();
		animate.start();

		stage.show();
	}
	public class AnimateObjects extends AnimationTimer
	{
		public void handle(long now)
		{
			gc.clearRect(0, 0, canvasSize[0], canvasSize[1]);
			drawMap();
			for(Player player : map.getPlayers())
			{
				gc.setFill(color[player.getNumber() - 1]);
				for(Building building : player.getBuildings())
					gc.fillRect(
						building.getLocation().getX(),
						building.getLocation().getY(),
						building.getWidth(),
						building.getHeight());

				for(Unit unit : player.getArmyUnits())
				{
					if(unit.isMoving())
						unit.setLocation(
							unit.getLocation().getLocationByDistance(
								unit.getSpeed(),
								unit.getDirection()));

					gc.fillOval(
						unit.getLocation().getX(),
						unit.getLocation().getY(),
						unit.getRadius(),
						unit.getRadius());
				}
			}
			String str = reader.nextLine();
		}
	}
	public void handle(final InputEvent event)
	{
		if(event instanceof KeyEvent)
		{
			if(((KeyEvent)event).getCode() == KeyCode.LEFT || ((KeyEvent)event).getCode() == KeyCode.A)
				x -= 5;
			else if(((KeyEvent)event).getCode() == KeyCode.RIGHT || ((KeyEvent)event).getCode() == KeyCode.D)
				x += 5;
			else if(((KeyEvent)event).getCode() == KeyCode.UP || ((KeyEvent)event).getCode() == KeyCode.W)
				y -= 5;
			else if(((KeyEvent)event).getCode() == KeyCode.DOWN || ((KeyEvent)event).getCode() == KeyCode.S)
				y += 5;
		}
		if(event instanceof MouseEvent) //Tracks when the key is lifted
		{
			System.out.println(((MouseEvent)event).getX());
			System.out.println(((MouseEvent)event).getY());
		}
	}
}
