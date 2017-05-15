
	

	
		import java.io.*;
		import java.util.*;
		class Main
		{
			public static void main(String args[])
			throws IOException
			{
				BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
				int t=Integer.parseInt(br.readLine());
				while(t--!=0)
				{
					int a=Integer.parseInt(br.readLine());
					int b=Integer.parseInt(br.readLine());
					int c=Integer.parseInt(br.readLine());
					int signal=Math.min (calculate(a,b,c),calculate(b,a,c));
					System.out.println(signal);
					
					
				}
			}
			
			static int calculate(int a,int b,int c)
			{
				if(c>a && c>b)
					return -1;
				else if(a==c || b==c)
					return 1;
				else if(c% gcd(a,b) !=0)//eliminating the impossible
					return -1;
				else
				{
					int vessel_a=0,vessel_b=0,count=0;
					while(true)
					{
						//System.out.println(vessel_a+" "+vessel_b);
						if(vessel_a==c || vessel_b==c)
							return count;
						if(vessel_b==0)
						{
							vessel_b=b;
							count++;
							continue;
						}
						if(vessel_a==a)
						{
							vessel_a=0;
							count++;
							continue;	
						}
						if(vessel_b!=0) 
						{
							int temp=vessel_a;//extra=a-vessel_a . b thke minus korbo extra ta
							vessel_a=Math.min(vessel_a+vessel_b, a);
							vessel_b=Math.max(vessel_b+temp-a, 0);
							count++;
						}
						
					}
				}
			}
			
			static int gcd(int a,int b)
			{
				if(b==0)
					return a;
				else
					return gcd(b,a%b);
			}
		}
