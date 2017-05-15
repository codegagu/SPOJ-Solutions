

		

		import java.io.*;
		import java.util.*;
		class Main
		{
			static int prime_array[];
			static BitSet bites=new BitSet();
			public static void create(int yo)
			{
				yo++;
				bites.set(0,yo,true);
				bites.clear(0);
				bites.clear(1);
				for(int m=2;m*m<=yo;m++)
				{
					if(bites.get(m))
					{
						for(int n=m;m*n<=yo;n++)
							bites.clear(m*n);
					}
				}
				//System.out.println("hamba "+bites.cardinality());
				prime_array=new int[78498];
				int index=0;
				for(int i=0;i<1000000;i++)
					if(bites.get(i)){//System.out.println(i);
						prime_array[index++]=i;}
				
				
			}
			
			public static void main(String args[])
			throws IOException
			{
				create(1000000);
				BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
				int t=Integer.parseInt(br.readLine());
				while(t--!=0)
				{
					long n=Long.parseLong(br.readLine());
					int check=0;
					for(int i=0;i<prime_array.length;i++)
					{
						if(prime_array[i]*prime_array[i]>n)break;
						int exp=0;
						while(n%prime_array[i]==0)
						{
							n=n/prime_array[i];
							exp++;
						}
						if(prime_array[i]%4==3 && exp%2==1)
							{System.out.println("No");check=1;break;}
						
					}
					if(check==0){
					if(n%4==3)
						System.out.println("No");
					else
						System.out.println("Yes");
					}
					
				}
			}
			
		}