
		
	
			import java.io.*;
			class Main
			{
				public static void main(String args[])
				throws IOException
				{
					BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
					String str="";
					while(!(str=br.readLine()).equals("0"))
					{
						double num=Double.parseDouble(str);
						num++;
						num=Math.log(num);
						int ans=(int)Math.ceil(num/Math.log(2));
						System.out.println(ans-1);
					}
				}
			}
