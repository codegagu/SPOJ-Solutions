

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

    int countbits(long long int v)
    {
      int c=0;
      while(v)
      {
            v &= v-1;
            c++;
      }

      return c;
    }


    int main()
    {
        int t;
        scanf("%d",&t);
        while(t--)
        {
            int n;
            ll k;
            scanf("%d%lld",&n,&k);
            k--;
            int c=countbits(k);
            if(c&1)
                cout<<"Female\n";
            else
                cout<<"Male\n";


        }

        return 0;
    }




