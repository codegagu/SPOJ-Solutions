

	
		import java.io.*;
		import java.util.*;
		class Main
		{
			public static void main(String args[])
			throws IOException
			{
				BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
				String str="";
				while(!(str=br.readLine()).equals("0"))
				{
					int n=Integer.parseInt(str.substring(0, str.indexOf(" ")));
					String s=str.substring(str.indexOf(" ")+1);
					long histos[]=new long[n];
					int pos=0;
					StringTokenizer st=new StringTokenizer(s);
					while(st.hasMoreTokens())
						histos[pos++]=Integer.parseInt(st.nextToken());
					
					Stack<Long> heights=new Stack<Long>();
					Stack<Integer> indexes=new Stack<Integer>();
					long tempAreaSize=0;
					long maxArea=0;
					for(int i=0;i<histos.length;i++)
					{
						/*case 1:
						 * if stack is empty or previous element ie heights.peek()
						 * is smaller that the recent element being scanned, ie recent element--> histos[i].
						 * then add it to the stack
						 */
						
						if(heights.isEmpty() || histos[i]>heights.peek())
						{
							heights.push(histos[i]);
							indexes.push(i);
						}
						
						/*case 2: if the topmost element of the stack is greater than the current element being scanned
						 * keep on popping the stack elements unless the topmost element of the stack becomes lesser than the 
						 * current element being scanned. This is done to ensure that the histograms are arranged in ascending 
						 * order in the stack. This ascending order property is of paramount importance for solving this.
						 */
						else if(histos[i]<heights.peek())
						{
							int lastIndex=0; //last index will store the index of the most recently popped out element
							while(!heights.isEmpty() && histos[i]<heights.peek())
							{
								lastIndex=indexes.pop();
								tempAreaSize=heights.pop()*(i-lastIndex);
								
								maxArea=Math.max(maxArea, tempAreaSize);
							}
							/*
							 * now that the unnecessary or bigger elements compared to histos[i]
							 * have been removed,we add the present element histos[i] to the queue. 
							 * thus incresing order is also maintained. :D 
							 */
							heights.push(histos[i]);
							indexes.push(lastIndex);//	note!!!!
							/*
							 * lastIndex: index of the latest popped out element. let there be a series of histograms(1,4,5,6,7,8,2)
							 * Due to the presence of 2 after 8-->  8,7,6,5,4 will be popped out since they all >2. (not in ascending order)  
							 * lastIndex will ultimately hold the index of 4. and then its like the histogram of height 2 will be 
							 * placed at that index of present element 4 i.e {1}. so the the ordering of the histograms become 1,2(ascending order)
							 * element 2 will be pushed into the height stack and index {1} will be pushed into the  indexes stack.
							 * 
							 * So ultimately 1 will have the corresponding index {0} and 2 will have the corresponding index {1}  //see diagram in copy for clear understanding
							 * 					
							 * 				|2| -----> |1|
							 * 				|*| -----> |*|	// some series of
							 * 				|*| -----> |*|	// pushing in and
							 * 				|*| -----> |*|	// popping out
							 * 				|1| -----> |0|
							 * 				---        ---
							 * 			   height     indexes
							 * 			   stack      stack
							 * 				
							 */
						}
					}//for
					
					//now for possible remaining elements of the stack
					
					while(!heights.isEmpty())
					{
						tempAreaSize=heights.pop()*(histos.length-indexes.pop());
						maxArea=Math.max(maxArea, tempAreaSize);
					}
					
					System.out.println(maxArea);
				}//while
				
			}
		}
