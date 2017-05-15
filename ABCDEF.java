
			import java.io.*;
			import java.util.*;
			class Main
			{
				public static void main(String args[])
				throws IOException
				{
					final BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
					final int n=Integer.parseInt(br.readLine().trim());
					final int arr[]=new int[n];
					for(int i=0;i<n;i++)
						arr[i]=Integer.parseInt(br.readLine().trim());
					final int n3=n*n*n;
					final int arr1[]=new int[n3];
					final int arr2[]=new int[n3];
					int count1=0;
					//Find the values of (a*b+c) for all possible sets (a,b,c) and store them in an array arr1
					for(int i=0;i<arr.length;i++)
					{
						for(int j=0;j<arr.length;j++)
						{
							for(int k=0;k<arr.length;k++)
							{
								int hold=(arr[i]*arr[j])+arr[k];
								arr1[count1++]=hold;
							}
						}
					}
					//Find the values of (d*(e+f)) for all possible sets (d,e,f) and store them in an array arr2
					int count2=0;
					for(int i=0;i<arr.length;i++)
					{
						if(arr[i]==0)
							continue;
						for(int j=0;j<arr.length;j++)
						{
							for(int k=0;k<arr.length;k++)
							{
								int hold=arr[i]*(arr[j]+arr[k]);
								arr2[count2++]=hold;
							}
						}
					}
					//bingo!
					
					Arrays.sort(arr1,0,count1);
					Arrays.sort(arr2,0,count2);
					int pos1=0,pos2=0;
					long sum=0;
					while(pos1<count1 && pos2<count2)
					{
						if(arr1[pos1]<arr2[pos2])
							++pos1;
						else if(arr1[pos1]>arr2[pos2])
							++pos2;
						else
						{
							int delta_arr1=1;
							while(delta_arr1+pos1<count1 && arr1[delta_arr1+pos1]==arr1[pos1])
								++delta_arr1;
							int delta_arr2=1;
							while(delta_arr2+pos2<count2 && arr2[delta_arr2+pos2]==arr2[pos2])
								++delta_arr2;
							
							sum+=delta_arr1*delta_arr2;
							pos1+=delta_arr1;
							pos2+=delta_arr2;
						}
					}
					System.out.println(sum);
				}
			}