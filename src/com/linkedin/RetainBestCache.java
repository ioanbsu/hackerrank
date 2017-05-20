package com.linkedin;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

interface RankObserver<T> {

    void addListener(RankListener<T> listener);
}

interface RankListener<T> {
    void rankChanged(T currentValue, int newRRank);
}

/**
 * Created by ibahdanau on 5/15/17.
 */
public class RetainBestCache<K, T extends Rankable> {

    private DataSource<K, T> dataSource;
    private int entriesToRetain;

    private Map<K, T> cachedData = new HashMap<>();
    private Map<T, Set<K>> reverseCacheData = new TreeMap<>(Comparator.comparingLong(Rankable::getRank));

    /* Constructor with a data source (assumed to be slow) and a cache size */
    public RetainBestCache(DataSource<K, T> ds, int entriesToRetain, final RankObserver<T> rankObserver) {
        // Implementation here
        if (entriesToRetain <= 0) {
            throw new IllegalArgumentException("The cache size can only be positive");
        }
        this.dataSource = ds;
        this.entriesToRetain = entriesToRetain;
        rankObserver.addListener((currentValue, newRRank) -> {/**/});
    }

    /* Gets some data. If possible, retrieves it from cache to be fast. If the data is not cached,
     * retrieves it from the data source. If the cache is full, attempt to cache the returned data,
     * evicting the T with lowest rank among the ones that it has available
     * If there is a tie, the cache may choose any T with lowest rank to evict.
     */
    public T get(K key) {
        // Implementation here
        if (key == null) {
            throw new IllegalArgumentException("The key can not be null");
        }
        T value = cachedData.get(key);
        if (value != null) {
            return value;
        }

        value = dataSource.get(key);
        if (value != null) {
            cachedData.put(key, value);

            //populate data to reverse map
            Set<K> keyFromReverse = reverseCacheData.get(value);
            if (keyFromReverse == null) {
                keyFromReverse = new HashSet<>();
            }
            keyFromReverse.add(key);
            reverseCacheData.put(value, keyFromReverse);

            checkAndEvictOverflowValues();
        }
        return value;
    }

    private void checkAndEvictOverflowValues() {
        if (cachedData.size() > entriesToRetain) {
            T valueToEvict = reverseCacheData.keySet().iterator().next();
            Set<K> keysToEvict = reverseCacheData.get(valueToEvict);
            for (K key : keysToEvict) {
                cachedData.remove(key);
            }
            reverseCacheData.remove(valueToEvict);
            checkAndEvictOverflowValues();
        }
    }
}
