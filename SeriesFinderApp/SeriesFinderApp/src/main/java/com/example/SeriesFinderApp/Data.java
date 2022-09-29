package com.example.SeriesFinderApp;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * DATA class for storing sequence & first-term & difference & ratio & number of terms
 */
public class Data {

    public BigDecimal[] sequence;

    public Data(BigDecimal[] sequence) {
        this.sequence = sequence;
    }

    public final BigDecimal firstTerm (){
        return sequence[0];
    }
    public final BigDecimal commonDifference(){
        return  sequence[1].subtract(sequence[0]);
    }


    public final BigDecimal numberOfTerms(){
        return BigDecimal.valueOf(sequence.length);
    }

    public final BigDecimal commonRatio(){
        return sequence[1].divide(sequence[0], 4, RoundingMode.HALF_UP);
    }
}
