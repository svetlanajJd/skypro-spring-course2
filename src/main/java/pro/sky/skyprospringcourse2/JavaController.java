package pro.sky.skyprospringcourse2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/exam/java/")

public class JavaController {
    private QuestionService questionService;


    public JavaController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping(path = "add")
    public Question addQuestion(@RequestParam("question") String question,
                                @RequestParam("answer") String answer) {
        return questionService.add(question, answer);
    }

    @GetMapping(path = "remove")
    public Question removeQuestion(@RequestParam("question") String question,
                                   @RequestParam("answer") String answer) {
        Question questionOther = new Question(question, answer);
        return questionService.remove(questionOther);
    }

    @GetMapping(path = "find")
    public Question findQuestion(@RequestParam("question") String question,
                                 @RequestParam("answer") String answer) {
        Question questionOther = new Question(question, answer);
        return questionService.find(questionOther);
    }

    @GetMapping(path = "all")
    public Set<Question> getAllQuestion() {
        return questionService.getAll();
    }

}
