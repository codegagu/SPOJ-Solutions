



			import java.io.*;
			import java.util.*;
			class Main
			{
				public static void main(String args[])
				throws IOException
				{
					BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
					int t=Integer.parseInt(br.readLine());
			        StringBuilder out = new StringBuilder("");

					while(t--!=0)
					{
						int n=Integer.parseInt(br.readLine().trim());
						String arr[]=new String[n];
						for(int i=0;i<n;i++)
							arr[i]=br.readLine().trim();
						boolean check=true;
						Arrays.sort(arr);
						for(int i=0;i<n-1 && check;i++)
							if(arr[i+1].length()>=arr[i].length() && arr[i+1].substring(0, arr[i].length()).equals(arr[i]))
								check=false;
						
						if (check)
			                out.append("YES\n");
			            else
			                out.append("NO\n");						
					}
					System.out.print(out);
				}
				
				
				
				
			}
			