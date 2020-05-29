/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanoi;

/**
 *
 * @author krsb2
 */
public class Hanoi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       int NumeroFichas = 3;
       Tower A = new Tower("A",NumeroFichas);//llenamos la torre A con fichas
       Tower or = new Tower("A",NumeroFichas);//torre referencia si se desea ver que se insertó
       Tower B = new Tower("B");//torre auxiliar pibot
       Tower C = new Tower("C");//torre final pibot
       Game g = new Game(A,B,C,or);//iniciamos hanoi con las torres correctamente inicializadas
       System.out.println("Torre A "+A.print());//imprimimos A
       g.Play();//jugamos
       System.out.println("Numero de movimientos "+g.getMovements());//Obtenemos los movimientos
       System.out.println("Torre A "+ (g.getA().print() == null?"Vacío":g.getA().print()));//imprime la torre, si regresa null esta vacia
       System.out.println("Torre B "+ (g.getB().print() == null?"Vacío":g.getB().print()));//imprime la torre, si regresa null esta vacia
       System.out.println("Torre C "+ (g.getC().print() == null?"Vacío":g.getC().print()));//imprime la torre, si regresa null esta vacia
    }
    
}
