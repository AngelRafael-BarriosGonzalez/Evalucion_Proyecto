package Objetos;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.*;

public class Tabla_Informacion {
	
	//botones
	JButton crear=new JButton();
	JButton actualizar=new JButton();
	JButton eliminar=new JButton();
		
		//Matriz
		Object [][]info=new Object [200][7];
		
		//tabla y complemento
		JTable tabla;
		JScrollPane sp;
		
		private void botones() {
			crear.setText("Agregar Usuario");
			crear.setBounds(160,530,130,70);
			
			//Funcion crear
			ActionListener funcion_crear = new ActionListener() {

			 @Override
			public void actionPerformed(ActionEvent e) {

			 crear();

			 }
			};

			 // Acción del evento
			crear.addActionListener(funcion_crear);
			
			actualizar.setText("Actualizar Usuario");
			actualizar.setBounds(350,530,160,70);
			
			//Funcion actualizar
			ActionListener funcion_actualisar = new ActionListener() {

			 @Override
			public void actionPerformed(ActionEvent e) {

			 actualizar();

			 }
			};

			 // Acción del evento
			actualizar.addActionListener(funcion_actualisar);
			
			eliminar.setText("Eliminar Usuario");
			eliminar.setBounds(580,530,130,70);
			
			//Funcion eliminar
			ActionListener funcion_eliminar = new ActionListener() {

			 @Override
			public void actionPerformed(ActionEvent e) {

			 eliminar();

			 }
			};

			 // Acción del evento
			eliminar.addActionListener(funcion_eliminar);
		}
		
		private void tabla() throws ClassNotFoundException {
			String [] datos= {"Usuario","Nombre","Apellido","Rol_id","Correo","Telefono"};
			
			//cargar
					try {

					 ObjectInputStream recuperar = new ObjectInputStream(new FileInputStream("tabla_info.dat"));

					info = (Object[][]) recuperar.readObject();
					recuperar.close();

					 } catch (IOException e) {
					}
			
			tabla = new JTable(info,datos);
			sp = new JScrollPane(tabla);
			sp.setBounds(10,10,860,500);
		}
		
		private void crear() {
	    	
	    	JFrame crear=new JFrame();
			JPanel p3=new JPanel();
			p3.setLayout(null);
			
			//etiquetas
			JLabel l1=new JLabel();
			JLabel l2=new JLabel();
			JLabel l3=new JLabel();
			JLabel l4=new JLabel();
			JLabel l5=new JLabel();
			JLabel l6=new JLabel();
			JLabel l7=new JLabel();
			JLabel l8=new JLabel();

			//cajas de texto
			JTextField t1=new JTextField();
			JTextField t2=new JTextField();
			JTextField t3=new JTextField();
			JTextField t4=new JTextField();
			JTextField t5=new JTextField();
			JTextField t6=new JTextField();
			JPasswordField t7=new JPasswordField();
			
			//Boton
			JButton b1 = new JButton();
			
			l8.setText("AGREGAR USUARIOS");
			l8.setFont(new Font("Serig", Font.PLAIN, 25));
			l8.setBounds(330,0,280,80);
			l8.setVisible(true);
			p3.add(l8);
			
			l1.setText("Nombre: ");
			l1.setFont(new Font("Serig", Font.PLAIN, 25));
			l1.setBounds(45,100,110,80);
			l1.setVisible(true);
			p3.add(l1);
			
			l2.setText("Apellido: ");
			l2.setFont(new Font("Serig", Font.PLAIN, 25));
			l2.setBounds(450,100,110,80);
			l3.setVisible(true);
			p3.add(l2);
			
			l3.setText("Telefono: ");
			l3.setFont(new Font("Serig", Font.PLAIN, 25));
			l3.setBounds(45,200,160,80);
			l3.setVisible(true);
			p3.add(l3);
			
			l4.setText("Direccion: ");
			l4.setFont(new Font("Serig", Font.PLAIN, 25));
			l4.setBounds(450,200,160,80);
			l4.setVisible(true);
			p3.add(l4);
			
			l5.setText("Correo: ");
			l5.setFont(new Font("Serig", Font.PLAIN, 25));
			l5.setBounds(45,300,160,80);
			l5.setVisible(true);
			p3.add(l5);
			
			l6.setText("F/Nacimiento: ");
			l6.setFont(new Font("Serig", Font.PLAIN, 25));
			l6.setBounds(450,300,170,80);
			l6.setVisible(true);
			p3.add(l6);
			
			l7.setText("Contraseña: ");
			l7.setFont(new Font("Serig", Font.PLAIN, 25));
			l7.setBounds(45,400,160,80);
			l7.setVisible(true);
			p3.add(l7);
			
			crear.setTitle("Modificar");
			crear.setLocationRelativeTo(null);
			crear.setBounds(200,20,900,700);
			crear.setVisible(true);
			p3.setBackground(Color.white);
			crear.add(p3);
			
			//jtextfields
			t1.setBounds(200,125,200,40);
			t2.setBounds(585,125,200,40);
			t3.setBounds(200,225,200,40);
			t4.setBounds(585,225,200,40);
			t5.setBounds(200,325,200,40);
			t6.setBounds(620,325,200,40);
			t7.setBounds(200,425,200,40);
			
			p3.add(t1);
			p3.add(t2);
			p3.add(t3);
			p3.add(t4);
			p3.add(t5);
			p3.add(t6);
			p3.add(t7);
			
			//boton
					b1.setText("Guardar");
					b1.setBounds(380, 550, 150, 60);
					p3.add(b1);

					// Funcionalidad
					ActionListener ingresar = new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {

							Usuarios objeto = new Usuarios(t1.getText(),t2.getText(),Integer.parseInt(t3.getText()),t4.getText(),t5.getText(),t6.getText(),t7.getText());
							
							for (int i = 0; i < info.length; i++) {
								if(info[i][0]==null) {
							
							info[i][0]=objeto.nombre;
							info[i][1]=objeto.apellido;
							info[i][2]=objeto.telefono;
							info[i][3]=objeto.direccion;
							info[i][4]=objeto.correo;
							info[i][5]=objeto.fecha_nacimiento;
							info[i][6]=objeto.contraseña;
							
							//guardar
							try {
							ObjectOutputStream carga = new ObjectOutputStream(new FileOutputStream("tabla_info.dat"));
							carga.writeObject(info);
							carga.close();
							} catch (IOException j) {
							}
							crear.setVisible(false);

							break;
						}
					}

				}
			};

			// Acción del evento
			b1.addActionListener(ingresar);
	}
		
		private void actualizar() {
			
	    	int seleccionar=tabla.getSelectedRow();
	    	if (seleccionar!=-1) {
	    	
	    	JFrame crear=new JFrame("Modificar");
			JPanel p3=new JPanel();
			p3.setLayout(null);
			
			//etiquetas
			JLabel l1=new JLabel();
			JLabel l2=new JLabel();
			JLabel l3=new JLabel();
			JLabel l4=new JLabel();
			JLabel l5=new JLabel();
			JLabel l6=new JLabel();
			JLabel l7=new JLabel();
			JLabel l8=new JLabel();

			//cajas de texto
			JTextField t1=new JTextField();
			JTextField t2=new JTextField();
			JTextField t3=new JTextField();
			JTextField t4=new JTextField();
			JTextField t5=new JTextField();
			JTextField t6=new JTextField();
			JPasswordField t7=new JPasswordField();
			
			//Boton
			JButton b1 = new JButton();
			
			l8.setText("MODIFICAR USUARIOS");
			l8.setFont(new Font("Serig", Font.PLAIN, 25));
			l8.setBounds(330,0,280,80);
			l8.setVisible(true);
			p3.add(l8);
			
			l1.setText("Nombre: ");
			l1.setFont(new Font("Serig", Font.PLAIN, 25));
			l1.setBounds(45,100,110,80);
			l1.setVisible(true);
			p3.add(l1);
			
			l2.setText("Apellido: ");
			l2.setFont(new Font("Serig", Font.PLAIN, 25));
			l2.setBounds(450,100,110,80);
			l3.setVisible(true);
			p3.add(l2);
			
			l3.setText("Telefono: ");
			l3.setFont(new Font("Serig", Font.PLAIN, 25));
			l3.setBounds(45,200,160,80);
			l3.setVisible(true);
			p3.add(l3);
			
			l4.setText("Direccion: ");
			l4.setFont(new Font("Serig", Font.PLAIN, 25));
			l4.setBounds(450,200,160,80);
			l4.setVisible(true);
			p3.add(l4);
			
			l5.setText("Correo: ");
			l5.setFont(new Font("Serig", Font.PLAIN, 25));
			l5.setBounds(45,300,160,80);
			l5.setVisible(true);
			p3.add(l5);
			
			l6.setText("F/Nacimiento: ");
			l6.setFont(new Font("Serig", Font.PLAIN, 25));
			l6.setBounds(450,300,170,80);
			l6.setVisible(true);
			p3.add(l6);
			
			l7.setText("Contraseña: ");
			l7.setFont(new Font("Serig", Font.PLAIN, 25));
			l7.setBounds(45,400,160,80);
			l7.setVisible(true);
			p3.add(l7);
			
			crear.setTitle("Modificar");
			crear.setLocationRelativeTo(null);
			crear.setBounds(200,20,900,700);
			crear.setVisible(true);
			p3.setBackground(Color.white);
			crear.add(p3);
			
			//jtextfields
			t1.setBounds(200,125,200,40);
			t2.setBounds(585,125,200,40);
			t3.setBounds(200,225,200,40);
			t4.setBounds(585,225,200,40);
			t5.setBounds(200,325,200,40);
			t6.setBounds(620,325,200,40);
			t7.setBounds(200,425,200,40);
			
			t1.setText(info[seleccionar][0]+"");
			t2.setText(info[seleccionar][1]+"");
			t3.setText(info[seleccionar][2]+"");
			t4.setText(info[seleccionar][3]+"");
			t5.setText(info[seleccionar][4]+"");
			t6.setText(info[seleccionar][5]+"");
			t7.setText(info[seleccionar][6]+"");
			
			p3.add(t1);
			p3.add(t2);
			p3.add(t3);
			p3.add(t4);
			p3.add(t5);
			p3.add(t6);
			p3.add(t7);
			
			//boton
					b1.setText("Guardar");
					b1.setBounds(380, 550, 150, 60);
					p3.add(b1);

					// Funcionalidad
					ActionListener ingresar = new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {

							Usuarios objeto = new Usuarios(t1.getText(),t2.getText(),Integer.parseInt(t3.getText()),t4.getText(),t5.getText(),t6.getText(),t7.getText());
							
							info[seleccionar][0]=objeto.nombre;
							info[seleccionar][1]=objeto.apellido;
							info[seleccionar][2]=objeto.telefono;
							info[seleccionar][3]=objeto.direccion;
							info[seleccionar][4]=objeto.correo;
							info[seleccionar][5]=objeto.fecha_nacimiento;
							info[seleccionar][6]=objeto.contraseña;
							
							//guardar
							try {
							ObjectOutputStream carga = new ObjectOutputStream(new FileOutputStream("tabla_info.dat"));
							carga.writeObject(info);
							carga.close();
							} catch (IOException j) {
							}
							crear.setVisible(false);
						}
					};

					// Acción del evento
					b1.addActionListener(ingresar);
		} else {
			JOptionPane.showMessageDialog(null,"Debe seleccionar una Fila");
		}
	}
		
		private void eliminar() {
			int posicion = tabla.getSelectedRow();
			
			if (posicion!=-1) {
				
				for (int i = posicion; i < info.length; i++) {
					if(i==199) {
						info[i][0]=null;
						info[i][1]=null;
						info[i][2]=null;
						info[i][3]=null;
						info[i][4]=null;
						info[i][5]=null;
					} 
					else if (info[i][0]!=null) {
						info[i][0]=info[i+1][0];
						info[i][1]=info[i+1][1];
						info[i][2]=info[i+1][2];
						info[i][3]=info[i+1][3];
						info[i][4]=info[i+1][4];
						info[i][5]=info[i+1][5];
				   }
				}
				
				try {
					ObjectOutputStream tabla = new ObjectOutputStream(new FileOutputStream("tabla_vendedores.dat"));
					tabla.writeObject(info);
					tabla.close();
					} catch (IOException j) {
					}
			} else {
				JOptionPane.showMessageDialog(null,"Debe seleccionar una Fila");
				}
			tabla.clearSelection();
		}
		
		public void ejecutar() throws ClassNotFoundException{
			botones();
			tabla();
		}
}
