package logica;

import Interface.ICrud;
import bean.ActividadFisica;
import bean.ParametroTipo;
import bean.UsuarioActFisica;

import java.awt.BorderLayout;
import java.awt.Dimension;
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
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import vista.VistaActividadFisica;

public class LActividadFisica implements ICrud<ActividadFisica, Boolean, LocalDate> {

	@Override
	public void registrar(ActividadFisica actFisica) {

		VistaActividadFisica vActFisica = new VistaActividadFisica();

		try {
			FileWriter archivo1 = new FileWriter("./datos/ActividadFisica/IngresoActividadFisica.txt", true);
			BufferedWriter escribir = new BufferedWriter(archivo1);
			PrintWriter linea = new PrintWriter(escribir);
			linea.append(actFisica.getId() + "," + actFisica.getTipoActividad() + "," + actFisica.getDuracion() + ","
					+ actFisica.getDistanciaRecorrida() + "," + actFisica.getFecha() + "\n");
			linea.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error con el trabajo del archivo");
		}

		vActFisica.informeUsuario(actFisica);

	}// CIERRE DEL METODO

	@Override
	public void listar(String rutaArchivo, JPanel panelCentroIzq) {
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
			JOptionPane.showMessageDialog(null, "Ocurrió un error al leer el archivo.");
		}
		textArea.setEditable(false);

		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setPreferredSize(new Dimension(400, 300));

		panelCentroIzq.removeAll();
		panelCentroIzq.setLayout(new BorderLayout());
		panelCentroIzq.add(scrollPane, BorderLayout.CENTER);
		panelCentroIzq.revalidate();
		panelCentroIzq.repaint();

	}// CIERRE DEL METODO

	public void listar2(String rutaArchivo) {
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
			JOptionPane.showMessageDialog(null, "Ocurrió un error al leer el archivo.");
		}
		textArea.setEditable(false);

		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setPreferredSize(new Dimension(400, 300));

		JOptionPane.showMessageDialog(null, scrollPane);

	}

	@Override
	public ArrayList<String> listarArchivo(JPanel panelCentro) {
		ArrayList<String> lineasArchivo = new ArrayList<>();

		try {
			File archivo = new File("./datos/ActividadFisica/IngresoActividadFisica.txt");
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
		
	}// CIERRE DEL METODO

	@Override
	public void serializacion(ArrayList<String> x) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./datos/ActividadFisica/IngresoActividadFisicaSer.txt"));
			oos.writeObject(x);
			oos.close();
			JOptionPane.showMessageDialog(null, "La serialización se ha realizado correctamente.");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al realizar la serialización: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);

		}

	}// CIERRE DEL METODO

	@Override
	public void deserializacion(JPanel panelCentro) {
		try {
			JOptionPane.showMessageDialog(null, "Deserializando el archivo: ");
			ObjectInputStream ois = new ObjectInputStream(
			new FileInputStream("./datos/ActividadFisica/IngresoActividadFisicaSer.txt"));
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

	public String clasificacionActFisica(short tipoAct) {

		String clasificacion = "";

		if (tipoAct >= 1 && tipoAct <= 30) {
			clasificacion = "Ligera";
		} else {
			if (tipoAct >= 31 && tipoAct <= 60) {
				clasificacion = "Moderada";
			} else {
				if (tipoAct >= 61 && tipoAct <= 90) {
					clasificacion = "Intensa";
				} else {
					if (tipoAct >= 91 && tipoAct <= 120) {
						clasificacion = "Muy intensa";
					}
				}
			}
		}

		return clasificacion;

	}// CIERRE DEL METODO

	public float calcularCaloriasQuemadas(UsuarioActFisica usuarioActFisica) {

		float TMR;
		float caloriasQuemadas;
		byte mets;

		if (usuarioActFisica.getUsuario().getSexo() == 1) {
			TMR = (float) (655 + (9.56 * usuarioActFisica.getUsuario().getPeso())
					+ (1.85 * usuarioActFisica.getUsuario().getAltura())
					- (4.68 * usuarioActFisica.getUsuario().getEdad()));
		} else {
			TMR = (float) (66 + (13.75 * usuarioActFisica.getUsuario().getPeso())
					+ (5 * usuarioActFisica.getUsuario().getAltura())
					- (6.75 * usuarioActFisica.getUsuario().getEdad()));
		}

		switch (usuarioActFisica.getActividadFisica().getTipoActividad()) {
		case "Ligera":
			mets = 2;
			break;
		case "Moderada":
			mets = 4;
			break;
		case "Intensa":
			mets = 7;
			break;
		case "Muy intensa":
			mets = 10;
			break;
		default:
			throw new AssertionError();
		}

		byte duracionHoras = (byte) (usuarioActFisica.getActividadFisica().getDuracion() / 3600);
		caloriasQuemadas = (float) (mets * TMR * usuarioActFisica.getActividadFisica().getDuracion());

		return caloriasQuemadas;

	}// CIERRE DEL METODO

	@Override
	public void modificar(ActividadFisica objeto) {

		VistaActividadFisica vActFisica = new VistaActividadFisica();
		String datoAModificar = vActFisica.opcionesModificar();
		String opcion = datoAModificar.split(":")[0];
		String atributoSeleccionado = datoAModificar.split(":")[1];
		eliminar(objeto);

		switch (opcion) {
		case "1":
			objeto.setTipoActividad(atributoSeleccionado);
			break;
		case "2":
			objeto.setDuracion(Long.parseLong(atributoSeleccionado));
			break;
		case "3":
			objeto.setDistanciaRecorrida(Float.parseFloat(atributoSeleccionado));
			break;
		default:
			JOptionPane.showMessageDialog(null, "Opción inválida");
			break;
		}

		registrar(objeto);

	}// CIERRE DEL METODO

	@Override
	public void eliminar(ActividadFisica objeto) {

		try {
			File archivo = new File("./datos/ActividadFisica/IngresoActividadFisica.txt");
			File archivoTemp = new File("./datos/IngresoActFisicaArchivoTemp.txt");
			BufferedReader bufferedReader = new BufferedReader(new FileReader(archivo));
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(archivoTemp));
			String linea;

			while ((linea = bufferedReader.readLine()) != null) {

				String[] atributos = linea.split(",");

				int identificacion = Integer.parseInt(atributos[0]);
				if (identificacion == objeto.getId()) {

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
			JOptionPane.showMessageDialog(null, "Ocurrió un error al eliminar el registro.");
		}

	}// CIERRE DEL METODO

	@Override
	public ParametroTipo<Boolean, ActividadFisica> buscar(LocalDate fecha) {

		boolean existe = false;
		ActividadFisica actividadFisica = new ActividadFisica();

		try {
			File archivo = new File("./datos/ActividadFisica/IngresoActividadFisica.txt");
			Scanner scanner = new Scanner(archivo);

			while (scanner.hasNextLine()) {
				String linea = scanner.nextLine();
				String[] datos = linea.split(",");

				if (LocalDate.parse(datos[4]).equals(fecha)) {
					existe = true;
					actividadFisica.setId(Integer.parseInt(datos[0]));
					actividadFisica.setTipoActividad(datos[1]);
					actividadFisica.setDuracion(Double.parseDouble(datos[2]));
					actividadFisica.setDistanciaRecorrida(Float.parseFloat(datos[3]));
					actividadFisica.setFecha(LocalDate.parse(datos[4]));

					break;
				}
			}
			scanner.close();

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Ocurrió un error al leer el archivo.");
		}

		return new ParametroTipo<>(existe, actividadFisica);

	}// CIERRE DEL METODO

	public void buscarRegistrosPorID(int id, String rutaArchivo, JPanel panel) {
		List<String> registrosEncontrados = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
			String linea;
			while ((linea = br.readLine()) != null) {
				String[] campos = linea.split(",");
				if (campos.length >= 5 && Integer.parseInt(campos[0]) == id) {
					String registroFormateado = "ID: " + campos[0] + "\n" + "Tipo de Actividad: " + campos[1] + "\n"
							+ "Tiempo: " + campos[2] + " segundos " + "\n" + "Distancia Recorrida: " + campos[3]
							+ " Km " + "\n" + "Fecha: " + campos[4] + "\n" + "--------------";
					registrosEncontrados.add(registroFormateado);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		mostrarRegistrosEnPanel(registrosEncontrados, panel);
	}

	private void mostrarRegistrosEnPanel(List<String> registros, JPanel panel) {
		JTextArea textArea = new JTextArea(10, 40);
		JScrollPane scrollPane = new JScrollPane(textArea);
		panel.add(scrollPane);

		SwingUtilities.invokeLater(() -> {
			for (String registro : registros) {
				textArea.append(registro + "\n");
			}
		});
	}

}// CIERRE DE LA CLASE
