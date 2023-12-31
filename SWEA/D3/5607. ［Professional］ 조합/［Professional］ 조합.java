import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int mod = 1234567891;
	static long factorial[] = new long[1000001];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case=1; test_case<=T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			
			long answer = nCr(N, R, mod);
			
			System.out.println("#"+test_case+" "+answer);
		}
	

	}

	private static long nCr(int n, int r, int mod) {
		if(r==0) return 1L;
		long[] fac = new long[n+1];
		fac[0] = 1;
		
		for(int i=1; i<=n; i++) {
			fac[i] = fac[i-1]*i%mod;			
		}
		
		return (fac[n]*power(fac[r], mod-2, mod)%mod*power(fac[n-r], mod-2, mod)%mod)%mod;
	}

	private static long power(long x, long y, long mod) {
		long res = 1L;
		x = x%mod;
		
		while(y>0) {
			if(y%2 == 1) res = (res*x)%mod;
			y = y/2;
			x = (x*x)%mod;
		}
		return res;
	}

}
