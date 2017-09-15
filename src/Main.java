/**
 * Created by danil on 14.09.2017.
 */
public class Main {
    public static void main(String[] args){
        Result res = new Result();
        Values.getValues();
        Values.show();
        System.out.println("Диагональное преобладание: "+Solution.checkDiagDomin(Values.a));
        Solution.solve(Values.size,Values.a, Values.b, Values.accuracy, res);
        res.show();
    }
}
