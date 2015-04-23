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
    
    //metodo recursivo que llene renglones con numeros del 1 al n sin repetir
    //movimientos
   //int derecha=y+1, izquierda=y-1, arriba=x-1, abajo=x+1;
    //(0,0)
  public boolean buscarElemDistintos(int [][]matrix, int n){
    boolean resp=false;  
   int x=0, y=0;
           while(matrix[x][y]!=0 && matrix[x][y]<=n){
                x=x+1;
            if(x==n-1 && y<n){
                x=0;
                y=y+1;
            }
            if(y==n-1 && matrix[x][y]<=n)
                resp=false;
            if(matrix[x][y]>n)
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
   
    public boolean llenar(int [][]matrix, int n, int x,int y, int k) {

       
        //si no se puede hacer tabla 
        if(n<=0)
            return false;
        //si matrix contiene ceros
        if(matrix[n][n]!=0)
            return false;
        matrix[x][y]=k;
        //si usuario puso numeros incorrectos
        if(buscarElemDistintos(matrix,n)==true)
            return false;   
        //buscar repetidos
        for(int i=0;i<n;i++){
            SetADT conjuntofila = new Conjunto();
            for(int j=0;j<n;j++)
                conjuntofila.add(matrix[i][j]);       
        }
        int i=0, j=0;
        while(matrix[i][j])
        if(llenar(matrix,n,x,y+1,k+1))
            return true;
        
        if (y==n-1)
            y=0;
            x=x+1;
        

        
        
        
        
        
    }
        
    
}
