package org.fundacionjala.app;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.io.File;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.stream.JsonReader;
import org.fundacionjala.app.quizz.model.Quiz;
import org.fundacionjala.app.quizz.model.QuizAnswers;

public class JsonPersistence {


	public static void saveQuizAnswers(QuizAnswers quizAnswers){
		Gson gson = new Gson();
        try (Writer writer = new FileWriter("./myQuizAnswers.json")) {
            gson.toJson(quizAnswers, writer);
        } catch (JsonIOException | IOException exception) {
            exception.printStackTrace();
        }
	}
	
	public static void saveQuiz(Quiz quiz){
		Gson gson = new Gson();
        try (Writer writer = new FileWriter("./myQuiz.json")) {
            gson.toJson(quiz, writer);
        } catch (JsonIOException | IOException exception) {
            exception.printStackTrace();
        }
	}

	public static Quiz getMyQuiz() {
		Gson gson = new Gson();
        Quiz quiz = null;
        try (JsonReader reader = new JsonReader(new FileReader("./myQuiz.json"))) {
            quiz = gson.fromJson(reader, Quiz.class);
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return quiz;
	}

	public static QuizAnswers getMyQuizAnswers() {
		Gson gson = new Gson();
        QuizAnswers quizAnswers = null;
        try (JsonReader reader = new JsonReader(new FileReader("./myQuizAnswers.json"))) {
            quizAnswers = gson.fromJson(reader, QuizAnswers.class);
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return quizAnswers;
	}

	public static boolean existsJsons() {
		File quiz = new File("./myQuiz.json");
		File quizAnswers = new File("./myQuizAnwers.json");
		
		if(quiz.exists() || quizAnswers.exists()){
			return true;
		}else{
			return false;
		}
	}

	public static Quiz getQuizWhitUrl(String url) {
		Gson gson = new Gson();
        Quiz quiz = null;
		//need to implement verification of file existence
        try (JsonReader reader = new JsonReader(new FileReader(url))) {
            quiz = gson.fromJson(reader, Quiz.class);
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return quiz;
	}

	public static QuizAnswers getQuizAnswersWhitUrl(String url) {
		Gson gson = new Gson();
        QuizAnswers quizAnswers = null;
		//need to implement verification of file existence
        try (JsonReader reader = new JsonReader(new FileReader(url))) {
            quizAnswers = gson.fromJson(reader, QuizAnswers.class);
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return quizAnswers;
	}

}
