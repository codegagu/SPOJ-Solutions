		
		
		
				
		import java.io.*;
		import java.util.*;
		import java.math.*;
                class Main
		{
			
			public static void main(String args[])
			throws IOException
			{
				BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
				int n=Integer.parseInt(br.readLine());
				
				
				for(int i=0;i<n;i++)
				{
					int num=Integer.parseInt(br.readLine());
					if(num%2==1)
						System.out.println(num);
					else
					{
						String str=Integer.toBinaryString(num);
						str=new StringBuilder(str).reverse().toString();
						System.out.println(Integer.parseInt(str,2));
					}
				}
				
			
			}
		}