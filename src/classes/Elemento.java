package classes;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;


public class Elemento {

    private HashSet<Paquete> hashSet;

    public Elemento() {
        hashSet=new HashSet<>();
    }
    public void agregar(Paquete paquete)
    {
        hashSet.add(paquete);
    }
    public void eliminar(Paquete paquete)
    {
        hashSet.remove(paquete);
    }
    public boolean buscar(Paquete paquete)
    {
        return hashSet.contains(paquete);
    }
    public int contar()
    {
        return hashSet.size();
    }

    public String listar() {
        String rta="";
        Iterator it=hashSet.iterator();
        while(it.hasNext())
        {
            rta+=it.next().toString()+"\n";
        }
        return rta;
    }
}
