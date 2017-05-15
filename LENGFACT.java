


			import java.io.*;
			class Main
			{
				public static void main(String args[])
				throws IOException
				{
					BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
					int t=Integer.parseInt(br.readLine());
					while(t--!=0)
					{
						long n=Long.parseLong(br.readLine());
						if(n==0 || n==1) {System.out.println(1);continue;}
						double pi=3.1415926535897932384626433832795;
						double e=2.7182818284590452353602874713527;
						long ans=(long)Math.floor(( (Math.log(2*pi*n)/2.00+n*(Math.log(n)-1) )/Math.log(10.0) )+1);
						System.out.println(ans);
						//
						
					}
				}
			}
			