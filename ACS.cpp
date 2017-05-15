

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

    int main()
    {

        int r[1234];
        int c[5678];
        for(int i=0;i<1234;i++)
            r[i]=i;
        for(int i=0;i<5678;i++)
            c[i]=i;

        char ch;
        int x,y;

        while(cin>>ch)
        {
            switch(ch)
            {
                case 'R':
                    {
                        scanf("%d%d",&x,&y);
                        x--;y--;
                        int temp=r[x];
                        r[x]=r[y];
                        r[y]=temp;
                        break;
                    }
                case 'C':
                    {
                        scanf("%d%d",&x,&y);
                        x--;y--;
                        int temp=c[x];
                        c[x]=c[y];
                        c[y]=temp;
                        break;
                    }
                case 'Q':
                    {
                        scanf("%d%d",&x,&y);
                        x--; y--;
                        int ans=r[x]*5678+c[y]+1;
                        printf("%d\n",ans);
                        break;
                    }
                case 'W':
                    {
                        int z;
                        scanf("%d",&z);
                        z--;
                        int row=z/5678;
                        int col=z%5678;
                        for(int i=0;i<1234;i++)
                            if(r[i]==row)
                                cout<<(i+1)<<" ";
                        for(int i=0;i<5678;i++)
                            if(c[i]==col)
                                cout<<(i+1)<<"\n";

                        break;
                    }

            }
        }

        return 0;
    }
