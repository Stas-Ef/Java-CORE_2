package org.skypro.ExamApp.service;

import org.skypro.ExamApp.model.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);
}
