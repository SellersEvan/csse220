import java.util.ArrayList;

/**
 *  Class: CS220
 *  Author: Evan Sellers
 * 
 *  Use: a simple dummy class to show assiated classes
 */

public class A {

    private B myB;
    private String name;

    public A( String name ) {
        this.name = name;
        this.myB = new B();
    }

    public void setBvalue( int value ) {
        this.myB.setValue( value );
    } 

    public String toString() {
        return "A with name: " + this.name + " with B: " + this.myB;
    }
}
