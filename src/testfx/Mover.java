
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
    // System.out.println("Acceleration X: " + acceleration.getX()+ "Acceleration Y: " + acceleration.getY());
    velocity = velocity.add(acceleration);    
    location = location.add(velocity);
    acceleration = acceleration.mul(zero);
    //System.out.println("Location X: " + location.getX()+ "Location Y: " + location.getY());
}

public void display( GraphicsContext gc){
             gc.setFill(Color.GREEN);
             gc.fillOval(location.getX(), location.getY(), 10, 10);
            /*gc.setStroke(Color.WHITE);
            gc.setLineWidth(5);
            gc.strokeLine(0, 0, location.getX(), location.getY());
            */
}
    
public void applyForce(MyVector force){
    MyVector newForce = force.div(this.mass);
    acceleration = acceleration.add(newForce);
}

public void checkEdges(){
    if(location.getX()>512){
        location.setX(512);
        velocity.setX(velocity.getX()*-1);
        
    }else if(location.getX()<0){
        location.setX(0);
        velocity.setX(velocity.getX()*-1); 
    }
    
    if(location.getY()>512){
        velocity.setY(velocity.getY()*-1);
        location.setY(512);
    }else if(location.getY()<0){
        location.setY(0);
        velocity.setY(velocity.getY()*-1); 
    }
       
}
        
}
