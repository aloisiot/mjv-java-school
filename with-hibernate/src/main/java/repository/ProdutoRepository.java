package repository;

import model.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class ProdutoRepository {

    private final EntityManagerFactory entityManagerFactory;

    public ProdutoRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public Produto salvar(Produto produto) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(produto);
        entityManager.getTransaction().commit();

        entityManager.close();
        return produto;
    }

    public Produto buscarPorId(Integer id){
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Produto produto = entityManager.find(Produto.class, id);

        entityManager.close();
        return produto;
    };

    public List<Produto> buscarTodos() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        String jpql = "SELECT p FROM Produto p";

        List<Produto> result = entityManager.createQuery(jpql, Produto.class).getResultList();
        entityManager.close();
        return result;
    }

    public void excluir(Integer id) throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Produto produto = buscarPorId(id);

        if(produto == null) {
            throw new Exception("registro nao encontrado");
        }

        entityManager.getTransaction().begin();
        entityManager.remove(
                entityManager.contains(produto)
                        ? produto
                        : entityManager.merge(produto)
        );
        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
