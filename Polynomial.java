import java.io.*;
import java.io.IOException;
import java.util.*;

public class Polynomial{
    double [] coe;
    int [] exp;
    public Polynomial() {
        coe = new double[1];
        exp = new int[1];
        coe[0] = 0;
        exp[0] = 0;
    }
    public Polynomial(double[] c, int[] e) {
        int size = c.length;
        coe = new double[size];
        exp = new int[size];
        for(int i = 0; i < size; i++){
            coe[i] = c[i];
            exp[i] = e[i];
        }
    }
    public Polynomial add(Polynomial pl){
        int size = exp.length;
        int sizepl = pl.exp.length;
        int count = size + sizepl;
        for(int p = 0; p < size; p++)
        {
            for(int q = 0; q < sizepl; q++)
            {
                if(exp[p] == pl.exp[q])
                {
                    count--;
                }
            }
        }
        double[] c;
        int[] e;
        c = new double[count];
        e = new int[count];
        int i = 0;
        int j = 0;
        while(i < size){
            while(j < sizepl)
            {
                if(exp[i] == pl.exp[j])
                {
                    c[i] = pl.coe[j];
                    break;
                }
                j++;
            }
            e[i] = exp[i];
            c[i] += coe[i];
            i++;
            j = 0;
        }
        int ed  = count - 1;
        int dif = 0;
        if(c[ed] == 0)
        {
            while(j < sizepl)
            {
                i = 0;
                dif = 0;
                // System.out.println(ed);
                while(i < size){
                    
                    if(exp[i] == pl.exp[j])
                    {
                        break;
                    }
                    dif++;
                    i++;
                }
                
                if(dif == size){
                    c[ed] = pl.coe[j];
                    e[ed] = pl.exp[j];
                    ed--;
                }
                j++;
            }
        }
        Polynomial pll = new Polynomial(c, e);
        return pll;  
    }
    public double evaluate(double x){
        int size = coe.length;
        double r = 0;
        for(int i = 0; i < size; i++){
            int pow = exp[i];
            r += coe[i] * Math.pow(x, pow);
        }
        return r;
    }
    public boolean hasRoot(double x){
        double re = 0;
        if(evaluate(x) == re)
            return true;
        return false;
    }
    public Polynomial multiply(Polynomial pl)
    {
        int i = 0;
        int j = 0;
        int sizepl = pl.exp.length;
        int size = exp.length;
        double [] c = new double[sizepl];
        int [] e = new int[sizepl]; 
        Polynomial pll = new Polynomial(c, e);
        double [] cc = new double[0];
        int [] ee = new int[0]; 
        Polynomial ans = new Polynomial(cc, ee);
        while(i < size)
        {
            while(j < sizepl)
            {
                pll.coe[j] = coe[i] * pl.coe[j];
                pll.exp[j] = exp[i] + pl.exp[j];
                
                j++;
            }
            ans = ans.add(pll);
            i++;
            j = 0;
        }
        return ans;
    }

    public Polynomial (File f) throws Exception
    {
        Scanner scan = new Scanner(f);
        String con = scan.nextLine();
        scan.close();
        String [] str = con.split("(?=[-+])", 0);
        int size = str.length;
        coe = new double[size];
        exp = new int[size]; 
        int i = 0;
        while(i < size){
            String [] s = str[i].split("x",2);
            if(s.length == 1){
                coe[i] = Double.parseDouble(s[0]);
                exp[i] = 0;
            }
            else{
                coe[i] = Double.parseDouble(s[0]);
                exp[i] = Integer.parseInt(s[1]);
            }
           
            i++;
        }
    }
    public void saveToFile(String name) throws Exception{
        String re = "";
        int i = 0;
        while(i < coe.length){
            
            if(exp[i] == 0){
                if(coe[i] > 0){
                    if(i != 0){
                        re = re + "+";
                    }
                    re = re + coe[i];
                }
                else{
                    re = re + coe[i];
                }
            }
            else{
                if(coe[i] > 0){
                    if(i != 0){
                        re = re + "+";
                    }
                    re = re + coe[i] + "x" + exp[i];
                }
                else{
                    re = re + coe[i] + "x" + exp[i];
                }
            }
            i++;
        }
        FileWriter wr = new FileWriter(name);
        wr.write(re);
        wr.close();
    }
} 
