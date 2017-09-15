import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * Created by danil on 15.09.2017.
 */
public class Values {
    final  static int MAX_SIZE=20;

    public static int size;
    public static double[][] a;
    public static double[] b;
    public static float accuracy;

    public static void getValues(){
        String option;
        boolean optionIsReceived = false;
        while(!optionIsReceived){
            System.out.println("Выберете способ ввода данных:");
            System.out.println("Вручную - цифра \"0\"");
            System.out.println("Из файла - цифра \"1\"");
            System.out.println("Случайные данные - цифра \"2\"");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try{
                option = reader.readLine();
                switch(option){
                    case "0":
                        handWrite();
                        optionIsReceived = true;
                        break;
                    case "1":
                        fileWrite();
                        optionIsReceived = true;
                        break;
                    case "2":
                        randWrite();
                        optionIsReceived = true;
                        break;
                    default:
                        System.out.println("Неверно введёные данные, попробуйте ещё раз");
                        break;
                }
            }catch (Exception e){ e.printStackTrace();}
        }
    }

    private static void handWrite(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] bString;
        String[] aString;
        String accString;

        boolean accIsRight = false;
        while(!accIsRight){
            try{
                System.out.print("Введите точность вычислений: ");
                accString = reader.readLine();
                accuracy = Float.parseFloat(accString);
                if (0<=accuracy){accIsRight = true;}else{throw new NumberFormatException();}
            }catch(NumberFormatException nfe){
                System.out.println("Неверно введёные данные, попробуйте ещё раз");
            }catch(IOException ioe){
                ioe.printStackTrace();
            }
        }

        boolean sizeIsRight = false;
        while(!sizeIsRight){
            try {
                System.out.print("Введите размер матрицы: ");
                size = Integer.parseInt(reader.readLine());
                if ((size<=MAX_SIZE)&&(0<size)){sizeIsRight = true;}else{throw new NumberFormatException();}
            }catch(NumberFormatException nfe){
                System.out.println("Неверно введёные данные, попробуйте ещё раз");
            }catch(IOException ioe){
                ioe.printStackTrace();
            }
        }

        boolean bIsRight = false;
        b = new double[size];
        while(!bIsRight){
            try{
                System.out.print("Введите все значения b через пробел(например \"3.0\"): ");
                bString = reader.readLine().split(" ");
                for (int i = 0; i < size; i++) {
                    b[i] = Double.parseDouble(bString[i]);
                }
                if (bString.length==size){bIsRight = true;}else{throw new ArrayIndexOutOfBoundsException();}
            }catch(NumberFormatException nfe){
                System.out.println("Неверно введёные данные, попробуйте ещё раз");
            }catch(ArrayIndexOutOfBoundsException aioobe){
                System.out.println("Неверное количество элементов, попробуйте ещё раз");
            }catch(IOException ioe){
                ioe.printStackTrace();
            }
        }

        a = new double[size][size];
        for (int i = 0; i < size; i++) {
            boolean stringIsRight = false;
            while(!stringIsRight){
                try{
                    System.out.printf("Введите %d-ую строку матрицы, вводя значения через пробел: ", i);
                    aString = reader.readLine().split(" ");
                    for (int j = 0; j < size; j++) {
                        a[i][j] = Double.parseDouble(aString[j]);
                    }
                    if (aString.length==size){stringIsRight = true;}else{throw new ArrayIndexOutOfBoundsException();}
                }catch(NumberFormatException nfe){
                    System.out.println("Неверно введёные данные, попробуйте ещё раз");
                }catch(ArrayIndexOutOfBoundsException aioobe){
                    System.out.println("Неверное количество элементов, попробуйте ещё раз");
                }catch(IOException ioe){
                    ioe.printStackTrace();
                }
            }
        }

    }
    private static void fileWrite(){//TODO определить fileWrite

    }
    private static void randWrite(){//TODO определить randWrite

    }

    public static void show(){
        System.out.printf("Точность: %.15f%n", accuracy);
        System.out.printf("Размер матрицы: %d%n", size);
        System.out.print("Массив b: ");
        for(int i = 0; i<size; i++){
            System.out.print(b[i]+" ");
        }
        System.out.println();
        System.out.println("Матрица b: ");
        for(int i = 0; i<size; i++){
            for(int j = 0; j<size; j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
