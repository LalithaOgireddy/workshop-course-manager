package se.lexicon.course_manager.data.dao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import se.lexicon.course_manager.data.sequencers.CourseSequencer;
import se.lexicon.course_manager.model.Course;


import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {CourseCollectionRepository.class})
public class CourseCollectionRepositoryTest {

    @Autowired
    private CourseDao testObject;

    @Test
    @DisplayName("Test context successfully setup")
    void context_loads() {
        assertFalse(testObject == null);
    }

    // TODO Write your tests here
    @Test
    void createCourse(){
        Course course = testObject.createCourse("Java 8", LocalDate.of(2025,1,1),40);
        assertNotNull(course);
    }

    @Test
    void findById(){
        Course course = testObject.createCourse("Java 8", LocalDate.of(2025,1,1),40);
        Course found = testObject.findById(course.getId());
        assertEquals(course,found);
    }

    @Test
    void removeCourse(){
        Course course = testObject.createCourse("Java 8", LocalDate.of(2025,1,1),40);
        assertEquals(true,testObject.removeCourse(course));
    }

    @AfterEach
    void tearDown() {
        testObject.clear();
        CourseSequencer.setCourseSequencer(0);
    }
}
