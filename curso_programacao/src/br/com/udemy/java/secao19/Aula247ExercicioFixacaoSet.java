package br.com.udemy.java.secao19;

import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

import br.com.udemy.java.secao19.model.entities.Aluno;
import br.com.udemy.java.secao19.model.entities.Curso;
import br.com.udemy.java.secao19.model.entities.Instrutor;

public class Aula247ExercicioFixacaoSet {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);		
		Scanner scan = new Scanner(System.in);
		
		
		Integer idInstrutor;
		String nomeInstrutor;
		
		System.out.print("Digite o ID do Instrutor: ");
		idInstrutor = scan.nextInt();scan.nextLine();
		
		
		System.out.print("Digite o NOME do Instrutor: ");
		nomeInstrutor = scan.nextLine();
		
		Instrutor instrutor = new Instrutor(idInstrutor, nomeInstrutor);
		
		
		
		Curso cursoA = new Curso(1, "Curso A");
		Curso cursoB = new Curso(1, "Curso B");
		Curso cursoC = new Curso(1, "Curso C");
		
		
		System.out.print("Quantidade de alunos do curso A: ");
		Integer quantidadeAluno = scan.nextInt();scan.nextLine();
		
		for (int i=1; i<=quantidadeAluno; i++ ) {
			cursoA.addAluno(new Aluno(scan.nextInt(),""));
		}
		
		
		System.out.print("Quantidade de alunos do curso B: ");
		quantidadeAluno = scan.nextInt();scan.nextLine();
		
		for (int i=1; i<=quantidadeAluno; i++ ) {
			cursoB.addAluno(new Aluno(scan.nextInt(),""));
		}
		
		
		System.out.print("Quantidade de alunos do curso C: ");
		quantidadeAluno = scan.nextInt();scan.nextLine();
		
		for (int i=1; i<=quantidadeAluno; i++ ) {
			cursoC.addAluno(new Aluno(scan.nextInt(),""));
		}
		
		
		
		instrutor.addCurso(cursoA);
		instrutor.addCurso(cursoB);
		instrutor.addCurso(cursoC);
		
		
		Set<Aluno> alunoUniqueList = new HashSet<>();
		
		
		
		
		for (Curso curso : instrutor.getCursoList()) {
			alunoUniqueList.addAll(curso.getAlunoList());
		}
		
		System.out.println("Quantidade de alunos Unique do Instrutor "+instrutor.getNome()+" : " + alunoUniqueList.size());
		
		scan.close();

	}

}
