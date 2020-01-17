package com.example.demo.domain.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Categoria;
import com.example.demo.domain.services.exceptions.ObjectNotFoundException;
import com.example.demo.repositories.CategoriaRepository;

@Service		
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
		  
	}
	
	public Categoria insert(Categoria obj) { 
		obj.setId(null); 
		return repo.save(obj);
	} 
	  
	public Categoria update(Categoria obj) { 
		find(obj.getId());
		return repo.save(obj);
	}
	 
	public void delete(Integer id) { 
		find(id);
		try {
		    repo.deleteById(id); 
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possivel excluir uma categoria que possi produtos 1");
		}
	}
	
}
