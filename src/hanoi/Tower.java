package hanoi;

/**
 *
 * @author krsb2
 */
public class Tower {
    public Node N;//Nodo raiz desde donde se va a insertar
    public int size;//esto era una referencia al valor
    public String name;//nombre de la torre
    public Tower(String name) {
        this.name = name;//inicializa una torre vacía con su nombre
    }
    public Tower(String name,int size){//Inicializa la torre con el numero de fichas y llama al encargado de hacer push en la torre si
        //este constructor es llamado
        this.size = size;
        this.initial();
        this.name = name;
    }
    public void initial(){
        for (int i = size; i > 0; i--) {//inicializa la torre con las fichas deseadas
            this.push(i);
        }
    }

    public boolean isEmpty() {
        return N == null;//Si el nodo principal es null returna true si no false
    }

    public Node push(int value) {
        return push(this.N, value);//llama al metodo auxiliar pasando por valor lo que se desea insertar como valor
    }

    private Node push(Node insert, int value) {
        
            if (insert != null) {
                if (value < insert.value) {
                    if (insert.nMinor != null) {
                        return push(insert.nMinor, value);
                    } else {
                        insert.nMinor = new Node(value);//inserta el valor hasta donde nMinor sea == null
                        return null;
                    }
                } else {
                    return new Node(value);
                }
            } else {
                this.N = new Node(value);
                return null;
            }
        
    }

    public String print() {
        return this.print(this.N);//retorna la suma de los strings que encuentra
    }

    private String print(Node N) {//misma logica,solo que adjunta en el string todo lo que vaya encontrando en N.valor
        if (N != null) {
            if (N.nMinor != null) {//si su hijo no es nulo simplemente prosigue
                return N + " " + print(N.nMinor);
            } else {
                return N + "";
            }
        } else {
            return null;
        }
    }

    public int size() {
        return this.size(this.N);
    }

    private int size(Node N) {
        int tam = 0;//tam 0 inicializando el recorrido, cada salto es uno
        if (N != null) {//si el nodo N pasado por valor es null es decir N que es la raiz del recorrido es null, este es 0 si no recorre
            tam++;//sumamos 1 ya que comprobamos que no es nulo
            if (N.nMinor != null) {//si el hijo del nodo actual 3(actual)->2.nMinor!=null prosigue el recorrido 
                return tam + size(N.nMinor);//retorna el tamaño mas lo que devuelvan los recorridos internos
            } else {
                return tam;//si el hijo del nodo actual 2(actual) o 3(actual)->3.nMinor==null solo retorna el 1 actual en tam
            }
        } else {
            return 0;//si no hay nodos no hay recorrido retorna 0
        }
    }

    public Node peek() {
        return this.peek(this.N);//Inicializa el recorrido de peek
    }

    private Node peek(Node peeking) {
        if (peeking != null) {//si el nodo es distinto de null recorre si no retorna null
            if (peeking.nMinor != null) {//si el siguiente nodo es distinto de null sigue
                if (peeking.nMinor.nMinor == null) {//si el siguiente hijo menor del hijo menor 3(actual)->2.nMinor->1.nMinor = null
                    Node aux = new Node(peeking.nMinor.value);//Si el siguiente hijo menor del hijo menor es null es el ultimo
                    peeking.nMinor = null;//seteamos a null el siguiente nodo
                    return aux;//retorna el nodo que está en la cima
                } else {
                    return peek(peeking.nMinor);//retorna lo que salga de la llamada recursiva
                }
            } else {
                Node aux = new Node(peeking.value);//retorna el nodo 1 de la torre si se da el caso
                N = null;//vacia la torre
                return aux;//retorna el ultimo nodo
            }
        } else {
            return null;//retorna null si está vacío
        }
    }

    public boolean equals(Tower A, Tower B) {
        if (A.size() == B.size()) {
            return equals(A.N, B.N);
        } else {
            return false;
        }
    }

    private boolean equals(Node A, Node B) {//este metodo se usa como comparativa si es necesario comparar dos torres con la misma logica de recorridos
        if(A == null || B == null)
            return false;
        else{
             if (A.value == B.value) {
                if (A.nMinor != null && B.nMinor != null) {
                        return equals(A.nMinor, B.nMinor);
                    } else {
                        return true;
                    }
                } else {
                    return false;
                }
        }
    }
}
