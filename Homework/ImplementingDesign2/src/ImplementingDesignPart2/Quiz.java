/*
 *   Copyright (C) 2020 Sellers Industry - All Rights Reserved
 *   Unauthorized copying of this file, via any medium is strictly
 *   prohibited. Proprietary and confidential.
 *
 *   author: Evan Sellers <sellersew@gmail.com>
 *   date: Mon Oct 05 2020
 *   file: Quiz.java
 *   project: CSSE220
 *   purpose: Build a simple quiz class with a
 *      list of questions connected to it.
 * 
 *   fixme:
 *      - add overloaded option for hasQuestion ArrayList<String>
 *      - add remove question String
 *      - add remove question overloaded ArrayList<String>
 *
 */


package ImplementingDesignPart2;
import java.util.ArrayList;

public class Quiz {

    // CLASS PROPERTIES
    private ArrayList<Integer> questions;


    /** QUIZ CONSTRUCTOR (PUBLIC)
     *  Builds and initializes the properties.
     */
    public Quiz() {
        questions = new ArrayList<>();
    }


    /** QUIZ CONSTRUCTOR OVERLOADED (PUBLIC)
     *  Builds and initializes the properties. What
     *  ever questionID is added to the array after
     *  being initialized.
     * 
     *  @param questionID { Integer } added to quiz
     */
    public Quiz( Integer questionID ) {
        this();
        addQuestion( questionID );
    }


    /** QUIZ CONSTRUCTOR OVERLOADED (PUBLIC)
     *  Builds and initializes the properties. What
     *  ever questionIDs is added to the array after
     *  being initialized.
     * 
     *  @param questionIDs { ArrayList<Integer> } added to quiz
     */
    public Quiz( ArrayList<Integer> questionIDs ) {
        this();
        addQuestion( questionIDs );
    }


    /** ADD QUESTION (PUBLIC)
     *  Adds the question to the array list. First the
     *  QuestionID is validated to ensure it does not 
     *  already exist inside the ArrayList.
     * 
     *  @param questionID { Integer } questionID
     */
    public void addQuestion( Integer questionID ) {
        if ( !hasQuestion( questionID ) ) this.questions.add( questionID );
    }

    /** ADD QUESTION OVERLOADED (PUBLIC)
     *  Adds the question to the array list. First the
     *  QuestionID is validated to ensure it does not 
     *  already exist inside the ArrayList. All items
     *  are added.
     * 
     *  @param questionID { ArrayList<Integer> } questionID
     */
    public void addQuestion( ArrayList<Integer> questionIDs ) {
        for ( Integer questionID : questionIDs )
            if ( !hasQuestion( questionID ) ) addQuestion( questionID );
    }

    /** HAS QUESTION (PUBLIC)
     *  Will return weather a quiz currently has a 
     *  specific question with an ID.
     * 
     *  @param questionID { Integer } questionID
     *  @return { boolean } exists in quiz
     */
    public boolean hasQuestion( Integer questionID ) {
        return getQuestions().contains( questionID );
    }

    /** GET QUESTION (PUBLIC)
     *  Will return an array list of all questionIDs
     *  for a quiz.
     * 
     *  @return { ArrayList<Integer> } questions
     */
    public ArrayList<Integer> getQuestions() {
        return this.questions;
    }

}
