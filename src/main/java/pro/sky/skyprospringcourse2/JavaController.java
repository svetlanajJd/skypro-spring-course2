package pro.sky.skyprospringcourse2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/exam")

public class JavaController {
    private QuestionService questionService;


    public JavaController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping(path = "/java/add")
    public Question addQuestion(@RequestParam("question") String question,
                                @RequestParam("answer") String answer) {
        return questionService.add(question, answer);
    }

    @GetMapping(path = "/java/remove")
    public Question removeQuestion(@RequestParam("question") String question,
                                   @RequestParam("answer") String answer) {
        Question questionOther = new Question(question, answer);
        questionService.remove(questionOther);
        return questionOther;
    }

    @GetMapping(path = "/java/find")
    public Question findQuestion(@RequestParam("question") String question,
                                 @RequestParam("answer") String answer) {
        Question questionOther = new Question(question, answer);
        questionService.find(questionOther);
        return questionOther;
    }

    @GetMapping(path = "/java/all")
    public List<Question> getAllQuestion() {
        return questionService.getAll();
    }

}
