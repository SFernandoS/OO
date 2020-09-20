package recursos;

public class Metodos {
	
	public static boolean isNatural(int number) {
		return (number > 0)? true: false;
	}
	
	public static boolean evenOrOdd(int number) {
		return (number % 2 == 0);
	}
	
	public static boolean divisibleThree(int number) {
		return (number % 3 == 0 && number > 0);
	}
	
	public static boolean divisibleFive(int number) {
		return (number % 5 == 0 && number > 0);
	}
	
	public static boolean isPrime (int number,int aux) {	  
		
		if(number <= 2)
			return (number == 2) ? true : false; 
		else if (number % aux == 0) 
			return false; 
		else if (aux * aux > number) 
	        return true; 
		
		return isPrime(number, aux + 1); 
	}
	
	public static boolean isPerfect(int number, int aux, int total) {
		
		if(number % aux == 0 && aux < number) 
			total += aux;
		else if(aux > number)
			return (total == number)? true: false;
				
		return isPerfect(number, aux + 1, total);
	}
}
