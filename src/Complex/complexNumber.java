package Complex;

public class complexNumber {
    private double real;
    private double complex;


    //constructor
    public complexNumber () {
        this.real = 0;
        this.complex = 0;
    }
    public complexNumber(double real, double complex) {
        this.real = real;
        this.complex = complex;
    }
    public complexNumber (complexNumber number) {
        this.real = number.getReal();
        this.complex = number.getComplex();
    }


    //setters and getters
    public double getReal() {
        return this.real;
    }
    public double getComplex() {
        return this.complex;
    }
    public void setReal(double real) {
        this.real = real;
    }
    public void setComplex (double complex) {
        this.complex = complex;
    }


    //length of the vector of the complex number
    public double length (complexNumber z) {
        return Math.sqrt(
                z.getReal() * z.getReal() +
                        z.getComplex() * z.getComplex());
    }
    public double length () {
        return Math.sqrt(
                this.real*this.real +
                        this.complex*this.complex);
    }


    //conjugation of the number
    public complexNumber conjugate () {
        return new complexNumber(this.real, -this.complex);
    }



    //reciprocal --- (1/x)
    public complexNumber reciprocal () {
        complexNumber result = new complexNumber(conjugate());
        return result.divide(result.length()* result.length());
    }



    // arithmetic operations
    public complexNumber sum(complexNumber x) {
        return new complexNumber(
                this.real + x.getReal(),
                this.complex + x.getComplex());
    }
    public complexNumber sum(int x) {
        return new complexNumber(
                this.real + x,
                this.complex);
    }

    public complexNumber sum (double x) {
        return new complexNumber(
                this.real + x,
                this.complex);
    }

    public complexNumber minus (complexNumber x) {
        return new complexNumber(
                this.real - x.getReal(),
                this.complex - x.getComplex());
    }
    public complexNumber minus (int x) {
        return new complexNumber(
                this.real - x,
                this.complex);
    }

    public complexNumber minus (double x) {
        return new complexNumber(
                this.real - x,
                this.complex);
    }

    public complexNumber multiply (complexNumber x) {
        return new complexNumber(
                this.real * x.getReal() - this.complex * x.getComplex(),
                this.real * x.getComplex() - this.complex * x.getReal());
    }
    public complexNumber multiply (int x) {
        return new complexNumber(
                this.real * x,
                -this.complex * x);

    }
    public complexNumber multiply (double x) {
        return new complexNumber(
                this.real * x,
                -this.complex * x);

    }

    public complexNumber divide (complexNumber x) {
        return new complexNumber(multiply(x.reciprocal()));
    }
    public complexNumber divide (int x) {
        return new complexNumber(
                this.real / x,
                this.complex / x);
    }
    public complexNumber divide (double x) {
        return new complexNumber(
                this.real / x,
                this.complex / x);
    }







    //printers
    public static void print (complexNumber x) {
        char sign = (x.getComplex() >= 0) ? '+' : '-';
        System.out.print(x.getReal() + " " + sign + " i" + Math.abs(x.getComplex()));
    }
    public void print () {
        char sign = (this.complex >= 0) ? '+' : '-';
        System.out.print(this.real + " " + sign + " i" + Math.abs(this.complex));
    }



}