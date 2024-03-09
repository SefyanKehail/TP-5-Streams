package presentation;

import metier.Employe;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Employe> employes = Arrays.asList(
                new Employe("NomEmploye2", "DepartementEmploye2", 12000),
                new Employe("NomEmploye1", "DepartementEmploye1", 8000),
                new Employe("NomEmploye3", "DepartementEmploye3", 31000)
        );

        System.out.println("\n**************** Affichage Q1 ****************");
        System.out.println(
                employes.stream()
                        .parallel()
                        .mapToDouble(Employe::getSalaire)
                        .sum()
        );

        System.out.println("\n**************** Affichage Q2 ****************");
        // forEach tout simplement ne marche pas avec parallel, sinon on supprime parallel() et on utilise forEach simple
        employes.stream()
                .parallel()
                .sorted(Comparator.comparing(Employe::getNom))
                .forEachOrdered(System.out::println);

        System.out.println("\n**************** Affichage Q2 ****************");
        employes.stream()
                .parallel()
                .sorted(Comparator.comparing(Employe::getNom))
                .forEachOrdered(System.out::println);


        System.out.println("\n**************** Affichage Q3 ****************");
        System.out.println(
                employes.stream()
                        .parallel()
                        .min(Comparator.comparing(Employe::getSalaire))
        );

        System.out.println("\n**************** Affichage Q4 ****************");
        System.out.println(
                employes.stream()
                        .parallel()
                        .filter(employe -> employe.getSalaire() > 8000)
                        .collect(Collectors.toList())
        );

        System.out.println("\n**************** Affichage Q5 ****************");
        employes.stream()
                .parallel()
                .reduce(
                        (employe1, employe2) -> employe1.getSalaire() > employe2.getSalaire() ? employe1 : employe2)
                .ifPresent(System.out::println);


        System.out.println("\n**************** Affichage Q6 ****************");
        employes.stream()
                .parallel()
                .map(Employe::getNom)
                .reduce(
                        (employeNom1, employeNom2) ->  employeNom1+employeNom2)
                .ifPresent(System.out::println);
    }
}
