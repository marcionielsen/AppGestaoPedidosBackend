package br.com.nielsen.app;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.nielsen.app.domain.Categoria;
import br.com.nielsen.app.domain.Produto;
import br.com.nielsen.app.repositories.CategoriaRepository;
import br.com.nielsen.app.repositories.ProdutoRepository;

@SpringBootApplication
public class AppGestaoPedidosBackendApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categRepo;
	
	@Autowired
	private ProdutoRepository prodRepo;

	
	public static void main(String[] args) {
		SpringApplication.run(AppGestaoPedidosBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Criação das categorias
		Categoria cat1 = new Categoria(null, "Lanches");
		Categoria cat2 = new Categoria(null, "Pizzas");
		Categoria cat3 = new Categoria(null, "Refrigerantes");
		Categoria cat4 = new Categoria(null, "Porções");
		
		// Criação dos Produtos
		Produto prd1 = new Produto(null, "Hamburger", BigDecimal.valueOf(10.00));
		Produto prd2 = new Produto(null, "X-Burger", BigDecimal.valueOf(12.00));
		Produto prd3 = new Produto(null, "X-Egg", BigDecimal.valueOf(15.00));

		prd1.getCategorias().add(cat1);
		prd2.getCategorias().add(cat1);
		prd3.getCategorias().add(cat1);
		
		cat1.getProdutos().addAll(Arrays.asList(prd1, prd2, prd3));
		
		Produto prd4 = new Produto(null, "Messarela", BigDecimal.valueOf(20.50));
		Produto prd5 = new Produto(null, "Calabresa", BigDecimal.valueOf(25.00));
		Produto prd6 = new Produto(null, "Portuguesa", BigDecimal.valueOf(45.00));

		prd4.getCategorias().add(cat2);
		prd5.getCategorias().add(cat2);
		prd6.getCategorias().add(cat2);
		
		cat2.getProdutos().addAll(Arrays.asList(prd4, prd5, prd6));

		Produto prd7 = new Produto(null, "Coca-cola", BigDecimal.valueOf(12.00));
		Produto prd8 = new Produto(null, "Fanta Laranja", BigDecimal.valueOf(10.00));
		Produto prd9 = new Produto(null, "Guarana", BigDecimal.valueOf(10.00));

		prd7.getCategorias().add(cat3);
		prd8.getCategorias().add(cat3);
		prd9.getCategorias().add(cat3);

		cat3.getProdutos().addAll(Arrays.asList(prd7, prd8, prd9));

		Produto prd10 = new Produto(null, "Bolinhas de queijo", BigDecimal.valueOf(10.00));
		Produto prd11 = new Produto(null, "Batata frita", BigDecimal.valueOf(15.00));
		Produto prd12 = new Produto(null, "Frango a passarinho", BigDecimal.valueOf(35.00));
		
		prd10.getCategorias().add(cat4);
		prd11.getCategorias().add(cat4);
		prd12.getCategorias().add(cat4);

		cat4.getProdutos().addAll(Arrays.asList(prd10, prd11, prd12));

		// Inserção dos dados no BD
		categRepo.saveAll(Arrays.asList(cat1, cat2, cat3, cat4));

		prodRepo.saveAll(Arrays.asList(prd1, prd2, prd3, 
				                       prd4, prd5, prd6, 
				                       prd7, prd8, prd9,
				                       prd10, prd11, prd12));
	}

}
