package br.com.udemy.java.secao13;

import java.util.Date;

import br.com.udemy.java.secao13.entities.Order;
import br.com.udemy.java.secao13.entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) {
		
		Order pedido = new Order(1234, new Date(), OrderStatus.PAGAMENTO_PENDENTE );		
		System.out.println(pedido);
		
		OrderStatus os1 = OrderStatus.ENTREGUE;
		OrderStatus os2 = OrderStatus.valueOf("ENVIADO");
		
		System.out.println(os1);
		System.out.println(os2);

	}

}
