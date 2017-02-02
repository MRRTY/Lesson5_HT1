import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by Greg on 30.01.2017.
 */
public class FileController implements FileFilter {
    private String input;
    private String output;
    private ArrayList<String> filter = new ArrayList<>();
    public FileController() {
    }



    public FileController(String input, String output, ArrayList<String> filter) {

        this.input = input;
        this.output = output;
        this.filter = filter;
    }

    public void copyAll(){
        File in = new File(input);
        for(File f : in.listFiles()){
            if(accept(f.getAbsoluteFile())){
                String outputFileName = output+"/"+f.getName();
                File outputFile = new File(outputFileName);
                try {
                    outputFile.createNewFile();
                    copy(f,outputFile);

                }catch (IOException e){
                    System.out.print(e);
                }
            }
        }

    }
    public static void copy(File inputFile,File outputFile){
        try (FileInputStream fis = new FileInputStream(inputFile);
            FileOutputStream fos = new FileOutputStream(outputFile)) {
            byte[] buffer = new byte[1024];
            int byteread = 0;
            for (; (byteread = fis.read(buffer)) > 0;) {
                fos.write(buffer, 0, byteread);
            }
        }
        catch (IOException e) {
            System.out.println(e);
        }

    }

    @Override
    public boolean accept(File pathname) {
        int lastPoint = pathname.getName().lastIndexOf(".");
        if(lastPoint == -1) {
            return false;
        }
       String ext = pathname.getName().substring(lastPoint+1);
        if(filter.indexOf(ext) != -1)
            return true;
        return false;
    }

    @Override
    public String toString() {
        return "FileController{" +
                "input='" + input + '\'' +
                ", output='" + output + '\'' +
                ", filter=" + filter +
                '}';
    }

    public ArrayList<String> getFilter() {
        return filter;
    }

    public void setFilter(ArrayList<String> filter) {
        this.filter = filter;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }
}
