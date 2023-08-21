package logica;

import java.io.IOException;
import java.io.RandomAccessFile;
import bean.ActividadFisica;
import bean.Usuario;
import bean.UsuarioActFisica;

import java.awt.BorderLayout;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Interface.ICrud;
import Interface.MetodosComposiciones;

public class LUsuarioActFisica implements MetodosComposiciones<UsuarioActFisica> {

	@Override
    public void hacerComposicion(UsuarioActFisica usuarioActF) throws IOException {

        RandomAccessFile archivo = new RandomAccessFile("./datos/ActividadFisica/IngresoUsuarioActF.txt", "rw");
        archivo.seek(archivo.length());

        Usuario usuario = usuarioActF.getUsuario();
        ActividadFisica actividadFisica = usuarioActF.getActividadFisica();

        archivo.writeInt(usuario.getIdentificacion());
        archivo.writeFloat(usuario.getPeso());
        archivo.writeByte(usuario.getSexo());
        archivo.writeInt(usuario.getEdad());
        archivo.writeUTF(actividadFisica.getTipoActividad());
        archivo.writeDouble(actividadFisica.getDuracion());
        archivo.writeFloat(actividadFisica.getDistanciaRecorrida());
        archivo.writeInt(actividadFisica.getFecha().getYear());
        archivo.writeInt(actividadFisica.getFecha().getMonthValue());
        archivo.writeInt(actividadFisica.getFecha().getDayOfMonth());

        archivo.close();

    }//CIERRE DEL METODO
    
	@Override
    public ArrayList<String> listarArchivoPlanoAleatorio(JPanel panelCentro) throws IOException {
        RandomAccessFile archivo = new RandomAccessFile("./datos/ActividadFisica/IngresoUsuarioActF.txt", "r");

        long registros = archivo.length() / 38; // 38 bytes

        ArrayList<String> listaRegistros = new ArrayList<>();

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        for (int i = 0; i < registros; i++) {
            int identificacion = archivo.readInt();
            float peso = archivo.readFloat();
            byte sexo = archivo.readByte();
            int edad = archivo.readInt();
            String tipoActividad = archivo.readUTF();
            double duracion = archivo.readDouble();
            float distanciaRecorrida = archivo.readFloat();
            int year = archivo.readInt();
            int month = archivo.readInt();
            int dayOfMonth = archivo.readInt();
            LocalDate fecha = LocalDate.of(year, month, dayOfMonth);

            String registro = "Registro " + (i + 1) + ":\n" +
                    "Identificación: " + identificacion + "\n" +
                    "Peso: " + peso + "\n" +
                    "Sexo: " + sexo + "\n" +
                    "Edad: " + edad + "\n" +
                    "Tipo de actividad: " + tipoActividad + "\n" +
                    "Duración de la actividad: " + duracion + " segundos" + "\n" +
                    "Distancia recorrida: " + distanciaRecorrida + " km" + "\n" +
                    "Fecha: " + fecha + "\n" +
                    "----------------------";

            listaRegistros.add(registro);
            textArea.append(registro + "\n");
        }

        archivo.close();

        JScrollPane scrollPane = new JScrollPane(textArea);
        panelCentro.removeAll();
        panelCentro.add(scrollPane);
        panelCentro.revalidate();
        panelCentro.repaint();

        serializacion(listaRegistros);

        return listaRegistros;
    }
    
	@Override
    public void serializacion(ArrayList<String> x) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream("./datos/ActividadFisica/IngresoUsuarioActFSer.txt"));
			oos.writeObject(x);
			oos.close();
			JOptionPane.showMessageDialog(null, "La serialización se ha realizado correctamente.");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al realizar la serialización: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

		}

	}// CIERRE DEL METODO

	@Override
    public void deserializacion(JPanel panelCentro) {
        try {
            JOptionPane.showMessageDialog(null, "Deserializando el archivo: ");
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./datos/ActividadFisica/IngresoUsuarioActFSer.txt"));
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
            JOptionPane.showMessageDialog(null, "Ocurrió un error al deserializar el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }





}//CIERRE DE LA CLASE