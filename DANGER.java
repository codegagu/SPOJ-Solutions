


			import java.io.*;
			class Main
			{
				public static void main(String args[])
				throws IOException
				{
					BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
					String str="";
					while(!(str=br.readLine()).equals("00e0"))
					{
						String str_n=str.substring(0,2);
						int z=Integer.parseInt(Character.toString(str.charAt(str.length()-1)));
						for(int i=0;i<z;i++)
							str_n+="0";
						int n=Integer.parseInt(str_n);//n ready
						int m=(int)Math.floor(Math.log(n)/Math.log(2));
						int two_pow_m=(int)Math.pow(2, m);
						int l=n-two_pow_m;
						System.out.println(2*l+1);
					}
				}
			}