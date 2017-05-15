



			import java.io.*;
			class Main
			{
				public static void main(String args[])
				throws IOException
				{
					BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
					PrintWriter pw=new PrintWriter(System.out);
					int t=Integer.parseInt(br.readLine());
					while(t!=0)
					{
						String in[]=br.readLine().split(" ");
						String a=(in[0]);
						String b=(in[1]);
						pw.println(reverse(a,b));
						t--;
					}
					pw.flush();
				}
				
				
				public static String reverse(String s1,String s2)
				{
					s1=new StringBuffer(s1).reverse().toString();
					s2=new StringBuffer(s2).reverse().toString();
					int yo=0;
					while(s1.charAt(yo)=='0')
						s1=s1.substring(yo+1);
					while(s2.charAt(yo)=='0')
						s2=s2.substring(yo+1);
					int ans=Integer.parseInt(s1)+Integer.parseInt(s2);
					String fans=Integer.toString(ans);
					fans=new StringBuffer(fans).reverse().toString();
					while(fans.charAt(yo)=='0')
						fans=fans.substring(yo+1);
						
					return fans;
					
				}
			}