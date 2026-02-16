import java.util.Scanner;

public class QuizApplication {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] questions = {
                "1. What is the capital of India?",
                "2. Which language is mainly used for Machine Learning?",
                "3. What does CPU stand for?"
        };

        String[][] options = {
                {"A. Mumbai", "B. Delhi", "C. Chennai", "D. Kolkata"},
                {"A. Python", "B. Java", "C. HTML", "D. C++"},
                {"A. Central Process Unit", "B. Central Processing Unit",
                        "C. Computer Processing Unit", "D. Control Process Unit"}
        };

        String[] answers = {"B", "A", "B"};

        int score = 0;
        String[] userAnswers = new String[questions.length];

        System.out.println("=======================================");
        System.out.println("      QUIZ APPLICATION WITH TIMER      ");
        System.out.println("=======================================");
        System.out.println("You have 10 seconds for each question.\n");

        for (int i = 0; i < questions.length; i++) {

            System.out.println(questions[i]);

            for (String option : options[i]) {
                System.out.println(option);
            }

            long startTime = System.currentTimeMillis();

            System.out.print("Enter your answer (A/B/C/D): ");
            String userAnswer = sc.nextLine().toUpperCase();

            long endTime = System.currentTimeMillis();
            long timeTaken = (endTime - startTime) / 1000;

            if (timeTaken > 10) {
                System.out.println("Time's up! Answer not recorded.");
                userAnswers[i] = "Not Answered";
            } else {
                userAnswers[i] = userAnswer;

                if (userAnswer.equals(answers[i])) {
                    System.out.println("Correct!");
                    score++;
                } else {
                    System.out.println("Wrong!");
                }
            }

            System.out.println("---------------------------------------");
        }

        // Result Section
        System.out.println("\n=======================================");
        System.out.println("              QUIZ RESULT              ");
        System.out.println("=======================================");
        System.out.println("Your Final Score: " + score + "/" + questions.length);

        System.out.println("\nAnswer Summary:");
        for (int i = 0; i < questions.length; i++) {
            System.out.println("Q" + (i + 1) +
                    " | Your Answer: " + userAnswers[i] +
                    " | Correct Answer: " + answers[i]);
        }

        sc.close();
    }
}
