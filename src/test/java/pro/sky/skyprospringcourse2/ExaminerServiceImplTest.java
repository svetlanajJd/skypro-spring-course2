package pro.sky.skyprospringcourse2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    private Question question1 = new Question("Вопрос1", "Ответ1");
    private Question question2 = new Question("Вопрос2", "Ответ2");
    private Question question3 = new Question("Вопрос3", "Ответ3");

    @Mock
    private QuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl out;

    @Test
    public void questionsWithAmount() {
        Set<Question> expected = new HashSet<>();

        expected.add(question1);
        expected.add(question2);
        expected.add(question3);

        questionService.add(question1);
        questionService.add(question2);
        questionService.add(question3);

        Question actualQuestion = questionService.getRandomQuestion();

        when(questionService.getRandomQuestion()).thenReturn(actualQuestion);
        when(questionService.getAll()).thenReturn(expected);
        assertEquals(expected, out.getQuestions(3));
    }

    @Test
    public void questionsWithAmountException() {
        Set<Question> expected = new HashSet<>();
        expected.add(question1);
        when(questionService.getAll()).thenReturn(expected);
        assertThrows(QuestionException.class, () -> out.getQuestions(5));
    }
}
