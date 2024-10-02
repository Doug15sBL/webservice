package br.edu.ifgoias.academico.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.edu.ifgoias.academico.entities.Curso;
import br.edu.ifgoias.academico.repositories.CursoRepository;

@Configuration
public class Config implements CommandLineRunner{
	
	@Autowired
	private CursoRepository cursoRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Curso c1 = new Curso(null, "Springboot");
		Curso c2 = new Curso(null, "Maven");
		
		cursoRepository.save(c1);
		cursoRepository.save(c2);
		
	}

}
