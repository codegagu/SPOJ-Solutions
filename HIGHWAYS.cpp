



            #include<cstdio>
            #include<algorithm>
            #include<iostream>
            #include<vector>
            #include<queue>

            #define pii pair<int,int>
            #define pb push_back
            #define INF 100000000
            using namespace std;

            bool visited[100000+5];
            int dist[100000+5];

            struct cmp
            {
                bool operator()(const pii &a,const pii &b)
                {
                    return a.second>b.second;
                }
            };

            int main()
            {
                int t;
                scanf("%d",&t);
                while(t--!=0)
                {
                    int n,m,start,End;
                    scanf("%d%d%d%d",&n,&m,&start,&End);


                    for(int i=0;i<n+2;i++)
                    {
                        visited[i]=0;
                        dist[i]=INF;
                    }

                    vector <pii> G[n+1];
                    int a=0,b=0,c=0;
                    for(int i=0;i<m;i++)
                    {
                        scanf("%d%d%d",&a,&b,&c);
                        G[a].pb(pii(b,c));
                        G[b].pb(pii(a,c));
                    }

                    dist[start]=0;

                    priority_queue <pii ,vector<pii> ,cmp> Q;
                    Q.push(pii(start,0));

                    while(!Q.empty())
                    {
                        int u=Q.top().first;
                        Q.pop();

                        if(visited[u])
                            continue;

                        for(int i=0;i<G[u].size();i++)
                        {
                            int v=G[u][i].first;
                            int w=G[u][i].second;

                            if(!visited[v] && dist[v]>dist[u]+w)
                            {
                                dist[v]=dist[u]+w;
                                Q.push(pii(v,dist[v]));
                            }
                        }

                        visited[u]=true;
                        if(u==End)
                            break;


                    }

                    if(dist[End]==INF)
                        printf("NONE\n");
                    else
                        printf("%d\n",dist[End]);

                }

                return 0;
            }
