/*
 *   Edited by Evan Sellers <sellersew@gmail.com> on
 *   behalf of Rose-Hulman Institute of Technology
 *
 *   author: Evan Sellers <sellersew@gmail.com>
 *   date: Sun Oct 18 2020
 *   original: N/A
 *   file: count.java
 *   project: Ball Strike Counter GUI
 *   purpose: N/A
 *
 */



package ballStrikeCounter;

public class Count {
    
    private int ballsCount;
    private int strikesCount;

    /** MAIN CONSTRUCTOR (PUBLIC)
     *  Will go set all class varibles to the default
     *  starting values. ballsCount=0, strikesCount=0
     */
    public Count() {
        this.ballsCount   = 0;
        this.strikesCount = 0;
    }


    /** ADD BALL (PUBLIC)
     *  Will add a single ball to the count, using the
     *  add ball class. Then return the total count of 
     *  balls after. 
     * 
     *  @return { int } total balls
     */
    public int addBall() {
        return this.addBalls( 1 );
    }


    /** ADD BALLS (PUBLIC)
     *  Will add multiple balls, depending on the parm
     *  that is passed {int}. If the balls go to 4, then
     *  it will reset the count. Will return after ball 
     *  count has been set.
     * 
     *  @param add_balls { int } total balls to add
     *  @return { int } total
     */
    public int addBalls( int add_balls ) {
        this.ballsCount += add_balls;
        if ( this.getBalls() >= 4 ) this.reset();
        return this.getBalls();
    }


    /** GET BALLS (PUBLIC)
     *  Return int of how many balls are in the count.
     * 
     *  @return { int } ball count
     */
    public int getBalls() {
        return this.ballsCount;
    }


    /** ADD STRIKE (PUBLIC)
     *  Will add a single strike to the count, using the
     *  add strikes class. Then return the total count of 
     *  strikes after. 
     * 
     *  @return { int } total strikes
     */
    public int addStrike() {
        return this.addStrikes( 1 );
    }


    /** ADD STRIKES (PUBLIC)
     *  Will add multiple strikes, depending on the parm
     *  that is passed {int}. If the strikes go to 3, then
     *  it will reset the count. Will return after strikes 
     *  count has been set.
     * 
     *  @param add_strikes { int } total strikes to add
     *  @return { int } total strikes
     */
    public int addStrikes( int add_strikes ) {
        this.strikesCount += add_strikes;
        if ( this.getStrikes() >= 3 ) this.reset();
        return this.getStrikes();
    }


    /** GET STRIKES (PUBLIC)
     *  Return int of how many strikes are in the count.
     * 
     *  @return { int } strikes count
     */
    public int getStrikes() {
        return this.strikesCount;
    }


    /** RESET COUNT (PUBLIC)
     *  Will reset the count of both balls and stikes
     *  to zero.
     */
    public void reset() {
        this.ballsCount   = 0;
        this.strikesCount = 0;
    }

}
