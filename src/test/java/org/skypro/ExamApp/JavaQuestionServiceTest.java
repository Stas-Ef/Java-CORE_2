package org.skypro.ExamApp;

import org.junit.jupiter.api.Test;
import org.skypro.ExamApp.model.Question;
import org.skypro.ExamApp.service.JavaQuestionService;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {

    private final JavaQuestionService service = new JavaQuestionService();

    @Test
    void emptyCollection_random_throws() {
        assertThrows(NoSuchElementException.class, service::getRandomQuestion);
    }


    @Test
    void addDuplicate_onlyOneStored() {
        service.add("Q", "A");
        service.add("Q", "A");
        assertEquals(1, service.getAll().size());
    }

    @Test
    void removeFromEmpty_throws() {
        assertThrows(NoSuchElementException.class,
                () -> service.remove(new Question("Q", "A")));
    }

    @Test
    void addAndRemove_success() {
        Question q = service.add("Q", "A");
        service.remove(q);
        assertTrue(service.getAll().isEmpty());
    }
}

