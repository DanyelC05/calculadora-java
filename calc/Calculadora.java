
import java.util.Scanner;

public class Calculadora {
	
	//metodos operações
	public double adicao(double a, double b) {
		return a + b;
	}
	
	public double subtracao(double a, double b) {
		return a - b;
	}
	
	public double multiplicacao(double a, double b) {
		return a * b;
	}
	
	public double divisao(double a, double b) {
		if (b != 0) {
			return a / b;
		} else {
			throw new IllegalArgumentException ("Não á permitido divisão por 0!"); //se a divisão for por 0, retorna um erro
		}
	}
	
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Calculadora calc = new Calculadora();
		
		System.out.println("Bem vindo a calculadora!");
		System.out.println("Digite o primeiro número: ");
		double num1 = sc.nextDouble();
		
		System.out.println("Digite o segundo número: ");
		double num2 = sc.nextDouble();
		
		System.out.println("Escolha a operação: ");
		System.out.println("1: Adição");
		System.out.println("2: Subtração");
		System.out.println("3: Multiplicação");
		System.out.println("4: Divisão");
		int operacao = sc.nextInt();
		
		double resultado;
        //switch para determinar a opera��o
		switch (operacao) {
			case 1 :
				resultado = calc.adicao(num1, num2);
				break;
				
			case 2 :
				resultado = calc.subtracao(num1, num2);
				break;
				
			case 3 :
				resultado = calc.multiplicacao(num1, num2);
				break;
				
			case 4 :
				resultado = calc.divisao(num1, num2);
				break;
				
			default:
				System.out.println("Operação inválida!");
				sc.close();
                return;
		}
		
        //mostra o resultado
		System.out.println("Resultado: " + resultado);
		sc.close();
	}
}
