package pro.sky.skyprospringcourse2;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface QuestionService {
    Question add(String question, String answer);

    Question add(Question question);

    Question remove(Question question);

    Question find(Question question);

    List<Question> getAll();

    Question getRandomQuestion();
}
