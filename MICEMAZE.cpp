

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

    struct edge
    {
        int v;
        int w;
    };

    int dist[102];
    vector <edge> graph[102];

    bool operator<(edge a,edge b)
    {
        return a.w<b.w;
    }

    void dijkstra(int start,int finish,int N)
    {
        for(int i=0;i<=N;i++)
            dist[i]=INF;

        priority_queue <edge> pq;
        pq.push((edge) {start,0} );
        dist[start]=0;

        while(!pq.empty())
        {
            edge E=pq.top();
            pq.pop();

            int node=E.v;
            for(int i=0;i<graph[node].size();i++)
            {
                edge K=graph[node][i];
                int neigh=K.v;
                int cost=K.w;

                if(dist[node]+cost<dist[neigh])
                {
                    dist[neigh]=dist[node]+cost;
                    pq.push(K);
                }
            }
        }


    }

    int main()
    {

        int n,e,timer,relations;
        scanf("%d%d%d%d",&n,&e,&timer,&relations);

        for(int i=0;i<relations;i++)
        {
            int u, v,w;
            scanf("%d%d%d",&u,&v,&w);
            graph[u].pb((edge) {v,w} );
        }

        int counter=0;
        for(int i=1;i<=n;i++)
        {
            dijkstra(i,e,n);
            if(dist[e]<=timer)
            {
                //cout<<"e "<<e<<" i is "<<i <<" distance is " <<dist[e]<<endl;
                counter++;
            }

        }
        printf("%d\n",counter);

        return 0;
    }





