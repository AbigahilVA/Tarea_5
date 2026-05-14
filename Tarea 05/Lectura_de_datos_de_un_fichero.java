import java.io.*;

class LeeFichero {
public static void main(String [] arg) {

File archivo = null;
FileReader reader = null;
BufferedReader buffer = null;

try {
archivo = new File("C:\\Users\\victo\\Desktop\\Tarea 05\\Lectura_de_datos_de_un_fichero.txt");
reader = new FileReader (archivo);
buffer = new BufferedReader(reader);
String linea;
while( (linea=buffer.readLine()) != null) {
System.out.println(linea);

}
}

catch(Exception e){
e.printStackTrace();

}finally{
try{
if( null != fr ){
fr.close();

}
}

catch (Exception e2){
e2.printStackTrace();

}
}
}
}