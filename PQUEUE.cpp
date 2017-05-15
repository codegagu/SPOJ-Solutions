
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
        int t;
        scanf("%d",&t);
        while(t--)
        {
            int n,pos;
            int jp;
            scanf("%d%d",&n,&pos);

            priority_queue<pii> pq;
            queue<pii> normalqueue;

            for(int i=0;i<n;i++)
            {
                scanf("%d",&jp);
                pq.push(pii(jp,i));
                normalqueue.push(pii(jp,i));
            }

            int big=pq.top().ff;
            int big_pos=pq.top().ss;
            int counter=0;

            while(!normalqueue.empty())
            {
                pii hold=normalqueue.front();
                normalqueue.pop();

                if(hold.ss==big_pos || hold.ff==big)
                {
                    counter++;
                    pq.pop();

                    if(hold.ss==pos)
                        break;

                    //cout<<" berolo "<<big<<" "<<big_pos<<" hold.ss "<<hold.ss<<" counter "<<counter<<endl;

                    big=pq.top().ff;
                    big_pos=pq.top().ss;
                }
                else
                {
                    //cout<<"pichone thello "<<hold.ff<<endl;
                    normalqueue.push(hold);
                }

            }

            printf("%d\n",counter);

        }
        return 0;
    }
