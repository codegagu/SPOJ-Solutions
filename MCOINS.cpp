



        #include<cstdio>
        #include<algorithm>
        using namespace std;

        int main()
        {
            int k=0,l=0,m=0;
            scanf("%d%d%d",&k,&l,&m);
            int arr[1000005],i=0;
            arr[0]=0;
            arr[1]=1;

            for(i=2;i<1000005;i++)
            {
                arr[i]=0;
                if(arr[i-1]==0)
                    arr[i]=1;
                else if(i-k>=0 && i-l<0)
                {
                    if(arr[i-k]==1)
                        arr[i]=0;
                    else if(arr[i-k]==0)
                        arr[i]=1;
                }
                else if(i-l>=0 && i-k<0)
                {
                    if(arr[i-l]==1)
                        arr[i]=0;
                    else if(arr[i-l]==0)
                        arr[i]=1;
                }
                else if(i-k>=0 && i-l>=0)
                {
                    if(arr[i-k]==0 || arr[i-l]==0)
                        arr[i]=1;
                    else
                        arr[i]=0;
                }

            }

            while(m--!=0)
            {
                int n=0;
                scanf("%d",&n);
                if(arr[n]==1)
                   printf("A");
                else
                   printf("B");
            }
            printf("\n");
            return 0;
        }
