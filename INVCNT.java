


			
				import java.io.*;
				class Main
				{
					static int max=200002;
					static int a[]=new int[max];
					static int L[]=new int[max/2+1];
					static int R[]=new int[max/2+1];
					static long total;
					
					
					public static void main(String args[])
					throws IOException
					{
						BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
						PrintWriter pw=new PrintWriter(System.out);
						int t=Integer.parseInt(br.readLine());
						while(t--!=0)
						{
							String blank=br.readLine();
							int n=Integer.parseInt(br.readLine());
							//System.out.println("n= "+n);
							total=0;
							for(int i=0;i<n;i++)
								a[i]=Integer.parseInt(br.readLine());
							
							
							merge_sort(0,n-1);
							pw.println(total);
						}
						pw.flush();
					}
					
					static void merge_sort(int l,int r)
					{
						if(l<r)
						{
							int mid = (l+r)/2;
							merge_sort(l,mid);
							merge_sort(mid+1,r);
							merge(l,mid,r);
						}
					}
					
					static void merge(int l,int mid,int r)
					{
						//System.out.println("l= "+l+" mid= "+mid+" r= "+r);
						int i,j,k,n1=mid-l+1,n2=r-mid;
						//System.out.println("n1 "+n1+" n2 "+n2+" mid "+mid);
						for(i=0;i<n1;i++)
							L[i]=a[l+i];
						for(j=0;j<n2;j++)
							R[j]=a[mid+1+j];
						for(k=l,i=j=0;k<=r;k++)
						{
							if(j>=n2 || (L[i]<=R[j] && i<n1))
								a[k]=L[i++];
							else
							{
								total+=n1-i;
								a[k]=R[j++];
							}
						}
					}
					
					
					
				}