

	

			import java.io.*;
			class Main
			{
				public static void main(String args[])
				throws IOException
				{
					BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
					PrintWriter pw=new PrintWriter(System.out);
					String str=br.readLine();
					while(!str.equals("0"))
					{
						int n=Integer.parseInt(str);
						int ans=(n*(n+1)*((2*n)+1))/6;
						pw.println(ans);
						str=br.readLine();
					}
					pw.flush();
				}
			}