package br.com.nielsen.app.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nielsen.app.domain.Categoria;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
	
	@GetMapping()
	public List<Categoria> listar() {
		
		Categoria cat1 = new Categoria(1L, "Lanches");
		Categoria cat2 = new Categoria(2L, "Pizzas");
		Categoria cat3 = new Categoria(3L, "Refrigerantes");
		Categoria cat4 = new Categoria(4L, "Porções");
		
		List<Categoria> retorno = new ArrayList<>();
		
		retorno.add(cat1);
		retorno.add(cat2);
		retorno.add(cat3);
		retorno.add(cat4);	
				
		return retorno;
	}
	
}
