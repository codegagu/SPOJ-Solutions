


			import java.io.*;
			class Main
			{
				public static void main(String args[])
				throws IOException
				{
					BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
					PrintWriter pw=new PrintWriter(System.out);
					String temp=br.readLine();
					while(!temp.equals("0"))
					{
						int n=Integer.parseInt(temp);
						int arr2[]=new int[n];
						String arr1[]=br.readLine().split(" ");//assuming this to be the inverse matrix
						for(int i=0;i<n;i++)
						{
							arr2[Integer.parseInt(arr1[i])-1]=i+1;//creating what the main matrix should be like
						}
						//comparing
						int yo=0;
						for(int i=0;i<n;i++){
							if(Integer.parseInt(arr1[i])!=arr2[i])
							{
								yo=1;
								break;
							}
						}
						if(yo==1)//not ambiguous
							pw.println("not ambiguous");
						else
							pw.println("ambiguous");
						
						temp=br.readLine();
					}
					pw.flush();
				}
			
			}