


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
        int sum;
        int lsum;
        int rsum;
        int msum;
    };

    int arr[50000+10];
    node st[4*50000];

    inline int maxx(int a,int b,int c)
    {
        if(a>b && a>c)
            return a;
        if(b>c)
            return b;
        return c;
    }

    node combine(node A,node B)
    {
        node res;
        res.sum=A.sum+B.sum;
        res.lsum=max(A.lsum,A.sum+B.lsum);
        res.rsum=max(B.rsum,B.sum+A.rsum);
        res.msum=maxx(A.msum,B.msum,A.rsum+B.lsum);
        return res;
    }

    node build_tree(int id,int l,int r)
    {
        if(l==r)
        {
            st[id].sum=st[id].msum=st[id].lsum=st[id].rsum=arr[l];
            return st[id];
        }
        else
        {
            int mid=(l+r)/2;
            build_tree(2*id,l,mid);
            build_tree(2*id+1,1+mid,r);
            st[id]=combine(st[2*id],st[2*id+1]);
        }
    }

    node query(int id,int l,int r,int x,int y)
    {
        if(l==x && r==y)
            return st[id];
        int mid=(l+r)/2;
        if(y<=mid)
            return query(2*id,l,mid,x,y);
        else if(x>mid)
            return query(2*id+1,mid+1,r,x,y);
        else
        {
            node one=query(2*id,l,mid,x,mid);
            node two=query(2*id+1,mid+1,r,mid+1,y);
            node res=combine(one,two);
            return res;
        }
    }

    void update(int id,int l,int r,int pos,int val)
    {
        if(l==r && l==pos)
        {
            st[id].lsum=st[id].msum=st[id].rsum=st[id].sum=val;
            return;
        }

        int mid=(l+r)/2;
        if(pos<=mid)
            update(2*id  ,l,mid,pos,val);
        else
            update(2*id+1,mid+1,r,pos,val);

        st[id]=combine(st[2*id],st[2*id+1]);

    }

    int main()
    {
        int n,q,type;
        scanf("%d",&n);
        for(int i=0;i<n;i++)
            scanf("%d",&arr[i]);

        build_tree(1,0,n-1);

        scanf("%d",&q);
        while(q--)
        {
            int x,y;
            scanf("%d%d",&x,&y);



                node ans=query(1,0,n-1,--x,--y);
                printf("%d\n",ans.msum);

        }

        return 0;
    }




