import daraBaseSource.DBConnector;
import model.Student;
import repository.StudentRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DBConnectionApp {
    public static void main(String[] args) throws SQLException {
        Connection connection = DBConnector.getConnection();

        Student student = new Student();
        student.setName("Joao");
        student.setLastName("Soares");

        StudentRepository repository = new StudentRepository();
        student = repository.save(student, connection);
        System.out.println(student.getId());


        student.setName("Marcia");
        student.setId(1);
        student = repository.update(student,  connection);
        System.out.println(student.getName());

        student = repository.find(1, connection);
        System.out.println(student.getId());
        System.out.println(student.getName());

        List<Student> students = repository.findAll(connection);
        System.out.println(students.size());

        repository.delete(2, connection);
        connection.close();
    }
}
