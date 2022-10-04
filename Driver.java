import java.io.*;
import java.io.IOException;
import java.util.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Driver { 
 public static void main(String [] args)throws Exception 
 { 
  // Polynomial p = new Polynomial(); 
  // System.out.println(p.evaluate(3)); 

  double [] c1 = {-1, 1}; 
  int [] e1 = {1, 2};
  Polynomial p1 = new Polynomial(c1, e1); 
  double [] c2 = {-7.3,-2, 3, 7.1}; 
  int [] e2 = {0,1,9, 4};
  Polynomial p2 = new Polynomial(c2, e2); 
  File file = new File("");
  String currentPath = file.getAbsolutePath();

  // multiply
  Polynomial m = p1.multiply(p2);
  System.out.println("_________");
  for(int i = 0; i < m.coe.length; i++){
    System.out.println(m.coe[i]);
  }
  System.out.println("_________");
  for(int i = 0; i < m.exp.length; i++){
    System.out.println(m.exp[i]);
  }

  // add
  Polynomial s = p1.add(p2); 
  System.out.println("_________");
  for(int i = 0; i < s.coe.length; i++){
    System.out.println(s.coe[i]);
  }
  System.out.println("_________");
  for(int i = 0; i < s.exp.length; i++){
    System.out.println(s.exp[i]);
  }

  // evaluate&root
  System.out.println("_________");
  System.out.println("s(1) = " + s.evaluate(1)); 
  if(s.hasRoot(1)) 
  {
    System.out.println("1 is a root of s"); 
  }
  else 
  {
    System.out.println("1 is not a root of s"); 
  }
  
  // left test
  System.out.println("_________");
  String path = currentPath + "/"+"test.txt";
  p2.saveToFile(path);
  File af = new File(path);
  Polynomial pl = new Polynomial(af);
  for(int z = 0; z < pl.coe.length; z++){
    System.out.println(pl.coe[z]);
  }
  System.out.println("_________");
  for(int g = 0; g < pl.exp.length; g++){
    System.out.println(pl.exp[g]);
  }
 }    
}