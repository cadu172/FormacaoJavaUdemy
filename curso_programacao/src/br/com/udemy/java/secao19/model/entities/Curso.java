package br.com.udemy.java.secao19.model.entities;

import java.util.ArrayList;
import java.util.List;

public final class Curso {
	
	private Integer codigo;
	private String nome;
	
	private List<Aluno> alunoList = new ArrayList<>();
	
	public Curso(Integer codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}
	
	public void addAluno(Aluno aluno) {
		this.alunoList.add(aluno);
	}

	public List<Aluno> getAlunoList() {
		return alunoList;
	}
	
	
	

}
