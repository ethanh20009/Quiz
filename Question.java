public class Question {
    private String question;
    private AnswerGroup answers;

    public AnswerGroup getAnswers() {
        return answers;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String q)
    {
        this.question = q;
    }

    public void setAnswers(AnswerGroup answers) {
        this.answers = answers;
    }
}
