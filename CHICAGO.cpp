



            #include<cstdio>
            #include<cstdio>
            #include<vector>
            #include<algorithm>
            #include<iostream>
            #include<map>
            #include<queue>
            #include<utility>
            using namespace std;

            #define max  - 9.000000;
            #define pii pair<int,double >
            #define pb push_back

            vector<pii> G[105];
            double dist[105];
            bool visited[105];

            struct cmp
            {
                bool operator() (const pii &a,const pii &b)
                {
                    return a.second<b.second;
                }
            };

            int main()
            {
                int n;
                while(scanf("%d", &n)==1 && n)
                {
                    //G.clear();
                        int m;
                        scanf("%d",&m);

                        for(int i=0;i<=n;i++)
                        {
                            dist[i]=max;
                            G[i].clear();
                            visited[i]=false;
                        }


                        for(int i=0;i<m;i++)
                        {
                            int a,b;
                            double p;
                            scanf("%d %d %lf",&a,&b,&p);
                            p/=100.0;

                            G[a].pb(pii(b,p));
                            G[b].pb(pii(a,p));
                        }

                        dist[1]=1.0;
                        priority_queue<pii, vector<pii> ,cmp > pq;
                        pq.push(pii(1,1.000000));//node and temporal distance;
                        while(!pq.empty())
                        {
                            int u=pq.top().first;
                            //printf("u--> %d \n",u);
                            pq.pop();

                            if(visited[u])
                                continue;
                            //printf("This node: %d     This node distance: %lf\n",u,dist[u]);
                            int size=G[u].size();
                            for(int i=0;i<size;i++)
                            {
                                int v;double w;
                                v=G[u][i].first;
                                //printf("v-->> %d\n",v);
                                w=G[u][i].second;
                                //printf("Value of w     %lf\n ",w);
                                if(!visited[v] && dist[u]*w>dist[v])
                                {
                                    dist[v]=dist[u]*w;
                                    pq.push(pii(v,dist[v]));
                                }
                            }

                            visited[u]=true;
                            if(u==n)
                                break;
                        }
                        //while(!pq.empty())
                          //  pq.pop();
                        printf("%.6lf percent\n",dist[n]*100.0+ 1e-10);
                        //printf("----------------------\n");
                }
                return 0;
            }
