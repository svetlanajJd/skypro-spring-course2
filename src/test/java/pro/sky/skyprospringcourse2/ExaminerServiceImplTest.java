package pro.sky.skyprospringcourse2;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.skyprospringcourse2.exception.QuestionException;
import pro.sky.skyprospringcourse2.impl.ExaminerServiceImpl;
import pro.sky.skyprospringcourse2.model.Question;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.setRemoveAssertJRelatedElementsFromStackTrace;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    private Question question1 = new Question("Вопрос1", "Ответ1");
    private Question question2 = new Question("Вопрос2", "Ответ2");
    private Question question3 = new Question("Вопрос3", "Ответ3");
    private Question question4 = new Question("Вопрос3", "Ответ4");
    private Question question5 = new Question("Вопрос3", "Ответ5");

    @Mock
    private QuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl out;

    @Test
    public void questionsWithAmount() {

        Set<Question> expected = Set.of(question1, question2, question3, question4, question5);
        Question actualQuestion = questionService.getRandomQuestion();
        when(questionService.getRandomQuestion()).thenReturn(question1,question2,question3);
        when(questionService.getAll()).thenReturn(expected);
        assertThat(out.getQuestions(3)).containsExactlyInAnyOrder(question1, question2, question3);
    }

    @Test
    public void questionsWithAmountException() {
        Set<Question> expected = new HashSet<>();
        expected.add(question1);
        when(questionService.getAll()).thenReturn(expected);
        assertThrows(QuestionException.class, () -> out.getQuestions(5));
    }
}
