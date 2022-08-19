package pro.sky.skyprospringcourse2;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private final Set<Question> questionsSet = new HashSet<>();
    private final Random random = new Random();

    @Override
    public Question add(String question, String answer) {
        Question questionOther = new Question(question, answer);
//        questionsSet.add(questionOther);
//        return questionOther;
       return add(questionOther);
    }

    @Override
    public Question add(Question question) {
        if (questionsSet.contains(question)){
            throw new QuestionException();
        }
        questionsSet.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (questionsSet.contains(question)){
            questionsSet.remove(question);
            return question;
        }
        throw new QuestionNotFoundException();

    }

    @Override
    public Question find(Question question) {
        Question questionOther=new Question(question.getQuestion(), question.getAnswer());
        if (questionsSet.contains(question)) {
            return question;
        }
        throw new QuestionNotFoundException();
    }

    @Override
    public Set<Question> getAll() {
        return questionsSet;
    }

    @Override
    public Question getRandomQuestion() {
        Question question = null;
        int size=questionsSet.size();
        int questionRandom=random.nextInt(size);
        int i=0;
        for (Question q:questionsSet) {
          if (i==questionRandom)
              return question=q;
          i++;
        }
        return question;
//        Question numberQuestion=questionsSet.random.nextInt();
//        return numberQuestion;
    }
}
