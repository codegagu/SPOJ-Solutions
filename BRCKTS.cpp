

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
        int sum,min;
    };

    node tree[30000*4];
    int A[30000+10];


    void build_tree(int id,int l,int r)
    {
        if(l==r){
            tree[id].sum=tree[id].min=A[l];
        }
        else if(l<r){
            int mid=(l+r)/2;
            build_tree(2*id,l,mid);
            build_tree(2*id+1,1+mid,r);

            tree[id].sum=tree[2*id].sum+tree[2*id+1].sum;
            tree[id].min=min(tree[2*id].min,tree[2*id].sum+tree[2*id+1].min);
        }
    }

    void update(int id,int l,int r,int pos)
    {
        if(l==r){
            tree[id].sum*=-1;
            tree[id].min=tree[id].sum;
        }
        else if(l<r){
            int mid=(l+r)/2;

            if(pos<=mid)
                update(2*id,l,mid,pos);
            else
                update(2*id+1,1+mid,r,pos);

            tree[id].sum=tree[2*id].sum+tree[2*id+1].sum;
            tree[id].min=min(tree[2*id].min,tree[2*id].sum+tree[2*id+1].min);

        }
    }

    int main()
    {
        int t=10;
        char str[30000+10];
        for(int k=1;k<=t;k++)
        {
            int n;
            scanf("%d",&n);
            scanf("%s",str);

            for(int i=0;i<n;i++)
            {
                if(str[i]=='(')
                    A[i]=1;
                else
                    A[i]=-1;
            }


            build_tree(1,0,n-1);

            int q;
            scanf("%d",&q);
            printf("Test %d:\n",k);
            while(q--)
            {
                int type;
                scanf("%d",&type);
                if(type==0)
                {
                    if(tree[1].sum==0 && tree[1].min==0)
                        printf("YES\n");
                    else
                        printf("NO\n");
                }
                else
                {
                    type--;
                    update(1,0,n-1,type);
                }
            }

        }

        return 0;
    }





