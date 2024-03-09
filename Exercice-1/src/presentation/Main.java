package presentation;


import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {


        List<String> words = Arrays.asList(
                "Serendipity",
                "Quixotic",
                "Mellifluous",
                "Pernicious",
                "Labyrinthine",
                "Nebulous",
                "Ephemeral",
                "Cacophony",
                "Ineffable",
                "Resplendent"
        );

        System.out.println("\n********** Affichage Q1 **********");
        System.out.println(words.stream().filter(word -> !word.contains("a")).collect(Collectors.toList()));

        System.out.println("\n********** Affichage Q2 **********");
        System.out.println(
                words.stream()
                        .parallel()
                        .filter(word -> word.length() > 3)
                        .map(word -> new StringBuilder(word).reverse().toString())
                        .collect(Collectors.toList())
        );


        System.out.println("\n********** Affichage Q3 **********");
        System.out.println(
                words.stream()
                        .parallel()
                        .filter(word -> word.contains("e"))
                        .map(word -> word.chars().mapToObj(c -> (char) c).collect(Collectors.toList()))
                        .collect(Collectors.toList())
        );


        System.out.println("\n********** Affichage Q4 **********");
        System.out.println(
                words.stream()
                        .parallel()
                        .map(String::toUpperCase)
                        .collect(Collectors.toList())
        );

        System.out.println("\n********** Affichage Q5 **********");
        System.out.println(
                words.stream()
                        .parallel()
                        .map(String::length)
                        .collect(Collectors.toList())
        );

        System.out.println("\n********** Affichage Q7 **********");
        System.out.println(
                words.stream()
                        .parallel()
                        .map(word -> word.chars().mapToObj(c -> (char) c).collect(Collectors.toList()))
                        .flatMap(List<Character>::stream )
                        .collect(Collectors.toList())
        );

        System.out.println("\n********** Affichage Q8 **********");
        System.out.println(
                words.stream()
                        .parallel()
                        .map(word -> word + " - "+ words.indexOf(word))
                        .collect(Collectors.toList())
        );
    }

}
