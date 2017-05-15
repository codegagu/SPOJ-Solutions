

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
        while(t--)
        {
            ll a,b;
            scanf("%lld%lld",&a,&b);

            int g=__gcd(a,b);
            ll x=b/g;
            ll y=a/g;
            cout<<x<<" "<<y<<endl;

        }

        return 0;
    }





