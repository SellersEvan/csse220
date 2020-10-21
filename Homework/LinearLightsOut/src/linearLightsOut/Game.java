/*
 *   Edited by Evan Sellers <sellersew@gmail.com> on
 *   behalf of Rose-Hulman Institute of Technology
 *
 *   author: Evan Sellers <sellersew@gmail.com>
 *   date: Sun Oct 18 2020
 *   original: Jan 18, 2010.
 *   file: Game.java
 *   project: Runs the Linear Lights Out application.
 *   purpose: N/A
 *
 */

package linearLightsOut;

import java.util.Random;

public class Game {
    
    // Statics
    private static char SWITCH_STATE_ON  = 'O'; // state of switch if on
    private static char SWITCH_STATE_OFF = 'X'; // state of switch if off

    // Locals
    private boolean[] board;    // Board playing area
    private int turnsTaken;     // turns taken
    private int switchCount;    // total amount of switches



    /** CONSTUCTOR MAIN (PUBLIC)
     *  Will init the game and the set the amout of switches
     * 
     *  @param switches { int } total amount of switches
     */
    public Game( int switches ) {
        this.switchCount = switches;
        init();
    }


    /** CONSTRUCTOR OVERLOADED (PUBLIC)
     *  Will init with a default of 6 switches
     */
    public Game() {
        this( 6 );
    }


    /** TAKE TURN (PUBLIC)
     *  Will invert the value of the one to left and right
     *  if exists. And then will add one to the turns take.
     * 
     *  @param pos { pos } that has been clicked
     */
    public void takeTurn( int pos ) {
        if ( pos - 1 >= 0 )           board[ pos - 1 ] = !board[ pos - 1 ];
        if ( pos + 1 < switchCount ) board[ pos + 1 ] = !board[ pos + 1 ];
        this.turnsTaken++;
    }


    /** GET GAME (PUBLIC)
     *  Will return an array of each button and its states in 
     *  the form of an Char array. 
     * 
     *  @return { char[] } the states of each switch
     */
    public char[] getGame() {
        char[] result = new char[switchCount];
        for ( int i = 0; i < switchCount; i++ )
            result[ i ] = ( this.board[ i ] ) ? SWITCH_STATE_ON : SWITCH_STATE_OFF;
        return result;
    }


    /** HAS WON (PUBLIC)
     *  Check to see if the user has won, return true if 
     *  the user has won and return false if the user has
     *  not won yet.
     * 
     *  @return { boolean } has won
     */
    public boolean hasWon() {
        for ( boolean pos : this.board )
            if ( pos != this.board[ 0 ] ) return false;
        return true;
    }


    /** INIT (PUBLIC)
     *  Will Define the turns take to zero and set the the
     *  array as the length of the amount of switches. This
     *  it will randomly populate the array. If the user has
     *  already won then it will reset the board to ensure the 
     *  user does not win a brand new game without making
     *  any moves.
     */
    public void init() {
        this.board       = new boolean[ this.switchCount ];
        this.turnsTaken  = 0;

        for ( int i = 0; i < switchCount; i++ ) {
            this.board[ i ] = true;
            if ( new Random().nextInt() > 0.5 ) this.board[ i ] = false;
        }

        if ( hasWon() ) init(); // prevent winning on first load
    }

    /** GET TURNS (PUBLIC)
     *  Will return the amount of turns taken in the current
     *  game by the user.
     * 
     *  @return { int } turns taken
     */
    public int getTurnsTake() {
        return this.turnsTaken;
    }

}
