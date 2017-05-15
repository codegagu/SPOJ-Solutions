
			

		import java.io.*;
		import java.util.*;
		class Main
		{
			public static void main(String args[])
			throws IOException
			{
				BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
				String t="";
				while(!(t=br.readLine()).equals("0"))
				{
					int n=Integer.parseInt(t);
					int arr[]=new int[n];
					for(int i=0;i<n;i++)
						arr[i]=Integer.parseInt(br.readLine());
					
					
					Arrays.sort(arr);
					
					int i;
					for(i=0;i<n-1;i++)
					{
						if(arr[i+1]-arr[i]>200)
							break;
					}
					//System.out.println("\n"+ (arr.length-1) +" hamba "+i+" "+(n-1));
					if(i<n-1 || (1422-arr[(arr.length-1)])*2 >200 )
						System.out.println("IMPOSSIBLE");
					else
						System.out.println("POSSIBLE");
				}
			}
			
				

		}		
