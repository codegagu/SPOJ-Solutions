



			
				import java.io.*;
				class Main
				{
					
					static int mod=1000000007;
					
					public static void main(String args[])
					throws IOException
					{
						BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
						int t=Integer.parseInt(br.readLine());
						while(t--!=0)
						{
							String in[]=br.readLine().trim().split(" ");
							int n=Integer.parseInt(in[0]);
							int m=Integer.parseInt(in[1]);
							long ans=fibo(m+2)-fibo(n+1);
							if (ans < 0) ans += mod;
							System.out.println(ans);
							
						}
					}
					
					
					static long fibo(int n)
					{
						
						if(n==1 || n==2)
							return 1;
						long M[][]=new long[][] {{0, 1}, {1, 1}};
						long [][] ans_matrix=matrix_pow(M,n-1);
						return(ans_matrix[0][0]+ans_matrix[0][1])%mod;
						
					}
					
					
					static long[][] matrix_pow(long [][] M,int n)//A^n
					{
						long [][] res=new long[2][2];
						long [][] X =new long[2][2];
						if(n==1)
							return M;
						if(n%2==0)
						{
							X=matrix_pow(M,n/2);
							res=matrix_mult(X,X);
						}
						else
						{
							res=matrix_mult(M,matrix_pow(M,n-1));
						}
						
						
						return res;
					}
					
					static long[][] matrix_mult(long [][] A,long [][] B)
					{
						int N = A.length;
				        long [][] C = new long [N][N];
				        for (int i = 0; i < N; i++) 
				            for (int j = 0; j < N; j++) 
				                for (int k = 0; k < N; k++)
				                    C [i][k] = (C [i][k] + A [i][j] * B [j][k]) % mod;
				        return C;
					}
					
				}

