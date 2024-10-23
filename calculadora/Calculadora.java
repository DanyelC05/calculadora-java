import java.util.Scanner;

public class Calculadora {
	
	//metodos operaùùes
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
			throw new IllegalArgumentException ("Nùo ù permitido divisùo por 0!"); //se a divisùo for por 0, retorna um erro
		}
	}
	
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Calculadora calc = new Calculadora();
		
		System.out.println("Bem vindo a calculadora!");
		System.out.println("Digite o primeiro nùmero: ");
		double num1 = sc.nextDouble();
		
		System.out.println("Digite o segundo nùmero: ");
		double num2 = sc.nextDouble();
		
		System.out.println("Escolha a operaùùo: ");
		System.out.println("1: Adiùùo");
		System.out.println("2: Subtraùùo");
		System.out.println("3: Multiplicaùùo");
		System.out.println("4: Divisùo");
		int operacao = sc.nextInt();
		
		double resultado;
        //switch para determinar a operaùùo
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
				System.out.println("Operaùùo invùlida!");
				sc.close();
                return;
		}
		
        //mostra o resultado
		System.out.println("Resultado: " + resultado);
		sc.close();
	}
}
