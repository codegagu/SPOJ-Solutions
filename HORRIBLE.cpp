


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
        ll sum;
        ll lazy;
        int left;
        int right;
    };

    node st[100000*4];

    void build_tree(int id,int l,int r)
    {
        if(l==r)
        {
            st[id].sum=st[id].lazy=0;
            st[id].left=st[id].right=l;
        }
        else if(l<=r)
        {
            int mid=(l+r)/2;
            build_tree(2*id,l,mid);
            build_tree(2*id+1,mid+1,r);

            st[id].sum=st[id].lazy=0;
            st[id].left=l;
            st[id].right=r;
        }
    }

    void update(int id,int l,int r,int x,int y,ll val)
    {
        if(st[id].lazy!=0)//this node requires to be updated
        {
            ll value=st[id].lazy;
            st[id].sum+=value*(r-l+1);

            if(st[id].left!=st[id].right)//if its not a leaf
            {
                st[2*id].lazy+=value;
                st[2*id+1].lazy+=value;
            }
            st[id].lazy=0;//Reseting
        }

        if(r<x || y<l)
            return ;

        if(l>=x && r<=y)//complete overlap
        {
            st[id].sum+=(r-l+1)*val;

            if(st[id].left!=st[id].right)//if its not a leaf
            {
                st[2*id].lazy+=val;
                st[2*id+1].lazy+=val;
            }
            return;
        }
        else if(l<x && r>=x)
        {
            st[id].sum+=val*(r-x+1);
        }
        else if(l<=y && r>y)
        {
            st[id].sum+=val*(y-l+1);
        }

        int mid=(l+r)/2;
        update(2*id,l,mid,x,y,val);
        update(2*id+1,mid+1,r,x,y,val);
        st[id].sum=st[2*id].sum+st[2*id+1].sum;

    }

    ll query(int id,int l,int r,int x,int y)
    {
        if(st[id].lazy!=0)//this node requires to be updated
        {
            ll value=st[id].lazy;
            st[id].sum+=value*(r-l+1);

            if(st[id].left!=st[id].right)//if its not a leaf
            {
                st[2*id].lazy+=value;
                st[2*id+1].lazy+=value;
            }
            st[id].lazy=0;//Reseting
        }

        if(r<x || y<l)
            return 0;

        if(l>=x && r<=y)//complete overlap
        {
            return st[id].sum;
        }

        int mid=(l+r)/2;
        return query(2*id,l,mid,x,y)+query(2*id+1,mid+1,r,x,y);

    }


    int main()
    {
        int t;
        scanf("%d",&t);
        while(t--)
        {
            int n,c;
            scanf("%d%d",&n,&c);
            memset(st,0,n+1);

            build_tree(1,0,n-1);
            while(c--)
            {
                int type;
                scanf("%d",&type);
                if(type==0)
                {
                    int p,q;
                    ll val;
                    scanf("%d%d%lld",&p,&q,&val);
                    p--;q--;
                    update(1,0,n-1,p,q,val);
                }
                else if(type==1)
                {
                    int p,q;
                    scanf("%d%d",&p,&q);
                    p--;q--;
                    printf("%lld\n",query(1,0,n-1,p,q));

                }
            }

        }

        return 0;
    }





