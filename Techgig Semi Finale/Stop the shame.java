/* Read input from STDIN. Print your output to STDOUT*/
#include <math.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <assert.h>
#include <limits.h>
#include <stdbool.h>

#include <bits/stdc++.h>
#include <ext/pb_ds/assoc_container.hpp>
#include <ext/pb_ds/tree_policy.hpp>
using namespace std;
using namespace __gnu_pbds;
#define ll long long 
#define candid_code(i,N) for (int i=0;i<N;i++)
typedef tree<int,null_type,less<int>,rb_tree_tag,tree_order_statistics_node_update> ordered_set;
#define vl vector<ll>

int main()
{
   ll N,P;
   cin>>N>>P;
   vl vec(N);
   ordered_set candidcodes;
   map<ll,ll> ak;
   candid_code(i,N) {
      cin>>vec[i];
      if(ak[vec[i]]==0) {
        candidcodes.insert(vec[i]);
        ak[vec[i]] = 1;
   }
 }
    vl tele(P);
    candid_code(i,P){
       int x;
       cin>>x;
    if(ak[x]==0) {
      candidcodes.insert(x);
      ak[x] = 1;
    }
   cout<<candidcodes.size()- candidcodes.order_of_key(x)<<endl;
  }
}
