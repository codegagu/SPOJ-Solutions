

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
    #define INF 1000000000

    typedef long long ll;
    //int dx[]= {-1,0,1,0};
    //int dy[]= {0,1,0,-1};


    int main()
    {
        int t;
        scanf("%d",&t);
        while(t--)
        {
            int n;
            scanf("%d",&n);
            pii schedule[n];

            for(int i=0;i<n;i++)
            {
                int st,en;
                scanf("%d%d",&st,&en);
                schedule[i]=mp(en,st);
            }
            sort(schedule,schedule+n);//sorting wrt finishing time

            int ans=-INF;
            for(int i=0;i<n;i++)
            {
                pii i1=schedule[i];
                int f1=i1.ff;
                int counter=0;

                for(int j=0;j<n;j++)
                {
                    //if(i==j)continue;

                    pii i2=schedule[j];
                    int s2=i2.ss;
                    int f2=i2.ff;

                    if(s2<=f1 && f2>=f1)
                    {

                        counter++;
                    }

                }


                ans=max(ans,counter);
            }


            cout<<ans<<endl;

        }

        return 0;
    }





