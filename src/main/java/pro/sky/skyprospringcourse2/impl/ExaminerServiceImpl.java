package pro.sky.skyprospringcourse2.impl;

import org.springframework.stereotype.Service;
import pro.sky.skyprospringcourse2.ExaminerService;
import pro.sky.skyprospringcourse2.model.Question;
import pro.sky.skyprospringcourse2.QuestionService;
import pro.sky.skyprospringcourse2.exception.QuestionException;

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
            while (questions.size() < amount) {
                questions.add(questionService.getRandomQuestion());
            }
            return questions;
        }
        throw new QuestionException();
    }
}
