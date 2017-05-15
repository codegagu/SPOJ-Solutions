

		import java.io.*;
import java.util.*;
		class SHOP
		{
			
			static int dx[]= {-1,0,1,0};
			static int dy[]= {0,1,0,-1};
			
			public static void main(String args[])
			throws IOException
			{
				BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
				String str="";
				while(!(str=br.readLine()).equals("0 0"))
				{
					
					StringTokenizer st=new StringTokenizer(str);
					int w=Integer.parseInt(st.nextToken());
					int h=Integer.parseInt(st.nextToken());
					int weight[][]=new int[h][w];
					
					int Sx=0,Sy=0,Dx=0,Dy=0;
					for(int i=0;i<h;i++)
					{
						String in=br.readLine();
						for(int j=0;j<in.length();j++)
						{
							char c=in.charAt(j);
							if(c=='S') {
								Sx=i;Sy=j;}
							else if(c=='D') {
								Dx=i;Dy=j;}
							else if(c=='X')
								weight[i][j]=1000000000;
							else
								weight[i][j]=c-'0';							
						}
					}
					
					PriorityQueue<Position> pq=new PriorityQueue<Position>();
					boolean visited[][]=new boolean [h][w];
					Position hold;
					pq.add(new Position(Sx,Sy,0));
					int x,y, cost=0;
					
					while(pq.size()>0)
					{
						hold=pq.poll();
						x=hold.x;y=hold.y;cost=hold.cost;
						
						if(x==Dx && y==Dy)
							break;
						visited[x][y]=true;
						//System.out.println("x= "+x+" y= "+y+" cost= "+cost);
						for(int k=0;k<4;k++)
						{
							int nx=x+dx[k];
							int ny=y+dy[k];
							
							if(nx<0 || nx>=h || ny<0 || ny>=w || visited[nx][ny] || weight[nx][ny]==1000000000)
								continue;
							//System.out.println(nx+" check "+ny+" k= "+k);
							pq.add(new Position(nx,ny,weight[nx][ny]+cost));
						}	
					}
					System.out.println(cost);
					System.out.flush();
					str=br.readLine();//blank line
				}
			}
			
			static class Position implements Comparable<Position>
			{
				public int x,y,cost;
				public Position(int x,int y,int cost)
				{
					this.x=x;this.y=y;this.cost=cost;
				}
				public int compareTo(Position other)
				{
					return cost-other.cost;
				}
			}
		}