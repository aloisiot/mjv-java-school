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
        student = repository.save(student, connection); // criação
        System.out.println(student.getId());


        student.setName("Marcia");
        student.setId(1);
        student = repository.update(student,  connection); // atualização
        System.out.println(student.getName());

        student = repository.find(1, connection); // busca por id
        System.out.println(student.getId());
        System.out.println(student.getName());

        List<Student> students = repository.findAll(connection); // busca todos
        System.out.println(students.size());

        repository.delete(2, connection); // exclusão
        connection.close();
    }
}
