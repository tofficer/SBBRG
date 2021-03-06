import java.util.*;

public class Test{
	public static void main(String[] args){
  	Scanner scnr = new Scanner(System.in);
	long a = -1;
	long b = -1;
	
	System.out.println(“Enter two different whole positive numbers separated by a space”);
  	String line = scnr.nextLine();
  	String[] parts = line.split(“\\s+”);
   	if (parts.length != 2) System.exit(0);
  
  	try{
  		a = Long.parseLong(parts[0]);
		b = Long.parseLong(parts[1]);
	} catch(NumberFormatException e){
		System.exit(0);	
	}

	scnr.close();
	
	Set<Long> primes = primes(a, b);
	Set<Long> fibonaccis = fibonaccis(a, b);
	Set<Long> commonSet = commonSet(primes, fibonaccis);
	
  	System.out.println(primes);
		System.out.println(fibonaccis);
	  	System.out.println(commonSet);
  	}

  	public static Set<Long> primes(long a, long b){
		Set<Long> res = new HashSet<Long>();
	  	boolean[] notPrime = new boolean[b+1];
	  	for (long i = 2; i <= b; i++){
			if (notPrime[i]) continue;
		  	if (i >= a) res.add(i);
		  	long k = i+i;
		  	while (k <= b){
				notPrime[k] = true;
			  	k += i;
		  	}
	  	}
	  	return res;
  	}

  	public static Set<Long> fibonaccis(long a, long b){
	  	Set<Long> res = new HashSet<Long>();
  		for (long i = a; i <= b; i++){
			if (isPerfectSquare((long) 5(i*i) + 4)) || isPerfectSquare((long) 5(i*i) - 4)){
			 	res.add(i);
			}
		}
	  	return res;
  	}

  	public static boolean isPerfectSquare(long n){
	 	long sqrt = (long) Math.sqrt(n); //remove decimals
	  	if (sqrt*sqrt == n) return true;
	  	return false;
  	}

  	public static Set<Long> commonSet(Set<Long> a, Set<Long> b){
		Set<Long> commonSet = new HashSet<Long>(a);
	  	commonSet.retainAll(b);
	  	return commonSet;
  	}
}
	
