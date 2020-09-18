/**
 *  Class: CS220
 *  Author: Evan Sellers
 * 
 *  Use: a simple dummy class to show assiated classes
 */

public class B {

    private int count;

    public B() {
        this.count = 0;
    }

    public void setValue( int count ) {
        this.count = count;
    }

    public String toString() {
        return "B with count: " + this.count;
    }

}
