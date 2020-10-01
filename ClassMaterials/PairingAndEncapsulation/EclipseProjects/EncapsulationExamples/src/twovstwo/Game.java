package twovstwo;

public class Game {

    private String[] players;
    private int teamWinner;

    /** GAME CONSTURCTOR (PUBLIC)
     * 
     * @param players { string }
     * @param teamWinner { int }
     */
    public Game( String[] players, int teamWinner ) {
        this.players    = players;
        this.teamWinner = teamWinner;
    }


    /** HAS PLAYER WON (PUBLIC)
     *  It will check if the player string passed is 
     *  the winner of the current game. If they are a 
     *  winner will return true, if they losed will 
     *  return false.
     * 
     * @param player { string }
     * @return { boolean } if the user passed has won
     */
    public boolean hasWon( String player ) {
        if ( teamWinner == 1 && ( players[ 0 ].equals( player ) || players[ 1 ].equals( player ) ) ) return true;
        if ( teamWinner == 2 && ( players[ 2 ].equals( player ) || players[ 3 ].equals( player ) ) ) return true;
        return false;
    }

    /** GET RESULTS (PUBLIC)
     *  Return string result for a game to a specific player
     * 
     * @example
     * Axe & Boomer vs Crusher & Doombot (win)
     * 
     * @param player { string } the result for which users
     * @return { string }
     */
    public String results( String player ) {
        return players[ 0 ] + " & " + players[ 1 ] + " vs " + players[ 2 ] + " & " + players[ 3 ] + ( ( hasWon( player ) ) ? " (won)" : " (lose)" );
    }
}
