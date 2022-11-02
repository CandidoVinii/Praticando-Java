package utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Utils {

	static NumberFormat formaterValue = new DecimalFormat("R$ #,##0.00");
	
	public static String doubleToString(Double value) {
		return formaterValue.format(value);
	}
}
