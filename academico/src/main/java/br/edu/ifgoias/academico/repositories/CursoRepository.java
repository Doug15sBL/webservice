package br.edu.ifgoias.academico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifgoias.academico.entities.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer>{

}
