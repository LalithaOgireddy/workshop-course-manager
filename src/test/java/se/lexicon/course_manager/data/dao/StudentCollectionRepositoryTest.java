package se.lexicon.course_manager.data.dao;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import se.lexicon.course_manager.data.sequencers.StudentSequencer;
import se.lexicon.course_manager.model.Student;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {StudentCollectionRepository.class})
public class StudentCollectionRepositoryTest {

    @Autowired
    private StudentDao testObject;

    @Test
    @DisplayName("Test context successfully setup")
    void context_loads() {
        assertFalse(testObject == null);
    }

    // TODO Write your tests here
    @Test
    void createStudent() {
        Student student = testObject.createStudent("Lalitha","lalitha@gmail.com","Södertälje");
        assertNotNull(student);
    }

    @Test
    void findById() {
        Student student = testObject.createStudent("Lalitha","lalitha@gmail.com","Södertälje");
        Student found = testObject.findById(student.getId());
        assertEquals(student,found);
    }

    @Test
    void removeStudent(){
        Student student = testObject.createStudent("Lalitha","lalitha@gmail.com","Södertälje");
        assertEquals(true,testObject.removeStudent(student));
    }

    @AfterEach
    void tearDown() {
        testObject.clear();
        StudentSequencer.setStudentSequencer(0);
    }

}
