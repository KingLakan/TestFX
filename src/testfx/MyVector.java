
package testfx;


public class MyVector {
    
    private final double x;
    private final double y;

    
    public MyVector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    
    
    public MyVector add(MyVector other) {
    //MyVector newVector = new MyVector( (this.getX()+other.getX()), (this.getY()+other.getY()) );
        return new MyVector( (this.x + other.getX()), (this.y + other.getY()) );
    }

    public MyVector sub(MyVector other) {
        return new MyVector((this.x - other.getX()), (this.y - other.getY()));
    }

    public MyVector mul(MyVector other) {
        return new MyVector(this.x * other.x, this.y * other.y);
    }
    
    public MyVector div(double m){
        
        return new MyVector((this.getX())/m,(this.getY())/m);
        
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return this.y;
    }
    
}
