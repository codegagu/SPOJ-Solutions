


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
    int dx[]= {-1,0,1,0,1,-1,-1,1};
    int dy[]= {0,1,0,-1,1,-1,1,-1};

    char arr[51][51];
    int visited[51][51];
    int ans;
    int h,w;
    pii start;

    bool isvalid(int x,int y)
    {
        if(x<0 || x>=h || y<0 || y>=w)
            return 0;
        return 1;
    }

    void dfs(pii pos,char c,int covered)
    {
        int x=pos.ff;
        int y=pos.ss;

        char next=c;
        next++;

        if(visited[x][y])
            return;

        visited[x][y]=1;
        ans=max(ans,covered);

        for(int k=0;k<8;k++)
        {
            int xx=x+dx[k];
            int yy=y+dy[k];
            if( isvalid(xx,yy) && arr[xx][yy]==next )
                dfs(mp(xx,yy),next,covered+1);
        }
        return;
    }

    int main()
    {
        int t=1;
        while(true)
        {
            int print=-1;
            scanf("%d%d",&h,&w);
            if(h==0 && w==0)
                break;

            vector <pii> startings;

            for(int i=0;i<h;i++)
            {
                string s;
                cin>>s;
                for(int j=0;j<w;j++)
                {
                    arr[i][j]=s[j];
                    if(arr[i][j]=='A')
                        startings.pb(mp(i,j));
                }
            }


            for(vector<pii> :: iterator it=startings.begin();it!=startings.end();it++)
            {
                for(int i=0;i<h;i++)
                for(int j=0;j<w;j++)
                    visited[i][j]=0;

                pii temp=*it;
                int a=temp.ff;  int b=temp.ss;

                ans=-1;
                dfs(mp(a,b),'A',0);
                ans++;

                print=max(print,ans);
            }

            if(print<0)print=0;
            cout<<"Case "<<t<<": "<<print<<endl;

            t++;

        }



        return 0;
    }




