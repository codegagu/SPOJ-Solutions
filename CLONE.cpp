
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

        while(true)
        {
                int n,m;
                scanf("%d%d",&n,&m);

                if(n==0 && m==0)
                    break;

                map<string , int> map1;
                map< int , int > map2;
                string seq;

                map<string,int> :: iterator it;

                for(int i=0;i<n;i++)
                {
                    cin>>seq;
                    it=map1.find(seq);
                    if(it==map1.end())// not there
                    {
                        map1.insert(make_pair<string,int>(seq,1));
                    }
                    else
                    {
                        int val=it->ss;
                        map1.erase(it);
                        map1.insert(make_pair<string,int>(seq,val+1));
                    }
                }

                int arr[n+1];
                for(int i=0;i<=n;i++)
                    arr[i]=0;

                for(it=map1.begin();it!=map1.end();it++)
                {
                    int counter=0;
                    counter=it->ss;
                    //cout<<"counter "<<counter<<endl;
                    arr[counter]++;
                }

                for(int i=1;i<=n;i++)
                    printf("%d\n",arr[i]);


        }


        return 0;
    }


