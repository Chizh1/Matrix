
import java.util.Scanner;

public class Main {
 //инициацизация матрицы
    static void printin  (int [][] a){
        for(int i=0; i<a.length; i++)
            for(int j=0;j<a[i].length; j++)
                a[i][j]=(int)(1+Math.random()*100);
    }
    //вывод
    static void printout(int [][] a){
        for(int i=0; i<a.length; i++){
            for(int j=0;j<a[i].length; j++)
                System.out.print(a[i][j] + "\t");
            System.out.println();
        }
    }
    //сдвиг влево
    static void shiftleft(int [][]a){
        int e;
        for(int i=0; i<a.length;i++){
            e = a[i][0];
            for(int j=0; j<a[i].length;j++){
                if(j==a[i].length-1)
                    a[i][j]=e;
                else
                a[i][j] = a[i][j + 1];
            }
        }
        System.out.println();
    }
    //сдвиг вверх
    static void shiftup(int a[][]){
        int tmp[]=new int[a[0].length ];
        for(int i=0; i<1;i++){
            for(int j=0; j<a[i].length;j++){
                tmp[j]=a[i][j];
            }
        }
        for(int i=0; i<a.length;i++){
            int count=i;
            count++;
            for (int j=0; j<a[i].length;j++){
                if(count!=a.length)
                a[i][j]=a[count][j];
                else
                    a[i][j]=tmp[j];
            }
        }
    }
    //отминусовываем средее арифметическое каждой строчки у каждого числа этой строчки
    static void average(int a[][]){
        int avr;
        int count=0;
        for(int i=0;i<a.length;i++ ){
            avr=0;
            count=0;
            for(int j=0;j<a[i].length;j++){
                avr+=a[i][j];
                count++;
            }
            avr/=count;
            System.out.println( "avg = "+avr);
            for(int j=0;j<a[i].length;j++){
                a[i][j]-=avr;
            }
        }
    }
    //траспонирование
    static int [][] trans(int a [][]){
        int b[][] = new int[a.length][a[0].length];
        for (int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++){
                b[j][i]=a[i][j];
            }
        }

        return b;
    }
    //поворот на 180
    static int [][] rotate180degrees(int a[][]){
        int col=a.length;
        int row=a[0].length;
        int c[][] = new int[col][row];
        for (int i=0;i<a.length;i++){
            col--;
            row=a[i].length-1;
            for(int j=0;j<a[i].length;j++){
                c[col][row]=a[i][j];
                row--;
            }
        }
        return c;
    }



    public static void main(String[] args) {
        System.out.println("laba 1");
        System.out.print("Enter the dimension of the matrix = ");
        Scanner scanner = new Scanner(System.in);
        int N=scanner.nextInt();
        System.out.println();
        int list [][]= new int[N][N];
        printin(list);
        System.out.println("\nmatrix  ");
        printout(list);
        shiftleft(list);
        System.out.println("\nmatrix list after shift (1 left)");
        printout(list);
        shiftup(list);
        System.out.println("\nmatrix list after shift (1 up)");
        printout(list);
        average(list);
        System.out.println("\naverage");
        printout(list);
        list=trans(list);
        System.out.println("\ntranspose " );
        printout(list);
        System.out.println("\nrotate 180 degrees");
        list=rotate180degrees(list);
        printout(list);
    }
}
