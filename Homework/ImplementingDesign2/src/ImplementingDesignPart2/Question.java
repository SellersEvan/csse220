/*
 *   Copyright (C) 2020 Sellers Industry - All Rights Reserved
 *   Unauthorized copying of this file, via any medium is strictly
 *   prohibited. Proprietary and confidential.
 *
 *   author: Evan Sellers <sellersew@gmail.com>
 *   date: Mon Oct 05 2020
 *   file: Question.java
 *   project: CSSE220
 *   purpose: Builds a simple question class for storing
 *      an abstract answers and prompts for quiz.
 *
 */


package ImplementingDesignPart2;

public class Question {
    
    private boolean answer;
    private String prompt;

    /** QUESTION CONSTRUCTOR (PUBLIC)
     *  Builds a new question class, and will setup all
     *  the properties for the class.
     *  
     *  @param answer { boolean } answer to prompt
     *  @param prompt { String } prompt question
     */
    public Question( boolean answer, String prompt ) {
        this.setQuestion( answer, prompt );
    }

    /** QUESTION CONSTRUCTOR OVERLOADED (PUBLIC)
     *  Builds a new question class, and will setup all
     *  the properties for the class. The default answer
     *  is false, and the default prompt is "N/A"
     */
    public Question() {
        this( false, "N/A" );
    }

    /** SET QUESTION (PUBLIC)
     *  Sets the properties for the answer and for the
     *  prompt. You will pass a boolean which is the answer
     *  to the prompt and a string which is the question or
     *  prompt for the answer. 
     * 
     *  @param answer { boolean } answer to prompt
     *  @param prompt { String } prompt question
     */
    public void setQuestion( boolean answer, String prompt ) {
        this.setAnswer( answer );
        this.setPrompt( prompt );
    }

    /** SET PROMPT (PROMPT)
     *  Will set the property of the prompt for the question
     * 
     *  @param prompt { String } string for prompt
     */
    public void setPrompt( String prompt ) {
        this.prompt = prompt;
    }

    /** SET ANSWER (PUBLIC)
     *  The boolean answer to the prompt for the promblem
     *  
     *  @param answer { boolean } answer to the prompt
     */
    public void setAnswer( boolean answer ) {
        this.answer = answer;
    }

    /** GET PROMPT (PUBLIC)
     *  Will return the prompt as a string from properites
     * 
     *  @return { String } prompt
     */
    public String getPrompt() {
        return this.prompt;
    }

    /** GET ANSWER (PUBLIC)
     *  Will return the answer as a boolean from the properties
     * 
     *  @return { boolean } anwer
     */
    public boolean getAnswer() {
        return this.answer;
    }
}
