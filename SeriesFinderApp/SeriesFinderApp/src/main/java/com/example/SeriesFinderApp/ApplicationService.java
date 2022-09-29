package com.example.SeriesFinderApp;

import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.math.RoundingMode;


@Service
public class ApplicationService {


    /**
     *
     * @param sequence Entered by user
     *    Checks  the sequence, If the series is  Arithmetic Series Or not
     * @return If it is then calls the ArithmeticSum Method for calculation of sum
     */
    public BigDecimal arithmetic (BigDecimal[] sequence){

        Data data = new Data(sequence);

        if (sequence == null || sequence.length == 0 ) {
            return  BigDecimal.ZERO;
        }
        if(sequence.length == 1){
            return sequence[0];
        }
        for (int i = 2; i < sequence.length; i++) {
            if (!(sequence[i].subtract(sequence[i - 1])).equals(data.commonDifference())) {
                return BigDecimal.ZERO;
            }
        }
        return  arithmeticSum(data.firstTerm(),data.commonDifference(),data.numberOfTerms());
    }
    /**
     *
     * @param firstTerm  First term of the sequence
     * @param commonDifference  of the sequence
     * @param numberOfTerms  of the sequence
     * @return Sum of  Arithmetic Series
     */
    public BigDecimal arithmeticSum(BigDecimal firstTerm, BigDecimal commonDifference, BigDecimal numberOfTerms){
        BigDecimal sum;
        sum = ((numberOfTerms.divide(BigDecimal.valueOf(2),4,RoundingMode.HALF_UP))).multiply((BigDecimal.valueOf(2).multiply(firstTerm) .add(numberOfTerms.subtract(BigDecimal.ONE) ).multiply(commonDifference)));
        return sum;
    }

    /**
     *
     * @param sequence Entered by user
     *    Checks  the sequence, If the series is Geometric Or not
     * @return If it is then calls the GeometricSum Method for calculation of sum
     */
    public BigDecimal geometric(BigDecimal[] sequence) {

        Data data = new Data(sequence);

        if (sequence == null || sequence.length == 0 ) {
            return  BigDecimal.ZERO;
        }
        if(sequence.length == 1){
            return sequence[0];
        }
        for (int i = 2; i < sequence.length; i++) {
            if (!(sequence[i].divide(sequence[i - 1],4,RoundingMode.HALF_UP)).equals(data.commonRatio())) {
                return BigDecimal.ZERO;
            }
        }
        return  geometricSum(data.firstTerm(),data.commonRatio(),data.numberOfTerms());
    }
    /**
     *
     * @param firstTerm First term of the sequence
     * @param commonRatio of the sequence
     * @param numberOfTerms of the sequence
     * @return  Sum of Geometric Series
     */
    public BigDecimal geometricSum(BigDecimal firstTerm, BigDecimal commonRatio, BigDecimal numberOfTerms){
        BigDecimal sum;
        sum = firstTerm.multiply(BigDecimal.ONE.subtract(commonRatio.pow(numberOfTerms.intValue()))).divide(BigDecimal.ONE.subtract(commonRatio), 4, RoundingMode.HALF_UP);
        return sum;
    }


}
