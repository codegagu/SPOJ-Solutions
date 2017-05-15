


			import java.io.*;
			class Main
			{
				public static void main(String args[])
				throws IOException
				{
					BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
					PrintWriter pw=new PrintWriter(System.out);
					int t=Integer.parseInt(br.readLine());
					while(t--!=0)
					{
						String str[]=br.readLine().split(" ");
						int n=Integer.parseInt(str[1]);
						if(n==0)
							pw.println("Airborne wins.");
						else
							pw.println("Pagfloyd wins.");
					}
					pw.flush();
				}
			}