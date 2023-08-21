
package logica;

import bean.Dieta;
import bean.Usuario;
import bean.UsuarioDieta;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LUsuarioDieta {

    public void hacerComposicion(UsuarioDieta usuarioDieta) throws IOException {
        
        RandomAccessFile archivo = new RandomAccessFile("./datos/Dieta/IngresoUsuarioDieta.txt", "rw");
        archivo.seek(archivo.length());

        Usuario usuario = usuarioDieta.getUsuario();
        Dieta dieta = usuarioDieta.getDieta();

        archivo.writeInt(usuario.getIdentificacion());
        archivo.writeFloat(usuario.getPeso());
        archivo.writeByte(usuario.getSexo());
        archivo.writeInt(usuario.getEdad());

        for (byte alimento : dieta.getAlimentosConsumidos()) {
            archivo.writeByte(alimento);
        }

        archivo.writeShort(dieta.getCaloriasTotales());
        archivo.writeInt(dieta.getFecha().getYear());
        archivo.writeInt(dieta.getFecha().getMonthValue());
        archivo.writeInt(dieta.getFecha().getDayOfMonth());

        archivo.close();
    }

    public ArrayList<String> listarArchivoPlanoAleatorio() throws IOException {
        RandomAccessFile archivo = new RandomAccessFile("./datos/Dieta/IngresoUsuarioDieta.txt", "r");
        long registros = archivo.length() / 35; //33 bytes

        ArrayList<String> listaRegistros = new ArrayList<>();

        System.out.println("Información del archivo plano aleatorio:");

        for (int i = 0; i < registros; i++) {
            int identificacion = archivo.readInt();
            float peso = archivo.readFloat();
            byte sexo = archivo.readByte();
            int edad = archivo.readInt();

            List<Byte> alimentosConsumidos = new ArrayList<>();
            byte alimento = archivo.readByte();
            while (alimento != 0) {
                alimentosConsumidos.add(alimento);
                alimento = archivo.readByte();
            }

            short caloriasTotales = archivo.readShort(); //arreglar

            int year = archivo.readInt();//arreglar
            int dayOfMonth = archivo.readInt();//arreglar
            int month = archivo.readInt();//arreglar
            LocalDate fecha = LocalDate.of(year, month, dayOfMonth);//arreglar


            String registro = "Registro " + (i + 1) + ":\n"
                    + "Identificación: " + identificacion + "\n"
                    + "Peso: " + peso + "\n"
                    + "Sexo: " + sexo + "\n"
                    + "Edad: " + edad + " años\n"
                    + "Alimentos consumidos: " + alimentosConsumidos + "\n"
                    + "Calorías totales: " + caloriasTotales + "\n"
                    + "Fecha: " + fecha + "\n"
                    + "----------------------";

            listaRegistros.add(registro);

            System.out.println(registro);
        }

        archivo.close();

        return listaRegistros;
    }
 
    public void serializacion(ArrayList<String> x) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./datos/Dieta/IngresoUsuarioDieta.ser"));
            oos.writeObject(x);
            oos.close();
            System.out.println("La serialización se ha realizado correctamente.");
        } catch (IOException e) {
            System.err.println("Error al realizar la serialización: " + e.getMessage());
        }

//        deserializacion();

    }//CIERRE DEL METODO

    
    public void deserializacion() {
        try {
            System.out.println("Deserlizando el archivo: ");
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./datos/Dieta/IngresoUsuarioDieta.ser"));
            ArrayList<String> registros = (ArrayList<String>) ois.readObject();
            ois.close();

            for (String registro : registros) {
                System.out.println(registro);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ocurrió un error al deserializar el archivo");
        }
        
    }//CIERRE DEL METODO


}//CIERRE DE LA CLASE
