package se.lexicon.course_manager.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {
    // TODO Implement your tests here
    Student testObject;

    @Test
    void getId(){
        testObject = new Student(1,"Test","test@gmail.com","södertälje");
        assertEquals(1,testObject.getId());
    }
}
