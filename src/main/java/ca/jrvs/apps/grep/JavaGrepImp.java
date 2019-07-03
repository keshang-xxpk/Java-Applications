package ca.jrvs.apps.grep;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JavaGrepImp implements JavaGrep{

    private String rootPath;
    private String regex;
    private String outFile;
    @Override
    public void process() throws IOException {
        List<String> matchedlines = new ArrayList<>();
        for(File file : listFiles(this.getRootPath())){
            for (String line : readLines(file)){
                if (containsPattern(line)){
                    matchedlines.add(line);
                }
            }
        }
        writeToFile(matchedlines);
    }

    @Override
    public List<File> listFiles(String rootDir) {
        List<File> fl = new ArrayList<>();
        File file = new File(rootDir);
        for (File f : file.listFiles()) {
            if (f.isDirectory()) {
                fl.addAll(listFiles(f.getAbsolutePath()));
            } else fl.add(f);
        }
        return fl;
    }

    @Override
    public List<String> readLines(File inputFile) {
        if(!inputFile.isFile()){
            throw new IllegalArgumentException("Not A File!");
        }
        List<String> lines = new ArrayList<>();
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(inputFile));
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);

            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return lines;
    }

    @Override
    public boolean containsPattern(String line) {
        return line.matches(this.getRegex());
    }

    @Override
    public void writeToFile(List<String> lines) throws IOException {
        FileOutputStream fos = new FileOutputStream(this.getOutFile());
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        BufferedWriter bw = new BufferedWriter(osw);

        for(String line : lines) {
            bw.write(line);
            bw.newLine();
        }
        bw.close();
    }

    @Override
    public String getRootPath() {
        return rootPath;
    }

    @Override
    public void setRootPath(String rootPath) {
        this.rootPath = rootPath;
    }

    @Override
    public String getRegex() {
        return regex;
    }

    @Override
    public void setRegex(String regex) {
        this.regex = regex;
    }

    @Override
    public String getOutFile() {
        return outFile;
    }

    @Override
    public void setOutFile(String outFile) {
        this.outFile = outFile;
    }

    public static void main(String[] args) {

        if(args.length != 3) {
            throw new IllegalArgumentException("USAGE:regex rootPath outFile");
        }

        JavaGrepImp javaGrepImp = new JavaGrepImp();
        javaGrepImp.setRegex(args[0]);
        javaGrepImp.setRootPath(args[1]);
        javaGrepImp.setOutFile(args[2]);

        try {
            javaGrepImp.process();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}