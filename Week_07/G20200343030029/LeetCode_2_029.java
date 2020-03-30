class LeetCode_2_029{
	public boolean isPowerOfTwo1(int n) {
		if(n == 0) {
			return 0;
		}

		long x = (long) n;

		return (x & (x - 1)) == 0;
	}

	public boolean isPowerOfTwo2(int n) {
		if(n == 0) {
			return false;
		}

		while (n % 2 == 0) {
			n = n / 2;
		}

		return n == 1;
	}
}
