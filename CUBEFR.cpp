

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

    #define LIM 1000010

    typedef long long ll;
    //int dx[]= {-1,0,1,0};
    //int dy[]= {0,1,0,-1};

    int arr[LIM];

    set<int> store;


    void sieve()
    {
        for(int i=2;i*i*i<LIM;i++)
        {
            int val=i*i*i;
            store.insert(val);

            for(int j=2;j*val<LIM;j++)
                store.insert(j*val);

        }
    }


    int main()
    {
        sieve();
        set<int> :: iterator it;
        vector<int> v;

        for(int i=1;i<1000010;i++)
        {
            it=store.find(i);
            if(it==store.end())
                v.pb(i);
        }


        int t;
        scanf("%d",&t);
        for(int i=1;i<=t;i++)
        {
            int n;
            scanf("%d",&n);

            it=store.find(n);
            if(it!=store.end())
                cout<<"Case "<<i<<": Not Cube Free"<<endl;
            else
            {


                cout<<"Case "<<i<<": "<< (1+ lower_bound(v.begin(),v.end(),n)-v.begin() ) <<endl;
            }



        }

        return 0;
    }





