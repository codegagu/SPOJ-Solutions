
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
        int parity;
        int light_count;
        int left,right;
    };

    node st[4*100000];
    int lazy[4*100000];
    int arr[100000+10];

    void build_tree(int id,int l,int r)
    {
        if(l==r)
        {
            st[id].left=st[id].right=l;
            st[id].parity=0;
            st[id].light_count=0;
        }
        else if(l<r)
        {
            int mid=(l+r)/2;
            build_tree(2*id,l,mid);
            build_tree(2*id+1,mid+1,r);

            st[id].left=l;            st[id].right=r;
            st[id].light_count=st[2*id].parity+st[2*id+1].parity;
        }
    }

    void st_apply(int id)
    {
        lazy[id]=0;

        int range=st[id].right-st[id].left+1;
        st[id].light_count=range-st[id].light_count;

        if(st[id].left!=st[id].right)//not a leaf
        {
            lazy[2*id]=!lazy[2*id];
            lazy[2*id+1]=!lazy[2*id+1];
        }
    }

    int query(int id,int l,int r,int x,int y)
    {
        if(lazy[id]==1)
        {
            st_apply(id);
        }

        if(r<x || y<l)
            return 0;

        if(l>=x && r<=y)// if there is a complete overlap
        {
            return st[id].light_count;
        }
        else
        {
            int mid=(l+r)/2;
            int s1=query(2*id,l,mid,x,y);
            int s2=query(2*id+1,mid+1,r,x,y);
            return (s1+s2);
        }
    }

    void update(int id,int l,int r,int x,int y)
    {
        if(lazy[id]==1)
        {
            st_apply(id);
        }

        if(r<x || y<l)
            return;

        if(l>=x && r<=y)// if there is a complete overlap
        {
            lazy[id]=1;
            st_apply(id);
            return;
        }
        else
        {
            int mid=(l+r)/2;
            update(2*id,l,mid,x,y);
            update(2*id+1,mid+1,r,x,y);

            st[id].light_count=st[2*id].light_count+st[2*id+1].light_count;
        }

    }

    int main()
    {
        int n,m;
        scanf("%d%d",&n,&m);

        build_tree(1,0,n-1);

        while(m--)
        {
            int type,x,y;
            scanf("%d%d%d",&type,&x,&y);

            if(!(type&1))// update
            {
                x--;y--;
                update(1,0,n-1,x,y);

            }
            else        // query
            {
                x--;y--;
                printf("%d\n",query(1,0,n-1,x,y));
            }
        }



        return 0;
    }
