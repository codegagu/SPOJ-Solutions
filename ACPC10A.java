


		import java.io.*;
		class Main
		{
			public static void main(String args[])
			throws IOException
			{
				BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
				PrintWriter pw=new PrintWriter(System.out);
				String input=br.readLine();
				while(!input.equals("0 0 0"))
				{
					String arr[]=input.split(" ");
					int a=Integer.parseInt(arr[0]);
					int b=Integer.parseInt(arr[1]);
					int c=Integer.parseInt(arr[2]);
					
					if((2*b)==(a+c))
					{
						pw.println("AP "+(c+(b-a)));
					}
					else
					{
						pw.println("GP "+(c*(b/a)));
					}
					input=br.readLine();
				}
				pw.flush();
			}
		}