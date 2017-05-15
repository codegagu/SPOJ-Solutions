


			import java.io.*;
			class Main
			{
				public static void main(String args[])
				throws IOException
				{
					BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
					PrintWriter pw=new PrintWriter(System.out);
					long n=Long.parseLong(br.readLine());
					if(n%10==0)
						pw.println(2);
					else
						pw.println(1+"\n"+(n%10));
							
					pw.flush();
				}
			}