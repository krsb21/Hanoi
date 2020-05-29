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
public class Node {
    public int value;
    public Node nMinor;
    public Node(int value){
        this.value = value;
    }
    @Override
    public String toString(){//en vez de imprimir el objeto saca su valor
        return this.value+" ";
    }
    
}
