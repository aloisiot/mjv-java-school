import model.Categoria;
import model.Produto;
import repository.CategoriaRepository;
import repository.ProdutoRepository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class WithHibernateApp {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory
                = Persistence.createEntityManagerFactory("MJV-PU");

        CategoriaRepository categoriaRepository = new CategoriaRepository(entityManagerFactory);
        ProdutoRepository produtoRepository = new ProdutoRepository(entityManagerFactory);

        Categoria categoria = new Categoria();
        categoria.setNome("categoria 2");
        categoria = categoriaRepository.salvar(categoria);

        Produto produto = new Produto();
        produto.setCategoria(categoria);
        produto.setDescricao("descricao...");
        produto.setNome("produto x");

        produtoRepository.salvar(produto);

        List<Produto> produtos = produtoRepository.buscarTodos();
        produtos.forEach(p -> System.out.println(p.getId() + " : " + p.getNome()));


        categoria = categoriaRepository.buscarPorId(categoria.getId());

        // Compara os ids para sinalizar se a consulta ocorreu como esperado
        System.out.println(categoria.getProdutos().get(0).getId().equals(produto.getId()));

        System.out.println(produtoRepository.buscarTodos().size() > 0);

        entityManagerFactory.close();
    }
}
