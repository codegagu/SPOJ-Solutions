

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
    //int dx[]={1,-1,0,0};
    //int dy[]={0,0,1,-1};

    const int MAX=1000+2;
    char graph[MAX][MAX];
    int component[MAX][MAX];
    int comp=0;
    int r, c;

    bool isValid(int i,int j)
    {
        if(i<0 || j <0 || i>=r || j>=c)
            return 0;
        return 1;
    }

    void dfs(int i,int j)
    {
        //cout<<i<<" "<<j<<" "<<comp<<endl;
        if(component[i][j])
        {
            comp=component[i][j];
            return;
        }
//cout<<" lol "<<endl;
        component[i][j]=comp;

        if(graph[i][j]=='E')
        {
            if(isValid(i,j+1))
                dfs(i,j+1);
        }
        if(graph[i][j]=='W')
        {
            if(isValid(i,j-1))
                dfs(i,j-1);
        }
        if(graph[i][j]=='N')
        {
            if(isValid(i-1,j))
                dfs(i-1,j);
        }
        if(graph[i][j]=='S')
        {
            if(isValid(i+1,j))
                dfs(i+1,j);
        }


        component[i][j]=comp;

        //cout<<" lul "<<i<<" "<<j<<" "<<comp<<endl;
    }

    int main()
    {
        scanf("%d%d",&r,&c);
        for(int i=0;i<r;i++)
            scanf("%s",graph[i]);

        int last=0;
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(!component[i][j])
                {
                    comp=last+1;
                    dfs(i,j);
                    if(comp>last)
                        last++;
                }
            }
        }

        printf("%d\n",last);

        /*for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                cout<<component[i][j];

            }
            cout<<endl;
        }*/


        return 0;
    }
