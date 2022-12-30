import java.util.List;

public class Grafo {

    int numVertices;
    int numAristas;
    List<Adyacente>[] listaAdj;
    
    public Grafo(int numVertices){
        this.numVertices = numVertices;
    }
    
    public boolean existeArista(int i, int j){
        Adyacente aux=new Adyacente(j);
       return listaAdj[i].contains(aux.destino);
    }
    public void insertarArista(int i,int j,int p){
        if(!existeArista(i,j) && i!=j){
            listaAdj[i].add(new Adyacente(j,p));
            listaAdj[j].add(new Adyacente(i,p));
        }
        numAristas++;
    }
    public String toString(){
        String res="";
        for(int i=1; i<=numVertices;i++){
            res += "Vertice: "+i;
            res+="con Adyacentes: ";
            for(int j=1;j<= listaAdj[i].size();j++){
               res+= listaAdj[i].get(j)+" ";
            }
            res+="\n";
        }

        return  res;
    }

    public int getNumVertices() {
        return numVertices;
    }

    public int getNumAristas() {
        return numAristas;
    }
}
