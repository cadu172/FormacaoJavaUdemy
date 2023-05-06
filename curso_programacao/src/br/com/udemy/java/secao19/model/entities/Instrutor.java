package br.com.udemy.java.secao19.model.entities;

import java.util.ArrayList;
import java.util.List;

public final class Instrutor extends AbstractPessoa {

	private List<Curso> cursoList = new ArrayList<>();
	
	public Instrutor(Integer codigo, String nome) {
		super(codigo, nome);
	}
	
	public void addCurso(Curso curso) {
		this.cursoList.add(curso);
	}

	public List<Curso> getCursoList() {
		return cursoList;
	}

	@Override
	public int compareTo(AbstractPessoa o) {		
		return this.getCodigo().compareTo(o.getCodigo());
	}
	
	
	
}
