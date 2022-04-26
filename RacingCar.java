
import javafx.application Application;

import javafx.scene. Scene;
import javafx.stage.Stage;

import javafx.scene.input.KeyCode;

public class RacingCar extends Application {

public void start(Stage primaryStage) {
// Create a car

CarPane carPane = new CarPane();

// Create and register handles

carPane.setOnMouse Pressed(e -> carPane,pauseCar()); carPane.setOnMouseReleased(e -> car Pane.play());

carPane.setOnKeyPressed(e -> {
if (e.getCode() == KeyCode.UP) {
carPane increaseCarSpeed();
}
else if (e.getCode() == KeyCode.DOWN) {
   carPane decreaseCarSpeed();
   }
   });

   // Create a scene and place it in the stage
Scene scene = new Scene carPane, 700, 200); primaryStage.setTitle("Racing Car"); primaryStage.setScene(scene);
primaryStage.show();
carPane.requestFocus();
}

//CarPane .java
import javafx.animation.KeyFrame:
import javafx.animation. Timeline;
import javafx.scene. Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape. Rectangle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.util.Duration;

//class CarPane extends Pane
public class CarPane extends Pane {
private double x = 0;
private double y = 100;
private double radius = 5;
private Rectangle rectangle;
private Polygon polygon;
private Circle circlel;
private Circle circle2;
private Timeline animation;

// animate CarPane

CarPane(){

drawCar();
animation = new Timeline(

new KeyFrame(Duration.millis(50), e -> moveCar())):

animation.setCycleCount(Timeline. INDEFINITE);

animation play();
}

// draw car

private void drawCar() {
getChildren().clear():

rectangle = new Rectangle(x, y-20, 50, 10);
polygon = new Polygon(x + 10,y-20, x + 20, y 30, x+30,
y - 30, x + 40, y - 20);
circlel = new Circle(x + 15, y - 5, radius);
circle2 = new Circle(x +35. y - 5, radius);
getChildren().addAll(rectangle, circlel, circle2, polygon);
}

//method to pause animation
public void pauseCar(){
animation.pause();
}

// method to play animation
public void play(){
animation.play();
}

//method to increase speed
public void increaseCarSpeed(){
animation.setRate(animation.getRate() + 1);
}

//method to decrease the speed
public void decreaseCarSpeed(){
animation.setRate(animation.getRate() > 0 ? animation.getRate() - 1:0);
}

//method to move car
protected void moveCar(){
if (x - getWidth()) {
x+ =1;
}

else

X=0;

drawCar();
}
}
