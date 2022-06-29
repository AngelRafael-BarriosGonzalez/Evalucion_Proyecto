package Objetos;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Menu_principal {
	JFrame principal=new JFrame(); 
	JTabbedPane pestañas=new JTabbedPane();
	
	//Paneles para pestañas
	JPanel tabladeinformacion=new JPanel();
	JPanel agregarusuarios=new JPanel();
	
	Tabla_Informacion ti=new Tabla_Informacion();
	
	private void valores_iniciales() throws ClassNotFoundException {
		
		//Frame datos
		principal.setTitle("Modulo Administrador");
		principal.setLocationRelativeTo(null);
		principal.setBounds(200,20,900,700);
		principal.setVisible(true);
		JButton cerrar=new JButton("Cerrar Sesion");
		cerrar.setBackground(Color.red);
		cerrar.setForeground(Color.white);
		cerrar.setBounds(670,0,200,20);
		
		//Funcion cerrar
		ActionListener funcion_cerrar = new ActionListener() {

		 @Override
		public void actionPerformed(ActionEvent e) {

		 login log=new login();
		 log.ejecutar();
		 
		 principal.setVisible(false);

		 }
		};

		 // Acción del evento
		cerrar.addActionListener(funcion_cerrar);
		
		principal.add(cerrar);
		principal.add(pestañas);
		
		
		
		//color de los paneles
		tabladeinformacion.setBackground(Color.white);
		
		tabladeinformacion.setLayout(null);
		
		//agregamos los paneles
		pestañas.addTab("Tabla de Informacion", tabladeinformacion);
		
		ti.ejecutar();
		tabladeinformacion.add(ti.crear);
		tabladeinformacion.add(ti.actualizar);
		tabladeinformacion.add(ti.eliminar);
		tabladeinformacion.add(ti.sp);
		
	}
	
	public void ejecutar() throws ClassNotFoundException{
		valores_iniciales();
	}
	
}
