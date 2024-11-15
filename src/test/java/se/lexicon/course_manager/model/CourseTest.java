package se.lexicon.course_manager.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class CourseTest {
    // TODO Implement your tests here
    Course testObject;
    Student student;

    @BeforeEach
    void setUp() {
        testObject = new Course(1);
        student = new Student(1);
    }

    @Test
    void enrollStudent() {
        testObject.enrollStudent(student);
        assertTrue(testObject.getStudents().contains(student));
    }

    @Test
    void unenrollStudent() {
        testObject.setStudents(new ArrayList<>(Collections.singletonList(student)));
        testObject.unenrollStudent(student);
        assertFalse(testObject.getStudents().contains(student));
    }

}
