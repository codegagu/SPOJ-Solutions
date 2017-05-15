


			import java.math.BigInteger;
			import java.util.Scanner;
			import java.io.*;
			class Main
			{
				public static void main(String args[])
				{
					Scanner sc=new Scanner(System.in);
					PrintWriter pw=new PrintWriter(System.out);
					while(sc.hasNextBigInteger())
					{
						//BigInteger two = new BigInteger("2");
						BigInteger N=sc.nextBigInteger();
						if(N.equals(BigInteger.ONE))
							pw.println(1);
						else
							pw.println(N.multiply(BigInteger.valueOf(2)).subtract(BigInteger.valueOf(2)));
					}
					pw.flush();
				}
			}