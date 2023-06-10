package com.example.examquestions.services;

import com.example.examquestions.exceptions.NotFoundQuestionException;
import com.example.examquestions.exceptions.QuestionDuplicateException;
import com.example.examquestions.exceptions.QuestionsAreEmptyException;
import com.example.examquestions.interfaces.QuestionService;
import com.example.examquestions.module.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class JavaQuestionService implements QuestionService {


    private final Set<Question> questionSet = new HashSet<>();
    Random random = new Random();

    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        if (questionSet.contains(question)) {
            throw new QuestionDuplicateException("Такой вопрос есть в списке.");
        }
        questionSet.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!questionSet.contains(question)) {
            throw new NotFoundQuestionException("Такого вопроса нет в списке.");
        }
        questionSet.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return new HashSet<>(questionSet);
    }

    @Override
    public Question getRandomQuestion() {
        if (questionSet.isEmpty()) {
            throw new QuestionsAreEmptyException("Список пуст.");
        }

        int i = random.nextInt(questionSet.size());
        int count = 0;
        for (Question q : questionSet) {
            if (i == count) {
                return q;
            }
            count++;
        }
        return null;
    }
}
