

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

    int parent[10000+5];
    vector <pip> edges;

    int find(int x)
    {
        if(x!=parent[x])
            return find(parent[x]);
        return parent[x];
    }


    int main()
    {
        int t;
        scanf("%d",&t);
        while(t--)
        {
            int num,neigh,v,w;
            scanf("%d",&num);

            edges.clear();
            memset(parent,0,sizeof(parent));

            for(int i=1;i<=num;i++)
            {
                parent[i]=i;
                string str;
                cin>>str;

                scanf("%d",&neigh);
                while(neigh--)
                {
                    scanf("%d%d",&v,&w);
                    //if(v>i)
                    edges.pb(pip(w,mp(i,v)));
                    //edges.pb(pip(w,mp(v,i)));
                }
            }

            /*cout<<"----------\n";
            for(vector<pip> :: iterator it=edges.begin();it!=edges.end();it++)
            {
                pip E=*it;
                int u=find(E.ss.ff);
                int v=find(E.ss.ss);
                w=E.ff;
                cout<<"from "<<u<< " to "<<v<<" cost= " <<w<<endl;
            }
            cout<<"----------\n";*/
            //

            sort(edges.begin(),edges.end());
            int cost=0;

            for(vector<pip> :: iterator it=edges.begin();it!=edges.end();it++)
            {
                pip E=*it;
                int u=find(E.ss.ff);
                int v=find(E.ss.ss);
                w=E.ff;

                if(u!=v){
                    cost+=w;
                    parent[v]=parent[u];
                }

            }

            printf("%d\n",cost);
        }

        return 0;
    }





