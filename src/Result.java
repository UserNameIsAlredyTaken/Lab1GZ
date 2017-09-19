import java.util.ArrayList;

/**
 * Created by danil on 15.09.2017.
 */
public class Result {
    public double[] x;
    public int iterCount;
    ArrayList<Double> errors = new ArrayList<>();

    public void show(){
        System.out.print("Ответ: ");
        for(int i=0;i<Values.size;i++){
            System.out.println(x[i]+" ");
        }
        System.out.println();
        System.out.println("Количество итераций: "+iterCount);

        System.out.println("Погрешности: ");
        for(int i=0;i<iterCount;i++){
            System.out.println(errors.get(i)+" ");
        }

    }
}
