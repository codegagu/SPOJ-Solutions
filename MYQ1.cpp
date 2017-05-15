
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


    int main()
    {
        int t;
        scanf("%d",&t);
        while(t--)
        {
            int n;
            scanf("%d",&n);
            if(n==1)
            {
                cout<<"poor conductor"<<endl;
                continue;
            }
            else
            {
                n--;
                int row;

                if(n%5)
                    row=(n/5)+1;
                else
                    row=n/5;

                if(row&1)//row is odd increasing seq
                {
                    int x=n%5;
                    int a=row;
                    switch(x)
                    {
                        case 1:
                            {
                                printf("%d W L\n",a);
                                                     break;
                            }
                        case 2:
                            {
                                printf("%d A L\n",a);
                                                     break;
                            }
                        case 3:
                            {
                                printf("%d A R\n",a);
                                                     break;
                            }
                        case 4:
                            {
                                printf("%d M R\n",a);
                                                     break;
                            }
                        case 0:
                            {
                                printf("%d W R\n",a);
                                                    break;
                            }
                    }
                }
                else
                {
                    int x=n%5;
                    int a=row;
                    switch(x)
                    {
                        case 1:
                            {
                                printf("%d W R\n",a);
                                                     break;
                            }
                        case 2:
                            {
                                printf("%d M R\n",a);
                                                     break;
                            }
                        case 3:
                            {
                                printf("%d A R\n",a);
                                                     break;
                            }
                        case 4:
                            {
                                printf("%d A L\n",a);
                                                     break;
                            }
                        case 0:
                            {
                                printf("%d W L\n",a);
                                                    break;
                            }
                    }
                }



            }

        }

        return 0;
    }




