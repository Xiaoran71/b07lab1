public class Polynomial{
    double [] coe;
    public Polynomial() {
        coe = new double[1];
        coe[0]= 0;
    }
    public Polynomial(double[] arr) {
        int size = arr.length;
        coe = new double[size];
        for(int i = 0; i < size; i++){
            coe[i] = arr[i];
        }
    }
    public Polynomial add(Polynomial pl){
        int size = coe.length;
        int sizepl = pl.coe.length;
        double[] ar = new double[Math.max(size, sizepl)];
        
        for(int i = 0; i < size; i++)
        {
            ar[i] += coe[i];
        }
        for(int j = 0; j < sizepl; j++)
        {
            ar[j] += pl.coe[j];
        }
        Polynomial pll = new Polynomial(ar);
        return pll;
        
    }
    public double evaluate(double x){
        int size = coe.length;
        double r = 0;
        for(int i = 0; i < size; i++){
            r += coe[i] * Math.pow(x, i);
        }
        return r;
    }
    public boolean hasRoot(double x){
        double re = 0;
        if(evaluate(x) == re)
            return true;
        return false;
    }
} 