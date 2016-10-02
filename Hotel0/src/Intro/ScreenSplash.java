package Intro;
import Singleton_State.Main1;
import Singleton_State.VistaLoggin;
import java.awt.*;
import java.awt.SplashScreen;
/**
 * @author Mouse
 */
public final class ScreenSplash {

  final SplashScreen splash ;
  
  //texto que se muestra a medida que se va cargando el screensplash
  final String[] texto = {"Configuración", "Librerías","Iconos","Propiedades","Base de Datos"};

  public ScreenSplash() {
         //Metodo que devuelve un objeto de tipo SplashScreen utilizado en la pantalla de bienvenida de la aplicacion de Java
	 splash = SplashScreen.getSplashScreen();
  }

   public void animar(){
       
        if (splash != null){
            //Creamos un objeto Graphics
            Graphics2D g = splash.createGraphics();
            for(int i=1; i<texto.length; i++){                       
                //se pinta texto del array
                g.setColor( new Color(6,72,151));//color de fondo
	        g.fillRect(203, 328,280,12);//para tapar texto anterior
                g.setColor(Color.white);//color de texto	        
                g.drawString("Cargando "+texto[i-1]+"...", 203, 338); 
                g.setColor(Color.RED);//color de barra de progeso del hilo
                g.fillRect(204, 308,(i*300/texto.length), 12);//Se pinta un objeto de tipo rectangulo
                
               
                splash.update();
		try {
                     
		 Thread.sleep(100);
                 
                 
		} catch(InterruptedException e) { }
            }

	   splash.close();
	}
        //una vez terminada la animación se muestra la aplicación principal
         try {
         
            new VistaLoggin().setVisible(true);
         
         }catch (Exception e) {
            System.out.println(e.getMessage());
        }
   }
   
}
