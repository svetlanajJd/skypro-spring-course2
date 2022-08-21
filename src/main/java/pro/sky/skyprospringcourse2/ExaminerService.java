package pro.sky.skyprospringcourse2;

import pro.sky.skyprospringcourse2.model.Question;

import java.util.Set;

public interface ExaminerService {
    Set<Question> getQuestions(int amount);


}
