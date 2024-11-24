// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    //Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(-3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
   		System.out.println(sqrt(1));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int plus = x1;
		if (x2 < 0) {
			return minus(x1, abs(x2));
		}
		for (int i = 0; i < x2; i++) {
			plus++;
		}
		return plus;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int minus = x1;
		if (x2 < 0) {
			return plus(x1, abs(x2));
		}
		for (int i = 0; i < x2; i++) {
			minus--;
		}
		return minus;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int times = 0;
		for (int i = 0; i < abs(x2); i++) {
			if (x2 < 0) times = minus(times, x1);
			else times = plus(times, x1);
		}
		return times;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int pow = 1;
		for (int i = 0; i < n; i++) {
			pow = times(pow, x);
		}
		return pow;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int times = abs(x2);
		int div = 0;
		while (abs(x1) >= times) {
			times = plus(times, abs(x2));
			if ((x1 < 0 && x2 >= 0) || (x1 >= 0 && x2 < 0)) div--;
			else div++;
		}
		return div;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int div = div(x1,x2);
		div = times(div, x2);
		int mod = x1 - div;
		
		return mod;
	}	

	//Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		if (x == 0 || x == 1) {
			return x;
		}
		double epsilon = 0.01;
		double g = x / 2;
		while (abs((int) (g * g - x)) > epsilon) {
			g = g - (g * g - x) / (2 * g);
		}
		return ((int) g);
	}
	
	public static int abs(int x) {
		if (x < 0) {
            int negX = 0;
            while (x != 0) {
                negX++;
                x++;    
            }
            return negX;
        }
        return x;
	}	
}