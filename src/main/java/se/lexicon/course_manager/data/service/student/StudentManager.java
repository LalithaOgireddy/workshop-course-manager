package se.lexicon.course_manager.data.service.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.course_manager.data.dao.CourseDao;
import se.lexicon.course_manager.data.dao.StudentDao;
import se.lexicon.course_manager.data.service.converter.Converters;
import se.lexicon.course_manager.dto.forms.CreateStudentForm;
import se.lexicon.course_manager.dto.forms.UpdateStudentForm;
import se.lexicon.course_manager.dto.views.StudentView;


import java.util.List;

// TODO provide proper implementation.
@Service
public class StudentManager implements StudentService {

    private final StudentDao studentDao;
    private final CourseDao courseDao;
    private final Converters converters;

    @Autowired
    public StudentManager(StudentDao studentDao, CourseDao courseDao, Converters converters) {
        this.studentDao = studentDao;
        this.courseDao = courseDao;
        this.converters = converters;
    }

    @Override
    public StudentView create(CreateStudentForm form) {
        return converters.studentToStudentView(studentDao.createStudent(form.getName(), form.getEmail(), form.getAddress()));
    }

    @Override
    public StudentView update(UpdateStudentForm form) {

        return null;
    }

    @Override
    public StudentView findById(int id) {
        return converters.studentToStudentView(studentDao.findById(id));
    }

    @Override
    public StudentView searchByEmail(String email) {
        return converters.studentToStudentView(studentDao.findByEmailIgnoreCase(email));
    }

    @Override
    public List<StudentView> searchByName(String name) {
        return converters.studentsToStudentViews(studentDao.findByNameContains(name));
    }

    @Override
    public List<StudentView> findAll() {
        return converters.studentsToStudentViews(studentDao.findAll());
    }

    @Override
    public boolean deleteStudent(int id) {
        return studentDao.removeStudent(studentDao.findById(id));
    }
}
