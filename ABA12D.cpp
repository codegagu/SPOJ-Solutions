
#include <bits/stdc++.h>
using namespace std;
#define N 1000000


int divisorSum[N+1];
bool isPrime[N+1];

int X[N+1];
int Cumulative[N+1];

void pre()
{
    int pos=0;
    for(int i=2;i<=N;i++)
    {
        if(isPrime[i])
        {

            divisorSum[i]=i+1;

            for(int j=i+i ; j<=N ; j+=i)
            {
                isPrime[j]=false;
                divisorSum[j]+=i;
            }
        }
        else
        {
            divisorSum[i]+=(i+1);

            for(int j=i+i ; j<=N ; j+=i)
            {
                divisorSum[j]+=i;
            }
        }
    }

    isPrime[0]=isPrime[1]=false;
    divisorSum[0]=0;divisorSum[1]=1;
    //cumulative

    for(int i=2;i<=N;i++)
        if( isPrime[divisorSum[i]] )
            X[i]=1;

    for(int i=2;i<=N;i++)
        Cumulative[i]=Cumulative[i-1]+X[i];
/*
    for(int i=0;i<=10;i++)
        cout<<X[i]<<" "<< Cumulative[i]<<endl;
*/

}


int main()
{
    memset(isPrime, true , sizeof isPrime);
    pre();


    int counter=0;
    int t,L,R;
    scanf("%d",&t);
    while(t--)
    {
        scanf("%d%d",&L,&R);

            int ans=Cumulative[R]-Cumulative[L-1];
            cout<<ans<<endl;

    }

    return 0;
}
