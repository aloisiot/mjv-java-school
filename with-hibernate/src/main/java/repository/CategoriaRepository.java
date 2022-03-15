package repository;

import model.Categoria;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class CategoriaRepository {

    private final EntityManagerFactory entityManagerFactory;

    public CategoriaRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public Categoria salvar(Categoria categoria) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(categoria);
        entityManager.getTransaction().commit();

        entityManager.close();
        return categoria;
    }

    public Categoria buscarPorId(Integer id){
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Categoria categoria = entityManager.find(Categoria.class, id);

        entityManager.close();
        return categoria;
    };

    public List<Categoria> buscarTodos() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        String jpql = "SELECT c FROM Categoria c";

        List<Categoria> result = entityManager.createQuery(jpql, Categoria.class).getResultList();
        entityManager.close();
        return result;
    }

    public void excluir(Integer id) throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Categoria categoria = buscarPorId(id);

        if(categoria == null) {
            throw new Exception("registro nao encontrado");
        }

        entityManager.getTransaction().begin();
        entityManager.remove(
                entityManager.contains(categoria)
                        ? categoria
                        : entityManager.merge(categoria)
        );
        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
