

		import java.util.*;
		import java.io.*;
		public class Main
		{
			private static Reader in;
			public static void main(String args[])throws IOException
			{
				int dp[][]=new int[2001][2001];
				int a[]=new int[2001];
				
				in = new Reader();
		        int n = in.nextInt();
				
				for(int i=0;i<n;i++)
				{
					int val=in.nextInt();
					a[i]=val;
					dp[i][i]=n*val;
				}
				for(int i=n-2;i>=0;i--)
				{
					for(int j=i+1;j<n;j++)
					{
						int age=n-j+i;
						dp[i][j]=Math.max(dp[i+1][j]+age*a[i],dp[i][j-1]+age*a[j]);
					}
				}
				System.out.println(dp[0][n-1]);
				System.out.flush();
				System.exit(0);
			}
		}
		
		
		/** Faster input **/
		class Reader
		{
		    final private int BUFFER_SIZE = 1 << 16;
		    
		    private DataInputStream din;
		    private byte[] buffer;
		    private int bufferPointer, bytesRead;
		    
		    public Reader()
		    {
		        din = new DataInputStream(System.in);
		        buffer = new byte[BUFFER_SIZE];
		        bufferPointer = bytesRead = 0;
		    }
		    
		    public Reader(String file_name) throws IOException
		    {
		        din = new DataInputStream(new FileInputStream(file_name));
		        buffer = new byte[BUFFER_SIZE];
		        bufferPointer = bytesRead = 0;
		    }
		    
		    public String readLine() throws IOException
		    {
		        byte[] buf = new byte[64]; // line length
		        int cnt = 0, c;
		        while( (c=read()) != -1) {
		            buf[cnt++] = (byte)c;
		            if(c == '\n') break;
		        }
		        return new String(buf,0,cnt);
		    }
		    
		    public int nextInt() throws IOException
		    {
		        int ret = 0;
		        byte c = read();
		        while (c <= ' ') c = read();
		        boolean neg = c == '-';
		        if (neg) c = read();
		        do {
		            ret = ret * 10 + c - '0';
		            c = read();
		        } while (c >= '0' && c <= '9');
		        if (neg) return -ret;
		        return ret;
		    }
		    
		    public long nextLong() throws IOException
		    {
		        long ret = 0;
		        byte c = read();
		        while (c <= ' ') c = read();
		        boolean neg = c == '-';
		        if (neg) c = read();
		        do {
		            ret = ret * 10 + c - '0';
		            c = read();
		        } while (c >= '0' && c <= '9');
		        if (neg) return -ret;
		        return ret;
		    }
		    
		    public double nextDouble() throws IOException
		    {
		        double ret = 0, div = 1;
		        byte c = read();
		        while(c <= ' ') c = read();
		        boolean neg = c == '-';
		        if(neg) c = read();
		        do {
		            ret = ret * 10 + c - '0';
		            c = read();
		        } while (c >= '0' && c <= '9');
		        if(c == '.')
		            while((c=read()) >= '0' && c <= '9') {
		                div *= 10;
		                ret = ret + (c - '0') / div;
		            }
		        if (neg) return -ret;
		        return ret;
		    }
		    
		    private void fillBuffer() throws IOException
		    {
		        bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
		        if (bytesRead == -1) buffer[0] = -1;
		    }
		    
		    private byte read() throws IOException
		    {
		        if (bufferPointer == bytesRead) fillBuffer();
		        return buffer[bufferPointer++];
		    }
		    
		    public void close() throws IOException
		    {
		        if(din == null) return;
		        din.close();
		    }
		}