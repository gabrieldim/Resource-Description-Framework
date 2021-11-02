package mk.ukim.finki.model;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.util.FileManager;
import org.apache.jena.vocabulary.VCARD;

import java.io.InputStream;

public class RDFReader {
    public static void main(String[] args) {

        Model model = ModelFactory.createDefaultModel();

        String fileRDFReader = "/home/gabrieldim/Desktop/7mi semestar/vbs_lab/src/main/resources/DataForRDF.xml";
        String profileURI = "https://www.linkedin.com/in/gabriel-dimitrievski-a678761a9/";

        InputStream in = FileManager.get().open(fileRDFReader);

        if(in == null){
            throw new IllegalArgumentException("File: "+ fileRDFReader);
        }

        model.read(in, "RDF/XML");

        model.write(System.out, "TURTLE");

        Resource myLinkedInProfile = model.getResource(profileURI);

        String email =  myLinkedInProfile
                                        .getProperty(VCARD.EMAIL)
                                        .getString();

        System.out.println("PRINT THE EMAIL: " + email);

    }
}
