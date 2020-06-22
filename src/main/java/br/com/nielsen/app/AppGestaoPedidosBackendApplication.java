package br.com.nielsen.app;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.nielsen.app.domain.Categoria;
import br.com.nielsen.app.repositories.CategoriaRepository;

@SpringBootApplication
public class AppGestaoPedidosBackendApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categRepo;

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
		
		categRepo.saveAll(Arrays.asList(cat1, cat2, cat3, cat4));

	}

}
