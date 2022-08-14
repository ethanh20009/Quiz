import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class QuestionInitializer {
    

    public static ArrayList<Question> getQuestions(String filePathQuestions, String filePathAnswers)
    {
        ArrayList<Question> questions = new ArrayList<Question>();
        try(BufferedReader qr = new BufferedReader(new FileReader(filePathQuestions)); BufferedReader ar = new BufferedReader(new FileReader(filePathAnswers)))
        {
            String question;
            String answer;
            while ((question = qr.readLine()) != null && (answer = ar.readLine()) != null)
            {
                Question tempQuestion = new Question();
                tempQuestion.setQuestion(question);
                String[] answers = answer.split(", *");
                AnswerGroup tempAnswerGroup = new AnswerGroup();
                for (String ans : answers)
                {
                    tempAnswerGroup.addAnswer(ans);
                }
                tempQuestion.setAnswers(tempAnswerGroup);
                questions.add(tempQuestion);
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
            return null;
        }
        return questions;
    }
}
