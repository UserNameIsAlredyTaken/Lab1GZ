import java.util.Arrays;

/**
 * Created by danil on 15.09.2017.
 */
public class Solution{
    private static boolean unposibleToDiagDom=false;
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
    /*составляет массив с индексами элементов,
     *превышающих сумму модулейостальных элементов строки,
     *если такого нет, то -1
     *если хотябы один из элементов= -1
     *или не один из них не строго больше модульной суммы в своём ряду, то unposibleToDiagmDom=true*/
    private static int[] greatestInTheRow(double[][] a){
        boolean oneIsStrictBigger=false;
        int[] greatests = new int[Values.size];
        for(int i=0;i<Values.size;i++){//проходим по всем строкам матрицы
            double rowSum = 0;
            for(int j=0;j<Values.size;j++){//считаем сумму модулей, для каждой строки
                rowSum+=Math.abs(a[i][j]);
            }
            greatests[i]=-1;
            for(int j=0;j<Values.size;j++){//проверяем каждый элемент в строке
                if(Math.abs(a[i][j])>=rowSum-Math.abs(a[i][j])){
                    greatests[i]=j;
                    if(Math.abs(a[i][j])>rowSum-Math.abs(a[i][j])){
                        oneIsStrictBigger=true;
                    }
                }
            }
            if(greatests[i]==-1){
                unposibleToDiagDom=true;
            }
        }
        if(!oneIsStrictBigger){
            unposibleToDiagDom=true;
        }
        return greatests;
    }
    /*проверяет возможность приведения матрицы к диагональному преобладанию
     *если в каждой строке есть елемент,
     *превосходящий или равный модульной сумме остальных элементов строки
     *и номера в строке этих элементов не повторяются*/
    public static boolean posibleToDiagDom(){
        int[] maxEl = greatestInTheRow(Values.a);
        if(unposibleToDiagDom){
            return false;
        }else{
            for(int i = 0; i<Values.size; i++){//проверяем, что элементы в greatestInTheRow не повторяются
                for(int j = i+1; j<Values.size-1; j++){
                    if(maxEl[i]==maxEl[j]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public static void makeDiagDom(){
        double[][] newA = new double[Values.size][Values.size];
        double[] newB = new double[Values.size];
        int[] maxEl = greatestInTheRow(Values.a);
        for(int i=0; i<Values.size;i++){//переставляем строки необходимым образом
            newB[maxEl[i]]=Values.b[i];
            for(int j=0; j<Values.size; j++){
                newA[maxEl[i]][j]=Values.a[i][j];
            }
        }
        for(int i=0; i< Values.size; i++){//Копиирование массивов
            Values.b[i]=newB[i];
            for(int j=0; j< Values.size; j++){
                Values.a[i][j]=newA[i][j];

            }
        }
    }
    private static boolean enough(double[] xToday, double[] xYesterday, double acc, Result res){
        double sqrSum = 0;
        for(int i = 0;i<Values.size;i++){
            sqrSum+=Math.pow(xToday[i]-xYesterday[i],2);
        }
        res.errors.add(Math.sqrt(sqrSum));
        if(Math.sqrt(sqrSum)>=acc){
            return false;
        }
        return true;
    }
    public static Result solve(int n, double[][] a, double[] b, double acc, Result res){
        double[] xToday = new double[n];
        double[] xYesterday = new double[n];
        do{
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
        }while(!enough(xToday, xYesterday, acc, res));
        res.x=xToday;
        return res;
    }
}
