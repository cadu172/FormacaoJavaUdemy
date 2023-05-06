package br.com.udemy.java.secao19.model.entities;

public final class Aluno extends AbstractPessoa {

	public Aluno(Integer codigo, String nome) {
		super(codigo, nome);
	}

	@Override
	public int compareTo(AbstractPessoa o) {		
		return this.getCodigo().compareTo(o.getCodigo());
	}

}
