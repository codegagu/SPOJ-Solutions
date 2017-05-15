


				import java.util.*;
				import java.io.*;
				class Main
				{
					static int ans_arr[][];
					static Queue<Integer> xc = new LinkedList<Integer>();
					static Queue<Integer> yc = new LinkedList<Integer>();
					
					public static void main(String args[])
					throws IOException
					{
						BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
						PrintWriter pw=new PrintWriter(System.out);
						int t=Integer.parseInt(br.readLine());
						while(t--!=0)
						{
							String temp=br.readLine();
							while(temp.length()==0)
								temp=br.readLine();
							String in[]=temp.split(" ");
							int n=Integer.parseInt(in[0]);
							int m=Integer.parseInt(in[1]);
							char arr[][]=new char[n][];
							for(int i=0;i<n;i++)
								arr[i]=br.readLine().trim().toCharArray();
							
							ans_arr=new int[n][m];
							for (int[] row: ans_arr)
							    Arrays.fill(row, -1);
							
							
							for(int i=0;i<n;i++)
							{
								for(int j=0;j<m;j++)
								{
									if(arr[i][j]=='1'){
										ans_arr[i][j]=0;
										xc.add(i);
										yc.add(j);
									}
								}
							}
							arrange(n,m);
							
							for(int i=0;i<n;i++)
                            {
                                    for(int j=0;j<m;j++)
                                    {
                                    	if(j==(m-1))
                                    		pw.print(ans_arr[i][j]);
                                    	else
                                            pw.print(ans_arr[i][j]+" ");
                                    }
                                    pw.println();
                            }
								
							
						}
						pw.flush();
					}
					
					
					static void arrange(int n,int m)
					{
						int dx[]={-1,0,1,0};
						int dy[]={0,1,0,-1};
						while(!xc.isEmpty() && !yc.isEmpty())
						{
							int i=xc.peek();
							int j=yc.peek();
							
							xc.remove();
							yc.remove();
							//
							for(int k=0;k<4;k++)
							{
								int x=i+dx[k];
								int y=j+dy[k];
								if(x >= 0 && x < n && y >= 0 && y < m)
								{
									if(ans_arr[x][y]==-1){
									ans_arr[x][y]=ans_arr[i][j]+1;
									xc.add(x);
									yc.add(y);
									}
								}
									
							}

							
	                                                 
							//
						}
						return;
					}
				}