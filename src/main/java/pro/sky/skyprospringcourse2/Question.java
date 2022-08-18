package pro.sky.skyprospringcourse2;

import java.util.Objects;

public class Question {

    private final String question;
    private final String answer;

    public Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public boolean equals(Object o) {
        Question questionOther = (Question) o;
        boolean result;
        result = question.equals(questionOther.question) &
                answer.equals(questionOther.answer);
        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(question, answer);
    }

}
