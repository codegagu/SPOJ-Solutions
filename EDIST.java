

	
			import java.io.*;
			class Main
			{
				public static void main(String args[])
				throws IOException
				{
					BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
					int t=Integer.parseInt(br.readLine().trim());
					int arr[][]=new int[2002][2002];
					while(t--!=0)
					{
						String A=br.readLine().trim();
						String B=br.readLine().trim();
						//base cases
						for(int i=0;i<=A.length();i++)
							arr[0][i]=i;// distance of prefixes of first string to empty string is equal to the length of the prefix
						for(int i=0;i<B.length();i++)
							arr[i][0]=i;// distance of prefixes of second string to empty string is equal to the length of the prefix
						
						
						for(int j=1;j<=A.length();j++)
						{
							for(int i=1;i<=B.length();i++)
							{
								if(A.charAt(j-1)==B.charAt(i-1))
								{
									arr[i][j]=arr[i-1][j-1];
								}
								else
								{
									int min=Math.min(arr[i-1][j]+1,arr[i][j-1]+1);
									arr[i][j]=Math.min(min, arr[i-1][j-1]+1);
								}
								
								
							}
						}
						
						System.out.println(arr[B.length()][A.length()]);
						
						/*for(int i=0;i<=B.length();i++)
						{
							for(int j=0;j<=A.length();j++)
								System.out.print(arr[i][j]);
							System.out.println();
						}*/
					
					}
				}
			}