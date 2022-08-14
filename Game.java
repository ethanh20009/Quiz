import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Game
{
    private ArrayList<Question> questions; 
    public Game()
    {
        this.questions = QuestionInitializer.getQuestions("questions.txt", "answers.txt");
    }

    public void shuffleQuestions()
    {
       Collections.shuffle(this.questions);
    }

    public static void main(String[] args)
    {
        Game game = new Game();
        if (game.questions == null){return;}

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            boolean playing = true;
            String userAnswer;
            while (playing)
            {
                game.shuffleQuestions();
                int score = 0;
                int numRounds = game.questions.size();
                for (Question q : game.questions)
                {
                    System.out.println(q.getQuestion());
                    userAnswer = br.readLine();
                    if (q.getAnswers().checkAnswer(userAnswer)) //Check if user answer is in list of answers for question
                    {
                        score++;
                        System.out.println("Correct! Your score is now: " + score);
                    }
                    else{
                        System.out.println("Incorrect. The answer was: " + q.getAnswers().returnAnswer() + ". Score: " + score);
                    }
                }
                System.out.println("Game over, you got: " + score + "/" + numRounds);
                System.out.println("Play Again? (y/n)");
                userAnswer = br.readLine();
                if (userAnswer.equals("n"))
                {
                    playing = false;
                }

            }

        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        
    }
}