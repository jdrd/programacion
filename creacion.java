package taller1;
import java.awt.*;
import javax.swing.*;
import java.awt.Color;


public class creacion extends JPanel{

   public final static int AZUL=0,VERDE=1,ROJO=2,MAGENTA=3,AMARILLO=4,ROSA=5,INICIAL=6;
   private int imgIni;
   Color color[];
   static int[][]matriz;
   int aleat;
   int i,j;   
   static int n=12,num,SupIzq,tam=26;
   boolean repet=false;

    Lanzadora lanza = new Lanzadora();

      public void paintComponent( Graphics g ){

//--------------------no tocar---------
      super.paintComponent( g );

      Color[] color = {Color.BLUE,Color.GREEN,Color.RED,Color.MAGENTA,Color.YELLOW,Color.PINK};

//primer metodo para rellenar la matriz
      if(imgIni == INICIAL){
       matriz = new int[n][n];
       creaMatrizIni();
      }

//recorrido para obtener los cuadritos aleatorios a partir de el primero.
       for(int i=0;i<n;i++){
           for(int j=0;j<n;j++){
               for (int col=0;col<6;col++){
                   if(matriz[i][j]==col){
                    num=col;
                   }
               }
           }
        }
//--------------------no tocar---------
//recorriendo los colores para capturar la opcion escogida.
      for(int colores=0;colores<6;colores++){
        if(imgIni == colores){
        num=colores;
        }
      }


//ejecucion del algoritmo recursivo para llenar la matriz.
      Busqueda();

       for(i=0;i<n;i++){
            for(j=0;j<n;j++)
            {
             g.setColor(color[matriz[i][j]]);
             g.fillRect( (tam*i), (tam*j), 40, 40 );
           }
       }
//Solo para observar si los colores mostrados en consola coinciden con los pintados en el programa.
      Colores();
     }

//Creacion de matriz inicial con colores aleatorios.
   public void creaMatrizIni(){
       for(i=0;i<n;i++){
           for(j=0;j<n;j++)
        {
            aleat = (int) (Math.random()*6);
            matriz[i][j]=aleat;
        }
       }       
   }

//algoritmo recursivo de busqueda de los colores
void Busqueda(){
     int x=0;
     int y=0;

     SupIzq=matriz[0][0];
     matriz[x][y]=num;
     valBusqueda(x,y);     
}

void valBusqueda(int x, int y){ //caso base

  try{     

    if(x-1 >= 0){
    if (matriz[x-1][y]==SupIzq){
    matriz[x-1][y] =num;
    valBusqueda(x-1,y); //caso recursivo
    }
    }

    if(x+1 < n){
    if (matriz[x+1][y]==SupIzq){
    matriz[x+1][y]=num;
    valBusqueda(x+1,y); //caso recursivo
    }
    }

    if(y-1 >= 0){
    if (matriz[x][y-1]==SupIzq){
    matriz[x][y-1]=num;
    valBusqueda(x,y-1); //caso recursivo
    }
    }

    if(y+1 < n){
    if (matriz[x][y+1]==SupIzq){
    matriz[x][y+1] =num;
    valBusqueda(x,y+1); //caso recursivo
    }
    }
//Excepcion para repeticion de evento en un color, lo que podria causar desbordamiento de pila.
    lanza.lanzaSiDesborda(x,y);
    }
    catch(MiExcepcion e){
    System.out.println( "Has repetido el color--> " + e.getMessage() );
    }
    catch(Exception e){
    System.out.println( "Excepcion: " + e.getMessage() );
    }
}

//Muestra de los colores de la matriz en consola
   public void Colores(){
      String Colores="";

      for(j=0;j<n;j++){
        for(i=0;i<n;i++){
      if(matriz[i][j]==0){
      Colores = "  Azul  ";
      }
      if(matriz[i][j]==1){
      Colores = "  Verde ";
      }
      if(matriz[i][j]==2){
      Colores = "  Rojo  ";
      }
      if(matriz[i][j]==3){
      Colores = " Magenta";
      }
      if(matriz[i][j]==4){
      Colores = "Amarillo";
      }
      if(matriz[i][j]==5){
      Colores = "  Rosa  ";
      }
      System.out.print(Colores+"  ");
      }
      System.out.println("");
      }
      System.out.println("");
   }
//Método para repintar el gráfico.
   public void dibujar( int opcionADibujar ){

      imgIni = opcionADibujar;
      repaint();
   }
//--------------------no tocar---------
}

