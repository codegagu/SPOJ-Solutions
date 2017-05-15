

        #include <bits/stdc++.h>
        using namespace std;

        int dp[201][201];
        int memo[201][201];

        int solve(int s,int e)
        {
            if(s>e)return 0;
            int &ret = memo[s][e];

            if(ret==-1)
            {
                ret=0;
                for(int i=s;i<=e;i++)
                {
                    int aux=dp[s][i]+solve(i+1,e);
                    if(aux>ret)ret=aux;
                }
            }
            return ret;
        }


        int main()
        {
            int t;
            scanf("%d",&t);
            while(t--)
            {
                memset(dp,0,sizeof(dp));
                int n;
                scanf("%d",&n);
                string str;
                cin>>str;

                for(int i=0;i<n;i++)
                {
                    for(int j=i;j<n;j++)
                    {
                        int diff=0;
                        for(int k=j;k>=i;k--)
                        {
                            if(str[k]=='1')
                                diff++;
                            else
                                diff--;

                            if(diff>0)
                                dp[i][j]=j-k+1;
                        }
                    }
                }

                memset(memo,-1,sizeof(memo));
                printf("%d\n",solve(0,n-1));

            }
            return 0;
        }
