



				import java.io.*;
				class Main
				{
					public static void main(String args[])
					throws IOException
					{
						BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
						PrintWriter pw=new PrintWriter(System.out);
						String temp="";
						while(!(temp=br.readLine()).equals("-1"))
						{
							long n=Long.parseLong(temp);
							n--;
							double hold=n/3.0;
							double ans=(Math.sqrt(1+4*hold)-1)/2.0;
							
							if(ans==(long)ans)
								pw.println("Y");
							else 
								pw.println("N");
							
						}
						pw.flush();
					}
				}