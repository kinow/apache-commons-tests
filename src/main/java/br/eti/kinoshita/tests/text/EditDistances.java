package br.eti.kinoshita.tests.text;

import java.util.Collections;

// TODO: pending PR
// import org.apache.commons.text.similarity.SorensenDiceSimilarity;

// import info.debatty.java.stringsimilarity.SorensenDice;

public class EditDistances {

    public static void main2(String[] args) {
        System.out.println("Testing jaccard sim/dis with empty strings");
        System.out.println("---");
        org.simmetrics.metrics.Jaccard<String> j1 = new org.simmetrics.metrics.Jaccard<>();
        float s1 = j1.compare(Collections.emptySet(), Collections.emptySet());
        System.out.println("Simmetrics Jaccard similarity: " + s1);
        float d1 = j1.distance(Collections.emptySet(), Collections.emptySet());
        System.out.println("Simmetrics Jaccard distance: " + d1);
        
        System.out.println("---");
        
        info.debatty.java.stringsimilarity.Jaccard j2 = new info.debatty.java.stringsimilarity.Jaccard();
        double s2 = j2.similarity("", "");
        System.out.println("javastringsimilarity Jaccard similarity: " + s2);
        double d2 = j2.distance("", "");
        System.out.println("javastringsimilarity Jaccard distance: " + d2);
        
        System.out.println("---");
        
        org.apache.commons.text.similarity.JaccardSimilarity j3_1 = new org.apache.commons.text.similarity.JaccardSimilarity();
        double s3 = j3_1.apply("", "");
        System.out.println("commons-text Jaccard similarity: " + s3);
        org.apache.commons.text.similarity.JaccardDistance j3_2 = new org.apache.commons.text.similarity.JaccardDistance();
        double d3 = j3_2.apply("", "");
        System.out.println("commons-text Jaccard distance: " + d3);
    }
    
    public static void main(String[] args) {
//        SorensenDiceSimilarity sd1 = new SorensenDiceSimilarity();
//        double d1 = sd1.apply("", "");
//        System.out.println(d1);
//        
//        SorensenDice sd2 = new SorensenDice();
//        double d2 = sd2.similarity("", "");
//        System.out.println(d2);
    }
}
