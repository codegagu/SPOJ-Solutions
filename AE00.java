



			import java.io.*;
			class Main
			{
				public static void main(String args[])
				throws IOException
				{
					BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
					PrintWriter pw=new PrintWriter(System.out);
					int num=Integer.parseInt(br.readLine());
					int count=0;
					for(int i=1;i<=num;i++)
					{
						for(int j=i;j<=num;j++)
						{
							if(i*j<=num)
								count++;
							else
								break;
						}
					}
					pw.println(count);
					pw.flush();
				}
			}