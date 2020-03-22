public int checkRecord(int n) {
    int _MOD = 1000000007;
    long dp00, dp01, dp02, dp10, dp11, dp12;
    dp00 = dp01 = dp10 = 1;
    dp11 = dp02 = dp12 = 0;
    for (int i = 2; i <= n; i++) {
        long t00 = dp00, t01 = dp01, t02 = dp02, t10 = dp10, t11 = dp11, t12 = dp12;
        // +P
        // 0A0L = 0A0L + 0A1L + 0A2L
        dp00 = (t00 + t01 + t02) % _MOD;
        // 1A0L = 1A0L + 1A1L + 1A2L
        dp10 = (t10 + t11 + t12) % _MOD;
        // +L
        // 0A1L = 0A0L
        dp01 = t00;
        // 0A2L = 0A1L
        dp02 = t01;
        // 1A1L = 1A0L
        dp11 = t10;
        // 1A2L = 1A1L
        dp12 = t11;
        // +A
        // 1A0L = 0A0L + 0A1L + 0A2L
        dp10 += (t00 + t01 + t02) % _MOD;
    }
    return (int) ((dp00 + dp01 + dp02 + dp10 + dp11 + dp12) % _MOD);
}
