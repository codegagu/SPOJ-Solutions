

		import java.io.*;
		import java.util.*;
		class Main
		{
			public static void main(String args[])
			throws IOException
			{
				int arr[]=new int[500001];
				arr[0]=0;
				boolean visited[]=new boolean[500000*7];
				Scanner sc=new Scanner(System.in);
				for(int i=1;i<=500000;i++)
				{
					if(arr[i-1]-i>0 && !visited[arr[i-1]-i])
					{
						arr[i]=arr[i-1]-i;
						visited[arr[i-1]-i]=true;
					}
					else
					{
						arr[i]=arr[i-1]+i;
						visited[arr[i-1]+i]=true;
					}
				}
				int n=0;
				while((n=sc.nextInt())!=-1)
				{
					System.out.println(arr[n]);
				}
				
			}
		}