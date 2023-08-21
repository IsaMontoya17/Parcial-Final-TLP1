package logica;

import bean.Usuario;
import vista.VistaSexo;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

import javax.swing.JPanel;

public class LSexo {

    public void ordenarSegunSexo(JPanel panelCentro) {
        Usuario vec[] = new Usuario[10];
        VistaSexo vSexo = new VistaSexo();
        int i = 0;

        try {
            File archivo = new File("./datos/IngresoUsuario.txt");
            Scanner scanner = new Scanner(archivo);

            while (scanner.hasNextLine() && i < vec.length) {

                Usuario usuario = new Usuario();
                String linea = scanner.nextLine();
                String[] partes = linea.split(",");

                usuario.setIdentificacion(Integer.parseInt(partes[0]));
                usuario.setPlanSeguimiento(Byte.parseByte(partes[1]));
                usuario.setNombre((partes[2]));
                usuario.setSexo(Byte.parseByte(partes[3]));
                usuario.setEdad(Byte.parseByte(partes[4]));
                usuario.setPeso(Float.parseFloat(partes[5]));
                usuario.setAltura(Float.parseFloat(partes[6]));
                usuario.setCorreoElectronico((partes[7]));
                usuario.setTelefonoCelular((partes[8]));
                usuario.setFechaNacimiento(LocalDate.parse(partes[9]));

                vec[i] = usuario;
                i++;
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("Ocurrio un error al leer el archivo");
        }

        Usuario vecOrdenado[] = new Usuario[vec.length];
        vecOrdenado = ordenarVector(vec);
        vSexo.imprimirvector(vecOrdenado, panelCentro);

    }//CIERRE DEL METODO

    private static Usuario[] ordenarVector(Usuario vec[]) {

        Usuario[] vecM = new Usuario[vec.length];
        Usuario[] vecF = new Usuario[vec.length];
        int iM = 0;
        int iF = 0;

        for (int i = 0; i < vec.length; i++) {
            if (vec[i] != null) {
                if (vec[i].getSexo() == 2) {
                    vecM[iM] = vec[i];
                    iM++;
                } else {
                    vecF[iF] = vec[i];
                    iF++;
                }
            }
        }

        Usuario[] vecOrdenado = new Usuario[vec.length];
        int i = 0;
        for (int j = 0; j < iM; j++) {
            vecOrdenado[i] = vecM[j];
            i++;
        }
        for (int j = 0; j < iF; j++) {
            vecOrdenado[i] = vecF[j];
            i++;
        }

        return vecOrdenado;

    }//CIERRE DEL METODO

}//CIERRE DE LA CLASE
