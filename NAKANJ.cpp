
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

    int kx[]={1,2,2,1,-1,-2,-2,-1};
    int ky[]={-2,-1,1,2,-2,-1,1,2};

    int board[8][8];
    int visited[8][8];
    int ans=0;

    bool isValid(int x,int y)
    {
        if(x<0 || x>7 || y<0 || y>7 )
            return 0;
        return 1;
    }

    void bfs(pii src,pii dest)
    {
        int x1=src.ff;
        int y1=src.ss;
        int x2=dest.ff;
        int y2=dest.ss;

        queue<pip> q;
        q.push(pip(0,src));
        while(!q.empty())
        {
            pip temp=q.front();
            q.pop();

            int cost=temp.ff;
            int x=temp.ss.ff;
            int y=temp.ss.ss;

            for(int k=0;k<8;k++)
            {
                int new_x=x+kx[k];
                int new_y=y+ky[k];

                if(isValid(new_x,new_y) && !visited[new_x][new_y] )
                {
                    visited[new_x][new_y]=1;
                    if(new_x==x2 && new_y==y2)
                    {
                        visited[new_x][new_y]=1;
                        ans=cost+1;
                    }
                    q.push( pip(cost+1,pii(new_x,new_y)) );
                }
            }
        }

    }

    void refresh()
    {
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++)
                visited[i][j]=0;

    }


    int main()
    {

        int t;
        scanf("%d",&t);
        string source;
        string dest;
        while(t--)
        {
            refresh();

            cin>>source>>dest;
            int x1=source[0]-'0'-'0'-1;
            int y1=source[1]-'0'-1;

            int x2=dest[0]-'0'-'0'-1;
            int y2=dest[1]-'0'-1;

            if(x1==x2 && y1==y2){
                cout<<0<<endl;
                continue;
            }


            bfs( pii(x1,y1) , pii(x2,y2) );
            cout<<ans<<endl;


        }

        return 0;
    }

