package com.stb.answer.answerrepository;

import com.stb.answer.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
//    Answer findBySubject(String subject);
//    Answer findBySubjectAndContent(String subject, String content);
//    List<Answer> findBySubjectLike(String subject);
}