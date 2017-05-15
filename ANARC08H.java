



			import java.io.*;
			import java.util.*;
			class Main
			{
				public static void main(String args[])
				throws IOException
				{
					BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
					String str="";
					while(!(str=br.readLine()).equals("0 0"))
					{
						String s=str;
						String in[]=s.split(" ");
						int n=Integer.parseInt(in[0]);
						int k=Integer.parseInt(in[1]);
						int dp[]=new int[n+1];
						dp[1]=1;
						for(int i=2;i<=n;i++)
							dp[i]=(dp[i-1]+ k-1)%i +1;
							
						System.out.println(s+" "+dp[n]);
					}
					
				}
				
				/*static int josephus(int n,int k)
				{
					if(n==1)
						return 1;
					else
						return (( josephus(n-1,k)+k-1 )%n+1);
				}*/
			}