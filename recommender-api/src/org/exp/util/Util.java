/**
 * org.exp.util
 * 
 * @author Mohamed Sahad KP,  Nov 12, 2016
 */

package org.exp.util;

public class Util {

	// Check null
	public static final boolean equalsWithNull(Object a, Object b) {
		if (a == b) {
			return true;
		}
		if ((a == null) || (b == null)) {
			return false;
		}
		return a.equals(b);
	}
}
