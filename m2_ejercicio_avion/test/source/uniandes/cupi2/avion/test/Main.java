package uniandes.cupi2.avion.test;

public class Main {
	 public int [][] matrix;
	  public Main()
	  {
	      matrix = new int[3][4];
	  }
	  public void metodo()
	  {
	      int a = 1;
	      for(int i = 0; i<matrix.length;i++)
	      {
	            for(int j = 0; j<matrix[0].length;j++)
	            {
	                matrix[i][j] = a;
	                a++;
	            }
	      }
	  } 

	  public int metodo1()
	  {
	        int num = 0;
	        for(int i = 0; i < matrix[0].length; i++)
	        {
	            num+=matrix[matrix.length-1][i];
	         }
	        return num;
	  }

	  public int metodo2()
	  {
	        int num = 0;
	        for(int i = 1; i < matrix[0].length; i+=2)
	        {
	            for(int j = 0; j < matrix.length; j++)
	            {
	                 num+=matrix[j][i];
	            }
	        }
	        return num;
	  }  

	  public static void main(String[] args) 
	  {
	       Main m =  new Main();
	       m.metodo();
	       System.out.println(m.metodo1()+m.metodo2());
	  }
}
