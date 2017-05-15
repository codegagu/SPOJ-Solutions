

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

    struct node
    {
        int val;
        int sq;
        ll sum;
        ll sq_sum;
    };

    node st[4*100000];
    int arr[100000+10];

    void build_tree(int id,int l,int r)
    {
        if(l==r)
        {
            st[id].val=st[id].sum=arr[l];
            st[id].sq=st[id].sq_sum=arr[l]*arr[l];
        }
        else if(l<r)
        {
            int mid=(l+r)/2;
            build_tree(2*id,l,mid);
            build_tree(2*id+1,mid+1,r);

            st[id].sum=st[2*id].sum+st[2*id+1].sum;
            st[id].sq_sum=st[2*id].sq_sum+st[2*id+1].sq_sum;
        }
    }

    ll query(int id,int l,int r,int x,int y)
    {
        if(r<x || y<l)
            return 0;

        if(l>=x && r<=y)
            return st[id].sq_sum;

        int mid=(l+r)/2;
        return query(2*id,l,mid,x,y)+query(2*id+1,mid+1,r,x,y);
    }

    void update0(int id,int l,int r,int x,int y,int value)
    {
        if(r<x || y<l)
            return;

        if(l==r && l>=x && l<=y)
        {
            st[id].val=st[id].sum=value;
            st[id].sq=st[id].sq_sum=value*value;
            return;
        }

        int mid=(l+r)/2;
        update0(2*id  ,l,mid,x,y,value);
        update0(2*id+1,1+mid,r,x,y,value);

        st[id].sum=st[2*id].sum+st[2*id+1].sum;
        st[id].sq_sum=st[2*id].sq_sum+st[2*id+1].sq_sum;

    }

    void update1(int id,int l,int r,int x,int y,int value)
    {
        if(r<x || y<l)
            return;

        if(l==r && l>=x && l<=y)
        {
            st[id].val+=value;
            st[id].sum=st[id].val;
            st[id].sq=st[id].val*st[id].val;
            st[id].sq_sum=st[id].sq;
            return;
        }

        int mid=(l+r)/2;
        update1(2*id  ,l,mid,x,y,value);
        update1(2*id+1,1+mid,r,x,y,value);

        st[id].sum=st[2*id].sum+st[2*id+1].sum;
        st[id].sq_sum=st[2*id].sq_sum+st[2*id+1].sq_sum;

    }

    int main()
    {
        int t;
        scanf("%d",&t);
        for(int c=1;c<=t;c++)
        {

            int n,q;
            scanf("%d%d",&n,&q);
            memset(arr,0,n+1);

            for(int i=0;i<n;i++)
                scanf("%d",&arr[i]);

            build_tree(1,0,n-1);

            cout<<"Case "<<c<<":\n";

            while(q--)
            {
                int type;
                scanf("%d",&type);
                if(type==0)// set all numbers to val
                {
                    int x,y,val;
                    scanf("%d%d%d",&x,&y,&val);
                    x--;y--;
                    update0(1,0,n-1,x,y,val);

                }
                else if(type==1)
                {
                    int x,y,val;
                    scanf("%d%d%d",&x,&y,&val);
                    x--;y--;
                    update1(1,0,n-1,x,y,val);
                }
                else if(type==2)//sum of squares
                {
                    int x,y;
                    scanf("%d%d",&x,&y);
                    x--;y--;

                    printf("%lld\n",query(1,0,n-1,x,y));
                }
            }

        }

        return 0;
    }





