package Complex;

public class complexNumber {

    /*
    ToDo:

    Constructors:
        +1) Zero constructor
        +2) Complex constructor
        +3) Copy constructor
        +etc. setters and getters

    Operations:
        +1) length
        +2) conjugate
        +3) reciprocal
        +4) arithmetic:
            +1. plus
            +2. minus
            +3. multiply
            +4. divide
        +5) print (1, 2, 3, 4)
        +6) Is it complex?
        7) Translate to angle form
        8) Translate to normal form
        9) Power
        10) Normalize in normal form
        11) Normalize in angle form


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
                getReal()*getReal() +
                        getComplex()*getComplex());
    }


    //conjugation of the number
    public complexNumber conjugate () {
        return new complexNumber(getReal(), -getComplex());
    }



    //reciprocal --- (1/x)
    public complexNumber reciprocal () {
        return conjugate().divide(length()*length());
    }


    // arithmetic operations
    public complexNumber sum(complexNumber x) {
        return new complexNumber(
                getReal() + x.getReal(),
                getComplex() + x.getComplex());
    }
    public static complexNumber sum(complexNumber x, complexNumber y) {
        return new complexNumber(
                x.getReal() + y.getReal(),
                x.getComplex() + y.getComplex());
    }
    public complexNumber sum (double x) {
        return new complexNumber(
                getReal() + x,
                getComplex());
    }

    public complexNumber minus (complexNumber x) {
        return new complexNumber(
                getReal() - x.getReal(),
                getComplex() - x.getComplex());
    }
    public static complexNumber minus (complexNumber y, complexNumber x) {
        return new complexNumber(
                y.getReal() - x.getReal(),
                y.getComplex() - x.getComplex());
    }
    public complexNumber minus (double x) {
        return new complexNumber(
                getReal() - x,
                getComplex());
    }

    public complexNumber multiply (complexNumber x) {
        return new complexNumber(
                getReal() * x.getReal() - getComplex() * x.getComplex(),
                getReal() * x.getComplex() + getComplex() * x.getReal());
    }
    public static complexNumber multiply (complexNumber y, complexNumber x) {
        return new complexNumber(
                y.getReal() * x.getReal() - y.getComplex() * x.getComplex(),
                y.getReal() * x.getComplex() + y.getComplex() * x.getReal());
    }
    public complexNumber multiply (double x) {
        return new complexNumber(
                getReal() * x,
                getComplex() * x);

    }

    public complexNumber divide (complexNumber x) {
        return new complexNumber(multiply(x.reciprocal()));
    }
    public static complexNumber divide (complexNumber y, complexNumber x) {
        return new complexNumber(y.multiply(x.reciprocal()));
    }
    public complexNumber divide (double x) {
        return new complexNumber(
                getReal() / x,
                getComplex() / x);
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
            char sign = (getComplex() > 0) ? '+' : '-';
            System.out.println(getReal() + " " + sign + " i" + Math.abs(getComplex()));
        }
    }
    public void print () {
        if (isComplex()) {
            System.out.print(getReal());
        } else {
            char sign = (getComplex() > 0) ? '+' : '-';
            System.out.print(getReal() + " " + sign + " i" + Math.abs(getComplex()));

        }
    }


}