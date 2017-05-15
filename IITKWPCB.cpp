

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



    ll GCD(ll a, ll b) { return b==0 ? a : GCD(b, a%b); }

    int main()
    {
        int t;
        scanf("%d",&t);
        while(t--)
        {
            ll n;
            scanf("%lld",&n);
            for(ll i=n/2;i>=1;i--)
            {
                if(GCD(n,i)==1)
                {
                    printf("%lld\n",i);
                    break;
                }
            }

        }

        return 0;
    }





