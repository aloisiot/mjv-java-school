import dataSource.DBConnector;
import model.Student;
import repository.StudentRepository;

import java.sql.SQLException;
import java.util.List;

public class DBConnectionApp {
    public static void main(String[] args) throws SQLException {
        Student student = new Student();
        student.setName("Joao");
        student.setLastName("Soares");

        StudentRepository repository = new StudentRepository();
        student = repository.save(student, DBConnector.getConnection());
        System.out.println(student.getId());


        student.setName("Marcia");
        student.setId(2);
        student = repository.update(student,  DBConnector.getConnection());
        System.out.println(student.getName());

        student = repository.find(3, DBConnector.getConnection());
        System.out.println(student.getId());
        System.out.println(student.getName());

        List<Student> students = repository.findAll(DBConnector.getConnection());
        System.out.println(students.size());

        repository.delete(1, DBConnector.getConnection());
    }
}
