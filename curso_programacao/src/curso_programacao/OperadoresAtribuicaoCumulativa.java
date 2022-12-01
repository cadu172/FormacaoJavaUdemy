package curso_programacao;

import java.util.Locale;
import java.util.Scanner;

public class OperadoresAtribuicaoCumulativa {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		float valorFranquia = 0.0f;
		int minutosFranquia = 0;
		int minutosFalados = 0;
		int minutosExcedentes = 0;		
		float valorMinutoExcedente = 0.2f;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("CALCULO DE CONSUMO DE CONTA DE TELEFONE");
		
		
		System.out.print("QUAL VALOR DA FRANQUIA: ");
		valorFranquia = scan.nextFloat();
		

		System.out.print("QUANTOS MINUTOS TEM A FRANQUIA: ");
		minutosFranquia = scan.nextInt();
		
		System.out.print("QUANTOS MINUTOS FORAM FALADOS NO MES: ");
		minutosFalados = scan.nextInt();
		
		minutosExcedentes = minutosFalados - minutosFranquia;
		
		if ( minutosExcedentes > 0 ) {
			// calcula o valor em reais do excedente
			valorFranquia += ( minutosExcedentes * valorMinutoExcedente );
		}
		
		System.out.printf("O valor final da conta é %.2f",valorFranquia);

		
		scan.close();

	}

}
