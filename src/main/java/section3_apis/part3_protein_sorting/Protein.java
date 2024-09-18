/*
 * Copyright (c) 2015 Michiel Noback [michiel.noback@gmail.com].
 * All rights reserved.
 */

package section3_apis.part3_protein_sorting;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Michiel Noback [michiel.noback@gmail.com]
 * @version 0.0.1
 */
public class Protein implements Comparable<Protein> {
    private final String name;
    private final String accession;
    private final String aminoAcidSequence;
    private GOannotation goAnnotation;

    private final Map<Character, Double> aminoAcidsMap = new HashMap<>() {{
        put('I', 131.1736);  // Isoleucine
        put('L', 131.1736);  // Leucine
        put('K', 146.1882);  // Lysine
        put('M', 149.2124);  // Methionine
        put('F', 165.19);    // Phenylalanine
        put('T', 119.1197);  // Threonine
        put('W', 204.2262);  // Tryptophan
        put('V', 117.1469);  // Valine
        put('R', 174.2017);  // Arginine
        put('H', 155.1552);  // Histidine
        put('A', 89.0935);   // Alanine
        put('N', 132.1184);  // Asparagine
        put('D', 133.1032);  // Aspartate
        put('C', 121.159);   // Cysteine
        put('E', 147.1299);  // Glutamate
        put('Q', 146.1451);  // Glutamine
        put('G', 75.0669);   // Glycine
        put('P', 115.131);   // Proline
        put('S', 105.093);   // Serine
        put('Y', 181.1894);  // Tyrosine
    }};

    /**
     * constructs without GO annotation;
     * @param name the protein name
     * @param accession the accession number
     * @param aminoAcidSequence the proteins amino acid sequence
     */
    public Protein(String name, String accession, String aminoAcidSequence) {
        this.name = name;
        this.accession = accession;
        this.aminoAcidSequence = aminoAcidSequence;
    }

    /**
     * constructs with main properties.
     * @param name the protein name
     * @param accession the accession number
     * @param aminoAcidSequence the proteins amino acid sequence
     * @param goAnnotation the GO annotation
     */
    public Protein(String name, String accession, String aminoAcidSequence, GOannotation goAnnotation) {
        this.name = name;
        this.accession = accession;
        this.aminoAcidSequence = aminoAcidSequence;
        this.goAnnotation = goAnnotation;
    }

    @Override
    public int compareTo(Protein other) {
        //YOUR CODE HERE (and remove the throw statement)
        return name.compareTo(other.name);
    }
    
    /**
     * provides a range of possible sorters, based on the type that is requested.
     * @param type the sorting type that is required
     * @return proteinSorter
     */
    public static Comparator<Protein> getSorter(SortingType type) {
        //YOUR CODE HERE (and remove the throw statement)
     switch (type) {
         case PROTEIN_NAME:
             return Comparator.comparing(Protein::getName);
         case ACCESSION_NUMBER:
             return (p1, p2) -> {
                 return p1.getAccession().toLowerCase().compareTo(p2.getAccession().toLowerCase());
             };
         case GO_ANNOTATION:
             return (p1, p2) -> {
                 int sort = 0;
                 // bio logical process
                 sort = p1.goAnnotation.getBiologicalProcess().compareTo(p2.goAnnotation.getBiologicalProcess());
                 if (sort != 0) return sort;
                 // cellulair component
                 sort = p1.goAnnotation.getCellularComponent().compareTo(p2.goAnnotation.getCellularComponent());
                 if (sort != 0) return sort;
                 // moleculair funciton
                 sort = p1.goAnnotation.getMolecularFunction().compareTo(p2.goAnnotation.getMolecularFunction());
                 return sort;
             };
         case PROTEIN_WEIGHT:
             return Comparator.comparingDouble(Protein::getMolecularWeight);
         case null:
         default:
             throw new IllegalArgumentException("Unsupported sort type: " + type);
     }

     }


    /**
     *
     * @return name the protein name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return accession the accession number
     */
    public String getAccession() {
        return accession;
    }

    /**
     *
     * @return aminoAcidSequence the amino acid sequence
     */
    public String getAminoAcidSequence() {
        return aminoAcidSequence;
    }

    /**
     *
     * @return GO annotation
     */
    public GOannotation getGoAnnotation() {
        return goAnnotation;
    }

    @Override
    public String toString() {
        return "Protein{" + "name=" + name + ", accession=" + accession + ", aminoAcidSequence=" + aminoAcidSequence + '}';
    }

    public double getMolecularWeight() {
        double weight = 0;
        for (char letter : aminoAcidSequence.toUpperCase().toCharArray()) {
            if (aminoAcidsMap.containsKey(letter)) {
                weight += aminoAcidsMap.get(letter);
            }
        }
        return weight;
    }

}
