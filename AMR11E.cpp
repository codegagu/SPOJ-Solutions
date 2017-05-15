

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
    #define N 1000000

    typedef long long ll;
    //int dx[]= {-1,0,1,0};
    //int dy[]= {0,1,0,-1};

    bool isPrime[N];
    int counter[N];
    set<int> s;

    void sieve()
    {
        memset(isPrime,1,N);
        memset(counter,0,N);
        isPrime[0]=isPrime[1]=0;

        for(int i=2;i*i<=N;i++)
        {
            if(isPrime[i])
            {
                for(int j=2;i*j<=N;j++)
                {
                    isPrime[i*j]=0;
                    counter[i*j]++;
                    if(counter[i*j]>=3)
                        s.insert(i*j);
                }
            }
        }
    }



    int main()
    {

        sieve();
        set<int>::iterator it;
        int t;
        scanf("%d",&t);
        while(t--)
        {
            int n;
            scanf("%d",&n);
            n--;
            it = s.begin();
            advance(it, n);
            cout<<*it<<endl;
        }

        return 0;
    }





