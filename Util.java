import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.image.*;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
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
import javafx.geometry.Insets;

public class Util
{
	public static Image rotate(Image image, double rotation)
	{
		ImageView iv = new ImageView(image);
		iv.setRotate((int)rotation);
		SnapshotParameters params = new SnapshotParameters();
		params.setFill(Color.TRANSPARENT);
		return iv.snapshot(params, null);
	}
	public static double asin(double ratio) { return Math.toDegrees(Math.asin(ratio)); }
	public static double sin(double degrees) { return Math.toDegrees(Math.sin(Math.toRadians(degrees))); }
	public static double cos(double degrees) { return Math.toDegrees(Math.cos(Math.toRadians(degrees))); }
	public static double findCotermAngle(double degrees)
	{
		if(degrees > 360)
			return findCotermAngle(degrees - 360);
		else if(degrees < 0)
			return findCotermAngle(degrees + 360);
		return degrees;
	}
}