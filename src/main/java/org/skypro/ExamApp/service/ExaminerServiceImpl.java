package org.skypro.ExamApp.service;

import org.skypro.ExamApp.model.Question;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Set<Question> getQuestions(int amount) {

        if (amount > questionService.getAll().size()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "В базе недостаточно вопросов"
            );
        }

        Set<Question> result = new HashSet<>();

        while (result.size() < amount) {
            result.add(questionService.getRandomQuestion());
        }

        return result;
    }
}
