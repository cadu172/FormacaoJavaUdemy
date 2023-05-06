package br.com.udemy.java.secao19.model.entities;

import java.util.Objects;

public abstract class AbstractPessoa implements Comparable<AbstractPessoa> {
	
	private Integer codigo;
	private String nome;
	
	
	public AbstractPessoa(Integer codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}


	public Integer getCodigo() {
		return codigo;
	}


	public String getNome() {
		return nome;
	}


	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractPessoa other = (AbstractPessoa) obj;
		return Objects.equals(codigo, other.codigo);
	}
	
	
	
	

}
