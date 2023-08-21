package logica;

import Interface.ICrud;
import bean.Dieta;
import bean.ParametroTipo;

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
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import vista.VistaDieta;

public class LDieta implements ICrud<Dieta, Boolean, LocalDate> {

	@Override
	public void registrar(Dieta dieta) {
		try {
			FileWriter archivo1 = new FileWriter("./datos/Dieta/IngresoDieta.txt", true);
			BufferedWriter escribir = new BufferedWriter(archivo1);
			PrintWriter linea = new PrintWriter(escribir);

			StringBuilder alimentos = new StringBuilder();
			for (Byte alimento : dieta.getAlimentosConsumidos()) {
				alimentos.append(alimento).append("/");
			}
			alimentos.deleteCharAt(alimentos.length() - 1);

			StringBuilder cal = new StringBuilder();
			for (short calorias : dieta.getCaloriasAlimentos()) {
				cal.append(calorias).append("-");
			}
			cal.deleteCharAt(cal.length() - 1);

			linea.append(String.valueOf(dieta.getId())).append(",").append(alimentos.toString()).append(",")
					.append(cal.toString()).append(",").append(dieta.getCaloriasTotales().toString()).append(",")
					.append(dieta.getFecha().toString()).append("\n");
			linea.close();
		} catch (IOException e) {
			System.out.print("Error con el trabajo del archivo");
		}

	}// CIERRE DEL METODO

	public short buscarNumeroEnArchivo(int numeroBuscado) {
		BufferedReader br = null;
		String linea;

		try {
			br = new BufferedReader(new FileReader("./datos/Dieta/ListaCalorias.txt"));

			while ((linea = br.readLine()) != null) {
				String[] partes = linea.split("/");

				if (partes.length == 2) {
					int numero = Integer.parseInt(partes[0].trim());
					short calorias = Short.parseShort(partes[1].trim());

					if (numero == numeroBuscado) {
						return calorias;
					}
				}
			}
		} catch (IOException e) {
			System.out.println("Error al leer el archivo: " + e.getMessage());
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					System.out.println("Error al cerrar el archivo: " + e.getMessage());
				}
			}
		}

		return -1;

	}// CIERRE DEL METODO

	public short calcularCalorias(Dieta dieta) {

		short caloriasTotales = 0;

		for (Short caloria : dieta.getCaloriasAlimentos()) {
			caloriasTotales += caloria;
		}

		return caloriasTotales;

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
			File archivo = new File("./datos/Dieta/IngresoDieta.txt");
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
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./datos/Dieta/IngresoDietaSer.txt"));
			oos.writeObject(x);
			oos.close();
			JOptionPane.showMessageDialog(null, "La serialización se ha realizado correctamente");
		} catch (IOException e) {
			String mensajeError = "Error al realizar la serialización: " + e.getMessage();
			JOptionPane.showMessageDialog(null, mensajeError, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public void deserializacion(JPanel panelCentro) {
		try {
			JOptionPane.showMessageDialog(null, "Deserializando el archivo: ");
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./datos/Dieta/IngresoDietaSer.txt"));
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

	@Override
	public ParametroTipo<Boolean, Dieta> buscar(LocalDate fecha) {

		boolean existe = false;
		Dieta dieta = new Dieta();
		ArrayList<Byte> alimentos = new ArrayList<>();
		ArrayList<Short> calorias = new ArrayList<>();

		try {
			File archivo = new File("./datos/Dieta/IngresoDieta.txt");
			Scanner scanner = new Scanner(archivo);

			while (scanner.hasNextLine()) {
				String linea = scanner.nextLine();
				String[] datos = linea.split(",");

				if (LocalDate.parse(datos[4]).equals(fecha)) {
					existe = true;
					dieta.setId(Integer.parseInt(datos[0]));

					alimentos = convertirStringEnArrayListByte(datos[1]);
					dieta.setAlimentosConsumidos(alimentos);

					calorias = convertirStringEnArrayListShort(datos[2]);
					dieta.setCaloriasAlimentos(calorias);

					dieta.setCaloriasTotales(Short.parseShort(datos[3]));
					dieta.setFecha(LocalDate.parse(datos[4]));

					break;
				}
			}
			scanner.close();

		} catch (IOException e) {
			System.out.println("Ocurrio un error al leer el archivo");
		}

		return new ParametroTipo<>(existe, dieta);

	}// CIERRE DEL METODO

	@Override
	public void modificar(Dieta dieta) {

		VistaDieta vDieta = new VistaDieta();
		LDieta lDieta = new LDieta();
		Dieta dietaEliminar = new Dieta();
		String datosAModificar;
		short caloriasTotales;
		ArrayList<Byte> alimentos = new ArrayList<>();
		datosAModificar = vDieta.opcionesModificar();
		ParametroTipo<Boolean, Dieta> pT = lDieta.buscar(dieta.getFecha());
		ParametroTipo<ArrayList<Byte>, Dieta> metodoArrayListByte = convertirStringEnArrayListByte1(datosAModificar);

		dietaEliminar = pT.getObjeto2();
		dieta.setId(dietaEliminar.getId());
		eliminar(dietaEliminar);

		alimentos = metodoArrayListByte.getObjeto1();

		dieta.setAlimentosConsumidos(alimentos);
		dieta.setCaloriasAlimentos(metodoArrayListByte.getObjeto2().getCaloriasAlimentos());
		caloriasTotales = lDieta.calcularCalorias(dieta);
		dieta.setCaloriasTotales(caloriasTotales);

		registrar(dieta);

	}// CIERRE DEL METODO

	@Override
	public void eliminar(Dieta objeto) {
		try {
			File archivo = new File("./datos/Dieta/IngresoDieta.txt");
			File archivoTemp = new File("./datos/Dieta/IngresoDietaArchivoTemp.txt");
			BufferedReader bufferedReader = new BufferedReader(new FileReader(archivo));
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(archivoTemp));
			String linea;

			while ((linea = bufferedReader.readLine()) != null) {
				String[] atributos = linea.split(",");

				LocalDate fecha = LocalDate.parse(atributos[4]);
				if (!fecha.equals(objeto.getFecha())) {
					bufferedWriter.write(linea);
					bufferedWriter.newLine();
				}
			}

			bufferedReader.close();
			bufferedWriter.close();

			archivo.delete();
			archivoTemp.renameTo(archivo);

		} catch (IOException e) {
			System.out.println("Ocurrió un error al eliminar el registro.");
		}

	}// CIERRE DEL METODO

	private ArrayList<Byte> convertirStringEnArrayListByte(String cadena) {
		List<String> elementos = Arrays.asList(cadena.split("/"));
		ArrayList<Byte> listaBytes = new ArrayList<>();

		for (String elemento : elementos) {
			byte valor = Byte.parseByte(elemento);
			listaBytes.add(valor);
		}

		return listaBytes;

	}// CIERRE DEL METODO

	private ParametroTipo<ArrayList<Byte>, Dieta> convertirStringEnArrayListByte1(String cadena) {
		Dieta dieta = new Dieta();
		short calorias;
		LDieta lDieta = new LDieta();
		List<String> elementos = Arrays.asList(cadena.split(","));
		ArrayList<Byte> listaBytes = new ArrayList<>();

		for (String elemento : elementos) {
			byte valor = Byte.parseByte(elemento);
			listaBytes.add(valor);
			calorias = lDieta.buscarNumeroEnArchivo(valor);
			dieta.getCaloriasAlimentos().add(calorias);
		}

		return new ParametroTipo<>(listaBytes, dieta);

	}// CIERRE DEL METODO

	private ArrayList<Short> convertirStringEnArrayListShort(String cadena) {
		List<String> elementos = Arrays.asList(cadena.split("-"));
		ArrayList<Short> listaShort = new ArrayList<>();

		for (String elemento : elementos) {
			try {
				int valor = Integer.parseInt(elemento);
				listaShort.add((short) valor);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}

		return listaShort;

	}// CIERRE DEL METODO

	public void buscarRegistrosPorID(int id, String rutaArchivo, JPanel panel) {
		List<String> registrosEncontrados = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
			String linea;
			while ((linea = br.readLine()) != null) {
				String[] campos = linea.split(",");
				if (campos.length >= 5 && Integer.parseInt(campos[0]) == id) {
					String idRegistro = campos[0];
					String caloriasConsumidas = campos[3];
					String fecha = campos[4];
					String registroFormateado = "ID: " + idRegistro + "\n" + "Calorias Consumidas: "
							+ caloriasConsumidas + "\n" + "Fecha: " + fecha + "\n" + "--------------";
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
