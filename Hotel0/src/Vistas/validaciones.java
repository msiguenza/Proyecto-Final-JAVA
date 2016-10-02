/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;

/**
 *
 * @author Silvia
 */
public class validaciones 
{
    	//metodo que comprueba dni correcto
    
        Toolkit tk = Toolkit.getDefaultToolkit(); 
	
	public static boolean NifValido(String nif)
        {
		
		Pattern nifPattern = Pattern.compile("(\\d{1,8})([TRWAGMYFPDXBNJZSQVHLCKEtrwagmyfpdxbnjzsqvhlcke])");
		Matcher m = nifPattern.matcher(nif);
		if(m.matches())
		{
			String letra = m.group(2);
			//Extraer letra del NIF
			String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
			int dni = Integer.parseInt(m.group(1));
			dni = dni % 23;
			String reference = letras.substring(dni,dni+1);
			 
			if (reference.equalsIgnoreCase(letra))
			{
				// NIF valido
				return true;
			}
			else
			{
				// NIF invalido
				return false;
			}
		}
                
		else
		{
			return false;
		}
        }

	//metodo que comprueba email correcto
	
	public boolean isEmail(String correo) {
		Pattern pat = null;
		Matcher mat = null;        
		pat = Pattern.compile("^[\\w\\-\\_\\+]+(\\.[\\w\\-\\_]+)*@([A-Za-z0-9-]+\\.)+[A-Za-z]{2,4}$");
		mat = pat.matcher(correo);
		        
		if (mat.find()) 
		{
		    return true;
		}
		        
		else
		{
		    return false;
		}        
	}
        
        
        public static boolean esNumero(String cadena){
	try {
		Integer.parseInt(cadena);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
}
        
        //metodo que permite introducir solo letras en los JTextField
        
        public void Sletras(JTextField a)
	{
		a.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent e)
			{
				char c=e.getKeyChar();
				
				if(Character.isDigit(c))
				{
					e.consume();
                                        tk.beep();
				}
			}
		});
	}
	
	//metodo que permite introducir solo numeros en los JTextField
	
	public void SNumeros(JTextField a)
	{
		a.addKeyListener(new KeyAdapter() 
		{			
			public void keyTyped(KeyEvent e)
			{
				char c=e.getKeyChar();
				
				if(Character.isLetter(c))
				{
					e.consume();
                                        tk.beep();
				}
			}
		});
	}
        
        public void longitudCampo(final JTextField a)
	{
		a.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent e)
			{
				if(a.getText().length()==9)
				{
					e.consume();
                                        tk.beep();
				}
                                
                                
			}
		});
	}
         

        public void longitudCampo1(final JTextField a)
	{
		a.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent e)
			{
				if(a.getText().length()==10)
				{
					e.consume();
                                        tk.beep();
				}
			}
		});
	}
        
        public void longitudCampo2(final JTextField a)
	{
		a.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent e)
			{
				if(a.getText().length()==5)
				{
					e.consume();
                                        tk.beep();
				}
			}
		});
	}
        
        
         public void pasarTextField(final JTextField a)
         {
             a.addActionListener(new ActionListener() {

                 @Override
                 public void actionPerformed(ActionEvent e) {
                    // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                     a.transferFocus();
                 }
             });
         }
}
