package Week3;

/**
 * Created by zhouxuexuan on 11/2/17.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class LineCount extends Thread {

    private static final String PATH = "/Users/zhouxuexuan/AndroidStudioProjects/SimpleShell/lib/src/main/java/Week3";

    //input your path before start

    private File file;

    public void go() {
        FileReader reader = null;
        try {
            reader = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (reader != null) {
            LineNumberReader lnr = new LineNumberReader(reader);
            try {
                lnr.skip(Long.MAX_VALUE);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            System.out.println(file.getName() + " " + lnr.getLineNumber());
        }
    }

    public LineCount(File file) {
        super();
        this.file = file;
    }

    public static void main(String... args) {
        File folder = new File(PATH);
        // Get path and run for each file
        try {
            for (File file : folder.listFiles()) {
                if (file.isFile()) {
                    LineCount lc = new LineCount(file);
                    lc.go();
                }
            }

        }catch (NullPointerException e){
            System.out.println("Please input valid file path");
        }
    }
}
