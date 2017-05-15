
		import java.util.*;
		import java.io.*;
		class Main
		{
			static int arr[];
			static int b_search[];
			static int n=0,c=0;
			
			public static void main(String args[])
			throws IOException
			{
				BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
				int t=Integer.parseInt(br.readLine());
				//long start=System.nanoTime();
				while(t--!=0)
				{
					String in[]=br.readLine().split(" ");
					n=Integer.parseInt(in[0]);
					c=Integer.parseInt(in[1]);
					arr=new int[n];
					for(int i=0;i<n;i++)
						arr[i]=Integer.parseInt(br.readLine());
					
					Arrays.sort(arr);
					
					
					int low=0,high=arr[n-1],mid=0;
					while(low<high)
					{
						mid=(low+high)/2;
						if(f(mid)==1)
							low=mid+1;						
						else if(f(mid)==0)
							high=mid;
					}
					
					System.out.println(low-1);
				}
				//System.out.println((System.nanoTime()-start)/1000000000.0);
			}
			
			static int f(int x)
			{
				int counter=1;
				int base=0;
				for(int pointer=1;pointer<n;pointer++)
				{
					
					int diff=arr[pointer]-arr[base];
					if(diff>=x)
					{
						counter++;
						if(counter==c)
							return 1;
						base=pointer;
					}
				}
				return 0;
			}
		}