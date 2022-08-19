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
    public Set<Question> getQuestions(int amount) {
        if (amount <= questionService.getAll().size()) {
            Set<Question> questions = new HashSet<>(amount);
            int i=1;
            while (i<=amount){
                questions.add(questionService.getRandomQuestion());
                i=i+1;
            }
            return questions;
        }
        throw new QuestionException();
    }
}
