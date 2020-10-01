import java.util.ArrayList;

public class Quiz {

    // Defaults
    private static String DEFAULT_QUIZ_NAME = "N/A";

    // Properties
    private String             name;        // quiz as a string
    private ArrayList<Integer> questions;   // questions in this quiz


    /** CONSTRUCTOR MAIN (PUBLIC)
     *  This will create a new quiz
     * 
     *  @param name { String } the title of the quiz
     */
    public Quiz( String name ) {
        this.name      = name;
        this.questions = new ArrayList<>();
    }


    /** CONSTRUCTOR OVERLOADED (PUBLIC)
     *  This will create a new quiz, defalt name
     */
    public Quiz() {
        this( DEFAULT_QUIZ_NAME );
    }


    /** SET NAME (PUBLIC)
     *  Will set the name of the quiz
     * 
     *  @param name { String } sets name to
     */
    public void setName( String name ) {
        this.name = name;
    }


    /** GET NAME (PUBLIC)
     *  Returns the name of the quiz 
     * 
     *  @return { String } name of the quiz
     */
    public String getName() {
        return this.name;
    }


    /** ADD QUESTION (PUBLIC)
     *  Add a quiestion ID to a specific quiz. Must be a 
     *  valid quiestion ID. This represnts the quiestion this
     *  quiz has in it.
     * 
     *  @param questionID { int } the question ID you want to add
     */
    public void addQuestion( int questionID ) {
        questions.add( questionID );
    }


    /** REMOVE QUESTION (PUBLIC)
     *  Remove a question ID to a specific quiz. Must be a 
     *  valid question ID. This represnts the question this
     *  quiz has in it.
     * 
     *  @param questionID { int } the question ID you want to remove
     */
    public void removeQuestion( int questionID ) {
        for ( int i = 0; i < questions.size(); i++ ) {
            if ( questions.get( i ) == questionID ) questions.remove( i );
        }
    }


    /** GET QUESTIONS (PUBLIC)
     *  This represnts the question this quiz has in it.
     * 
     *  @return { ArrayList<Integer> } which question are this quiz in it
     */
    public ArrayList<Integer> getQuestions() {
        return this.questions;
    }


}
