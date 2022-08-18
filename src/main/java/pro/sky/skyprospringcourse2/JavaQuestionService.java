package pro.sky.skyprospringcourse2;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private final List<Question> questionsList = new ArrayList<>();
    final Random random = new Random();

    @Override
    public Question add(String question, String answer) {
        Question questionOther = new Question(question, answer);
        questionsList.add(questionOther);
        return questionOther;
    }

    @Override
    public Question add(Question question) {
        questionsList.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (questionsList.contains(question)){
            questionsList.remove(question);
            return question;
        }
        throw new QuestionNotFoundException();

    }

    @Override
    public Question find(Question question) {
        Question questionOther=new Question(question.getQuestion(), question.getAnswer());
        if (questionsList.contains(question)) {
            return question;
        }
        throw new QuestionNotFoundException();
    }

    @Override
    public List<Question> getAll() {
        return questionsList;
    }

    @Override
    public Question getRandomQuestion() {
        Question numberQuestion=questionsList.get(random.nextInt(2));
        return numberQuestion;
    }
}
