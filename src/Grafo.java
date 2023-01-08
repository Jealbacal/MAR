import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Grafo {

    private int numVertices;
    private int numAristas;
    private final List<List<Adyacente>> listaAdj;
    
    public Grafo(int numVertices){
        this.numVertices = numVertices;
        this.listaAdj= new ArrayList<>();
        for(int i=0;i<numVertices;i++){
            listaAdj.add(new ArrayList<>());
        }

    }
    


    public void insertarArista(int i,int j,int p){

            listaAdj.get(i-1).add(new Adyacente(j,p));
            listaAdj.get(j-1).add(new Adyacente(i,p));

        numAristas++;
    }
    public String toString(){
        String res="";
        for(int i=0; i<numVertices;i++){
            res += "Vertice: "+(i+1);
            res+=" con Adyacentes: ";
            for(int j=0;j< listaAdj.get(i).size();j++){
               res+= listaAdj.get(i).get(j)+" ";
            }
            res+="\n";
        }

        return  res;
    }

    public void prim(){
        int[] coste_min=new int[numVertices];
        int[] conexion= new int[numVertices];
        MonticuloAdjacentes m = new MonticuloAdjacentes();
        List<HashMap<Integer,Integer>> arm= new ArrayList<>();
        coste_min[0]=-1;
        for(int i=1;i<numVertices;i++){
            coste_min[i]=1000000000;
            conexion[i]=1;
        }
        List<Adyacente> l = listaAdj.get(0);

        while(!l.isEmpty()){
            Adyacente i= (Adyacente) l.remove(0);
            coste_min[i.destino-1]=i.peso;
            m.insertarElemento(i);
        }

        for(int i=0;i<numVertices-1;i++){
            Adyacente minimo=m.min();
            m.eliminarMin();
            HashMap<Integer,Integer> a= new HashMap<>();
            a.put(conexion[minimo.destino-1],minimo.destino);
            arm.add(a);
            coste_min[minimo.destino-1]=-1;
            List<Adyacente> k=listaAdj.get(minimo.destino-1);

            while (!k.isEmpty()){
                Adyacente j= (Adyacente) k.remove(0);
                if(j.peso < coste_min[j.destino-1]){
                    coste_min[j.destino-1]=j.peso;
                    conexion[j.destino-1]=minimo.destino;
                    m.decrecerClave(j, coste_min[j.destino-1]);


                }

            }

        }
        System.out.println(arm.toString());
    }

    public int getNumVertices() {
        return numVertices;
    }

    public int getNumAristas() {
        return numAristas;
    }
}
