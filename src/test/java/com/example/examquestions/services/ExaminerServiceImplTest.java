package com.example.examquestions.services;

import com.example.examquestions.exceptions.IncorrectNumberOfQuestionsException;
import com.example.examquestions.interfaces.QuestionService;
import com.example.examquestions.module.Question;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private QuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    private final Collection<Question> questions = Set.of(
            new Question("q1", "a1"),
            new Question("q2", "a2"),
            new Question("q3", "a3"),
            new Question("q4", "a4"),
            new Question("q5", "a5")
    );

    @Test
    public void getQuestionNegativeTest() {
        when(questionService.getAll()).thenReturn(questions);

        assertThatExceptionOfType(IncorrectNumberOfQuestionsException.class)
                .isThrownBy(() -> examinerService.getQuestions(-1));
        assertThatExceptionOfType(IncorrectNumberOfQuestionsException.class)
                .isThrownBy(() -> examinerService.getQuestions(questions.size() + 1));

    }

    @Test
    public void getQuestionsTest() {
        when(questionService.getAll()).thenReturn(questions);

        when(questionService.getRandomQuestion()).thenReturn(
                new Question("q1", "a1"),
                new Question("q1", "a1"),
                new Question("q2", "a2"),
                new Question("q4", "a4")
        );

        assertThat(examinerService.getQuestions(3))
                .hasSize(3)
                .containsExactlyInAnyOrder(
                        new Question("q1", "a1"),
                        new Question("q2", "a2"),
                        new Question("q4", "a4")
                );
    }




}