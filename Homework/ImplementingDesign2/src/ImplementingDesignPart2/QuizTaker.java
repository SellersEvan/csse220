/*
 *   Copyright (C) 2020 Sellers Industry - All Rights Reserved
 *   Unauthorized copying of this file, via any medium is strictly
 *   prohibited. Proprietary and confidential.
 *
 *   author: Evan Sellers <sellersew@gmail.com>
 *   date: Mon Oct 05 2020
 *   file: QuizTaker.java
 *   project: CSSE220
 *   purpose: A simple quiz taker, will look for a buffer
 *      in a response and will answer true of false based
 *      on if the prompt contains that word.
 *
 */


package ImplementingDesignPart2;
import java.util.ArrayList;

public class QuizTaker {


    // PROPERTIES
    private String buffer;


    /** QUIZ TAKER CONSTRUCTOR (PUBLIC)
     *  Creates a new class with a buffer
     *  value that will be searched for on
     *  each question. 
     * 
     *  @param buffer { String } search value
     */
    public QuizTaker( String buffer ) {
        this.buffer = buffer;
    }

    /** TAKE QUIZ (PUBLIC)
     *  Will take a quiz with question, if the prompt
     *  contains the buffer word then will say the answer
     *  is true, then will check if that is correct. Will
     *  return double of percentage correct.
     * 
     *  @param questions { ArrayList<Question> } questions to take
     *  @return { double } score
     */
    public double takeQuiz( ArrayList<Question> questions ) {
        int correct = 0;
        for ( Question question : questions )
            if ( question.getPrompt().contains( getBuffer() ) == question.getAnswer() ) correct++;
        return ( ( double ) correct ) / ( ( double ) questions.size() );
    }


    /** GET BUFFER
     *  This will return the buffer keyword as a string 
     *  @return { String } buffer
     */
    public String getBuffer() {
        return this.buffer;
    }

}
