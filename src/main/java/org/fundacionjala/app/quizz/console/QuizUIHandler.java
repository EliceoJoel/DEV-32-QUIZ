package org.fundacionjala.app.quizz.console;

import java.util.Set;

import org.fundacionjala.app.quizz.model.Answer;
import org.fundacionjala.app.quizz.model.Question;
import org.fundacionjala.app.quizz.model.Quiz;
import org.fundacionjala.app.quizz.model.QuizAnswers;
import org.fundacionjala.app.quizz.console.util.InputReader;

public class QuizUIHandler {

	public static Quiz createQuiz() {
		return new QuizUIMenu().handleCreateQuiz();
	}

	public static QuizAnswers fillQuiz(Quiz quiz) {
		QuizAnswers quizAnswers = new QuizAnswers(quiz);
		QuestionInputHandler questionHandler = new QuestionInputHandler();

		System.out.println("Quiz: " + quiz.getTitle());
		for (Question question : quiz.getQuestions()) {
			Set<String> answers = questionHandler.askQuestionValue(question);
			Answer answer = new Answer(question, answers);
			quizAnswers.addAnswer(answer);
		}

		return quizAnswers;
	}

	public static void showQuiz(QuizAnswers quizAnswers) {
		System.out.println("\n              " + quizAnswers.getQuiz().getTitle());
		System.out.println("=============================================");

		int i = 1;
		for (Answer answer : quizAnswers.getAnswers()) {
			System.out.println(i + ".- " + answer);
			i++;
		}

		System.out.println("=============================================");
		System.out.println("Press ENTER to continue");
		InputReader.readLine();
	}
}
