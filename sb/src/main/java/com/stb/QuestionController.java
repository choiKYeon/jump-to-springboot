package com.stb;


import org.springframework.ui.Model;
import com.stb.question.Question;
import com.stb.question.QuestionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.RequiredArgsConstructor;


import java.util.List;
@RequiredArgsConstructor
@Controller
public class QuestionController {

    private final QuestionRepository questionRepository;
    @GetMapping("/question/list2")
    public String list(Model model) {
        List<Question> questionList = this.questionRepository.findAll();
        model.addAttribute("questionList", questionList);

        return "question_list";
    }
}