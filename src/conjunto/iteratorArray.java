
package conjunto;

public class iteratorArray<T> implements Iterator<T> {
    private T[] cosas;
    private int cont,pos;
    public iteratorArray(T[] contenido,int numElem){
        cosas=(T []) new Object [numElem];
        for(int i =0; i<numElem;i++)
            cosas[i]=contenido[i];
        pos=0;
    }
        
        public boolean hasNext(){
            return pos<cont;
        }
        public T next(){
            if (hasNext())
                return cosas[pos++];
            throw new Unchecked("ElementNotFoundException");
        }
        
    }
    

