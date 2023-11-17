package com.stb.question.questionservoce;

import java.util.List;

import com.stb.DataNotFoundException;
import com.stb.question.entity.Question;
import com.stb.question.questionrepository.QuestionRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public List<Question> getList() {
        return this.questionRepository.findAll();
    }

    public Question getQuestion(Integer id) {
        Optional<Question> question = this.questionRepository.findById(id);
        if (question.isPresent()) {
            return question.get();
        } else {
            throw new DataNotFoundException("question not found");
        }
    }
}