
    #include <bits/stdc++.h>
    using namespace std;

    #define pii pair<int,int>
    #define pip pair<int,pii>
    #define pb push_back
    #define mp make_pair
    #define ff first
    #define ss second
    #define MOD 1000000007

    typedef long long ll;
    int dx[]={1,-1,0,0,-1,1,-1,1};
    int dy[]={0,0,1,-1,-1,1,1,-1};


    vector<int> graph[102];
    int indegree[102];
    bool visited[102];

    int main()
    {
        memset(indegree , 0, sizeof (indegree));
        memset(visited , false, sizeof (visited));

        int tasks=0,rules=0;
        scanf("%d%d",&tasks,&rules);

        while(rules--)
        {
            int t_no=0,dependencies=0;
            cin>>t_no>>dependencies;
            indegree[t_no]=dependencies;

            for(int i=0;i<dependencies;i++)
            {
                int num=0;
                cin>>num;
                graph[num].pb(t_no);
            }
        }

        queue<int> q;

        while(q.size()<tasks)
        {
            int sink=0;
            for(int i=1;i<=tasks;i++)
            {
                if(indegree[i]==0 && !visited[i])
                {
                    visited[i]=true;
                    sink=i;
                    break;
                }
            }
            q.push(sink);
            for(int i=0;i<graph[sink].size();i++)
            {
                int node=graph[sink][i];
                indegree[node]--;
            }
            graph[sink].clear();

        }

        while(q.size()!=0)
        {
            int top=q.front();
            cout<<top<<" ";
            q.pop();
        }
        cout<<endl;

        return 0;
    }

