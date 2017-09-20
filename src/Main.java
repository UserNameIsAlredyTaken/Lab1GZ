/**
 * Created by danil on 14.09.2017.
 */
public class Main {
    public static void main(String[] args){
        Result res = new Result();
        Values.getValues();
        Values.show();
        boolean diagDom = Solution.checkDiagDomin(Values.a);
        System.out.println("Диагональное преобладание: "+diagDom);
        if(!diagDom){
            if(Solution.posibleToDiagDom()){
                Solution.makeDiagDom();
                System.out.println("Привели к диагональному преобладанию");
                Solution.solve(Values.size,Values.a, Values.b, Values.accuracy, res);
                res.show();
            }else{
                System.out.println("Не удалось привести к диагональному преобладанию");
            }
        }else{
            Solution.solve(Values.size,Values.a, Values.b, Values.accuracy, res);
            res.show();
        }
    }
}
