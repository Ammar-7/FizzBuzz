
public class FizzBuzz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		for (int num = 1 ;num<50 ; num++) {
			
			if(num%3 == 0) {
				if (num % 5 == 0)
					System.out.print( "FizzBuzz");
				else

				System.out.print( "Fizz");
				
			}
			
			else if(num%5 == 0) 
				System.out.print( "Buzz");
				else  
					System.out.println( num);
			
			System.out.println();

			
		}
		
		
		
	}

}
