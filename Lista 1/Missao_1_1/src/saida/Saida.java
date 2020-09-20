package saida;

public class Saida {
	public static void evenOrOdd(boolean check, boolean isNatural){
		
		if(!isNatural)
			System.out.println("nao eh par e nem eh impar");
		else if (check)
			System.out.println("eh par");
		else
			System.out.println("eh impar");
	}
	
	public static void divisibleThree(boolean check){
		
		if (check)
			System.out.println("eh divisivel por 3");
		else
			System.out.println("nao eh divisivel por 3");
	}
	
	public static void divisibleFive(boolean check){
		
		if (check)
			System.out.println("eh divisivel por 5");
		else
			System.out.println("nao eh divisivel por 5");
	}
	
	public static void isPrime(boolean check){
		
		if (check)
			System.out.println("eh primo");
		else
			System.out.println("nao eh primo");
	}
	
	public static void isPerfect(boolean check, boolean isNatural){
		
		if(!isNatural)
			System.out.println("nao eh um numero perfeito");
		else if (check)
			System.out.println("eh um numero perfeito");
		else
			System.out.println("nao eh um numero perfeito");
	}
}
