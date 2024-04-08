//M03 Programming Assignment (2)
//Ivy Tech Community College
//SDEV 200 - Java
//Professor Bumgardner
//Nativida Muhammad
//07 April 2024

import java.util.Scanner;
import java.math.BigInteger;

public class Main {
  private BigInteger numerator;
  private BigInteger denominator;

  public Main() {
    this(BigInteger.ZERO, BigInteger.ONE);
  }

  public Main(BigInteger numerator, BigInteger denominator) {
    BigInteger gcd = numerator.gcd(denominator);
    this.numerator = numerator.divide(gcd);
    this.denominator = denominator.divide(gcd);
  }

  public Main add(Main secondRational) {
    BigInteger n = numerator.multiply(secondRational.getDenominator())
        .add(denominator.multiply(secondRational.getNumerator()));
    BigInteger d = denominator.multiply(secondRational.getDenominator());
    return new Main(n, d);
  }

  public Main subtract(Main secondRational) {
    BigInteger n = numerator.multiply(secondRational.getDenominator())
        .subtract(denominator.multiply(secondRational.getNumerator()));
    BigInteger d = denominator.multiply(secondRational.getDenominator());
    return new Main(n, d);
  }

  public Main multiply(Main secondRational) {
    BigInteger n = numerator.multiply(secondRational.getNumerator());
    BigInteger d = denominator.multiply(secondRational.getDenominator());
    return new Main(n, d);
  }

  public Main divide(Main secondRational) {
    BigInteger n = numerator.multiply(secondRational.getDenominator());
    BigInteger d = denominator.multiply(secondRational.getNumerator());
    return new Main(n, d);
  }

  public BigInteger getNumerator() {
    return numerator;
  }

  public BigInteger getDenominator() {
    return denominator;
  }

  @Override
  public String toString() {
    if (denominator.equals(BigInteger.ONE))
      return numerator + "";
    else
      return numerator + "/" + denominator;
  }

  public double doubleValue() {
    return numerator.doubleValue() / denominator.doubleValue();
  }

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("Enter the first rational number: ");
    BigInteger num1 = input.nextBigInteger();
    BigInteger den1 = input.nextBigInteger();
    Main r1 = new Main(num1, den1);

    System.out.print("Enter the second rational number: ");
    BigInteger num2 = input.nextBigInteger();
    BigInteger den2 = input.nextBigInteger();
    Main r2 = new Main(num2, den2);

    System.out.println(r1 + " + " + r2 + " = " + r1.add(r2));
    System.out.println(r1 + " - " + r2 + " = " + r1.subtract(r2));
    System.out.println(r1 + " * " + r2 + " = " + r1.multiply(r2));
    System.out.println(r1 + " / " + r2 + " = " + r1.divide(r2));
    System.out.println(r2 + " is " + r2.doubleValue());
  }
}
