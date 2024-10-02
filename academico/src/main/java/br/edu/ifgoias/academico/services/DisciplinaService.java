package br.edu.ifgoias.academico.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.edu.ifgoias.academico.entities.Disciplina;
import br.edu.ifgoias.academico.repositories.DisciplinaRepository;

@Service
public class DisciplinaService {
	
	@Autowired
	private DisciplinaRepository repository;
	
	public List<Disciplina> findAll(){
		return repository.findAll();
	}
	
	public Disciplina findById(Integer id) {
		return repository.findById(id)
				.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	public Disciplina insert(Disciplina disciplina) {
		return repository.save(disciplina);
	}
	
	public void delete (Integer id) {
		repository.findById(id).map(
				disciplina -> { repository.delete(disciplina);
				return Void.TYPE;
				}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	public void update (Integer id, Disciplina obj) {
		repository.findById(id).map(
				disciplina -> { disciplina.setNomedisciplina(obj.getNomedisciplina());
				return repository.save(disciplina);
				}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

}