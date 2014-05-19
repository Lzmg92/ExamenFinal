import javax.swing.*;
import java.io.*;
import java.util.*;

/**
 * Created by Leslie on 18/05/2014.
 */
public class ExamenFinal_201314808 {

    public static void main(String[] args) {

    String ruta, cifra1, cifra2;
    LinkedList <String >registro = new LinkedList<String>();
  
        File archivo;
        archivo = new File(args[0]);


        try{

            FileReader read = new FileReader(archivo);
            BufferedReader bufer=new BufferedReader(read);

            int lineas=Integer.parseInt(bufer.readLine());

            for(int numlin=1;numlin<=lineas;numlin++){

                String lin = bufer.readLine();
                String[]vec = lin.split(" ");

                if(vec[0].length()== vec[1].length()){

                   cifra1 = vec[0];
                   cifra2 = vec[1];

                String temp;


                for(int i=0;i<cifra1.length();i++){
                    temp =""+cifra2.charAt(cifra2.length()-1);

                    for(int j=0;j<cifra2.length()-1;j++){
                        temp=temp + cifra2.charAt(j);
                    }
                    if(temp.equals(cifra1)){

                        String casosi = "Caso # "+numlin+"\t es reciclable ->"+temp ;
                        System.out.println(casosi);
                        registro.add(casosi);
                        break;
                    }
                    else{
                        cifra2=temp;

                    }
                    if(i==cifra1.length()-1){
                        String casono = "Caso # "+numlin+"\t no es reciclable";
                        System.out.println(casono);
                        registro.add(casono);
                    }

                }
                }}


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String [] pila = new String[registro.size()];
        for(int i=0;i<registro.size();i++){
            pila[i]= registro.get(i);}


        //escritura
        File f;
        f = new File("Salida.txt");

        try{
            FileWriter w = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(w);
            PrintWriter wr = new PrintWriter(bw);

            for (int i = 0; i<pila.length;i++){
                wr.write(pila[i]);
                wr.write(System.lineSeparator());
            }


            wr.close();
            bw.close();

        } catch (IOException e) {e.printStackTrace();}
    }




    }

