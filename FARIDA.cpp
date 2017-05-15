

    #include<bits/stdc++.h>
    using namespace std;

    #define pii pair<int,int>
    #define pip pair<int,pii>
    #define ff first
    #define ss second
    #define FOR(i,n) for(int i=0; i<(int)n ;i++)
    #define REP(i,a,n) for(int i=a;i<(int)n;i++)
    #define pb push_back
    #define mp make_pair

    typedef long long ll;
    //int dx[]= {-1,0,1,0};
    //int dy[]= {0,1,0,-1};


    int main()
    {
        int t;
        scanf("%d",&t);
        for(int k=1;k<=t;k++)
        {
            int n;
            scanf("%d",&n);

            if(n==0)
            {
                cout<<"Case "<<k<<": "<<0<<endl;
                continue;
            }

            ll arr[n];
            ll dp[n];
            memset(dp,0,sizeof(dp));
            for(int i=0;i<n;i++)
                scanf("%lld",&arr[i]);

            dp[0]=arr[0];
            dp[1]=max(dp[0],arr[1]);

            for(int i=2;i<n;i++)
            {
                dp[i]=max(arr[i]+dp[i-2] , dp[i-1] );
            }

            //for(int i=0;i<n;i++)
              //  cout<<dp[i]<<" lol"<<endl;
            cout<<"Case "<<k<<": "<<dp[n-1]<<endl;


        }

        return 0;
    }




