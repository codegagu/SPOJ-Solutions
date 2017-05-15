

			
			import java.io.*;
			class Main
			{
				public static void main(String args[])
				throws IOException
				{
					//while(true){
					//long start=System.nanoTime();
					BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
					int n=Integer.parseInt(br.readLine());
					if(n==0)
						{System.out.println(0);System.exit(0);}
					String ans="";
					while(n!=0)
					{
						if(Math.abs(n)%2==1)//odd
						{
								n--;
								n=n/(-2);
								ans+="1";
						}
						else
						{
							n=n/(-2);
							ans+="0";
						}
					}
					
					System.out.println(new StringBuilder(ans).reverse().toString());//}
					//System.out.println((System.nanoTime()-start)/1000000000.0);
				}
			}