/**
 * Created by danil on 15.09.2017.
 */
public class Result {
    public double[] x;
    public int iterCount;
    public double[] errors = new double[100];//TODO исправить инициализацию вот тут

    public void show(){
        System.out.print("Ответ: ");
        for(int i=0;i<Values.size;i++){
            System.out.println(x[i]+" ");
        }
        System.out.println();
        System.out.println("Количество итераций: "+iterCount);

        System.out.println("Погрешности: ");
        for(int i=0;i<iterCount;i++){
            System.out.println(errors[i]+" ");
        }

    }
}
