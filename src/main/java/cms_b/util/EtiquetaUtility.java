package cms_b.util;

import java.util.List;

public class EtiquetaUtility {

	  public static boolean isNullOrEmpty(String param) {
		    return param == null || param.trim().length() == 0;
		  }

		  public static boolean isNullOrEmpty(List<?> element) {
		    return element == null || element.isEmpty();
		  }
}
