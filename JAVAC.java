


			
		
			import java.io.*;
			class Main
			{
				public static void main(String args[])
				throws IOException
				{
					BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
					String temp=br.readLine().trim();
					while(temp != null && !temp.isEmpty())
					{
						temp=temp.trim();
						if(((int)temp.charAt(0)>=65 && (int)temp.charAt(0)<=90) && temp.length()==1)
						{
							System.out.println("Error!");
							temp=br.readLine().trim();
							continue;
						}
						if(temp.charAt(0)=='_')
						{
							System.out.println("Error!");
							temp=br.readLine().trim();
							continue;
						}
						int yo=0,checkcase=0,checkus=0;
						int l=temp.length();
						for(int i=0;i<l;i++)
						{
							//check for capital letters
							if((int)temp.charAt(i)>=65 && (int)temp.charAt(i)<=90)
								checkcase=1;
							//check for underscore
							else if((int)temp.charAt(i)==95)
							{
								if(i!=(temp.length()-1))
								{
								char ch=temp.charAt(i+1);
								if(ch=='_'){
									yo=1;
									System.out.println("Error!");
									break;
									}
								}
								checkus=1;
							}

							if(checkcase==1 && checkus==1)
							{
								System.out.println("Error!");
								yo=1;break;
							}
						}
						if(yo==1){
							temp=br.readLine();
							continue;
						}
						
						if(checkcase==1){
							conv_to_cpp(temp);
							//System.out.println();
						}
						else if(checkus==1){
							conv_to_java(temp);
							//System.out.println();
						}
						else
							System.out.println(temp);
							
						temp=br.readLine();
					}
					
				}
				//end of main()
				
				
				static void conv_to_cpp(String str)
				{
					if((int)str.charAt(0)>=65 && (int)str.charAt(0)<=90)
					{
						System.out.println("Error!");
						return;
						
					}
					for(int i=0;i<str.length();i++)
					{
						char c=str.charAt(i);
						if((int)c>=65 && (int)c<=90)
							System.out.print("_"+(char)((int)c+32));
						else
							System.out.print(c);
					}
					System.out.println();
					
				}
				
				
				static void conv_to_java(String str)
				{
					if(str.charAt(str.length()-1)=='_')
					{
						System.out.println("Error!");
						return;
						
					}
					for(int i=0;i<str.length();i++)
					{
						
						if((int)str.charAt(i)==95)
						{
							char c=str.charAt(i+1);
							System.out.print((char)((int)c-32));
							i++;
						}
						else
							System.out.print(str.charAt(i));
					}
						System.out.println();
					
				}
				
				
			}
						