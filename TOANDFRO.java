



			import java.io.*;
			class Main
			{
				public static void main(String args[])
				throws IOException
				{
					BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
					PrintWriter pw=new PrintWriter(System.out);
					String s=br.readLine();
					while(!s.equals("0"))
					{
						int rows;
						int c=Integer.parseInt(s);
						String str=br.readLine();
						int len=str.length();
						if(len%c==0)
							rows=len/c;
						else
							rows=(len/c)+1;
						char arr[][]=new char[rows][c];
						int low_lim=0,up_lim=0;
						for(int i=0;i<rows;i++)
						{
							up_lim+=c;
							String yo=str.substring(low_lim,up_lim);
							if(i%2==0)
								arr[i]=yo.toCharArray();
							else
								arr[i]=(new StringBuffer(yo).reverse().toString()).toCharArray();
							
							low_lim+=c;
						}
						String ans="";
						for(int j=0;j<c;j++)
						{
							for(int i=0;i<rows;i++)
								ans=ans+arr[i][j];
						}
						pw.println(ans);
						s=br.readLine();
					}
					pw.flush();
				}
			}