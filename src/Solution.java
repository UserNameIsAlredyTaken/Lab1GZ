import java.util.Arrays;

/**
 * Created by danil on 15.09.2017.
 */
public class Solution{
    public static boolean checkDiagDomin(double[][] a){
        boolean allAreBigger = true;
        boolean oneIsStrictBigger = false;
        for(int i=0; i<Values.size; i++){
            double sumAbs=0;
            for(int j=0; j<Values.size; j++){
                if(i!=j){
                    sumAbs+=Math.abs(a[i][j]);
                }
            }
            if(Math.abs(a[i][i])<sumAbs){
                allAreBigger = false;
                break;
            }else if(Math.abs(a[i][i])>sumAbs){
                oneIsStrictBigger = true;
            }
        }
        return allAreBigger&&oneIsStrictBigger;
    }
    private static boolean enough(double[] xToday, double[] xYesterday, double acc, Result res){
        double sqrSum = 0;
        for(int i = 0;i<Values.size;i++){
            sqrSum+=Math.pow(xToday[i]-xYesterday[i],2);
        }
        res.errors[res.iterCount]=Math.sqrt(sqrSum);
        if(res.errors[res.iterCount]>=acc){
            return false;
        }
        return true;
    }
    public static Result solve(int n, double[][] a, double[] b, double acc, Result res){
        double[] xToday = new double[n];
        double[] xYesterday = new double[n];
        while(!enough(xToday, xYesterday, acc, res)){
            res.iterCount++;
            xYesterday= Arrays.copyOf(xToday, n);
            for(int i = 0; i<n; i++){
                double multiplicationsSum = 0;
                for(int j = 0; j<i; j++){
                    multiplicationsSum+=(a[i][j]*xToday[j]);
                }
                for(int j = i+1; j<n;j++){
                    multiplicationsSum+=(a[i][j]*xYesterday[j]);
                }
                xToday[i]=(b[i]-multiplicationsSum)/a[i][i];
            }
        }
        res.x=xToday;
        return res;
    }
}
