


			import java.math.*;
			import java.io.*;
			class Main
			{
				public static void main(String args[])
				throws IOException
				{
					BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
					int t=Integer.parseInt(br.readLine().trim());
					while(t--!=0)
					{
						String str=br.readLine();
						while(str.length()==0)
							str=br.readLine();
						
						long n=Long.parseLong(str);
						long three=3;
						long two=2;
						BigInteger bi=BigInteger.ONE;
						BigInteger one=BigInteger.ONE;
						BigInteger thre= BigInteger.valueOf(three);
						BigInteger to= BigInteger.valueOf(two);
						BigInteger N=BigInteger.valueOf(n);
						
						bi=bi.multiply(N);
						
						bi=bi.multiply(thre);//3n
						
						bi=bi.add(one);//3n+1
						
					
						bi=bi.multiply(N);//n(3n+1)
						
						bi=bi.divide(to);
						
						//System.out.println(bi);
						long modval=1000007;
						BigInteger modvalue=BigInteger.valueOf(modval);
						BigInteger ans=bi.mod(modvalue);
						System.out.println(ans);
						
					}
				}
			}