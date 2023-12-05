package com.mysite.sb_web;

import com.mysite.sb_web.answer.Answer;
import com.mysite.sb_web.answer.AnswerRepository;
import com.mysite.sb_web.question.Question;
import com.mysite.sb_web.question.QuestionRepository;
import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;
@SpringBootTest
class SbWebApplicationTests {


        @Autowired
        private QuestionRepository questionRepository;

        @Autowired
        private AnswerRepository answerRepository;

        @Test
        @Transactional
        void testJpa() {
            Optional<Question> oq = this.questionRepository.findById(2);
            assertTrue(oq.isPresent());
            Question q = oq.get();

            List<Answer> answerList = q.getAnswerList();

            assertEquals(1, answerList.size());
            assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContent());
        }
        }

