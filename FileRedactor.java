import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Greg on 30.01.2017.
 */
public class FileRedactor {
    private File inputFirstFile;
    private File inputSecondFile;
    private File outputFile;
    private Set<String> firstSet = new HashSet<>();
    private Set<String> secondSet = new HashSet<>();

    public FileRedactor(File inputFirstFile, File inputSecondFile, File outputFile) {
        this.inputFirstFile = inputFirstFile;
        this.inputSecondFile = inputSecondFile;
        this.outputFile = outputFile;
        readToSet(inputFirstFile,firstSet);

        readToSet(inputSecondFile,secondSet);

    }

    public void readToSet(File f, Set<String> s){
       try( BufferedReader br = new BufferedReader(new FileReader(f))){
           StringBuilder sb = new StringBuilder();
           String str = "";
           while ((str = br.readLine()) != null){
               sb.append(str);
               sb.append(" ");
           }
           str = sb.toString();
           for(String st : str.split(" ")){
               s.add(st);
           }
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }
    }

    public FileRedactor() {

    }
    public void go(){
        HashSet<String> temp = new HashSet<>();
        temp.addAll(firstSet);
        firstSet.removeAll(secondSet);
        temp.removeAll(firstSet);
        try(PrintWriter pr = new PrintWriter(outputFile)) {
            for(String s : temp){
                pr.println(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String toString() {
        return "FileRedactor{" +
                "inputFirstFile=" + inputFirstFile +
                ", inputSecondFile=" + inputSecondFile +
                ", outputFile=" + outputFile +
                '}';
    }

    public File getInputFirstFile() {
        return inputFirstFile;
    }

    public void setInputFirstFile(File inputFirstFile) {
        this.inputFirstFile = inputFirstFile;
    }

    public File getInputSecondFile() {
        return inputSecondFile;
    }

    public void setInputSecondFile(File inputSecondFile) {
        this.inputSecondFile = inputSecondFile;
    }

    public File getOutputFile() {
        return outputFile;
    }

    public void setOutputFile(File outputFile) {
        this.outputFile = outputFile;
    }
}
