


		import java.io.*;
		class Main
		{
			public static void main(String args[])
			throws IOException
			{
				BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
				PrintWriter pw=new PrintWriter(System.out);
				String in=br.readLine();
				while(!in.equals("0.00"))
				{
					
					float c=Float.parseFloat(in);
					int counter=0,i=2;
					float sum=0;
					do{
						sum+=(float)(1/(float)i);
						counter++;
						i++;
					}while(sum<=c);
					
					pw.println(counter+" card(s)");
					in=br.readLine();
				}
				pw.flush();
			}
		}