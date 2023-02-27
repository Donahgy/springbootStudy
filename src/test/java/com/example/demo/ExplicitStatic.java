package com.example.demo;

public class ExplicitStatic {
    public static void main(String[] args) {
        Cups.f2(5);
        Cups cups = new Cups();
    }
}

class Cup{
    Cup(int marker)
    {
        System.out.println("Cup("+marker+")");
    }

    void f1(int marker)
    {
        System.out.println("f1("+marker+")");
    }
}

class Cups{
    static Cup cup = new Cup(1);
    Cup cup2 = new Cup(2);

    {
        Cup cup3 = new Cup(3);
    }

    static
    {
        Cup cup4 = new Cup(4);
    }

    Cups()
    {
        System.out.println("Cups()");
    }

    static void f2(int marker)
    {
        System.out.println("f2("+marker+")");
    }
}


