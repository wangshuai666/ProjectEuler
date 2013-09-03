package ProjectEuler;

import java.util.ArrayList;

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
		problems.problem7();
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
	
	private void problem3() {
		long startime = System.currentTimeMillis();
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
		System.out.println("used time: "+(System.currentTimeMillis()-startime)/1000+"s");
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
	
}
