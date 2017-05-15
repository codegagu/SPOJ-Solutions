

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

    ll combi(ll n,ll r)
    {
        if(r>n-r)
            r=n-r;

        ll ans=1;
        int i;

        for( i=1;i<=r;i++)
        {
            ans*=n-r+i;
            ans/=i;
        }
        return ans;
    }


    int main()
    {
        int t;
        scanf("%d",&t);
        while(t--)
        {
            ll n,k;
            scanf("%lld%lld",&n,&k);
            ll N=k;
            ll R=n-k;
            ll ans=combi(N+R-1,R);
            printf("%lld\n",ans);
        }

        return 0;
    }




