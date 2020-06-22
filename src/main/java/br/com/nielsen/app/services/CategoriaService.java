package br.com.nielsen.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.nielsen.app.domain.Categoria;
import br.com.nielsen.app.dto.CategoriaDTO;
import br.com.nielsen.app.repositories.CategoriaRepository;
import br.com.nielsen.app.services.exceptions.IntegridadeDadosException;
import br.com.nielsen.app.services.exceptions.ObjetoNaoEncontradoException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	public List<Categoria> listAll() {
		List<Categoria> lista = repo.findAll();

		return lista;
	}

	public Categoria findById(Long id) {
		Optional<Categoria> categoria = repo.findById(id);

		return categoria.orElseThrow(() -> new ObjetoNaoEncontradoException(id.toString(), Categoria.class.getName()));
	}

	public Page<Categoria> listPerPage(Integer numPage, Integer linesPage, String direction, String orderBy) {
		PageRequest pageRequest = PageRequest.of(numPage, linesPage, Direction.valueOf(direction), orderBy);

		return repo.findAll(pageRequest);
	}

	public Categoria insert(CategoriaDTO obj) {

		Categoria newObj = repo.save(fromDTO(obj));

		return newObj;
	}

	public Categoria update(CategoriaDTO obj) {

		Categoria newObj = this.findById(obj.getId());

		this.updateData(newObj, fromDTO(obj));

		Categoria saveObj = repo.save(newObj);

		return saveObj;
	}

	public void delete(Long id) {
		findById(id);

		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new IntegridadeDadosException(id.toString(), Categoria.class.getName());
		}
	}

	public Categoria fromDTO(CategoriaDTO obj) {
		return new Categoria(obj.getId(), obj.getNome());
	}

	private void updateData(Categoria newObj, Categoria obj) {
		newObj.setNome(obj.getNome());
	}

}
