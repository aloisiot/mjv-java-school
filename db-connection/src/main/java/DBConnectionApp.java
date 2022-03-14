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
        student = repository.save(student); // criação
        System.out.println(student.getId());


        student.setName("Sandra");
        student.setId(1);
        student = repository.update(student); // atualização
        System.out.println(student.getName());

        student = repository.find(1); // busca por id
        System.out.printf("id = 1 ? %b\n", student.getId() == 1);
        System.out.printf("id: %d, name: %s\n",student.getId(), student.getName());

        List<Student> students = repository.findAll(); // busca todos
        System.out.printf("Numero de registros no repositorio: %s\n" , students.size());
        System.out.println(students.get(1).getName());
        System.out.println(students.stream().filter(student1 -> student1.getId() == 1).findFirst().get().getName());

        repository.delete(2); // exclusão
    }
}
