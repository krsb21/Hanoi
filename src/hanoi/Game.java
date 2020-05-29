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
public class Game {
    private Tower A,B,C;
    private Tower original;
    private static int movements = 0;
    public Game(Tower A, Tower B, Tower C,Tower original) {
        this.original = original;//torre inicial de referencia no se usa en el juego
        this.A = A;//torre A normalmente se usa como pibot inicial, es decir tiene las fichas
        this.B = B;//torre B uso de pibot
        this.C = C;//torre C uso de pibot y destino
        
    }
    public void Play(){
       Play(A.size,"A","C","B");//Se pasa como referencia cuantas fichas se quiere jugar, torre desde, auxiliar y hasta
    }
    private void Play(int nx,String from,String to,String aux){
            if(nx==1){
                int tmp = this.peek(from).value;//si nx que es el numero de fichas movidas es == 1 hacemos pick desde donde y hacemos push hasta donde
                this.push(to, tmp);//push hasta la torre destino
                System.out.println("Movimientos hechos ficha "+tmp+" desde "+from+" hasta "+to);//impresion del mensaje de ficha que se movio
                movements++;//sumamos un movimiento
                return;//paramos la recursión en este caso
            }
            Play(nx-1, from, aux, to); //mandamos el numero de fichas menos uno con la misma logica
            Node auxs = this.peek(from);//sacamos una ficha desde donde necesitamos en la ejecucion
            if(auxs!=null){//si la ficha que hacemos peek es distinta a null es decir si no sacamos nada de la torre
                int tmp = auxs.value;//variable temporal de lo que sacamos
                this.push(to, tmp);//insertamos en la torre que se encuentre en este momento con "to" puede ser A B o C e insertamos el valor que hicimos peek
                System.out.println("Movimientos hechos ficha "+tmp+" desde "+from+" hasta "+to);//imprimimos el movimiento que hicimos
                movements++;//sumamos un movimiento
            }
            Play(nx-1, aux, to, from); //volvemos a la recursion pero esta vez aux es desde donde vamos a hacer peek, to funciona de auxiliar y from funciona de de destino
    }
    public Node peek(String Tower){//hacemos peek de donde necesitamos a través del nombre de la torre
        if(A.name.equals(Tower))
            return A.peek();
        else if(B.name.equals(Tower))
            return B.peek();
        else return C.peek();
    }
    public void push(String Tower,int value){//hacemos push con el nombre de la torre y el valor del nodo que se va a crear
        if(A.name.equals(Tower))
            A.push(value);
        else if(B.name.equals(Tower))
            B.push(value);
        else C.push(value);
    }

    public Tower getA() {
        return A;
    }

    public Tower getB() {
        return B;
    }

    public Tower getC() {
        return C;
    }

    public Tower getOriginal() {
        return original;
    }

    public static int getMovements() {
        return movements;
    }
    
}
