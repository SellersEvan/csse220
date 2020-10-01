package twovstwo;
import java.util.ArrayList;

public class Player {

    public String name;
    private ArrayList<Game> games;

    /** PLAYER CONSTUCTOR (PUBLIC)
     * 
     * @param name { String } Player Names
     */
    public Player( String name ) {
        this.name  = name;
        this.games = new ArrayList<>();
    }

    /** ADD NEW GAME (PUBLIC)
     * 
     * @param newGame { Game } new game to add
     */
    public void addGame( Game newGame ) {
        games.add( newGame );
    }


    /** GET WIN COUNT (PUBLIC)
     *  This will go check each game the player
     *  has and see if they won that game.
     * @return { int } total win counts for player
     */
    public int getWinCount() {
        int totalWins = 0;
        for ( Game game : games )
            if ( game.hasWon( name ) )
                totalWins++;
        return totalWins;
    }

    /** PRINT WINNING RESULTS (PUBLIC)
     *  This will print the results for a the player and the result 
     *  of each game.
     */
    public void winningResults() {
        for ( Game game : games ) System.out.println( game.results( name ) );
    }

}
