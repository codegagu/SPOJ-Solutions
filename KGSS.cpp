

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

    struct node
    {
        ll maxx;
        ll minn;
    };

    node st[4*100000];
    ll arr[100000+10];


    void build_tree(int id,int l,int r)
    {
        if(l==r)
        {
            st[id].maxx=arr[l];
            st[id].minn=0;
        }
        else if(l<r)
        {
            int mid=(l+r)/2;
            build_tree(2*id,l,mid);
            build_tree(2*id+1,1+mid,r);

            int ar[4];
            ar[0]=st[2*id].maxx;
            ar[1]=st[2*id].minn;
            ar[2]=st[2*id+1].maxx;
            ar[3]=st[2*id+1].minn;
            sort(ar,ar+4);
            st[id].maxx=ar[3];
            st[id].minn=ar[2];
        }
    }

    node query(int id,int l,int r,int x,int y)
    {

        if(l>=x && r<=y)
            return st[id];

        int mid=(l+r)/2;

        if(mid>=y)
            return query(2*id,l,mid,x,y);
        else if(mid<x)
            return query(2*id+1,mid+1,r,x,y);
        else
        {
            node one=query(2*id,l,mid,x,mid);
            node two=query(2*id+1,mid+1,r,mid+1,y);
            int ar[4];
            ar[0]=one.maxx;
            ar[1]=one.minn;
            ar[2]=two.maxx;
            ar[3]=two.minn;
            sort(ar,ar+4);
            node ans;
            ans.maxx=ar[3];
            ans.minn=ar[2];
            return ans;
        }


    }

    void update(int id,int l,int r,int pos,int value)
    {
        if(l>r)return;

        if(l==r && l==pos)//leaf we need
        {
            st[id].maxx=value;
            st[id].minn=0;
            return;
        }
        int mid=(l+r)/2;

        if(mid>=pos)
            update(2*id,l,mid,pos,value);
        else if(mid<pos)
            update(2*id+1,mid+1,r,pos,value);

        int ar[4];
        ar[0]=st[2*id].maxx;
        ar[1]=st[2*id].minn;
        ar[2]=st[2*id+1].maxx;
        ar[3]=st[2*id+1].minn;
        sort(ar,ar+4);

        st[id].maxx=ar[3];
        st[id].minn=ar[2];

    }

    int main()
    {
        int n,q;
        scanf("%d",&n);
        memset(arr,0,n+1);

        for(int i=0;i<n;i++)
            scanf("%d",&arr[i]);

        build_tree(1,0,n-1);

        scanf("%d",&q);
        while(q--)
        {
            char type;
            cin>>type;
            if(type=='Q')//query
            {
                int x,y;
                scanf("%d%d",&x,&y);
                x--;y--;

                node N=query(1,0,n-1,x,y);
                ll ans=N.maxx+N.minn;
                printf("%lld\n",ans);

            }
            else
            {
                int pos,value;
                scanf("%d%d",&pos,&value);
                pos--;
                update(1,0,n-1,pos,value);
            }
        }


        return 0;
    }





