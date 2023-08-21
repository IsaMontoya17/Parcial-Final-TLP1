
package logica;

import bean.ParametroTipo;
import bean.Sueño;
import bean.Usuario;
import bean.UsuarioActFisica;
import bean.UsuarioSueño;

import java.awt.BorderLayout;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Interface.MetodosComposiciones;

public class LUsuarioSueño implements MetodosComposiciones<UsuarioSueño> {

	@Override
    public void hacerComposicion(UsuarioSueño usuarioSueño) throws IOException {

        RandomAccessFile archivo = new RandomAccessFile("./datos/Sueño/IngresoUsuarioSueño.txt", "rw");
        archivo.seek(archivo.length());

        Usuario usuario = usuarioSueño.getUsuario();
        Sueño sueño = usuarioSueño.getSueño();

        archivo.writeInt(usuario.getIdentificacion());
        archivo.writeInt(usuario.getEdad());
        archivo.writeFloat(sueño.getDuracion());
        archivo.writeUTF(sueño.getCalidadObjetiva());
        archivo.writeInt(sueño.getFecha().getYear());
        archivo.writeInt(sueño.getFecha().getMonthValue());
        archivo.writeInt(sueño.getFecha().getDayOfMonth());

        archivo.close();

    }//CIERRE DEL METODO

	@Override
    public ArrayList<String> listarArchivoPlanoAleatorio(JPanel panelCentro) throws IOException {
        RandomAccessFile archivo = new RandomAccessFile("./datos/Sueño/IngresoUsuarioSueño.txt", "r");

        long registros = archivo.length() / 31; // 31 bytes

        ArrayList<String> listaRegistros = new ArrayList<>();

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        for (int i = 0; i < registros; i++) {
            int identificacion = archivo.readInt();
            int edad = archivo.readInt();
            float duracion = archivo.readFloat();
            String calidadObjetiva = archivo.readUTF();
            int year = archivo.readInt();
            int month = archivo.readInt();
            int dayOfMonth = archivo.readInt();

            LocalDate fecha = LocalDate.of(year, month, dayOfMonth);

            String registro = "Registro " + (i + 1) + ":\n"
                    + "Identificación: " + identificacion + "\n"
                    + "Edad: " + edad + " años\n"
                    + "Duración del sueño: " + duracion + " horas\n"
                    + "Calidad objetiva del sueño: " + calidadObjetiva + "\n"
                    + "Fecha: " + fecha + "\n"
                    + "----------------------";

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
			ObjectOutputStream oos = new ObjectOutputStream(
					new FileOutputStream("./datos/Sueño/IngresoUsuarioSueñoSer.txt"));
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
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./datos/Sueño/IngresoUsuarioSueñoSer.txt"));
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
