package se.lexicon.course_manager.data.dao;



import se.lexicon.course_manager.data.sequencers.CourseSequencer;
import se.lexicon.course_manager.data.sequencers.StudentSequencer;
import se.lexicon.course_manager.model.Student;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

// TODO provide proper implementation.

public class StudentCollectionRepository implements StudentDao {

    private Collection<Student> students;

    public StudentCollectionRepository(Collection<Student> students) {
        this.students = students;
    }

    @Override
    public Student createStudent(String name, String email, String address) {
        Student student = new Student(StudentSequencer.nextStudentId(),name,email,address);
        //if(students.add(student)) return student;
        //return null;
        return students.add(student) ? student : null;
    }

    @Override
    public Student findByEmailIgnoreCase(String email) {
        for(Student st : students){
            if(st.getEmail().trim().equalsIgnoreCase(email)){
                return st;
            }
        }
        return null;
    }

    @Override
    public Collection<Student> findByNameContains(String name) {
        Collection<Student> studentTempList = new HashSet<>();
        for(Student st: students){
            if(st.getName().trim().toLowerCase().contains(name.trim().toLowerCase())){
                studentTempList.add(st);
            }
        }
        return studentTempList;
    }

    @Override
    public Student findById(int id) {
        for(Student st : students){
            if(st.getId()==id){
                return st;
            }
        }
        return null;
    }

    @Override
    public Collection<Student> findAll() {
        return Collections.unmodifiableCollection(students);
    }

    @Override
    public boolean removeStudent(Student student) {
        /*if(students.contains(student)){
            students.remove(student);
            return true;
        }
        return false;*/
        return students.remove(student);
    }

    @Override
    public void clear() {
        this.students = new HashSet<>();
    }
}
