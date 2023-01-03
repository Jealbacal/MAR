import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MonticuloWilliams {

    private int next;
    private Integer[] v;

    public MonticuloWilliams() {
        next = 0;
        v = new Integer[10000000];
    }

    public void insertarElemento(int val) {
        v[next]=val;

        next++;
        flotar(next-1);
    }

    private void flotar(int nodo) {
        int j = nodo;

        while (j > 0 && v[(j - 1) / 2] > v[j]) {
            int aux = v[(j - 1) / 2];
            v[(j - 1) / 2] = v[j];
            v[j] = aux;
            j = (j - 1) / 2;
        }
    }

    public void eliminarMin(){
        v[0]=v[next -1];
        next--;
        hundir(0,next);
    }

    public  void decrecerClave(int nodo, int valor ){

        if(nodo < next && v[nodo] > valor){
            v[nodo]=valor;
            flotar(nodo);
        }
        else{
            System.out.println("el valor tiene que ser estrictamente menor");
        }

    }

    private void hundir(int s, int l){
        int j=s;
        boolean stop=false;
        while( ((2*j+1)<l) && !stop ){

            int m;
            if(((2*j+2)<l) && v[(2*j+2)] <= v[2*j+1]){// el hijo derecho es el minimo
                m=2*j+2;
            }
            else{// el hijo izquierdo es el minimo
                m=2*j+1;
            }

            if( v[j]> v[m]){
                int aux=v[j];
                v[j]=v[m];
                v[m]=aux;
                j=m;
            }
            else{
                stop=true;
            }
        }

    }

    public int min(){
        return v[0];
    }

    public String toString(){
        String str="[";
        for(int i=0;i<next;i++){

            if(i==next-1){
                str+=v[i]+"]";
            }
            else{
                str+=v[i]+",";
            }
        }
        return str;
    }
    /// decrecer clave Idea :
    /// pedir el el nodo(la posicion del array y el valor de la nueva clave
    // verificar si la posicion es valida y si el valor es menor que la clave a cambiar
    // cambiar el valor, hacer el metodo flotar ( hacer un nuevo metodo o modificar el que tengo para empezar desde el valor del nodo que se quiere
}