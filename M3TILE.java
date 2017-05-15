


		import java.io.*;
		import java.util.*;
		class M3TILE
		{
			public static void main(String args[])
			throws IOException
			{
				int f[]=new int[35];
				int g[]=new int[35];
				f[0]=1;f[1]=0;f[2]=3;
				g[0]=0;g[1]=1;
				//f(n) = f(n - 2) + 2g(n - 1),g(n) = f(n - 1) + g(n - 2)
				for(int i=2;i<35;i++)
				{
					f[i]=f[i-2]+2*g[i-1];
					g[i]=f[i-1]+g[i-2];
				}
				
				
				BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
				String str="";
				while(!(str=br.readLine()).equals("-1"))
				{
					int n=Integer.parseInt(str);
					System.out.println(f[n]);
				}
			}
		}