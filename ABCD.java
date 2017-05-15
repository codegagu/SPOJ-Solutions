

		
		import java.io.*;
		class Main
		{
			public static void main(String args[])
			throws IOException
			{
				BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
				PrintWriter pw=new PrintWriter(System.out);
				int n=Integer.parseInt(br.readLine());
				char arr[][]=new char [2][2*n];
				char duo1[];
				String str=br.readLine();
				while(str.length()==0)
				    str=br.readLine();
				arr[0]=str.toCharArray();
				char colours[]={'A','B','C','D'};
				if(str.length()==2)
				{
					duo1=str.toCharArray();
				}
				else
				{
					duo1=str.substring(0,2).toCharArray();
				}
				int pos=0;
				for(int i=0;i<4;i++)
				{
					int check=0;
					for(int j=0;j<2;j++)
					{
						if(colours[i]==duo1[j])
							check=1;
					}
					if(check==0)
					{
						arr[1][pos]=colours[i];
						pos++;
					}
				}
				
				for(int k=2;k<2*n;k+=2)
				{	
					int yo=0;
					duo1[0]=arr[0][k];
					duo1[1]=arr[0][k+1];
					
					
					for(int i=0;i<4;i++)
					{
						int check=0;
						for(int j=0;j<2;j++)
						{
							if(colours[i]==duo1[j])
								check=1;
						}
						if(check==0)
						{
							if(arr[1][k-1]!=colours[i] && yo==0)
							{
								arr[1][k]=colours[i];
								yo=1;
							}
							else if(arr[1][k-1]==colours[i] || arr[1][k]=='\0')
							{
								if(arr[1][k+1]=='\0')
								arr[1][k+1]=colours[i];
								
								else if(arr[1][k]=='\0' && arr[1][k+1]!='\0')
									arr[1][k]=colours[i];
							}
							else
								arr[1][k+1]=colours[i];
						}
					}
				}
				
					for(int i=0;i<arr[1].length;i++)
						pw.print(arr[1][i]);
					pw.flush();
			}
		}