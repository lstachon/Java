package agh.cs.lab1;

import com.sun.codemodel.internal.JForEach;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class Genes {

    private int[] genes= new int[32];;
    final int gensNumber = 32;
    final int numberOfGenTypes = 8;

    public Genes() {
    fillRandomGens();
    }

    public Genes(Genes g1, Genes g2) {

            int firstcut = (int) (Math.random() * (gensNumber - 1));

            int secondcut = firstcut;
            while (secondcut == firstcut) {
                secondcut = (int) (Math.random() * (gensNumber - 1));
            }

            if (firstcut > secondcut) {
                int tmp = firstcut;
                firstcut = secondcut;
                secondcut = tmp;
            }

            for (int i = 0; i <= firstcut; i++) {
                genes[i] = g1.getGenes()[i];
            }
            for (int i = firstcut + 1; i <= secondcut; i++) {
                genes[i] = g2.getGenes()[i];
            }
            for (int i = secondcut; i < gensNumber; i++) {
                genes[i] = g1.getGenes()[i];
            }

        Arrays.sort(this.genes);
        checkIfGenesCorrect();
    }

    @Override
    public int hashCode() {
            return Arrays.hashCode(this.genes);
    }

    @Override
    public boolean equals(Object other){
        if (!(other instanceof Genes))
            return false;
        Genes that = (Genes) other;
        for(int i =0; i < gensNumber; i++){
            if(this.genes[i] != that.genes[i]){
                return false;
            }
        }
        return true;
    }

    public int[] getGenes(){
        return this.genes;
    }

    public void fillRandomGens(){
        int n = numberOfGenTypes;
        for(int i =0; i<gensNumber; i++){
            int gen = (int) (Math.random() * n);
            this.genes[i] = gen;
        }

        Arrays.sort(this.genes);
        checkIfGenesCorrect();
        printGens();
    }

    public void printGens(){
        System.out.println("GENS:");
        for(int i=0; i<gensNumber; i++){
            System.out.print(this.genes[i]+" ");
        }
        System.out.println();
    }

    public void checkIfGenesCorrect(){
        int[] geneCounter = new int[numberOfGenTypes];
        for(int i=0; i<gensNumber; i++){
            geneCounter[this.genes[i]]++;
        }
        for(int i=0; i<numberOfGenTypes; i++){
            if(geneCounter[i]==0){
                int genToChange = (int) (Math.random() * gensNumber);
                int newGene = (int) (Math.random() * numberOfGenTypes);
                genes[genToChange] = newGene;
                Arrays.sort(this.genes);
                checkIfGenesCorrect();
            }
        }
    }

    public int returnRandomGen() {
        int randomGen = (int) (Math.random() * (gensNumber));
        return genes[randomGen];
    }

}
