

			import java.util.*;
			import java.math.*;
			class Main
			{
				public static void main(String args[])
				{
					Scanner sc=new Scanner(System.in);
					int t=sc.nextInt();
					while(t--!=0)
					{
						BigInteger b=sc.nextBigInteger();
						BigInteger c=sc.nextBigInteger();
						BigInteger d=sc.nextBigInteger();
						
						long minus_one=-1,two=2;
						BigInteger sum_of_roots=b.multiply(BigInteger.valueOf(minus_one));//a=1 here. -b/a
						BigInteger sum_of_prod=c;// a=1 here. c/a
						BigInteger ans=sum_of_roots.pow(2);
						ans=ans.subtract(sum_of_prod.multiply(BigInteger.valueOf(two)));
						System.out.println(ans);
					}
				}
			}
			