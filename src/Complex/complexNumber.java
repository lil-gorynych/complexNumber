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
        +7) Translate to angle form
        8) Translate to normal form
        9) Power
       +10) Normalize in normal form
        11) Normalize in angle form
       +12) get quarter
       +13)is zero?


     */


    private double real;
    private double complex;
    boolean normalForm;

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
    //setter of the whole number
    public void changeNumber (complexNumber x) {
        setReal(x.getReal());
        setComplex(x.getComplex());
    }

    //length of the vector of the complex number
    public double length () {
        return Math.sqrt(
                getReal()*getReal() +
                        getComplex()*getComplex());
    }

    //normalize the vector - vector with the length 1
    public complexNumber normalized () throws Exception {
        return new complexNumber(divide(length()));
    }


    //conjugation of the number
    public complexNumber conjugate () {
        return new complexNumber(getReal(), -getComplex());
    }



    //reciprocal --- (1/x)
    public complexNumber reciprocal () throws Exception {
        return conjugate().divide(length()*length());
    }


    // arithmetic operations
    //PLUS
    public complexNumber sum (complexNumber x) {
        return new complexNumber(
                getReal() + x.getReal(),
                getComplex() + x.getComplex());
    }
    public complexNumber sum (double x) {
        return new complexNumber(
                getReal() + x,
                getComplex());
    }

    //MINUS
    public complexNumber minus (complexNumber x) {
        return new complexNumber(getReal() - x.getReal(),
                getComplex() - x.getComplex());
    }
    public complexNumber minus (double x) {
        return new complexNumber(getReal() - x,
                getComplex());
    }

    //MULTIPLY
    public complexNumber multiply (complexNumber x) {
        return new complexNumber(
                getReal() * x.getReal() - getComplex() * x.getComplex(),
                getReal() * x.getComplex() + getComplex() * x.getReal());
    }
    public complexNumber multiply (double x) {
        return new complexNumber(
                getReal() * x,
                getComplex() * x);
    }

    //Division
    public complexNumber divide (complexNumber x) throws Exception{
        return multiply(x.reciprocal());
    }
    public complexNumber divide (double x) throws Exception{
        if (x == 0) {
            throw new Exception("Division be zero!");
        }
        return new complexNumber(
                getReal() / x,
                getComplex() / x);
    }






    /// check is it complex
    public boolean isReal () {
        return (getComplex() == 0);
    }
    public boolean isZero () {
        return (length() == 0);
    }


    //angle format
    //1)get quarter
    //0 goes if there some equals 0
    public int getQuarter () {
        if (getReal() > 0 && getComplex() == 0) return 41;
        if (getReal() > 0 && getComplex() > 0) return 1;
        if (getReal() == 0 && getComplex() > 0) return 12;
        if (getReal() < 0 && getComplex() > 0) return 2;
        if (getReal() < 0 && getComplex() == 0) return 23;
        if (getReal() < 0 && getComplex() < 0) return 3;
        if (getReal() == 0 && getComplex() < 0) return 34;
        if (getReal() > 0 && getComplex() < 0) return 4;
        return 0;
    }
    //2) get quarter
    public double getAngle () {
        switch (getQuarter()) {
            case 41: return 0;
            case 12: return 90;
            case 23: return 180;
            case 34: return 270;
        }

        double angle = Math.atan( Math.abs(getComplex() / getReal()));
        switch (getQuarter()) {
            case 1: return Math.toDegrees(angle);
            case 2: return 180 - Math.toDegrees(angle);
            case 3: return 180 + Math.toDegrees(angle);
            case 4: return 360 - Math.toDegrees(angle);
            default: return -1;
        }
    }
    //3) transform
    public double[] transformToAngleForm () {
        return new double[]{length(), getAngle()};
    }

    //transform from angle form to normal
    public complexNumber transformToNormalForm (double[] arr) {

    }

    //printers
    public void println () {
        System.out.println(toString());
    }
    public void print () {
        System.out.print(toString());
    }

    //toString
    public String toString () {
        if (isReal()) return (Double.toString(getReal()));
        else {
            char sign = (getComplex() > 0) ? '+' : '-';
            return getReal() + " " + sign + " i" + getComplex();
        }
    }



    //234 - 01:25
}