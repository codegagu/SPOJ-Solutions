

		import java.util.Arrays;
		import java.io.*;
		class Main
		{
			public static void main(String args[])
			throws IOException
			{
				BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
				PrintWriter pw=new PrintWriter(System.out);
				int t=Integer.parseInt(br.readLine());
				int yo=0;
				while(yo!=(2*t))
				{
					String m1[]=br.readLine().split(" ");
					String m2[]=br.readLine().split(" ");
					int mount1=Integer.parseInt(m1[0]);
					int mount2=Integer.parseInt(m2[0]);
					int mount1arr[]=new int[mount1];
					int mount2arr[]=new int[mount2];
					for(int i=1;i<mount1+1;i++)
						mount1arr[i-1]=Integer.parseInt(m1[i]);
					for(int i=1;i<mount2+1;i++)
						mount2arr[i-1]=Integer.parseInt(m2[i]);
					int min=1000000;
					for(int i=0;i<mount1;i++)
					{
						for(int j=0;j<mount2;j++)
						{
							if(Math.abs(mount1arr[i]-mount2arr[j])<min)
								min=Math.abs(mount1arr[i]-mount2arr[j]);
						}
					}
					pw.println(min);
					yo+=2;
				}
				pw.flush();
			}
		}