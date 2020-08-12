package Complex;

public class complexNumber {

    /*
    ToDo:
    Constructors:
        1) Zero constructor
        2) Complex constructor
        3) Copy constructor
        etc. setters and getters

    Operations:
        1) length
        2) conjugate
        3) reciprocal
        4) arithmetic:
            1. plus
            2. minus
            3. multiply
            4. divide
        5) print (1, 2, 3, 4)
        6) Is it complex?






     */


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
        result.divide(result.length()*result.length()).print();

        return result.divide(result.length() * result.length());
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
                - this.real * x.getComplex() - this.complex * x.getReal());
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





    /// check is it complex
    public boolean isComplex () {
        return (getComplex() == 0);
    }
    public static boolean isComplex (complexNumber x) {
        return (x.getComplex() == 0);
    }


    //printers
    public static void println (complexNumber x) {
        if (x.isComplex()) {
            System.out.println(x.getReal());
        } else {
            char sign = (x.getComplex() > 0) ? '+' : '-';
            System.out.println(x.getReal() + " " + sign + " i" + Math.abs(x.getComplex()));
        }
    }
    public static void print (complexNumber x) {
        if (x.isComplex()) {
            System.out.print(x.getReal());
        } else {
            char sign = (x.getComplex() > 0) ? '+' : '-';
            System.out.print(x.getReal() + " " + sign + " i" + Math.abs(x.getComplex()));
        }
    }
    public void println () {
        if (isComplex()) {
            System.out.println(getReal());
        } else {
            char sign = (this.complex > 0) ? '+' : '-';
            System.out.println(this.real + " " + sign + " i" + Math.abs(this.complex));
        }
    }
    public void print () {
        if (isComplex()) {
            System.out.print(getReal());
        } else {
            char sign = (this.complex > 0) ? '+' : '-';
            System.out.print(this.real + " " + sign + " i" + Math.abs(this.complex));

        }
    }


}