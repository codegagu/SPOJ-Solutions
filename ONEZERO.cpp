

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

    struct node
    {
        string s;
        int mod;
    };

    int visited[20000+10];

    void bfs(int num)
    {
        queue<node> q;
        node temp,hold,poss1,poss2;

        temp.s="1";
        //
            int x=0;
            for(int i=0;i<temp.s.size();i++)
                x= (x*10 + temp.s[i]-'0')%num;
        //
        temp.mod=x;
        if(temp.mod==0)
        {
            cout<<num<<endl;
            return;
        }
        q.push(temp);
        visited[temp.mod]=1;
        while(!q.empty())
        {
            hold=q.front();
            q.pop();

            if(hold.mod==0)
            {
                cout<<hold.s<<endl;
                break;
            }

            poss1.s=hold.s;
            poss1.s+='0';
            //
            x=0;
            for(int i=0;i<poss1.s.size();i++)
                x= (x*10 + poss1.s[i]-'0')%num;
            //
            poss1.mod=x;
            if(!visited[poss1.mod])
            {
                visited[poss1.mod]=1;
                q.push(poss1);
            }

            poss2.s=hold.s;
            poss2.s+='1';
            //
            x=0;
            for(int i=0;i<poss2.s.size();i++)
                x= (x*10 + poss2.s[i]-'0')%num;
            //
            poss2.mod=x;
            if(!visited[poss2.mod])
            {
                visited[poss2.mod]=1;
                q.push(poss2);
            }

        }

    }

    int main()
    {
        int t;
        scanf("%d",&t);
        while(t--)
        {
            int n;
            scanf("%d",&n);
            for(int i=0;i<20000+4;i++)
                visited[i]=0;

            bfs(n);
        }

        return 0;
    }

