package repository;

import daraBaseSource.DBConnector;
import model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    public Student save (Student student, Connection connection) throws SQLException {
        PreparedStatement statement;
        String query = "INSERT INTO tb_student (nome, sobrenome) VALUES (?, ?);";
        statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, student.getName());
        statement.setString(2, student.getLastName());
        statement.execute();
        ResultSet resultSet = statement.getGeneratedKeys();

        if(resultSet.next()) {
            student.setId(resultSet.getInt(1));
        }

        statement.close();
        return student;
    }

    public Student find (Integer id, Connection connection) throws SQLException {
        Student student = new Student();
        Statement statement = DBConnector.getConnection().createStatement();
        String query = String.format("SELECT * FROM tb_student WHERE student_id = %d;", id);
        ResultSet resultSet = statement.executeQuery(query);

        if(resultSet.next()) {
            student.setId(resultSet.getInt(1));
            student.setName(resultSet.getString(2));
            student.setLastName(resultSet.getString(3));
        }

        statement.close();
        return student;
    }

    public List<Student> findAll (Connection connection) throws SQLException {
        List<Student> students = new ArrayList<>();
        Statement statement = DBConnector.getConnection().createStatement();
        String query = "SELECT * FROM tb_student";
        ResultSet resultSet = statement.executeQuery(query);

        while(resultSet.next()) {
            Student student = new Student();
            student.setId(resultSet.getInt(1));
            student.setName(resultSet.getString(2));
            student.setLastName(resultSet.getString(3));
            students.add(student);
        }

        statement.close();
        return students;
    }

    public Student update (Student student, Connection connection) throws SQLException {
        Statement statement = DBConnector.getConnection().createStatement();
        String query = String.format(
            "UPDATE tb_student SET nome= '%s', sobrenome = '%s' WHERE student_id = %d;",
            student.getName(),
            student.getLastName(),
            student.getId()
        );
        statement.execute(query, Statement.RETURN_GENERATED_KEYS);
        ResultSet resultSet = statement.getGeneratedKeys();

        if(resultSet.next()) {
            student.setName(resultSet.getString(1));
        }
        if(resultSet.next()) {
            student.setLastName(resultSet.getString(2));
        }

        statement.close();
        return student;
    }

    public void delete (Integer id, Connection connection) throws SQLException {
        PreparedStatement statement;
        statement = connection.prepareStatement("DELETE FROM tb_student WHERE student_id = ?");
        statement.setInt(1, id);
        statement.execute();
        statement.close();
    }
}
