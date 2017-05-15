


		import java.io.*;
		class Main
		{
			static int dp[][];
			public static void main(String args[])
			throws IOException
			{
				BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
				int t=Integer.parseInt(br.readLine().trim());
				while(t--!=0)
				{
					String in[]=br.readLine().trim().split(" ");
					int n=Integer.parseInt(in[0]);
					int k=Integer.parseInt(in[1]);
					dp=new int[n+1][k+1];
					for(int i=0;i<n+1;i++)
						for(int j=0;j<k+1;j++)
							dp[i][j]=-1;
					
					dp[0][0]=0;
					System.out.println(count(n,k));
					
					/*for(int i=0;i<n+1;i++)
					{
						for(int j=0;j<k+1;j++)
							System.out.print(dp[i][j]+"\t");
						System.out.println();
					}*/
					
				}
			}
			
			static int count(int n,int k)
			{
				if(n==0)//there are no permutations at all.
					return 0;
				if(k==0)// there is only one permutation ie in ascending order
					return 1;
				if(dp[n][k]!=-1)
					return dp[n][k];
				int sum=0;
				for(int i=0;i<n && k-i>=0;i++)
					sum+=count(n-1,k-i);
				return(dp[n][k]=sum);
			}
		}