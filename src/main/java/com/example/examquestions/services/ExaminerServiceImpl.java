package com.example.examquestions.services;

import com.example.examquestions.exceptions.IncorrectNumberOfQuestionsException;
import com.example.examquestions.interfaces.ExaminerService;
import com.example.examquestions.interfaces.QuestionService;
import com.example.examquestions.module.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > questionService.getAll().size() || amount <= 0) {
            throw new IncorrectNumberOfQuestionsException("Превышено колличество вопросов");
        }

        int counter = 0;

        Set<Question> questionSet = new HashSet<>();

        while (counter < amount) {
            Question question = questionService.getRandomQuestion();

            if (!questionSet.contains(question)) {
                questionSet.add(question);
                counter++;
            }

        }
        return questionSet;
    }
}
