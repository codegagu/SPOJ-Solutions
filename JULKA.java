


			import java.util.Scanner;
			import java.io.*;
			import java.math.BigInteger;
			class Main
			{
				public static void main(String args[])
				throws IOException
				{
					//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
					Scanner in = new Scanner(System.in);
					PrintWriter pw=new PrintWriter(System.out);
					int t=10;
					BigInteger total,more,sub,natalia,klaudia;
					while(t--!=0)
					{
						total=in.nextBigInteger();
						more=in.nextBigInteger();
						sub=total.subtract(more);
						natalia=sub.divide(BigInteger.valueOf(2));
						klaudia=natalia.add(more);
						
						pw.println(klaudia+"\n"+natalia);
					}
					pw.flush();
				}
			}