import java.util.ArrayList;

public class Question {

    // Defaults
    private static String DEFAULT_QUESTION_NAME = "N/A";


    // Properties
    private String             name;           // Question as a string
    private ArrayList<Integer> quizes;         // quiz with this question


    /** CONSTRUCTOR MAIN (PUBLIC)
     *  This will create a new question
     * 
     *  @param name { String } the title of the question
     */
    public Question( String name ) {
        this.name     = name;
        this.quizes   = new ArrayList<>();
    }


    /** CONSTRUCTOR OVERLOADED (PUBLIC)
     *  This will create a new question, defalt name
     * 
     *  @param question { String } the title of the question
     */
    public Question() {
        this( DEFAULT_QUESTION_NAME );
    }


    /** SET NAME (PUBLIC)
     *  Will set the name of the question
     * 
     *  @param name { String } sets name to
     */
    public void setName( String name ) {
        this.name = name;
    }


    /** GET NAME (PUBLIC)
     *  Returns the name of the question 
     * 
     *  @return { String } name of the question
     */
    public String getName() {
        return this.name;
    }


    /** ADD QUIZ (PUBLIC)
     *  Add a quiz ID to a specific question. Must be a 
     *  valid quiz ID. This represnts the quizes this
     *  question is in.
     * 
     *  @param quizID { int } the quiz ID you want to add
     */
    public void addQuiz( int quizID ) {
        quizes.add( quizID );
    }


    /** REMOVE QUIZ (PUBLIC)
     *  Remove a quiz ID to a specific question. Must be a 
     *  valid quiz ID. This represnts the quizes this
     *  question is in.
     * 
     *  @param quizID { int } the quiz ID you want to remove
     */
    public void removeQuiz( int quizID ) {
        for ( int i = 0; i < quizes.size(); i++ ) {
            if ( quizes.get( i ) == quizID ) quizes.remove( i );
        }
    }


    /** GET QUIZES (PUBLIC)
     *  This represnts the quizes this question is in.
     * 
     *  @return { ArrayList<Integer> } which quizes are this question in
     */
    public ArrayList<Integer> getQuizes() {
        return this.quizes;
    }


}
