
package logica;

import Interface.ICrud;
import bean.ParametroTipo;
import bean.Sueño;

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

import vista.VistaSueño;

public class LSueño implements ICrud<Sueño, Boolean, LocalDate>{

    @Override
    public void registrar(Sueño sueño) {
         try {
            FileWriter archivo1 = new FileWriter("./datos/Sueño/IngresoSueño.txt", true);
            BufferedWriter escribir = new BufferedWriter(archivo1);
            PrintWriter linea = new PrintWriter(escribir);
            linea.append(sueño.getId() + "," + sueño.getDuracion() + "," + sueño.getLatencia() + "," + sueño.getAmbiente() + "," + sueño.getCalidadObjetiva()+ "," + sueño.getFecha() + "\n");
            linea.close();
        } catch (IOException e) {
        	JOptionPane.showMessageDialog(null, "Error con el trabajo del archivo", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
    
    public Sueño calcularCalidadSueño(Sueño sueño) {
    	
        String calidadObjetiva = "";

        if (sueño.getDuracion() < 4 && sueño.getAmbiente() == 2 && sueño.getLatencia() > 1 && sueño.getCalidadSubjetiva() == 1) {
            calidadObjetiva = "mala";
        } else if (sueño.getDuracion() < 4 && sueño.getAmbiente() == 2 && sueño.getLatencia() < 1 && (sueño.getCalidadSubjetiva() == 2 || sueño.getCalidadSubjetiva() == 3)) {
            calidadObjetiva = "mala";
        } else if (sueño.getDuracion() <= 4 && sueño.getAmbiente() == 1 && sueño.getLatencia() < 1 && sueño.getCalidadSubjetiva() > 3) {
            calidadObjetiva = "regular";
        } else if (sueño.getDuracion() > 4 && sueño.getAmbiente() == 2 && sueño.getLatencia() > 1 && sueño.getCalidadSubjetiva() == 1) {
            calidadObjetiva = "regular";
        } else if ((sueño.getDuracion() > 4 && sueño.getDuracion() <= 6) && sueño.getAmbiente() == 1 && sueño.getLatencia() > 1 && sueño.getCalidadSubjetiva() == 1) {
            calidadObjetiva = "buena";
        } else if (sueño.getDuracion() > 6 && sueño.getAmbiente() == 1 && sueño.getLatencia() > 1 && sueño.getCalidadSubjetiva() <= 3) {
            calidadObjetiva = "buena";
        } else if (sueño.getDuracion() > 6 && sueño.getAmbiente() == 1 && sueño.getLatencia() < 1 && sueño.getCalidadSubjetiva() > 3) {
            calidadObjetiva = "muy buena";
        } else {
            calidadObjetiva = "buena";
        }

        sueño.setCalidadObjetiva(calidadObjetiva);

        return sueño;
    }

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

    }//CIERRE DEL METODO
    
    @Override
	public ArrayList<String> listarArchivo(JPanel panelCentro) {
	    ArrayList<String> lineasArchivo = new ArrayList<>();

	    try {
	        File archivo = new File("./datos/Sueño/IngresoSueño.txt");
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
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./datos/Sueño/IngresoSueñoSer.txt"));
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
	        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./datos/Sueño/IngresoSueñoSer.txt"));
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
    public ParametroTipo<Boolean, Sueño> buscar(LocalDate fecha) {
        
        boolean existe = false;
        Sueño sueño = new Sueño();
        ArrayList<Byte> alimentos = new ArrayList<>();
        ArrayList<Short> calorias = new ArrayList<>();

        try {
            File archivo = new File("./datos/Sueño/IngresoSueño.txt");
            Scanner scanner = new Scanner(archivo);

            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] datos = linea.split(",");

                if (LocalDate.parse(datos[5]).equals(fecha)) {
                    existe = true;
                    sueño.setId(Integer.parseInt(datos[0]));
                    sueño.setDuracion(Float.parseFloat(datos[1]));
                    sueño.setLatencia(Float.parseFloat(datos[2]));
                    sueño.setAmbiente(Byte.parseByte(datos[3]));
                    sueño.setCalidadObjetiva(datos[4]);
                    sueño.setFecha(LocalDate.parse(datos[5]));
                    break;
                }
            }
            scanner.close();

        } catch (IOException e) {
            System.out.println("Ocurrio un error al leer el archivo");
        }

        return new ParametroTipo<>(existe, sueño);
    }
    
    public void buscarYDarConsejos(int identificacion) {
        
        boolean existe = false;
        Sueño sueño = new Sueño();
        ArrayList<Float> duracion = new ArrayList<>();
        ArrayList<Float> latencia = new ArrayList<>();
        ArrayList<Byte> ambiente = new ArrayList<>();
        
        try {
            File archivo = new File("./datos/Sueño/IngresoSueño.txt");
            Scanner scanner = new Scanner(archivo);

            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] datos = linea.split(",");
                
                if (Integer.parseInt(datos[0]) == identificacion) {
                    existe = true;
                    sueño.setId(Integer.parseInt(datos[0]));
                    sueño.setDuracion(Float.parseFloat(datos[1]));
                    sueño.setLatencia(Float.parseFloat(datos[2]));
                    sueño.setAmbiente(Byte.parseByte(datos[3]));
                    sueño.setCalidadObjetiva(datos[4]);
                    sueño.setFecha(LocalDate.parse(datos[5]));
                    
                    duracion.add(sueño.getDuracion());
                    latencia.add(sueño.getLatencia());
                    ambiente.add(sueño.getAmbiente());
                    
                   break;
                }
            }
            scanner.close();
            
            recorrerArrayListDuracion(duracion);
            recorrerArrayListLatencia(latencia);
            recorrerArrayListAmbiente(ambiente);
                        
        } catch (IOException e) {
            System.out.println("Ocurrio un error al leer el archivo");
        }
            
    }

    public void recorrerArrayListDuracion(ArrayList<Float> duracion) {
        
        VistaSueño vSueño = new VistaSueño();
        
        short contador=0;
        
        for (float valor : duracion) {
            if (valor < 4) {
                contador++;
            }
        }

        float porcentaje = (contador / (float) duracion.size()) * 100;


        vSueño.consejosDuracion(porcentaje);

        
    }//CIERRE DEL METODO
    
    public void recorrerArrayListLatencia(ArrayList<Float> latencia) {
        
        VistaSueño vSueño = new VistaSueño();
        
        short contador=0;
        
        for (float valor : latencia) {
            if (valor > 1) {
                contador++;
            }
        }

        float porcentaje = (contador / (float) latencia.size()) * 100;


        vSueño.consejosLatencia(porcentaje);

        
    }//CIERRE DEL METODO
    
    public void recorrerArrayListAmbiente(ArrayList<Byte> ambiente) {
        
        VistaSueño vSueño = new VistaSueño();
        
        short contador=0;
        
        for (float valor : ambiente) {
            if (valor == 2) {
                contador++;
            }
        }

        float porcentaje = (contador / (float) ambiente.size()) * 100;


        vSueño.consejosAmbiente(porcentaje);

        
    }//CIERRE DEL METODO
    
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
    public void modificar(Sueño sueño) {
        VistaSueño vSueño = new VistaSueño();
        String datoAModificar = vSueño.opcionesModificar();
        String opcion = datoAModificar.split(":")[0];
        String atributoSeleccionado = datoAModificar.split(":")[1];
        eliminar(sueño);

        switch (opcion) {
            case "1":
                sueño.setDuracion(Float.parseFloat(atributoSeleccionado));
                break;
            case "2":
                sueño.setCalidadSubjetiva(Byte.parseByte(atributoSeleccionado));
                break;
            case "3":
                sueño.setAmbiente(Byte.parseByte(atributoSeleccionado));
                break;
            case "4":
                sueño.setLatencia(Float.parseFloat(atributoSeleccionado));
                break;
            default:
                System.out.println("Opción inválida");
                break;
        }
        
        registrar(sueño);
    }

    @Override
    public void eliminar(Sueño sueño) {
        
        try {
            File archivo = new File("./datos/Sueño/IngresoSueño.txt");
            File archivoTemp = new File("./datos/Sueño/IngresoSueñoArchivoTemp.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(archivo));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(archivoTemp));
            String linea;

            while ((linea = bufferedReader.readLine()) != null) {
                String[] atributos = linea.split(",");

                LocalDate fecha = LocalDate.parse(atributos[5]);
                if (!fecha.equals(sueño.getFecha())) {
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

    }//CIERRE DEL METODO
    
    public void buscarRegistrosPorID(int id, String rutaArchivo, JPanel panel) {
    	String ambiente="";
        List<String> registrosEncontrados = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(",");
                if (campos.length >= 6 && Integer.parseInt(campos[0]) == id) {
                	
                	if(campos[3]=="1") {
                		ambiente = "Bueno";
                	}
                	else {
                		ambiente = "malo";
                	}
                	
                    String registroFormateado = "ID: " + campos[0] + "\n"
                            + "Duración: " + campos[1] + " horas\n"
                            + "Latencia: " + campos[2] + " horas\n"
                            + "Ambiente: " + ambiente + "\n"
                            + "Calidad del sueño: " + campos[4] + "\n"
                            + "Fecha: " + campos[5] + "\n"
                            + "--------------";
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
    
}//CIERRE DE LA CLASE
