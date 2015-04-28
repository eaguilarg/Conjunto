/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conjunto;

/**
 *
 * @author introduccion03
 */
public class Raiz3Sudoku {
    public Raiz3Sudoku(){
        
    }
    
    //metodo recursivo que llene renglones con numeros del 1 al n sin repetir
    //movimientos
   //int derecha=y+1, izquierda=y-1, arriba=x-1, abajo=x+1;
    //(0,0)
  public boolean buscarElemDistintos(int [][]matrix, int n){
    boolean resp=false;  
   int x=0, y=0;
           while(matrix[x][y]!=0 && matrix[x][y]<=n || matrix[x][y]!=0 && matrix[x][y]>0){
                x=x+1;
            if(x==n-1 && y<n){
                x=0;
                y=y+1;
            }
            if(y==n-1 && matrix[x][y]<=n ||y==n-1 && matrix[x][y]>0)
                resp=false;
            if(matrix[x][y]>n || matrix[x][y]<0)
                resp=true;
            }
    return resp;
  }
  public boolean ElemRepFila(int [][]matrix,int n){
      int x=0, y=0, elem = 0;
      int cont=1;
      while(y<n && cont<2)
          y=y+1;
      matrix[x][y]= elem;
      if(matrix[x][y]==elem);
        cont++;
     if(cont>1)
         return false;
      return false;
        
  }
  public boolean contains(int fila,int elem, int [][]matrix, int n, int y){
      boolean resp=true;
            while(matrix[fila][y]!=elem && y<n)
                y++;
            if(y==n)
               resp=false;
      return resp;
                   
  }
  public void imprimeMatriz(int [][] matriz){
for (int x=0; x < matriz.length; x++) {
  System.out.print("|");
  for (int y=0; y < matriz[x].length; y++) {
    System.out.print (matriz[x][y]);
    if (y!=matriz[x].length-1) System.out.print("\t");
  }
 System.out.println("|");
}
}
 /*  
    public boolean llenar(int [][]matrix, int n, int x,int y, int k) {

       
        
       
        //si no se puede hacer tabla 
        if(n<=0)
            return false;
        //si matrix contiene ceros
        if(matrix[n][n]!=0)
            return false;
        //validacion si puede poner valor en posicion
        if(k>n || k<0)
            return false;
        
        if(matrix[x][y]!=0)
            return false;
        if(contains(x,k,matrix, n,y))
            return false;
        matrix[x][y]=k;
        
        //si usuario puso numeros incorrectos
        if(buscarElemDistintos(matrix,n)==true)
            return false; 
        
              
        if(llenar(matrix,n,x,y+1,1))
            return true;
        if(llenar(matrix,n,x,y+1,2))
            return true;
        if(llenar(matrix,n,x,y+1,3))
            return true;
        if(llenar(matrix,n,x,y+1,4))
            return true;
        if(llenar(matrix,n,x,y+1,5))
            return true;
        if(llenar(matrix,n,x,y+1,6))
            return true;
        if(llenar(matrix,n,x,y+1,7))
            return true;
        if(llenar(matrix,n,x,y+1,8))
            return true;
        if(llenar(matrix,n,x,y+1,9))
            return true;
        
        if (y==n-1){
            y=0;
            x=x+1;
        }
        
     matrix[x][y]=0;
    return false;
       
        
    }*/
  //fila
    private boolean valida(int [][]A, int x,int y,int val){
       boolean resp=true;
        if(!(x>=0 && x<A.length && y>=0 && y<A[0].length))
            return false;
        for(int i=0; i<A[0].length;i++)
            if(val==A[x][i]){
                resp=false;
                break;
            }
         for(int i=0; i<A[0].length;i++)
            if(val==A[i][y]){
                resp=false;
                break;
            }
        
        return resp;
     
    }
    
    //primer posicion, insertar elementos
    //funcion profe fila
    public boolean llena(int [][]A, int x,int y,int val){
        int xAnt=x, yAnt=y;
        if(!valida(A,x,y,val))
            return false;
        A[x][y]=val;
        if(x==A.length-1 && y==A[0].length-1)
            return true;
        if(y<A[0].length-1)
            y++;
        else{
            y=0;
            x++;
        }
        
        
        
        //9 casos
        boolean done=false;
        int i=1;
        while(!done && i<=A.length)
            done=llena(A,x,y,i++);
        if(!done)
            A[xAnt][yAnt]=0;
        return done;
       
    
}
    
    
    
    public static void main(String args[]){
        Raiz3Sudoku p=new Raiz3Sudoku();
        int [][] c=new int [3][3];
       
        p.llena(c,0,0,1);
        p.imprimeMatriz(c);
    }
        
    
}
