package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DAOFactory;
import model.dao.interfaces.InterfaceDepartmentDAO;
import model.entities.Department;

public class program2 {

	public static void main(String[] args) {
		
		Integer id = null;
		Department depto = null;
		String nomeDepartamento = null;
		
		Scanner scan = new Scanner(System.in);
		
		InterfaceDepartmentDAO DAODepto = DAOFactory.createDepartmentDAO();
		
		
		System.out.println("TESTE 0: ----- DepartmentDAO::findById -> LOCALIZAR DEPARTAMENTO -------");
		
		System.out.print("Informe o ID: ");
		id = scan.nextInt();scan.nextLine();
		
		depto = DAODepto.findById(id);
		
		if ( depto == null  ) {
			System.out.println("ID Informado não localizado");
		}
		else {			
			
			System.out.println(depto);
			
		}		
		
		System.out.println();
		System.out.println();
		System.out.println("TESTE 1: ----- DepartmentDAO::insert -> INCLUSAO DE NOVO DEPARTAMENTO -------");
		System.out.print("Digite o nome do Departamento para Incluso: ");
		nomeDepartamento = scan.nextLine();
		
		depto = new Department(null, nomeDepartamento);
		
		// inclusao do departamento na base
		DAODepto.insert(depto);
		
		System.out.println("Departamento incluido com sucesso! ID: " + depto.getId());
		
		System.out.println();
		System.out.println();
		System.out.println("TESTE 2: ----- DepartmentDAO::update -> ATUALIZAR DEPARTAMENTO -------");
		
		System.out.print("Informe o ID: ");
		id = scan.nextInt();scan.nextLine();
		
		depto = DAODepto.findById(id);
		
		if ( depto == null  ) {
			System.out.println("ID Informado não localizado");
		}
		else {
			
			System.out.print("Digite o nome do Departamento para ALTERACAO: ");
			nomeDepartamento = scan.nextLine();			
			
			depto.setName(nomeDepartamento);
			
			DAODepto.update(depto);
			
			System.out.println("Departamento ATUALIZADO com sucesso...");
			
		}
		
		System.out.println();
		System.out.println();
		System.out.println("TESTE 3: ----- DepartmentDAO::deleteById -> EXCLUIR DEPARTAMENTO -------");
		
		System.out.print("Informe o ID: ");
		id = scan.nextInt();scan.nextLine();
		
		depto = DAODepto.findById(id);
		
		if ( depto == null  ) {
			System.out.println("ID Informado não localizado");
		}
		else {
			
			DAODepto.deleteById(id);
			
			System.out.println("Departamento EXCLUIDO com sucesso...");
			
		}		
		
		
		System.out.println();
		System.out.println();
		System.out.println("TESTE 4: ----- DepartmentDAO::findAll -> IMPRIMIR LISTA DE DEPARTAMENTO -------");		
		
		List<Department> deptoList = DAODepto.findAll();
		
		for ( Department item : deptoList  ) {
			System.out.println(item);			
		}		
		
		scan.close();
		
		System.out.println("Fim do programa");

	}

}
