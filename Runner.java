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

public class Runner extends Application implements EventHandler<InputEvent>
{
	GraphicsContext gc;
	Image trooper;
	int x = 0;
	int y = 0;
	int[] canvasSize = {700, 700};
	AnimateObjects animate;
	Map map;
	Color[] color = {Color.BLUE, Color.RED, Color.YELLOW};
	int players = 0;

	public static void main(String[] args)
	{
		launch();
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
		gc.setFill(Color.GREEN);
		gc.fillRect(0, 0, canvasSize[0], canvasSize[1]);

		map = new Map();
		map.add(new Player(1, map));
		map.add(new Player(2, map));

		players = map.numPlayers();

		map.add(new MainBuilding(map, new Location(200, 200), 1));
		map.add(new MainBuilding(map, new Location(500, 500), 2));

		gc.setFill(Color.BLACK);

		animate = new AnimateObjects();
		animate.start();

		stage.show();
	}
	public class AnimateObjects extends AnimationTimer
	{
		public void handle(long now)
		{
			for(int i = 0; i < players; i++)
			{
				gc.setFill(color[i]);
				for(int j = 0; j < map.getPlayers().get(i).getBuildings().size(); j++)
					gc.fillRect(
						map.getPlayers().get(i).getBuildings().get(j).getLocation().getX(),
						map.getPlayers().get(i).getBuildings().get(j).getLocation().getY(),
						map.getPlayers().get(i).getBuildings().get(j).getWidth(),
						map.getPlayers().get(i).getBuildings().get(j).getHeight());
			}
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
		if(event instanceof MouseEvent)
		{
			System.out.println(((MouseEvent)event).getX());
			System.out.println(((MouseEvent)event).getY());
		}
	}
}
