/**
 * Created by danil on 14.09.2017.
 */
public class Main {
    public static void main(String[] args){
        Values.getValues();
        Solution.checkDiagDomin(Values.a);
        Solution.solve(Values.size,Values.a, Values.b, Values.accuracy);
        Result.show();
    }
}
