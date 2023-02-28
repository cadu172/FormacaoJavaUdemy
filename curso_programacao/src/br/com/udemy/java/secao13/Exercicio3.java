package br.com.udemy.java.secao13;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import br.com.udemy.java.secao13.entities.Cliente;
import br.com.udemy.java.secao13.entities.Pedido;
import br.com.udemy.java.secao13.entities.PedidoItem;
import br.com.udemy.java.secao13.entities.Produto;
import br.com.udemy.java.secao13.entities.enums.StatusPedido;

public class Exercicio3 {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");		
		String nomeCliente;
		String emailCliente;
		Date dataNascimentoCliente;
		String statusPedido;
		int quantidadeItemsPedido;
		String nomeDoProduto;
		Double precoDoProduto;
		int quantidadeItems;
		
		System.out.println("Enter cliente data: ");		
		
		System.out.print("Name: ");
		nomeCliente = scan.nextLine();
		
		System.out.print("E-Mail: ");
		emailCliente = scan.nextLine();

		System.out.print("Birth date (DD/MM/YYYY): ");
		dataNascimentoCliente = formatter.parse(scan.nextLine());		
		
		System.out.println("Enter order data: ");		
		
		System.out.print("Status: ");
		statusPedido = scan.nextLine();
		
		System.out.print("How many items to this order? ");
		quantidadeItemsPedido = scan.nextInt();scan.nextLine();
 
		Cliente cliente = new Cliente(
				nomeCliente, //String nome, 
				emailCliente, //String email, 
				dataNascimentoCliente//Date dataNasciment				
				);
		
		Pedido pedido = new Pedido(StatusPedido.valueOf(statusPedido), cliente);
		
		
		for (int i = 1; i <= quantidadeItemsPedido; i++) {
			
			System.out.println("Enter #"+i+" item data: ");
			System.out.print("Product name: ");nomeDoProduto = scan.nextLine();
			System.out.print("Product price: ");precoDoProduto = scan.nextDouble();
			System.out.print("Quantity: ");quantidadeItems = scan.nextInt();scan.nextLine();
			
			Produto produto = new Produto(nomeDoProduto,precoDoProduto);
			PedidoItem pedidoItem = new PedidoItem(quantidadeItems,precoDoProduto,produto);			
			
			pedido.addItem(pedidoItem);
			
		}
		
		System.out.println(pedido);
		
		scan.close();	

	}

}
