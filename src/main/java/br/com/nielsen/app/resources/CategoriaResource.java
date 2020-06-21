package br.com.nielsen.app.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.nielsen.app.domain.Categoria;
import br.com.nielsen.app.dto.CategoriaDTO;
import br.com.nielsen.app.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaService categoriaService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Categoria> findById(@PathVariable Long id) {

		Categoria categoria = categoriaService.findById(id);
		return ResponseEntity.ok().body(categoria);
	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<CategoriaDTO>> listAll() {

		List<Categoria> lista = categoriaService.listAll();

		List<CategoriaDTO> listaDTO = lista.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());

		return ResponseEntity.ok().body(listaDTO);
	}
	
}

//@GetMapping()
//public List<Categoria> listar() {
//	
//	Categoria cat1 = new Categoria(1L, "Lanches");
//	Categoria cat2 = new Categoria(2L, "Pizzas");
//	Categoria cat3 = new Categoria(3L, "Refrigerantes");
//	Categoria cat4 = new Categoria(4L, "Porções");
//	
//	List<Categoria> retorno = new ArrayList<>();
//	
//	retorno.add(cat1);
//	retorno.add(cat2);
//	retorno.add(cat3);
//	retorno.add(cat4);	
//			
//	return retorno;
//}
