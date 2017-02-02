import java.io.File;
import java.util.ArrayList;

/**
 * Created by Greg on 30.01.2017.
 */
public class Main {
    public static void main(String args[]){
        ArrayList<String> filter = new ArrayList<>();
        filter.add("txt");
        filter.add("doc");
        FileController fileController = new FileController("Input","Output",filter);
        fileController.copyAll();
        System.out.print(fileController.toString());
        FileRedactor fr = new FileRedactor(new File("inputOne.txt"),new File("inputTwo.txt"),new File("output.txt"));
        fr.go();
    }
}


