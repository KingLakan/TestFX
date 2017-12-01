/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testfx;


import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;

import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author lakan
 */
public class TestFX extends Application {
    

    
    Mover mover = new Mover();
    MyVector force = null;
    //Group root;
    Scene theScene;
    
    Image earth;
    Image sun;
    Image space;
    
    Main main = new Main();//STARTAR GRAFIK TRÅDEN
    //public static void main(String[] args) {
     
    //    launch(args);
    //}
  
    public void start(Stage theStage) throws Exception 
    {

    
    theStage.setTitle(String.format("(%s, %s)", 1, 1));
    
    setup();     
   GridPane root = new GridPane();

   root.setAlignment(Pos.CENTER);
root.setHgap(10);
root.setVgap(10);
root.setPadding(new Insets(0, 10, 0, 10));
root.setGridLinesVisible(true);
    //root = new Group();//creat root node
     theScene = new Scene( root, 512, 512 );//add node to scene
    
    theStage.setScene( theScene );//add scene to staget
    
    Canvas canvas = new Canvas(512,512);
    
    root.getChildren().add(canvas);//add canvas to rootnode
    //root.getChildren().add(new Menu().addVBox());
    root.add(new Menu().addVBox(theStage), 0, 0,1,1);
    GraphicsContext gc = canvas.getGraphicsContext2D();//ta grafik objekt från canvas   

    
final Rectangle rectPath = new Rectangle (0, 0, 40, 40);
rectPath.setArcHeight(10);
rectPath.setArcWidth(10);
rectPath.setFill(Color.ORANGE);

Path path = new Path();
path.getElements().add(new MoveTo(20,20));
path.getElements().add(new CubicCurveTo(380, 0, 380, 120, 200, 120));
path.getElements().add(new CubicCurveTo(0, 120, 0, 240, 380, 240));
PathTransition pathTransition = new PathTransition();
pathTransition.setDuration(Duration.millis(4000));
pathTransition.setPath(path);
pathTransition.setNode(rectPath);
pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
pathTransition.setCycleCount(Timeline.INDEFINITE);
pathTransition.setAutoReverse(true);
root.getChildren().add(rectPath);

pathTransition.play();
 
final long startNanoTime = System.nanoTime();
    

    new AnimationTimer()
    {
        public void handle(long currentNanoTime)
        {
            double t = (currentNanoTime - startNanoTime) / 1000000000.0; 
 
            double x = 232 + 128 * Math.cos(t);
            double y = 232 + 128 * Math.sin(t);
            mover.applyForce(force);
            mover.update();

            
            //System.out.println("Location X: " + location.getX()+ "Location Y: " + location.getY());
            
            gc.drawImage( space, 0, 0 );
            gc.drawImage( earth, x, y );
            gc.drawImage( sun, 196, 196 );
            
            mover.display(gc);
            mover.checkEdges();

             
        }
    }.start();
    

    
    theStage.show();
    }

public void setup(){
    
    force =  new MyVector(0.01,0.03);

    
    earth = new Image( "earth.png" );
    sun = new Image( "sun.png" );
    space = new Image( "space.png" ); 
    
}
    
}    

