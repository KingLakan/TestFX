
package testfx;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Mover {

    private MyVector location;
    private MyVector velocity;
    private MyVector acceleration;
    private MyVector zero;
    private double mass;
    
public Mover(){
    location = new MyVector(0,0);
    velocity = new MyVector(1,1);
    acceleration = new MyVector(0.01,0.01);
    zero = new MyVector(0,0);
    mass = 1;
}

public void update(){
     System.out.println("Acceleration X: " + acceleration.getX()+ "Acceleration Y: " + acceleration.getY());
    velocity = velocity.add(acceleration);    
    location = location.add(velocity);
    acceleration = acceleration.mul(zero);
    System.out.println("Location X: " + location.getX()+ "Location Y: " + location.getY());
}

public void display( GraphicsContext gc){
            gc.setStroke(Color.WHITE);
            gc.setLineWidth(5);
            gc.strokeLine(0, 0, location.getX(), location.getY());
            
}
    
public void applyForce(MyVector force){
    MyVector newForce = force.div(this.mass);
    acceleration = acceleration.add(newForce);
}
        
}
