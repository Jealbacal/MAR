import java.util.Random;

public class Main {


    public static void main(String[] args){

        if(args[0].equals("monticulo")) {
//            MonticuloWilliams monticuloW = new MonticuloWilliams();
//
//            monticuloW.insertarElemento(4);
//            monticuloW.insertarElemento(8);
//            monticuloW.insertarElemento(6);
//            monticuloW.insertarElemento(5);
//            monticuloW.insertarElemento(3);
//            monticuloW.insertarElemento(7);
//            monticuloW.insertarElemento(1);
//            System.out.println(monticuloW.toString());
//
//            monticuloW.eliminarMin();
//            System.out.println(monticuloW.toString());
//
//            monticuloW.decrecerClave(3,1);
//            System.out.println(monticuloW.toString());
//
//            monticuloW.decrecerClave(3,6);
//            System.out.println(monticuloW.min());

            MonticuloWilliams monticuloP = new MonticuloWilliams();
            int min_num=1;
            int max_num=100;
            Random rng=new Random();

            for(int i=0;i<20;i++){
                int x=rng.nextInt(max_num-min_num)+min_num;
                monticuloP.insertarElemento(x);
            }

            long startime=System.nanoTime();

            monticuloP.insertarElemento(1);

            long endtime=System.nanoTime()-startime;
            System.out.println(endtime);

            System.out.println(monticuloP.toString());

        }
    }
}
