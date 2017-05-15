 
 import java.math.BigInteger;
 import java.io.*;
 class Main
 {
	public static void main(String args[])
	throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		
		for(int i=0;i<t;i++)
		{
			int num=Integer.parseInt(br.readLine());
			BigInteger fact=new BigInteger("1");
			for(int k=1;k<=num;k++)
				fact=fact.multiply(new BigInteger(k+""));
			System.out.println(fact);
		}
		
	}
 } 