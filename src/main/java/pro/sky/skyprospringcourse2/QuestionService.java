package pro.sky.skyprospringcourse2;

import pro.sky.skyprospringcourse2.model.Question;

import java.util.Set;

public interface QuestionService {
    Question add(String question, String answer);

    Question add(Question question);

    Question remove(Question question);

    Question find(Question question);

    Set<Question> getAll();

    Question getRandomQuestion();
}
