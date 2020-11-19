package bibliotecaweb.utils;

import java.util.List;

public class Utils {

	public static boolean isNullOrEmpty(Object o) {
		boolean ret = false;
		if (o == null) { return true; };
		if (o instanceof String) { return ((String) o).isEmpty(); }
		if (o instanceof List) { return ((List<?>) o).isEmpty(); }
		return ret;
	}
}
