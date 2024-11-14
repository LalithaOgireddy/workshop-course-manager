package se.lexicon.course_manager.data.dao;



import se.lexicon.course_manager.data.sequencers.CourseSequencer;
import se.lexicon.course_manager.model.Course;
import se.lexicon.course_manager.model.Student;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;

// TODO provide proper implementation.

public class CourseCollectionRepository implements CourseDao{

    private Collection<Course> courses;


    public CourseCollectionRepository(Collection<Course> courses) {
        this.courses = courses;
    }

    @Override
    public Course createCourse(String courseName, LocalDate startDate, int weekDuration) {
        Course course = new Course(CourseSequencer.nextCourseId(),courseName,startDate,weekDuration);
        courses.add(course);
        return course;
    }

    @Override
    public Course findById(int id) {
        for(Course c: courses){
            if(c.getId() == id) return c;
        }
        return null;
    }

    @Override
    public Collection<Course> findByNameContains(String name) {
        Collection<Course> courseTempList = new HashSet<>();
        for(Course c: courses){ if(c.getCourseName().contains(name)){courseTempList.add(c); }}
        return courseTempList;
    }

    @Override
    public Collection<Course> findByDateBefore(LocalDate end) {
        Collection<Course> courseTempList = new HashSet<>();
        for(Course c: courses){ if(c.getStartDate().isBefore(end)) courseTempList.add(c);}
        return courseTempList;
    }

    @Override
    public Collection<Course> findByDateAfter(LocalDate start) {
        Collection<Course> courseTempList = new HashSet<>();
        for(Course c: courses){
            if(c.getStartDate().isAfter(start)) courseTempList.add(c);
        }
        return courseTempList;
    }

    @Override
    public Collection<Course> findAll() {
        return courses;
    }

    @Override
    public Collection<Course> findByStudentId(int studentId) {
        Collection<Course> courseTempList = new HashSet<>();
        for(Course c: courses) { for(Student st : c.getStudents()){ if(st.getId()==studentId) courseTempList.add(c); }}
        return courseTempList;
    }

    @Override
    public boolean removeCourse(Course course) {
        if(courses.contains(course)){
            courses.remove(course);
            return true;
        }
        else return false;
    }

    @Override
    public void clear() {
        this.courses = new HashSet<>();
    }
}
