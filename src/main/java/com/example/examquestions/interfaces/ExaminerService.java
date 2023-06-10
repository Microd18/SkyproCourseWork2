package com.example.examquestions.interfaces;

import com.example.examquestions.module.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);

}
