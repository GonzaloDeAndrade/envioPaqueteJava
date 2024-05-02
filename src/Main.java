

import classes.Elemento;
import classes.Paquete;
import classes.PaqueteAire;
import classes.PaqueteTierra;

import javax.swing.text.Element;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

            Elemento misPaquetes= new Elemento();
            Paquete paqueteTierra = new PaqueteTierra(20,"miramar",1,102,"camion");
            Paquete paqueteTierra2 = new PaqueteTierra(20,"ecuador",0,102,"camion");
            Paquete paqueteAire= new PaqueteAire(30,"brasil",0,"AA","express");
            Paquete paqueteAire2= new PaqueteAire(50,"alemania",-1,"Argentina","normal");
            misPaquetes.agregar(paqueteTierra);
            misPaquetes.agregar(paqueteTierra2);
            misPaquetes.agregar(paqueteAire);
            misPaquetes.agregar(paqueteAire2);

            System.out.println(misPaquetes.listar());

        }
    }
