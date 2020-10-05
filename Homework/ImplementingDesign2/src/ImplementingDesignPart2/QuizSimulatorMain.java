/*
 *   Copyright (C) 2020 Sellers Industry - All Rights Reserved
 *   Unauthorized copying of this file, via any medium is strictly
 *   prohibited. Proprietary and confidential.
 *
 *   author: Evan Sellers <sellersew@gmail.com>
 *   date: Mon Oct 05 2020
 *   file: QuizSimulatorMain.java
 *   project: CSSE220
 *   purpose: This class simulates the quiz creation and
 * 		updating along with testing scenario
 *
 */

package ImplementingDesignPart2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class QuizSimulatorMain {

	// SHARED DATABASES
	private HashMap<Integer, Question>  questionStorage;
	private HashMap<Integer, Quiz>      quizStorage;
	private HashMap<Integer, QuizTaker> quizTakerStorage;

		//Used to remind user of commands available
	public final static String HELP_STRING = "create-question [id] [answer] [prompt]\n" 
											+ "create-quiz [id] \n"
											+ "create-quiz-tester [id] [searchString] \n"
											+ "report-overall-quiz-tester-score [id] \n"
											+ "report-quiz-tester-score-on-quiz [testerId] [quizId] \n"
											+ "add-question-to-quiz [questionId] [quizId] \n"
											+ "display-quiz [quizId] \n"
											+ "display-question-prompt [questionId]  \n"
											+ "update-question [questionId] [answer] [prompt]\n ";
	

	public static void main(String[] args) {
		QuizSimulatorMain simulator = new QuizSimulatorMain();
		System.out.println("Welcome to QuizTester.  Enter commands.  Type 'exit' to end.");
		System.out.println("Enter [help] for a list of commands.");
		System.out.println( HELP_STRING );
		
		Scanner scanner = new Scanner(System.in);
		while(true) {
			String commandLine = scanner.nextLine();
			String result = simulator.handleCommand(commandLine);
			System.out.println(result);
		}
	}
	
	
	/**
	 *  Do not change this method, it parses the input from the user so you don't have to.
	 *  It then calls the handler methods that you are required to implement 
	 * 
	 * @param command
	 * @return
	 */
	public String handleCommand( String command ) {
		Scanner input = new Scanner( command );
		String commandType = input.next();
		String toReturn = null;

		if( commandType.equals( "help" ) ) {
			toReturn= HELP_STRING;
		} else if( commandType.equals( "create-question" ) ) {
			int id = input.nextInt();
			boolean answer = input.nextBoolean();
			String prompt = input.nextLine();
			handleCreateQuestion( id, answer, prompt) ;
			toReturn = "OK: created question";	
		} else if ( commandType.equals( "create-quiz" ) ) {
			int id = input.nextInt();
			handleCreateQuiz( id );
			toReturn = "OK: created quiz";
		} else if ( commandType.equals( "create-quiz-tester" ) ) {
			int id = input.nextInt();
			String searchString = input.next();
			handleCreateQuizTester( id, searchString );
			toReturn = "OK: created quiz tester";
		} else if ( commandType.equals( "report-overall-quiz-tester-score" ) ) {
			int id = input.nextInt();
			double score = handleGetQuizTesterOverallScore( id );
			toReturn = "OK: Overall Score:" + score;
		} else if ( commandType.equals( "report-quiz-tester-score-on-quiz" ) ) {
			int testerId = input.nextInt();
			int quizId = input.nextInt();
			double score = handleGetQuizTesterScoreOnQuiz(testerId, quizId);
			toReturn = "OK: Individual Score:" + score;
		} else if (commandType.equals("add-question-to-quiz")) {
			int questionId = input.nextInt();
			int quizId = input.nextInt();
			handleAddQuestionToQuiz(questionId, quizId);
			toReturn = "OK: question added to quiz";
		} else if (commandType.equals("display-quiz")) {
			int quizId = input.nextInt();
			String quizString = handleGetQuizString(quizId);
			toReturn = "OK: Displaying Quiz\n" + quizString;
		} else if (commandType.equals("display-question-prompt")) {
			int questionId = input.nextInt();
			String questionPrompt = handleGetQuestionPrompt(questionId);
			toReturn = "OK: Displaying Question Prompt:\n" + questionPrompt;
		} else if (commandType.equals("update-question")) {
			int id = input.nextInt();
			boolean answer = input.nextBoolean();
			String prompt = input.nextLine();
			handleUpdateQuestion(id, answer, prompt);
			toReturn = "OK: question updated";
		} else if(commandType.equals("exit")) {
			input.close();
			System.exit(0);
		}
		else {
			toReturn = "Unknown command " + commandType;
		}
		input.close();
		
		return toReturn;
	}



	/** QUIZ SIM CONSTRUCTOR (PUBLIC)
	 *  Init all the properties for storage
	 */
	public QuizSimulatorMain() {
		this.questionStorage  = new HashMap<>();
		this.quizStorage      = new HashMap<>();
		this.quizTakerStorage = new HashMap<>();
	}


	/** CREATE QUESTION (PUBLIC)
	 *  Validates the ID does not already exist. If the ID already
	 *  exists with the hashmap, will return false. Then will create 
	 *  the new quetion and add to the hashmap under the ID. If successful
	 *  will retun true. 
	 * 
	 *  @param id { int }
	 *  @param answer { boolean }
	 *  @param prompt { String } 
	 *  @return { boolean } success
	 */
	public boolean handleCreateQuestion( int id, boolean answer, String prompt ) {
		if ( questionStorage.containsKey( id ) ) return false;
		questionStorage.put( id, new Question( answer, prompt ) );
		return true;
	}


	/** GET PROMPT (PUBLIC)
	 *  Get back the String prompt from a question
	 *  with id questionId. Will return null if the 
	 *  question ID does not exist.
	 * 
	 *  @param questionId { int }
	 *  @return { String } 
	 */
	public String handleGetQuestionPrompt( int questionId ) {
		if ( !questionStorage.containsKey( questionId ) ) return null;
		return questionStorage.get( questionId ).getPrompt();
	}


	/** CREATE QUIZ (PUBLIC)
	 *  Create a quiz with corresponding id, initially
	 *  it should have no questions. If the quiz ID already
	 *  exists it will return false. If success return true.
	 * 
	 *  @param id { int }
	 *  @return { boolean } success
	 */
	public boolean handleCreateQuiz( int id ) {
		if ( quizStorage.containsKey( id ) ) return false;
		quizStorage.put( id, new Quiz() );
		return true;
	}


	/** ADD QUESTION TO QUIZ (PUBLIC)
	 *  Adds an already created question with id=questionId to an
	 *  already created quiz with id=quizId
	 * 
	 *  @param questionId { int }
	 *  @param quizId { int }
	 *  @return { boolean } success
	 */
	public boolean handleAddQuestionToQuiz( int questionId, int quizId ) {
		if ( !quizStorage.containsKey( quizId ) ) return false;
		if ( !questionStorage.containsKey( questionId ) ) return false;
		quizStorage.get( quizId ).addQuestion( questionId );
		return true;
	}


	/** UPDATE QUESTION
	 *  Updates a question with questionId with a new
	 *  answer and prompt. Will return true if able to
	 *  valid questionID and false if unable to validate.
	 * 
	 *  @param questionId { int }
	 *  @param answer { boolean }
	 *  @param prompt { prompt }
	 *  @return { boolean } success
	 */
	public boolean handleUpdateQuestion( int questionId, boolean answer, String prompt ) {
		if ( !questionStorage.containsKey( questionId ) ) return false;
		questionStorage.get( questionId ).setQuestion( answer, prompt );
		return true;
	}


	/** GET QUIZ STRING (PUBLIC)
	 *  This method should return a String presentation
	 *  of a quiz which then gets displayed to the screen
	 *  via handle command you can add "\n" to a String to
	 *  create a line break, so that when printed it will go
	 *  to the next line. This method is not unit tested, so
	 *  you can represent it how you like, but test it
	 *  manually for yourself.
	 * 
	 *  @param quizId { int }
	 *  @return { String }
	 */
	public String handleGetQuizString( int quizId ) {
		if ( !quizStorage.containsKey( quizId ) ) return "FAIL: unable to find quiz (" + quizId + ")";
		String result = "Quiz [" + quizId + "]\n";
		for ( Integer questionID : quizStorage.get( quizId ).getQuestions() ) {
			result += "[" + questionID + "] ";
			if ( !questionStorage.containsKey( questionID ) ) {
				result += "N/A";
			} else {
				result += questionStorage.get( questionID ).getAnswer();
				result += " : ";
				result += questionStorage.get( questionID ).getPrompt();
			}
			result += "\n";
		}
		return result;
	}


	/** NEW QUIZ TAKER (PUBLIC)
	 *  Creates a new QuizTester with a provide id and searchString
	 *  used to answer questions. If the ID already exists in the hashmap
	 *  will return false. If success creates the quiz taker returns true.
	 * 
	 *  @param id { int } id for the quiz taker
	 *  @param searchString { String } buffer to search for
	 *  @return { boolean } success
	 */
	public boolean handleCreateQuizTester( int id, String searchString ) {
		if ( quizTakerStorage.containsKey( id ) ) return false;
		quizTakerStorage.put( id, new QuizTaker( searchString ) );
		return true;
	}


	/** GET QUIZ TEST SCORE (PUBLIC)
	 *  Will first valid that both the quiz and quiz taker exist. If they
	 *  do not it will return -1. Then it will pass all the questions to
	 *  the quiz taker and return the double.
	 * 
	 * @param quizTesterId { int } quiz taker id
	 * @param quizId { int } quiz id
	 * @return { double } score the quiz
	 */
	public double handleGetQuizTesterScoreOnQuiz( int quizTesterId, int quizId ) {
		if ( !quizTakerStorage.containsKey( quizTesterId ) ) return -1;
		if ( !quizStorage.containsKey( quizId ) ) return -1;

		ArrayList<Question> questions = new ArrayList<>();
		for ( Integer questionID : quizStorage.get( quizId ).getQuestions() )
			if ( questionStorage.containsKey( questionID ) ) questions.add( questionStorage.get( questionID ) );
		return quizTakerStorage.get( quizTesterId ).takeQuiz( questions );
	}


	/** GET OVERALL QUIZ TEST SCORE (PUBLIC)
	 *  Take an id for a QuizTester and then finds the average score of
	 *  that QuizTester on ALL Quizzes in the simulator. Note this is
	 *  different than the average on all the individual problems. Will
	 *  return -1 if there is an error.
	 * 
	 * @param quizTesterId { int }
	 * @return { double }
	 */
	public double handleGetQuizTesterOverallScore( int quizTesterId ) {
		if ( !quizTakerStorage.containsKey( quizTesterId ) ) return -1;
		double total = 0;
		ArrayList<Integer> quizes = new ArrayList<>( quizStorage.keySet() );
		for ( Integer quiz : quizes )
			if ( quizStorage.containsKey( quiz ) )
				total += handleGetQuizTesterScoreOnQuiz( quizTesterId, quiz );
		return ( ( ( double ) total ) / ( ( double ) quizes.size() ) );
	}
}
