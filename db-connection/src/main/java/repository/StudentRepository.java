package repository;

import static daraBaseSource.DBConnector.getConnection;
import model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    public Student save (Student student) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement statement;
        String query = "INSERT INTO tb_student (name, last_name) VALUES (?, ?);";
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

    public Student find (Integer id) throws SQLException {
        Connection connection = getConnection();
        Student student = new Student();
        String query = "SELECT * FROM tb_student WHERE student_id = ?;";
        PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1, id);
        statement.execute();
        ResultSet resultSet = statement.getResultSet();

        if(resultSet.next()) {
            student.setId(resultSet.getInt(1));
            student.setName(resultSet.getString(2));
            student.setLastName(resultSet.getString(3));
        }

        statement.close();
        return student;
    }

    public List<Student> findAll () throws SQLException {
        Connection connection = getConnection();
        List<Student> students = new ArrayList<>();
        Statement statement = connection.createStatement();
        String query = "SELECT * FROM tb_student;";
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

    public Student update (Student student) throws SQLException {
        Connection connection = getConnection();
        String query = "UPDATE tb_student SET name= ?, last_name = ? WHERE student_id = ?;";
        PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, student.getName());
        statement.setString(2, student.getLastName());
        statement.setInt(3, student.getId());
        statement.executeUpdate();
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

    public void delete (Integer id) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement statement;
        statement = connection.prepareStatement("DELETE FROM tb_student WHERE student_id = ?;");
        statement.setInt(1, id);
        statement.execute();
        statement.close();
    }
}
