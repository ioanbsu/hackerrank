package com.linkedin;

/**
 * Created by ibahdanau on 5/15/17.
 */
public interface Rankable {
    /**
     * Returns the Rank of this object, using some algorithm and potentially
     * the internal state of the Rankable.
     */
    long getRank();

}
