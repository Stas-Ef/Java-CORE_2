package org.skypro.ExamApp;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.skypro.ExamApp.model.Question;
import org.skypro.ExamApp.service.ExaminerService;
import org.skypro.ExamApp.service.ExaminerServiceImpl;
import org.skypro.ExamApp.service.QuestionService;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ExaminerServiceImplTest {

    @Test
    void amountZero_returnsEmpty() {
        QuestionService service = Mockito.mock(QuestionService.class);
        when(service.getAll()).thenReturn(Set.of());

        ExaminerService examiner = new ExaminerServiceImpl(service);
        assertTrue(examiner.getQuestions(0).isEmpty());
    }

    @Test
    void amountMoreThanAvailable_throws() {
        QuestionService service = Mockito.mock(QuestionService.class);
        when(service.getAll()).thenReturn(Set.of(new Question("Q", "A")));

        ExaminerService examiner = new ExaminerServiceImpl(service);
        assertThrows(RuntimeException.class,
                () -> examiner.getQuestions(2));
    }
}

