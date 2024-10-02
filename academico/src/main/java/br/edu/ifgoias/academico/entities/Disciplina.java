package br.edu.ifgoias.academico.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;

@Entity
public class Disciplina implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer iddisciplina;
	
	@Column(name= "nomedisciplina", nullable = false)
	private String nomedisciplina;
	
	@ManyToOne
	@JsonIgnore
	@JoinTable(name = "curso_disciplina",
				joinColumns = @JoinColumn(name = "iddisciplina"),
				inverseJoinColumns = @JoinColumn(name="idcurso"))
	private List<Curso> listaCurso = new ArrayList<>();

	public Disciplina(Integer iddisciplina, String nomedisciplina, List<Curso> listaCurso) {
		this.iddisciplina = iddisciplina;
		this.nomedisciplina = nomedisciplina;
		this.listaCurso = listaCurso;
	}

	public Disciplina() {
		
	}
	
	public List<Curso> getListaCurso() {
		return listaCurso;
	}
	
	public void adicionarCurso (Curso c) {
		
		if (!listaCurso.contains(c)) {
			listaCurso.add(c);
			c.adicionarDisciplina(this);
		}		
	}

	public Integer getIddisciplina() {
		return iddisciplina;
	}

	public void setIddisciplina(Integer iddisciplina) {
		this.iddisciplina = iddisciplina;
	}

	public String getNomedisciplina() {
		return nomedisciplina;
	}

	public void setNomedisciplina(String nomedisciplina) {
		this.nomedisciplina = nomedisciplina;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((iddisciplina == null) ? 0 : iddisciplina.hashCode());
		result = prime * result + ((nomedisciplina == null) ? 0 : nomedisciplina.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disciplina other = (Disciplina) obj;
		if (iddisciplina == null) {
			if (other.iddisciplina != null)
				return false;
		} else if (!iddisciplina.equals(other.iddisciplina))
			return false;
		if (nomedisciplina == null) {
			if (other.nomedisciplina != null)
				return false;
		} else if (!nomedisciplina.equals(other.nomedisciplina))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Disciplina [iddisciplina=" + iddisciplina + ", nomedisciplina=" + nomedisciplina + "]";
	}

	
	
	

}
