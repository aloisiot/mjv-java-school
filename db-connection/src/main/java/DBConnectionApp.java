import daraBaseSource.DBConnector;
import model.Student;
import repository.StudentRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;
import java.util.List;

public class DBConnectionApp {

    private static void  withJpa() {
        EntityManagerFactory entityManagerFactory
                = Persistence.createEntityManagerFactory("Student-PU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Student student = new Student();
        student.setName("Joao");
        student.setLastName("Soares");

        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();
        System.out.println("id : " + student.getId());

        entityManager.close();
        entityManagerFactory.close();
    }

    private static void withoutJpa() throws SQLException {
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

        DBConnector.getConnection().close(); // finalizando a conexao
    }

    public static void main(String[] args) throws SQLException {
        withJpa();
        withoutJpa();
    }
}
