

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

        ll arr[4];
        int counter=0;
        while(scanf("%lld%lld%lld%lld",&arr[0],&arr[1],&arr[2],&arr[3])!=EOF)
        {
            counter++;
            sort(arr,arr+4);
            printf( "Case %d: %lld\n", counter, arr[ 2 ] + arr[ 3 ]  );
        }


        return 0;
    }





