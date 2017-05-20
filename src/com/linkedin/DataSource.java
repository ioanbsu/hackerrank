package com.linkedin;

/**
 * Created by ibahdanau on 5/15/17.
 */
public interface DataSource<K, T extends Rankable> {
    T get (K key);
}