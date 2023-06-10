package com.example.examquestions.services;

import com.example.examquestions.exceptions.NotFoundQuestionException;
import com.example.examquestions.exceptions.QuestionDuplicateException;
import com.example.examquestions.exceptions.QuestionsAreEmptyException;
import com.example.examquestions.interfaces.QuestionService;
import com.example.examquestions.module.Question;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


class JavaQuestionServiceTest {
    private final QuestionService questionService = new JavaQuestionService();

    @BeforeEach
    public void beforeEach() {
        questionService.add("q1", "a1");
        questionService.add("q2", "a2");
        questionService.add("q3", "a3");
    }


    @AfterEach
    public void afterEach() {
        new HashSet<>(questionService.getAll()).forEach(questionService::remove);
    }

    @Test
    public void add1Test() {
        int beforeCount = questionService.getAll().size();
        Question question = new Question("q4", "a4");

        Assertions.assertThat(questionService.add(question))
                .isEqualTo(question)
                .isIn(questionService.getAll());
        Assertions.assertThat(questionService.getAll()).hasSize(beforeCount + 1);
    }

    @Test
    public void add2NegativeTest() {
        assertThatExceptionOfType(QuestionDuplicateException.class)
                .isThrownBy(() -> questionService.add("q1", "a1"));
    }

    @Test
    public void removeTest() {
        int beforeCount = questionService.getAll().size();
        Question question = new Question("q2", "a2");

        Assertions.assertThat(questionService.remove(question))
                .isEqualTo(question)
                .isNotIn(questionService.getAll());
        Assertions.assertThat(questionService.getAll()).hasSize(beforeCount - 1);
    }

    @Test
    public void removeNegativeTest() {
        assertThatExceptionOfType(NotFoundQuestionException.class)
                .isThrownBy(() -> questionService.remove(new Question("q4", "a4")));
    }

    @Test
    public void getAllTest() {
        Assertions.assertThat(questionService.getAll())
                .hasSize(3)
                .containsExactlyInAnyOrder(
                        new Question("q1", "a1"),
                        new Question("q3", "a3"),
                        new Question("q2", "a2")
                );
    }

    @Test
    public void getRandomQuestionTest() {
        Assertions.assertThat(questionService.getRandomQuestion())
                .isNotNull()
                .isIn(questionService.getAll());
    }

    @Test
    public void getRandomQuestionNegativeTest() {
        afterEach();

        assertThatExceptionOfType(QuestionsAreEmptyException.class)
                .isThrownBy(questionService::getRandomQuestion);
    }

}




















