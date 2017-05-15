

		import java.io.*;
		import java.util.*;
		import java.math.*;
		class Main
		{
			public static void main(String args[])
			throws IOException
			{
				BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
				
				int sieve_max=100000;
				boolean isPrime[]=new boolean[sieve_max+1];
				Arrays.fill(isPrime, true);
				isPrime[0]=isPrime[1]=false;
				//pre-computing sieve
				for(int i=2;i*i<=sieve_max;i++)
				{
					if(isPrime[i])
					{
						for(int j=i;i*j<=sieve_max;j++)
							isPrime[i*j]=false;
					}
				}
				
				int t=Integer.parseInt(in.readLine());
				while(t-->0)
				{
					StringTokenizer st=new StringTokenizer(in.readLine()," ");
					int m=Integer.parseInt(st.nextToken());
					int n=Integer.parseInt(st.nextToken());
					
					if(n<=sieve_max)
					{
						for(int i=m;i<=n;i++)
						{
							if(isPrime[i])
							{
								out.append(String.valueOf(i));
								out.newLine();
							}
						}
						out.newLine();
					}
					else
					{
						//if n>somewhat Math.sqrt(10^9)
						//Re-run the sieve within the limits m to n
						int d=n-m;
						boolean [] check_prime=new boolean[d+1];
						Arrays.fill(check_prime, true);
						
						for(int i=2;i*i<=n;i++)
						{
							if(isPrime[i])
							{
								//We find the first smallest number lesser than m
								//that is divisible by our first prime number i.e 2
								int k=m/i;
								k=k*i;
								if(k<m)k+=i;
								if(k==i)k+=i;
								for(;k<=n;k+=i)
									check_prime[k-m]=false;
							}
						}
						for(int i=0;i<d;i++)
						{
							if(check_prime[i])
							{
								out.append(String.valueOf(m+i));
								out.newLine();
							}
						}
						out.newLine();
					}
				}
				out.flush();
			}
		}
