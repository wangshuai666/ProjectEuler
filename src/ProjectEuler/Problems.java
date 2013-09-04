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
//		problems.problem4();
//		problems.problem5();
//		problems.problem6();
//		problems.problem7();
//		problems.problem9();
//		problems.problem10();
		problems.fib();
//		System.out.println("fib_recur="+problems.fib_recur(1, 1));
//		problems.problem14();
//		problems.problem37();
		problems.newProblem37();
//		problems.getPrimeList(20000000);
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
	private boolean isPrime(long n, ArrayList<Long> primelist) { 
		if(n<=1) return false;
		long sqrt_n = (long) Math.sqrt(n);
		for(long prime:primelist){ 
			if(prime<=sqrt_n&&n%prime==0){ 
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
		while(front<100000000000000000L){
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
		int max_number = 1;//start number
		int max_chain = 1;//chain length
		for(int ixnumber=1;ixnumber<1000000;ixnumber++){
			int chainnum = getChainNum(ixnumber);
			if(chainnum>max_chain){
				max_number = ixnumber;
				max_chain = chainnum;
			}
		}
		System.out.println("demand number is "
					+max_number+"max chain length "+max_chain);
	}
	private int getChainNum(long ixnumber){
		int chainnum = 1;
		while(ixnumber>1){
			if(ixnumber%2==0)	ixnumber /= 2;//even
			else	ixnumber = ixnumber*3 + 1;//odd
			++chainnum;
		}
		return chainnum;
	}
	
	public void problem37(){
		ArrayList<Long> primelist = new ArrayList<Long>();
		ArrayList<Long> truncprimelist = new ArrayList<Long>();
		primelist.add((long) 2);
		int truncix = 0;
		for(long prime=3;truncix<=11;prime+=2){
			if(isPrime(prime, primelist)){
				if(isTruncPrime(prime,primelist)){
					System.out.println("p"+prime+" ix"+truncix);
					truncprimelist.add(prime);
					++truncix;
				}
				primelist.add(prime);
			}
		}
		long sum = 0;
		for(Long lrprime:truncprimelist){
			sum += lrprime;
		}
		System.out.println("sum of lrprimes is "+sum);
	}
	private boolean isTruncPrime(long prime,ArrayList<Long> primelist){
		if(prime<23) return false;
		final long primeLong = prime;
		long rsPrime = primeLong;
		for(int i=Long.toString(primeLong).length()-1;i>0;i--){
			long lsPrime = primeLong%(long)Math.pow(10, i);
			rsPrime /= 10;
			if(!primelist.contains(lsPrime)||!primelist.contains(rsPrime))
				return false;
		}
		return true;
	}
	
	/**
	 * 筛法求n以下(不包括n)的素数个数
	 * @param n
	 * @return byte[] primecontainer
	 */
	public byte[] getPrimeContainer(int n){//n为指定的自然数最大值，不包括n
		byte[] container = new byte[n];
		int count = 0;int sqrt_n = (int) Math.sqrt(n);
		container[0]=1;container[1]=1;
		for(int i=2;i<container.length;i++){
			if(0==container[i]){//0表示素数,每个素数做一次筛选
				++count;//计算素数个数
				if(i>sqrt_n) continue;//i大于sqrt时，不再筛选
				execSieve(i, container);
			}
		}
//		System.out.println("count="+count);
		return container;
	}
	private void execSieve(int num,byte[] container){
		int len = container.length;
		for(int ix=2;num*ix<len&&ix<len;ix++){
			container[num*ix] = 1;//非素数设为1
		}
	}
	
	public void newProblem37(){
		long startime = System.currentTimeMillis();
		int n = 2000000;int trunCount = 0;long sum = 0;
		while(trunCount<11){
			byte[] primecontainer = getPrimeContainer(n);
			trunCount = 0;
			for(int i=2;i<primecontainer.length;i++){
				if(0==primecontainer[i]){
					if(isTruncPrime(i, primecontainer)){
						++trunCount;
						sum += i;
						System.out.println("t"+trunCount+" "+i);
					}
				}
			}
			n = n*n;
		}
		System.out.println("sum of lrprimes is "+sum);
		System.out.println("time "+(System.currentTimeMillis()-startime));
	}
	private boolean isTruncPrime(int prime, byte[] primecontainer){
		if(prime<23) return false;
		final int primeLong = prime;
		int rsPrime = primeLong;
		for(int i=Long.toString(primeLong).length()-1;i>0;i--){
			int lsPrime = primeLong%(int)Math.pow(10, i);
			rsPrime /= 10;
			if(primecontainer[lsPrime]!=0||primecontainer[rsPrime]!=0)
				return false;
		}
		return true;
	}
	
}
