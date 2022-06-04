import org.junit.Test;
import stev.booleans.Source.Core.src.stev.booleans.*;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
 // #26###81#3##7#8##64###5###7#5#1#7#9###39#51###4#3#2#5#1###3###25##2#4##9#38###46#
public class Main {
    public static Valuation v = new Valuation();

    public static final PropositionalVariable X = new PropositionalVariable("x");

    public static final PropositionalVariable Y = new PropositionalVariable("y");

    public static final PropositionalVariable Z = new PropositionalVariable("z");

    public static final PropositionalVariable T = new PropositionalVariable("t");

    public static final PropositionalVariable U = new PropositionalVariable("u");

    public static final PropositionalVariable P = new PropositionalVariable("p");

    public static final PropositionalVariable Q = new PropositionalVariable("q");

    public static void main(String[] args){
        String Sudoku = args[0];
        boxContainsOnlyOneNumber(Sudoku);
        OneNumberInEachRow(Sudoku);
        OneNumberInEachColumn(Sudoku);
        OneNumberInEach3x3(Sudoku);
        System.out.println(X.evaluate(v));
        System.out.println(Y.evaluate(v));
        System.out.println(Z.evaluate(v));
        System.out.println(T.evaluate(v));
    }

    private static void boxContainsOnlyOneNumber(String Sudoku) {
        boolean value = (Sudoku.length()== 81);
        v.put("x", value);
    }

    private static void OneNumberInEachRow(String Sudoku) {
        boolean value= true;
        for(int i=0; i < Sudoku.length() ; i+=9) {
            ArrayList<Character> b = new ArrayList<Character>();
            for(int j=i; j < i+9 ; j++) {
                char c = Sudoku.charAt(j);
                if(c!='#' && b.contains(c)){
                    value = false;
                }
                else if(c!='#' && !b.contains(c)){
                    b.add(c);
                }
            }
        }
        v.put("y", value);
    }

    private static void OneNumberInEachColumn(String Sudoku){
        boolean value= true;
        for(int j=0; j < 9 ; j++) {
            ArrayList<Character> b = new ArrayList<Character>();
            for(int i=j; i < Sudoku.length() ; i+=9) {
                char c = Sudoku.charAt(i);
                if(c!='#' && b.contains(c)){
                    value = false;
                }
                else if(c!='#' && !b.contains(c)){
                    b.add(c);
                }
            }
        }
        v.put("z", value);
    }

     private static void OneNumberInEach3x3(String Sudoku) {
         boolean value= true;
         for(int ThreeByThreeAxisX=0; ThreeByThreeAxisX<3; ThreeByThreeAxisX++) {
             for(int ThreeByThreeAxisY=0; ThreeByThreeAxisY<3; ThreeByThreeAxisY++) {
                 ArrayList<Character> b = new ArrayList<Character>();
                 for(int i=0; i< 3;i++) {
                     for(int j=0; j< 3;j++) {
                         int XCoordinate = ThreeByThreeAxisX * 3 + i;
                         int YCoordinate = ThreeByThreeAxisY * 3 + j;
                         int Index = XCoordinate*9 + YCoordinate;
                         char c = Sudoku.charAt(Index);
                         if(c!='#' && b.contains(c)){
                             value = false;
                         }
                         else if(c!='#' && !b.contains(c)){
                             b.add(c);
                         }
                     }
                 }
//                 System.out.println(b);
             }
         }
         v.put("t", value);
     }

}
