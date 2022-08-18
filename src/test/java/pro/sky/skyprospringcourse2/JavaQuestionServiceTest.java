package pro.sky.skyprospringcourse2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JavaQuestionServiceTest {
    private JavaQuestionService out = new JavaQuestionService();


    @Test
    public void addQuestionAndAnswer() {
        Question actual = out.add("Вопрос1", "Ответ1");
        Question expected = new Question("Вопрос1", "Ответ1");
        assertEquals(actual, expected);
    }

    @Test
    public void addQuestion() {
        Question actual = out.add(new Question("Вопрос1", "Ответ1"));
        Question expected = new Question("Вопрос1", "Ответ1");
        assertEquals(actual, expected);
    }

    @Test
    public void removeQuestion() {
        Question question = new Question("Вопрос1", "Ответ1");
        out.add(question);
        Question actual = out.remove(question);
        Question expected = new Question("Вопрос1", "Ответ1");
        assertEquals(actual, expected);
    }

    @Test
    public void findQuestion() {
        Question question = new Question("Вопрос1", "Ответ1");
        out.add(question);
        Question actual = out.find(question);
        Question expected = new Question("Вопрос1", "Ответ1");
        assertEquals(actual, expected);
    }

    @Test
    public void allQuestions() {
        Question question = new Question("Вопрос1", "Ответ1");
        out.add(question);
        List<Question> actual = out.getAll();
        List<Question> expected = new ArrayList<>();
        expected.add(question);
        assertEquals(actual, expected);
    }

    @Test
    public void randomQuestion() {
        Question question1 = new Question("Вопрос1", "Ответ1");
        out.add(question1);
        Question actual = out.getRandomQuestion();
        Question expected = new Question("Вопрос1", "Ответ1");
        assertEquals(actual, expected);
    }

    @Test
    public void questionNotFoundExceptionRemove() {
        Question question = new Question("Вопрос_несуществующий", "Ответ_несуществующий");
        Assertions.assertThrows(QuestionNotFoundException.class, () -> out.remove(question));
    }

    @Test
    public void questionNotFoundExceptionFind() {
        Question question = new Question("Вопрос_несуществующий", "Ответ_несуществующий");
        Assertions.assertThrows(QuestionNotFoundException.class, () -> out.find(question));
    }
}
