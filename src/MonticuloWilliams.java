public class MonticuloWilliams {

    int next;
    int[] v;

    public MonticuloWilliams() {
        next = 0;
        v = new int[]{};
    }

    public void insertarElemento(int val) {
        v[next] = val;
        next++;
        flotar();
    }

    private void flotar() {
        int j = next -1;
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
}