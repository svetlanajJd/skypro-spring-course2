package pro.sky.skyprospringcourse2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyprospringcourse2.ExaminerService;
import pro.sky.skyprospringcourse2.model.Question;

import java.util.Set;


@RestController
@RequestMapping("/exam")
public class ExamController {

    private ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping(path = "/get")
    public Set<Question> getQuestions(@RequestParam("amount") int amount) {
        return examinerService.getQuestions(amount);
    }

}
