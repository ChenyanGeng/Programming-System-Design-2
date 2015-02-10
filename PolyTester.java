// Name:Chenyan Geng
// USC loginid:cgeng	
// CS 455 PA2
// Spring 2013
import java.util.*;

public class PolyTester{
public static void main(String[] args){
 System.out.println("General test of create, add, eval, toFormattedString methods");
 Poly a = new Poly();
 Poly b = new Poly(new Term(3,5));
 Poly sum = a.add(b);
 System.out.println("a = "+a.toFormattedString());
 System.out.println("b = "+b.toFormattedString());
 System.out.println("sum = "+sum.toFormattedString());
 System.out.println("When x = 5:");
 System.out.println("sum = "+sum.eval(5));
 
 System.out.println("Special test of add method");
 Poly p1 = new Poly(new Term(1,5)).add(new Poly(new Term(-2,4))).add(new Poly(new Term(-3,2))).add(new Poly(new Term(5,0)));
 Poly p2 = new Poly(new Term(2,4)).add(new Poly(new Term(2,3))).add(new Poly(new Term(2,2))).add(new Poly(new Term(-1,0)));
 sum = p1.add(p2);
 System.out.println("p1 = "+p1.toFormattedString());
 System.out.println("p2 = "+p2.toFormattedString());
 System.out.println("sum = "+sum.toFormattedString());
 
 System.out.println("Test of assert"); // when test assert, we should delete the 26th, 28th, 55th and 57th lines in Poly.java at first
 Poly p3 = new Poly(new Term(1,5)).add(new Poly(new Term(-2,6)));
 Poly p4 = new Poly(new Term(0,4)).add(new Poly(new Term(2,3)));
 System.out.println("p3 = "+p3.toFormattedString());
 System.out.println("p4 = "+p4.toFormattedString());

 }
 
}
