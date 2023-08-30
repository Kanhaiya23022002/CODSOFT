import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Quiz_Application {
    private static Scanner scanner = new Scanner(System.in);
    private static Timer timer;
    private static int timeLimit = 10; // Time limit for each question in seconds
    private static int currentQuestionIndex = 0;
    private static int score = 0;

    private static String[] questions = {
        "What is the capital of France?",
        "Which planet is known as the Red Planet?",
        "What is the largest mammal?"
    };

    private static String[] answers = {
        "paris",
        "mars",
        "blue whale"
    };

    public static void main(String[] args) {
        System.out.println("Welcome to the Quiz!");
        System.out.println("You have " + timeLimit + " seconds to answer each question.\n");

        timer = new Timer();

        askNextQuestion();
    }

    private static void askNextQuestion() {
        if (currentQuestionIndex < questions.length) {
            System.out.println("Question " + (currentQuestionIndex + 1) + ": " + questions[currentQuestionIndex]);
            startTimer();
            String userAnswer = scanner.nextLine().toLowerCase();

            if (userAnswer.equals(answers[currentQuestionIndex])) {
                score++;
            }

            stopTimer();
            currentQuestionIndex++;
            askNextQuestion();
        } else {
            System.out.println("Quiz completed!");
            System.out.println("Your score: " + score + " out of " + questions.length);
            timer.cancel();
        }
    }

    private static void startTimer() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Time's up!");
                stopTimer();
                currentQuestionIndex++;
                askNextQuestion();
            }
        }, timeLimit * 1000);
    }

    private static void stopTimer() {
        timer.cancel();
        timer = new Timer();
    }
}
