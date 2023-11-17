package com.stb.sb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.Optional;

import com.stb.answer.Answer;
import com.stb.answer.AnswerRepository;
import com.stb.question.Question;
import com.stb.question.QuestionRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class SbbApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private AnswerRepository answerRepository;

	@Test
	@DisplayName("데이터 넣기")
	void testJpa0() {
		Question q1 = new Question();
		q1.setSubject("세번 째 시험용으로 넣어보겠습니다.");
		q1.setContent(" 또 잘 들어갔네요");
		q1.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q1);  // 첫번째 질문 저장

		Question q2 = new Question();
		q2.setSubject("네번 째 꺼도 넣어보겠씁니다.");
		q2.setContent("또 이것도 잘 들어갔습니다.");
		q2.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q2);  // 두번째 질문 저장
	}

	@Test
	@DisplayName("데이터 삭제하기")
	void testJpa() {
		assertEquals(4, this.questionRepository.count());
		Optional<Question> oq = this.questionRepository.findById(1);
		assertTrue(oq.isPresent());
		Question q = oq.get();
		this.questionRepository.delete(q);
		assertEquals(3, this.questionRepository.count());
	}

	@Test
	@DisplayName("데이터 수정하기")
	void test007() {
		Optional<Question> oq = this.questionRepository.findById(2);
		assertTrue(oq.isPresent());
		Question q = oq.get();
		q.setSubject("두번 째 거 수정되었습니다.");
		this.questionRepository.save(q);
	}

	@Test
	@DisplayName("답변 조회하기")
	void testJpa2() {
		Optional<Answer> oa = this.answerRepository.findById(1);
		assertTrue(oa.isPresent());
		Answer a = oa.get();
		assertEquals(2, a.getQuestion().getId());
	}

	@Test
	@DisplayName("답변 생성하기")
	void testJpa4() {
		Optional<Question> oq = this.questionRepository.findById(2);
		assertTrue(oq.isPresent());
		Question q = oq.get();

		Answer a = new Answer();
		a.setContent("네, 답변이 잘 생성됐네요.");
		a.setQuestion(q);  // 어떤 질문의 답변인지 알기위해서 Question 객체가 필요하다.
		a.setCreateDate(LocalDateTime.now());
		this.answerRepository.save(a);
	}
}