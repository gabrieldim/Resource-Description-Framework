package mk.ukim.finki.model;

import org.apache.jena.rdf.model.*;
import org.apache.jena.vocabulary.VCARD;

public class JenaModel {
    public static void main(String[] args) {

        String profileURI = "https://www.linkedin.com/in/gabriel-dimitrievski-a678761a9/";
        String fullName = "Gabriel D.";

        Model model = ModelFactory.createDefaultModel();

        Resource myLinkedInProfile = model.createResource(profileURI);

        myLinkedInProfile.addProperty(VCARD.FN, fullName)
                .addProperty(VCARD.Country, "MK")
                .addProperty(VCARD.EMAIL, "email@test.com")
                .addProperty(VCARD.Street,"test street 19")
                .addProperty(VCARD.ORG, model.createResource())
                        .addProperty(VCARD.NAME, "Test Name")
                        .addProperty(VCARD.LABEL, "Test Label");

        System.out.println("Printing with model.listStatements(): ");
        StmtIterator iter = model.listStatements();

        while(iter.hasNext()){
            Statement stmt = iter.nextStatement(); // get next statement
            Resource subject = stmt.getSubject(); // get the subject
            Property predicate = stmt.getPredicate(); // get the current predicate
            RDFNode object = stmt.getObject(); // get the object

            System.out.print(subject.toString());
            System.out.print(" " + predicate.toString() + " ");
            if(object instanceof Resource){
                System.out.print(object.toString());
            } else{
                // object is a literal
                System.out.print(" \"" + object.toString() + "\"");
            }
            System.out.println(" .");
        }


        System.out.println("Printing with model.print(), in Turtle: ");

        System.out.println("Print as RDF/XML");
        model.write(System.out);

        System.out.println("Print as pretty RDF/XML");
        model.write(System.out, "RDF/XML-ABBREV");

        System.out.println("Print as N-Triples:");
        model.write(System.out,"N-TRIPLES");

        System.out.println("Print as Turtle: ");
        model.write(System.out, "TURTLE");
    }
}
