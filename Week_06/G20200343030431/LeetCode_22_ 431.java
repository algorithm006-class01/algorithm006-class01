package thread;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.ArrayList;
import java.util.List;

public class SolutionX {
	public List<String> generateParentthesis(int n) {
		if (n == 0) {
			return new ArrayList<>();
		}
		List<List<String>> dp = new ArrayList<>(n);
		List<String> dp0 = new ArrayList<>();
		dp0.add("");
		dp.add(dp0);

		for (int i = 1; i <= n; i++) {
			List<String> cur = new ArrayList<>();
			for (int j = 0; j < i; j++) {
				List<String> strl = dp.get(j);
				List<String> str2 = dp.get(i - 1 - j);
				for (String sl : strl) {
					for (String s2 : str2) {
						cur.add("(" + sl + ")" + s2);
					}
				}
			}
			dp.add(cur);
		}
		return dp.get(n);
	}
}
