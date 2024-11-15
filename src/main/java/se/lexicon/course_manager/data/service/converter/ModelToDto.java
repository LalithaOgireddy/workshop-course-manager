package se.lexicon.course_manager.data.service.converter;

import org.springframework.stereotype.Component;
import se.lexicon.course_manager.dto.views.CourseView;
import se.lexicon.course_manager.dto.views.StudentView;
import se.lexicon.course_manager.model.Course;
import se.lexicon.course_manager.model.Student;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

// TODO Convert model -> view & models -> views

@Component
public class ModelToDto implements Converters {

    @Override
    public StudentView studentToStudentView(Student student) {
        return new StudentView(student.getId(), student.getName(), student.getEmail(), student.getAddress());
    }

    @Override
    public CourseView courseToCourseView(Course course) {
        List<StudentView> studentviewList = studentsToStudentViews(course.getStudents());
        return new CourseView(course.getId(), course.getCourseName(), course.getStartDate(), course.getWeekDuration(), studentviewList);
    }

    @Override
    public List<CourseView> coursesToCourseViews(Collection<Course> courses) {
        List<CourseView> courseViewList = new ArrayList<>();
        for(Course c:courses){
            courseViewList.add(courseToCourseView(c));
        }
        return courseViewList;
    }

    @Override
    public List<StudentView> studentsToStudentViews(Collection<Student> students) {
        List<StudentView> studentsViewList = new ArrayList<>();
        for(Student st : students){
            studentsViewList.add(studentToStudentView(st));
        }
        return studentsViewList;
    }
}
