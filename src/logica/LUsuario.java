package logica;

import Interface.ICrud;
import bean.ParametroTipo;
import bean.Usuario;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import vista.VistaUsuario;

public class LUsuario extends VistaUsuario implements ICrud<Usuario, Boolean, Integer> {

	@Override
	public void registrar(Usuario usuario) {

		//VistaUsuario vistaUsuario = new VistaUsuario();

		try {
			FileWriter archivo1 = new FileWriter("./datos/IngresoUsuario.txt", true);
			BufferedWriter escribir = new BufferedWriter(archivo1);
			PrintWriter linea = new PrintWriter(escribir);
			linea.append(usuario.getIdentificacion() + "," + usuario.getPlanSeguimiento() + "," + usuario.getNombre()
					+ "," + usuario.getSexo() + "," + usuario.getEdad() + "," + usuario.getPeso() + ","
					+ usuario.getAltura() + "," + usuario.getCorreoElectronico() + "," + usuario.getTelefonoCelular()
					+ "," + usuario.getFechaNacimiento() + "\n");
			linea.close();
		} catch (IOException e) {
			System.out.print("Error con el trabajo del archivo");
		}

		System.out.println("");
		super.asignarUsuarioYContraseña(usuario.getIdentificacion());
		System.out.println("");

	}// CIERRE DEL METODO

	@Override
	public void listar(String rutaArchivo, JPanel panelCentro) {
		JTextArea textArea = new JTextArea();

		try {
			File archivo = new File(rutaArchivo);
			Scanner scanner = new Scanner(archivo);
			while (scanner.hasNextLine()) {
				String linea = scanner.nextLine();
				textArea.append(linea + "\n");
			}
			scanner.close();
		} catch (IOException e) {
			System.out.println("Ocurrió un error al leer el archivo");
		}
		textArea.setEditable(false);

		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setPreferredSize(new Dimension(400, 300));

		panelCentro.removeAll();
		panelCentro.setLayout(new BorderLayout());
		panelCentro.add(scrollPane, BorderLayout.CENTER);
		panelCentro.revalidate();
		panelCentro.repaint();

	}// CIERRE DEL METODO

	public void MostrarUsuario(int identificacion, JPanel panelCentro) {
	    try {
	        File archivo = new File("./datos/IngresoUsuario.txt");
	        Scanner scanner = new Scanner(archivo);
	        String sexo = "";
	        String plan = "";
	        
	        Font font = new Font("Nirmala UI", Font.PLAIN, 11);

	        while (scanner.hasNextLine()) {
	            String[] datos = scanner.nextLine().split(",");
	            if (Integer.parseInt(datos[0]) == identificacion) {

	                if (Integer.parseInt(datos[3]) == 1) {
	                    sexo = "Femenino";
	                } else {
	                    sexo = "Masculino";
	                }

	                switch (Integer.parseInt(datos[1])) {
	                    case 1:
	                        plan = "Actividad física";
	                        break;
	                    case 2:
	                        plan = "Alimentación";
	                        break;
	                    case 3:
	                        plan = "Sueño";
	                        break;
	                    default:
	                        break;
	                }

	                panelCentro.removeAll();
	                panelCentro.setLayout(new GridLayout(0, 1));

	                JLabel identificacionLabel = new JLabel("Identificación: " + datos[0]);
	                identificacionLabel.setFont(font);
	                panelCentro.add(identificacionLabel);
	                
	                JLabel planLabel = new JLabel("Plan de seguimiento: " + plan);
	                planLabel.setFont(font);
	                panelCentro.add(planLabel);
	                
	                JLabel nombreLabel = new JLabel("Nombre: " + datos[2]);
	                nombreLabel.setFont(font);
	                panelCentro.add(nombreLabel);
	                
	                JLabel sexoLabel = new JLabel("Sexo: " + sexo);
	                sexoLabel.setFont(font);
	                panelCentro.add(sexoLabel);
	                
	                JLabel edadLabel = new JLabel("Edad: " + datos[4]);
	                edadLabel.setFont(font);
	                panelCentro.add(edadLabel);
	                
	                JLabel pesoLabel = new JLabel("Peso: " + datos[5]);
	                pesoLabel.setFont(font);
	                panelCentro.add(pesoLabel);
	                
	                JLabel alturaLabel = new JLabel("Altura: " + datos[6]);
	                alturaLabel.setFont(font);
	                panelCentro.add(alturaLabel);
	                
	                JLabel correoLabel = new JLabel("Correo electrónico: " + datos[7]);
	                correoLabel.setFont(font);
	                panelCentro.add(correoLabel);
	                
	                JLabel telefonoLabel = new JLabel("Teléfono celular: " + datos[8]);
	                telefonoLabel.setFont(font);
	                panelCentro.add(telefonoLabel);
	                
	                JLabel fechaNacimientoLabel = new JLabel("Fecha de nacimiento: " + datos[9]);
	                fechaNacimientoLabel.setFont(font);
	                panelCentro.add(fechaNacimientoLabel);

	                panelCentro.revalidate();
	                panelCentro.repaint();
	                break;
	            }
	        }
	        scanner.close();
	    } catch (IOException e) {
	        JOptionPane.showMessageDialog(null, "Ocurrió un error al leer el archivo", "Error",
	                JOptionPane.ERROR_MESSAGE);
	    }
	}

	@Override
	public ParametroTipo<Boolean, Usuario> buscar(Integer identificacion) {

		boolean existe = false;
		Usuario usuario = new Usuario();

		try {
			File archivo = new File("./datos/IngresoUsuario.txt");
			Scanner scanner = new Scanner(archivo);

			while (scanner.hasNextLine()) {
				String linea = scanner.nextLine();
				String[] datos = linea.split(",");

				if (Integer.parseInt(datos[0]) == identificacion) {
					existe = true;
					usuario.setIdentificacion(Integer.parseInt(datos[0]));
					usuario.setPlanSeguimiento(Byte.parseByte(datos[1]));
					usuario.setNombre(datos[2]);
					usuario.setSexo(Byte.parseByte(datos[3]));
					usuario.setEdad(Byte.parseByte(datos[4]));
					usuario.setPeso(Float.parseFloat(datos[5]));
					usuario.setAltura(Float.parseFloat(datos[6]));
					usuario.setCorreoElectronico(datos[7]);
					usuario.setTelefonoCelular(datos[8]);
					usuario.setFechaNacimiento(LocalDate.parse(datos[9]));
					break;
				}
			}
			scanner.close();

		} catch (IOException e) {
			System.out.println("Ocurrio un error al leer el archivo");
		}

		return new ParametroTipo<>(existe, usuario);

	}// CIERRE DEL METODO

	@Override
	public void modificar(Usuario objeto) {

		//VistaUsuario vUsuario = new VistaUsuario();
		String datoAModificar = super.opcionesModificar();
		String opcion = datoAModificar.split(":")[0];
		String atributoSeleccionado = datoAModificar.split(":")[1];
		eliminar(objeto);

		switch (opcion) {
		case "1":
			objeto.setIdentificacion(Integer.parseInt(atributoSeleccionado));
			break;
		case "2":
			objeto.setNombre(atributoSeleccionado);
			break;
		case "3":
			objeto.setEdad(Byte.parseByte(atributoSeleccionado));
			break;
		case "4":
			objeto.setAltura(Float.parseFloat(atributoSeleccionado));
			break;
		case "5":
			objeto.setPeso(Float.parseFloat(atributoSeleccionado));
			break;
		case "6":
			objeto.setSexo(Byte.parseByte(atributoSeleccionado));
			break;
		case "7":
			LocalDate fechaNacimiento = LocalDate.parse(atributoSeleccionado);
			objeto.setFechaNacimiento(fechaNacimiento);
			break;
		case "8":
			objeto.setCorreoElectronico(atributoSeleccionado);
			break;
		case "9":
			objeto.setTelefonoCelular(atributoSeleccionado);
			break;
		default:
			System.out.println("Opción inválida");
			break;
		}

		registrar(objeto);

	}// CIERRE DEL METODO
	
	public void cambiarPlanSeguimiento(Usuario objeto) {

		//VistaUsuario vUsuario = new VistaUsuario();
		String datoAModificar = super.cambiarPlanSeguimiento();
		String opcion = datoAModificar.split(":")[0];
		String atributoSeleccionado = datoAModificar.split(":")[0];
		eliminar(objeto);

		objeto.setPlanSeguimiento(Byte.parseByte(atributoSeleccionado));

		registrar(objeto);

	}// CIERRE DEL METODO

	@Override
	public void eliminar(Usuario objeto) {

		try {
			File archivo = new File("./datos/IngresoUsuario.txt");
			File archivoTemp = new File("./datos/IngresoUsuarioArchivoTemp.txt");
			BufferedReader bufferedReader = new BufferedReader(new FileReader(archivo));
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(archivoTemp));
			String linea;

			while ((linea = bufferedReader.readLine()) != null) {

				String[] atributos = linea.split(",");

				int identificacion = Integer.parseInt(atributos[0]);
				if (identificacion == objeto.getIdentificacion()) {

					continue;
				}

				bufferedWriter.write(linea);
				bufferedWriter.newLine();
			}

			bufferedReader.close();
			bufferedWriter.close();

			archivo.delete();
			archivoTemp.renameTo(archivo);

		} catch (IOException e) {
			System.out.println("Ocurrió un error al eliminar el registro.");
		}

	}// CIERRE DEL METODO
	
	@Override
	public ArrayList<String> listarArchivo(JPanel panelCentro) {
	    ArrayList<String> lineasArchivo = new ArrayList<>();

	    try {
	        File archivo = new File("./datos/IngresoUsuario.txt");
	        Scanner scanner = new Scanner(archivo);
	        while (scanner.hasNextLine()) {
	            String linea = scanner.nextLine();
	            lineasArchivo.add(linea);
	        }
	        scanner.close();
	    } catch (IOException e) {
	        System.out.println("Ocurrió un error al leer el archivo");
	    }

	    JTextArea textArea = new JTextArea();
	    for (String linea : lineasArchivo) {
	        textArea.append(linea + "\n");
	    }

	    JScrollPane scrollPane = new JScrollPane(textArea);
	    scrollPane.setPreferredSize(new Dimension(400, 300));

	    panelCentro.removeAll();
	    panelCentro.setLayout(new BorderLayout());
	    panelCentro.add(scrollPane, BorderLayout.CENTER);
	    panelCentro.revalidate();
	    panelCentro.repaint();

	    serializacion(lineasArchivo);
	    
	    return lineasArchivo;
	}

	@Override
	public void serializacion(ArrayList<String> x) {
		
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./datos/IngresoUsuarioSer.txt"));
			oos.writeObject(x);
			oos.close();
			JOptionPane.showMessageDialog(null, "La serialización se ha realizado correctamente ");
		} catch (IOException e) {
			String mensajeError = "Error al realizar la serialización: " + e.getMessage();
			JOptionPane.showMessageDialog(null, mensajeError, "Error", JOptionPane.ERROR_MESSAGE);
		}

	}// CIERRE DEL METODO

	@Override
	public void deserializacion(JPanel panelCentro) {
	    try {
	        JOptionPane.showMessageDialog(null, "Deserializando el archivo: ");
	        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./datos/IngresoUsuarioSer.txt"));
	        ArrayList<String> registros = (ArrayList<String>) ois.readObject();
	        ois.close();

	        JTextArea textArea = new JTextArea(10, 30);
	        textArea.setEditable(false);

	        for (String registro : registros) {
	            textArea.append(registro + "\n");
	        }

	        JScrollPane scrollPane = new JScrollPane(textArea);

	        panelCentro.removeAll();
	        panelCentro.setLayout(new BorderLayout());
	        panelCentro.add(scrollPane, BorderLayout.CENTER);
	        panelCentro.revalidate();
	        panelCentro.repaint();
	    } catch (IOException | ClassNotFoundException e) {
	        JOptionPane.showMessageDialog(null, "Ocurrió un error al deserializar el archivo: " + e.getMessage(),
	                "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}



}// CIERRE DE LA CLASE