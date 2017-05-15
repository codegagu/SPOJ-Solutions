

#include<bits/stdc++.h>
using namespace std;

#define N 10000001

int F[N];
long long res[N];


void preprocess()
{
    res[0]=res[1]=0;
    for(int i=2;i<N;i++)
    {
        if(F[i]==0)//not seen
        {
            F[i]=i;
            res[i]=res[i-1]+F[i];
            for(int j=i+i;j<N;j+=i){
                if(F[j]==0)
                    F[j]=i;
            }
        }
        else
            res[i]=res[i-1]+F[i];
    }
}

int main()
{
    preprocess();
    int t;
    cin>>t;
    while(t--){
        int d;
        cin>>d;
        cout<<res[d]<<endl;
    }

    return 0;
}
