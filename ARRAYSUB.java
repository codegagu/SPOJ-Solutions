



			import java.io.*;
			import java.util.*;
			class Main
			{
				private static Reader in;
				static int arr[];
				
				public static void main(String args[])
				throws IOException
				{
					in=new Reader();
					BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
					int n=in.nextInt();
					arr=new int[n];

					for(int i=0;i<n;i++)
						arr[i]=in.nextInt();

					int k=in.nextInt();
					calculate(n,k);
				}
				
				
				static void calculate(int n,int k)
				{
					Deque<Integer> dq=new LinkedList<Integer>();
					int i;
					// process the first k elements ie the first window
					for(i=0;i<k;i++)
					{
						// for every element the previous smaller element are useless
						// so remove them from dq
						while((!dq.isEmpty()) && arr[i]>=arr[dq.peekLast()])
							dq.pollLast();
						
						//add the new element at the rear end
						dq.offerLast(i);
					}
					
					
					//now processing the rest of the elements from arr[k] to arr[n-1]
					for(;i<n;++i)
					{
						//the front element of the queue will always be the largest element
						System.out.print(arr[dq.peekFirst()]+" ");
						
						//remove all elements that are out of the window
						while((!dq.isEmpty()) && dq.peekFirst()<=i-k)
							dq.pollFirst();
						
						//if the current element being scanned is greater than the value of
						//the existing max value stored at the front of the queue make the desired change
						while((!dq.isEmpty()) && arr[i]>=arr[dq.peekLast()])
							dq.pollLast();
						
						dq.offerLast(i);
					}
					System.out.print(arr[dq.peekFirst()]);
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