def reconstructing_arrays(N,K,S):
    mod = 10**9+7
    dp = [0]*(N+1)
    dp[0]=1

    for i in range(1,N+1):
        for j in range(1,min(i+1,10)):
           if S[i-j] != '0' and int (S[i-j:i])<=k:
              dp[i] = dp([i]+dp[i-j])%mod 
    return dp[N]

N,K = map(int,input().split())
S = input().strip()
result = reconstructing_arrays(N,K,S)
print(result)
