package Output;

import Repositorio.LeiloesRepositorio;
import java.io.*;

public class OutputFile {

    public static void writer (LeiloesRepositorio leilao)throws IOException{
        BufferedWriter writer = null;
        try {
            File arq = new File("C:\\Users\\willian\\Desktop\\Leilao\\arq.DET");
            FileOutputStream fout = new FileOutputStream(arq);
            ObjectOutputStream objout = new ObjectOutputStream(fout);
            //objout.writeObject(leilao.ApresentacaoLeilao());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
