

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

    int arr[10000+10];

    struct node
    {
        int msum;
        int rsum;
        int lsum;
        int sum;
    };

    node st[4*10000];

    inline int maxx(int a ,int b,int c)
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

    void build_tree(int id,int l,int r)
    {
        if(l==r)
        {
            st[id].sum=st[id].msum=st[id].lsum=st[id].rsum=arr[l];
            //return st[id];
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


    int main()
    {
        int t;
        scanf("%d",&t);
        while(t--)
        {
            int n;
            scanf("%d",&n);

            for(int i=0;i<n;i++)
                scanf("%d",&arr[i]);

            build_tree(1,0,n-1);

            //for(int i=1;i<=13;i++)
            //{
              //  cout<<i<<" lolwa "<<st[i].sum<<endl;
            //}


            int q;
            scanf("%d",&q);
            while(q--)
            {
                int x1,y1,x2,y2;
                scanf("%d%d%d%d",&x1,&y1,&x2,&y2);
                x1--;y1--;x2--;y2--;
                if(y1<x2)
                {
                    int ans=query(1,0,n-1,y1,x2).sum;
                    if(x1+1<=y1)ans+=max(0,query(1,0,n-1,x1,y1-1).rsum);
                    if(x2+1<=y2)ans+=max(0,query(1,0,n-1,x2+1,y2).lsum);
                    printf("%d\n",ans);
                }
                else
                {
                    int a=arr[x2];
                    if(x1+1<=x2)a+=max(0,query(1,0,n-1,x1,x2-1).rsum);
                    if(x2+1<=y2)a+=max(0,query(1,0,n-1,x2+1,y2).lsum);

                    int b=arr[y1];
                    if(x1+1<=y1)b+=max(0,query(1,0,n-1,x1,y1-1).rsum);
                    if(y1+1<=y2)b+=max(0,query(1,0,n-1,y1+1,y2).lsum);

                    int c = query(1,0,n-1,x2,y1).msum;
                    int ans = max(max(a,b),c);

                    printf("%d\n",ans);
                }
            }
        }

        return 0;
    }





