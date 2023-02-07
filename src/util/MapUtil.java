package util;

import java.util.*;
import java.util.Map.Entry;

public class MapUtil {
	/**
	 * sort a map by descending value
	 * @param <K> the type of the keys of the map
	 * @param <V> the type of the values of the map
	 * @param map the map to sort
	 * @return the map sorted in descending way
	 */
	public static <K,V extends Comparable <?super V>> Map <K,V> sortByDescendingValue(Map<K,V> map){
		List<Entry<K, V>> sortedEntries = new ArrayList<Entry<K, V>>(map. entrySet ( )) ;
		Collections . sort ( sortedEntries , new Comparator<Entry<K, V>>() {
			@Override
			public int compare(Entry<K, V> e1 , Entry<K, V> e2) {
				return e2 . getValue ( ) .compareTo(e1 . getValue ( ) ) ;
			}
		});
		
		
			Map<K, V> result = new LinkedHashMap<>();
			for (Entry<K, V> entry : sortedEntries ) {
				result.put( entry . getKey () , entry . getValue ( ) ) ;
			}
			return result ;
		}

}
