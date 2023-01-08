import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class MonticuloAdjacentes  {


    private int next;
    private Adyacente[] v;

    public MonticuloAdjacentes(){
        next = 0;
        v = new Adyacente[10000000];
    }

    public void insertarElemento(Adyacente val) {
        v[next]=val;

        next++;
        flotar(next-1);
    }

    private void flotar(int nodo) {
        int j = nodo;

        while (j > 0 && v[(j - 1) / 2].peso > v[j].peso) {
            Adyacente aux = v[(j - 1) / 2];
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

    public  void decrecerClave(Adyacente nodo, int valor ){
        boolean stop=false;
        int i=0;
        int pos=-1;
        while(i<next && !stop){
            if(v[i].destino==nodo.destino){
                stop=true;
                pos=i;
            }
            i++;
        }
        if(stop)
            v[pos].peso=valor;
        else
            insertarElemento(nodo);
    }

    private void hundir(int s, int l){
        int j=s;
        boolean stop=false;
        while( ((2*j+1)<l) && !stop ){

            int m;
            if(((2*j+2)<l) && v[(2*j+2)].peso <= v[2*j+1].peso){// el hijo derecho es el minimo
                m=2*j+2;
            }
            else{// el hijo izquierdo es el minimo
                m=2*j+1;
            }

            if( v[j].peso >= v[m].peso){
                Adyacente aux=v[j];
                v[j]=v[m];
                v[m]=aux;
                j=m;
            }
            else{
                stop=true;
            }
        }

    }

    public Adyacente min(){
        return v[0];
    }
}
