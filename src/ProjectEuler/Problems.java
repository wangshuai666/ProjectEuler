package ProjectEuler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Project Euler Problems
 * @author wangshuai
 * @since 2013-09-02
 */
public class Problems {
	public static void main(String[] args){
		Problems problems = new Problems(); 
//		problems.problem1();
//		problems.problem2();
//		problems.problem3();
//		problems.newProblem3();
//		problems.problem4();
//		problems.problem5();
//		problems.problem6();
//		problems.problem7();
//		problems.problem9();
//		problems.problem10();
//		problems.fib();
//		System.out.println("fib_recur="+problems.fib_recur(1, 1));
		problems.problem14();
	}
	
	public void problem1(){
		int sum = 0;
		for(int i=3;i<1000;i++){
			if(i%3==0||i%5==0){
				sum += i;
			}
		}
		System.out.println("sum="+sum);
	}
	
	public void problem2(){
		int sum = 0;
		int front = 1;
		int back = 1;
		while(front<4000000){
			int tmp = back;
			back = front;
			front = front + tmp;
			System.out.println("front: "+front);
			if(front%2==0){
				sum += front;
			}
		}
		System.out.println("sum="+sum);
	}
	
	public void problem3(){
		long goalnum = 600851475143L; 
		long sqrt_goalnum = (long) Math.sqrt(goalnum); 
		long maxprime = 0; 
		ArrayList<Long> primelist = getPrimeList(sqrt_goalnum); 
		for(long prime:primelist){ 
			if(goalnum%prime==0){ 
				maxprime = prime; 
				} 
			} 
		System.out.println("maxprime="+maxprime); 
		}
	private ArrayList<Long> getPrimeList(long sqrt_goalnum) { 
		ArrayList<Long> primelist = new ArrayList<Long>(); 
		primelist.add((long) 2); 
		for(long i=3;i<sqrt_goalnum;i+=2){ 
			if(isPrime(i,primelist)){ 
				primelist.add(i); 
			} 
		} 
		return primelist;
	}
	private boolean isPrime(long i, ArrayList<Long> primelist) { 
		for(long prime:primelist){ 
			if(i%prime==0){ 
				return false; 
			} 
		} 
		return true; 
	}
	
	public void newProblem3(){
		long goalnum = 600851475143L;
		long maxfactor = 3;
		long factor = 3;
		while(goalnum>1){
			if(goalnum%factor==0){
				goalnum /= factor;
			}else{
				factor += 2;
				maxfactor = factor;
			}
		}
		System.out.println("maxfactor="+maxfactor);
	}
	
	public void problem4(){
		int goalnum = 999*999;
		for(;goalnum>10000;goalnum--){
			if(isPalind(goalnum)){
				if(isDivBy3Digit(goalnum)){
					break;
				}
			}
		}
		System.out.println("largest palindrome is "+goalnum);
	}
	private boolean isPalind(int goalnum){
		String goalnString = Integer.toString(goalnum);
		int length = goalnString.length();
		for(int i=0,j=length-1;i<=j;i++,j--){
			if(goalnString.charAt(i)!=goalnString.charAt(j)){
				return false;
			}
		}
		return true;
	}
	private boolean isDivBy3Digit(int goalnum){
		for(int i=999;i>0;i--){
			if(goalnum%i==0){
				int num = goalnum/i;
				if(num>=100&&num<=999){
					return true;
				}
			}
		}
		return false;
	}

	public void problem5(){
		int goalnum = 20;
		while(true){
			if(isDivided(goalnum)) break;
			else goalnum += 2;
		}
		System.out.println("smallest positive number is "+goalnum);
	}
	private boolean isDivided(int goalnum){
		for(int i=2;i<=20;i++){
			if(goalnum%i!=0){
				goalnum += 2;
				return false;
			}
		}
		return true;
	}
	
	public void problem6(){
		int sumofsquare = 0;//The sum of the squares 
		int squareofsum = 0;//The square of the sum
		for(int i=1;i<=100;i++){
			sumofsquare += i*i;
		}
		int sum = 0;
		for(int j=1;j<=100;j++){
			sum += j;
		}
		squareofsum = sum*sum;
		System.out.println("the difference is "+(squareofsum-sumofsquare));
	}
	
	public void problem7(){
		ArrayList<Long> primelist = new ArrayList<Long>();
		primelist.add((long) 2);
		for(long prime=3,i=1;i<10001;prime+=2){
			if(isPrime(prime, primelist)){
				primelist.add(prime);
				++i;
			}
		}
		System.out.println("10001st prime number is "+primelist.get(primelist.size()-1));
	}
	
	public void problem9(){
		for(int a=1;a<999;a++){
			for(int b=999;b>0;b--){
				for(int c=a+b;c>0;c--){
					if((a+b+c)!=1000) continue;
					if(a*a+b*b==c*c){
						System.out.println("a="+a+" b="+b+" c="+c+", a*b*c="+a*b*c);
						return;
					}
				}
			}
		}
	}
	
	public void problem10(){
		ArrayList<Long> primelist = new ArrayList<Long>();
		primelist.add((long) 2);
		long primesum = 2;
		for(long prime=3;prime<2000000;prime+=2){
			if(isPrime(prime, primelist)){
				primesum += prime;
				primelist.add(prime);
			}
		}
		System.out.println("sum of primes below 2 million is "+primesum);
	}
	
	public void fib(){
		long front=1,back=1;
		while(front<1000000000){
			long tmp = back;
			back = front;
			front += tmp;
		}
		System.out.println("fib="+front);
	}
	
	public long fib_recur(long back,long front){
		if(front>1000000000) return front;
		return fib_recur(front, back+front);
	}
	
	public void problem14(){
		ArrayList<Integer> chainlist = new ArrayList<Integer>();
		chainlist.add(0);//占位
		for(int ixnumber=1;ixnumber<1000000;ixnumber++){
			int chainnum = getChainNum(ixnumber);
			chainlist.add(chainnum);
		}
		int maxindex = getMaxIndex(chainlist);
		System.out.println("demand number is "+maxindex);
		System.out.println("max chain length "+chainlist.get(maxindex));
	}
	private int getChainNum(int ixnumber){
		int chainnum = 1;
		while(ixnumber>1){
			if(ixnumber%2==0)	ixnumber /= 2;//even
			else	ixnumber = ixnumber*3 + 1;//odd
			++chainnum;
		}
		return chainnum;
	}
	private int getMaxIndex(ArrayList<Integer> chainlist){
		int maxnum = chainlist.get(0);
		int maxindex = 0;
		for(int i=1;i<chainlist.size();i++){
			int item = chainlist.get(i);
			if(item>maxnum){
				maxindex = i;
				maxnum = item;
			}
		}
		return maxindex;
	}
/*	private int getChainNum(int ixnumber,int chainnum) {//recurr
		if(ixnumber==1) return chainnum;
		if(ixnumber%2==0) ixnumber /= 2;
		else ixnumber = 3*ixnumber + 1;
		++chainnum;
		return getChainNum(ixnumber, chainnum);
	}*/
	
}
