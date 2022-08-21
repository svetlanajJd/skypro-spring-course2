package pro.sky.skyprospringcourse2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.skyprospringcourse2.exception.QuestionNotFoundException;
import pro.sky.skyprospringcourse2.impl.JavaQuestionService;
import pro.sky.skyprospringcourse2.model.Question;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JavaQuestionServiceTest {
    private JavaQuestionService out = new JavaQuestionService();

    @BeforeEach
    public void beforeEach() {
        out.getAll().forEach(out::remove);
    }

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
        Set<Question> actual = out.getAll();
        Set<Question> expected = new HashSet<>();
        expected.add(question);
        assertEquals(actual, expected);
    }

    @Test
    public void randomQuestion() {
        Question question1 = new Question("Вопрос1", "Ответ1");
        Question question2 = new Question("Вопрос2", "Ответ2");
        Question question3 = new Question("Вопрос3", "Ответ3");
        out.add(question1);
        out.add(question2);
        out.add(question3);
        assertThat(out.getAll().contains(out.getRandomQuestion()));
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
