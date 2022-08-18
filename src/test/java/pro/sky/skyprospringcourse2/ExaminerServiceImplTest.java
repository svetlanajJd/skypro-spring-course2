package pro.sky.skyprospringcourse2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    private Question question1 = new Question("Вопрос1", "Ответ1");
    private Question question2 = new Question("Вопрос1", "Ответ1");

    @Mock
    private QuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl out;

    @Test
    public void questionsWithAmount() {
        List<Question> expected = new ArrayList<>();
        expected.add(question1);
        when(questionService.getRandomQuestion()).thenReturn(question1);
        when(questionService.getAll()).thenReturn(expected);
        assertEquals(expected, out.getQuestions(1));
    }

    @Test
    public void questionsWithAmountException() {
        List<Question> expected = new ArrayList<>();
        expected.add(question1);
        when(questionService.getAll()).thenReturn(expected);
        assertThrows(QuestionException.class, () -> out.getQuestions(5));
    }
}
