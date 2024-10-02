package br.edu.ifgoias.academico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifgoias.academico.entities.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Integer>{

}
