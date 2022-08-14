import java.util.ArrayList;

public class AnswerGroup {

    private ArrayList<String> answers;

    public AnswerGroup()
    {
        answers = new ArrayList<String>();
    }

    public void addAnswer(String answer)
    {
        this.answers.add(answer);
    }

    boolean checkAnswer(String answer)
    {
        for (String a : answers)
        {
            if (a.toLowerCase().equals(answer.toLowerCase()))
            {
                return true;
            }
        }
        return false;
    }

    String returnAnswer()
    {
        return this.answers.get(0);
    }
}
