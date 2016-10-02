/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidad.EntidadHabitación;
import Modelo.ModeloEmpleados;
import Modelo.ModeloHabitacion;
import Vistas.VistaLimpiadora;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Silvia
 */
public class ControladorLimpiadora implements ActionListener
{
    
    VistaLimpiadora vistaLimp = new VistaLimpiadora();
    EntidadHabitación eha = new EntidadHabitación();
    
    int contador = 0, filas = 0, resp = 0;
    
    public ControladorLimpiadora()
    {
        
    }
    
    public ControladorLimpiadora(VistaLimpiadora vistaLimp)
    {
        this.vistaLimp = vistaLimp;
    }
    
    //buscar por dni limpiadora
        
    public static List<EntidadHabitación> getDniLimpiadora(EntidadHabitación filtrarDniLimpiadora) throws SQLException, Exception
    {
	return ModeloHabitacion.getDniLimpiadora(filtrarDniLimpiadora);
    }
    
    public static void modificarHabitacion(EntidadHabitación modificarHabitacion) throws Exception 
    {
            ModeloHabitacion.modificarHabitacion(modificarHabitacion);
    }
    
   
   
   
   
    public void iniciar() throws SQLException, Exception
    {
        vistaLimp.jTextFieldDniLimp.setActionCommand("dni limpiadora");
        vistaLimp.jTextFieldDniLimp.addActionListener(this);
        
        vistaLimp.jButtonPreparada.setActionCommand("preparada");
        vistaLimp.jButtonPreparada.addActionListener(this);
                
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e!=null)
        {
            String s = e.getActionCommand();
        
        
        if(s.equals("dni limpiadora"))
        {
            eha.setDniLimpiadora(vistaLimp.jTextFieldDniLimp.getText());
            
            contador = 0;
				
	    mostrarHabitaciones();
        }
        
        else if(s.equals("preparada"))
        {
            
            filas = vistaLimp.jTableHabLimp.getSelectedRow();
            
                    if (filas == -1) 
                    {
                             JOptionPane.showMessageDialog(null, "Debe seleccionar la habitación que ha preparado");
                    }
                    
                    
                    DefaultTableModel dtm = (DefaultTableModel) vistaLimp.jTableHabLimp.getModel();
                                 
                                 
                    if(dtm.getValueAt(filas, 4).toString().equals("Preparada"))
                    {
                             JOptionPane.showMessageDialog(null, "Esa habitación ya está preparada");
                    }

                    else 
                    {
                             resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro que la habitación elegida está preparada?",
                             "Preparada", JOptionPane.YES_NO_OPTION);

                             if (resp == JOptionPane.YES_OPTION) 
                             {
                                 
                                    eha.setNHabitacion(Integer.parseInt(dtm.getValueAt(filas, 0).toString()));

                                    eha.setNPlanta(Integer.parseInt(dtm.getValueAt(filas, 1).toString()));

                                    eha.setVistas(dtm.getValueAt(filas, 2).toString());

                                    eha.setTipo(dtm.getValueAt(filas, 3).toString());

                                    eha.setEstado("Preparada");

                                    eha.setDniLimpiadora(dtm.getValueAt(filas, 5).toString());

                                    eha.setCapacidad(Integer.parseInt(dtm.getValueAt(filas, 6).toString()));
                                    
                                    eha.setDescripcion(dtm.getValueAt(filas, 7).toString());
                                    
                                    eha.setPrecio(Integer.parseInt(dtm.getValueAt(filas, 8).toString()));

                                    try {
                                        modificarHabitacion(eha);
                                        mostrarHabitaciones();
                                        
                                    } catch (Exception ex) {
                                        Logger.getLogger(ControladorLimpiadora.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                             }
                    }
        }
        }
    }

    private void mostrarHabitaciones() 
    {
        try 
	{
		String [] cabecera={"Nº habitación", "Nª planta", "Vistas", "Tipo", "Estado", "DNI limpiadora", "Capacidad", "Descripción", "Precio"};
		List<EntidadHabitación> list= ModeloHabitacion.getDniLimpiadora(eha);
					
		String[][] datos=new String[list.size()][9];
		int i;
		for (i = 0; i < list.size(); i++) 
		{
			datos[i][0]=Integer.toString(list.get(i).getNHabitacion());
			datos[i][1]=Integer.toString(list.get(i).getNPlanta());
			datos[i][2]=list.get(i).getVistas();
			datos[i][3]=list.get(i).getTipo();
			datos[i][4]=list.get(i).getEstado();
			datos[i][5]=list.get(i).getDniLimpiadora();
                        datos[i][6]=Integer.toString(list.get(i).getCapacidad());
                        datos[i][7]=list.get(i).getDescripcion();
                        datos[i][8]=Integer.toString(list.get(i).getPrecio());
		}
					
		vistaLimp.jTableHabLimp.setModel(new DefaultTableModel(datos, cabecera));
                                
                if(datos.length==0)
                {
                        JOptionPane.showMessageDialog(null, "No hay resultados para esta limpiadora");
                }
	}
                        
	catch (SQLException e1) 
	{
		e1.printStackTrace();
		JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
	} 
				
	catch (Exception e1) 
	{
		e1.printStackTrace();
		JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
	}
    }
}
