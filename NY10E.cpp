

        #include<cstdio>
        #include<iostream>
        using namespace std;
        int main()
        {
            int t;
            scanf("%d",&t);
            while(t--!=0)
            {
                int p,n;
                scanf("%d%d",&p,&n);
                long long arr[n+1][10];

                for(int i=1;i<n+1;i++)
                {
                    for(int j=0;j<10;j++)
                    {
                        if(i==1)
                            arr[i][j]=1;
                        else if(j==0)
                            arr[i][j]=1;
                        else
                            arr[i][j]=arr[i][j-1]+arr[i-1][j];
                    }
                }
                long long sum=0;
                for(int i=0;i<10;i++)
                    sum+=arr[n][i];

                printf("%d %lld\n",p,sum);
            }
            return 0;
        }
