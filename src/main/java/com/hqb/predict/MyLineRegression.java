package com.hqb.predict;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 最小二乘法
 * @author coshaho
 *
 */
public class MyLineRegression
{

    public Map<String, Double> lineRegression(double[] X, double[] Y)
    {
        if(null == X || null == Y || 0 == X.length
                || 0 == Y.length || X.length != Y.length)
        {
            throw new RuntimeException();
        }

        // x平方差和
        double Sxx = varianceSum(X);
        // y平方差和
        double Syy = varianceSum(Y);
        // xy协方差和
        double Sxy = covarianceSum(X, Y);

        double xAvg = arraySum(X) / X.length;
        double yAvg = arraySum(Y) / Y.length;

        double a = Sxy / Sxx;
        double b = yAvg - a * xAvg;

        // 相关系数
        double r = Sxy / Math.sqrt(Sxx * Syy);
        Map<String, Double> result = new HashMap<>();
        result.put("a", a);
        result.put("b", b);
        result.put("r", r);

        return result;
    }


    private double varianceSum(double[] X)
    {
        double xAvg = arraySum(X) / X.length;
        return arraySqSum(arrayMinus(X, xAvg));
    }


    private double covarianceSum(double[] X, double[] Y)
    {
        double xAvg = arraySum(X) / X.length;
        double yAvg = arraySum(Y) / Y.length;
        return arrayMulSum(arrayMinus(X, xAvg), arrayMinus(Y, yAvg));
    }


    private double[] arrayMinus(double[] X, double x)
    {
        int n = X.length;
        double[] result = new double[n];
        for(int i = 0; i < n; i++)
        {
            result[i] = X[i] - x;
        }

        return result;
    }

    private double arraySum(double[] X)
    {
        double s = 0 ;
        for( double x : X )
        {
            s = s + x ;
        }
        return s ;
    }


    private double arraySqSum(double[] X)
    {
        double s = 0 ;
        for( double x : X )
        {
            s = s + Math.pow(x, 2) ; ;
        }
        return s ;
    }


    private double arrayMulSum(double[] X, double[] Y)
    {
        double s = 0 ;
        for( int i = 0 ; i < X.length ; i++ )
        {
            s = s + X[i] * Y[i] ;
        }
        return s ;
    }


}