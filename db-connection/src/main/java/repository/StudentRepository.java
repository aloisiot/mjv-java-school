package repository;

import dataSource.DBConnector;
import model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    public Student find (Integer id, Connection connection) throws SQLException {
        Student student = new Student();
        Statement statement = DBConnector.getConnection().createStatement();
        try {
            String query = String.format("SELECT * FROM tb_alunos WHERE aluno_id = %d;", id);
            ResultSet resultSet = statement.executeQuery(query);

            if(resultSet.next()) {
                student.setId(resultSet.getInt(1));
                student.setName(resultSet.getString(2));
                student.setLastName(resultSet.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(statement != null)
                statement.close();
        }
        return student;
    }

    public List<Student> findAll (Connection connection) throws SQLException {
        List<Student> students = new ArrayList<>();
        Statement statement = DBConnector.getConnection().createStatement();
        try {
            String query = String.format("SELECT * FROM tb_alunos");
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt(1));
                student.setName(resultSet.getString(2));
                student.setLastName(resultSet.getString(3));
                students.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(statement != null)
                statement.close();
        }
        return students;
    }


    public Student save (Student student, Connection connection) throws SQLException {
        PreparedStatement statement = null;
        try {
            String query = "INSERT INTO tb_alunos (nome, sobrenome) VALUES (?, ?);";
            statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, student.getName());
            statement.setString(2, student.getLastName());
            statement.execute();
            ResultSet resultSet = statement.getGeneratedKeys();
            if(resultSet.next())
                student.setId(resultSet.getInt(1));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(statement != null)
                statement.close();
        }
        return student;
    }

    public Student update (Student student, Connection connection) throws SQLException {
        Statement statement = DBConnector.getConnection().createStatement();
        try {
            String query = String.format(
                "UPDATE tb_alunos SET nome= '%s', sobrenome = '%s' WHERE aluno_id = %d;",
                student.getName(),
                student.getLastName(),
                student.getId()
            );
            statement.execute(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = statement.getGeneratedKeys();

            if(resultSet.next())
                student.setName(resultSet.getString(1));
            if(resultSet.next()) {
                student.setLastName(resultSet.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(statement != null)
                statement.close();
        }
        return student;
    }

    public void delete (Integer id, Connection connection) throws SQLException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("DELETE FROM tb_alunos WHERE aluno_id = ?");
            statement.setInt(1, id);
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(statement != null)
                statement.close();
        }
    }
}
