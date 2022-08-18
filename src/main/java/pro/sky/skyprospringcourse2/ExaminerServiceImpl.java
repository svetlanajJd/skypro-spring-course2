package pro.sky.skyprospringcourse2;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public List<Question> getQuestions(int amount) {

        List<Question> questions = new ArrayList<>(amount + 1);
        if (amount <= questionService.getAll().size()) {
            for (int i = 1; i <= amount; i++) {
                questions.add(questionService.getRandomQuestion());
            }
            return questions;
        }
        throw new QuestionException();
    }
}
