package mk.ukim.finki.model;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.FileManager;

import java.io.InputStream;

public class Medicine {
    public static void main(String[] args) {

        Model model = ModelFactory.createDefaultModel();
        String filePDFReaderFromCourses = "/home/gabrieldim/Desktop/7mi semestar/vbs_lab/src/main/resources/hifm-dataset.ttl";

        InputStream in = FileManager.get().open(filePDFReaderFromCourses);

        if(in == null){
            throw new IllegalArgumentException("File: "+ filePDFReaderFromCourses);
        }

        model.read(in, "TURTLE");

        model.write(System.out, "TURTLE");

    }
}
