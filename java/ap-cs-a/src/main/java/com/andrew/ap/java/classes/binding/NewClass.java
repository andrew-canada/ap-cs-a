package com.andrew.ap.java.classes.binding;

//Java Program to Illustrate Static Binding

//Main class
class NewClass {
    public static class SuperClass {

        // Method of inner class
        static void print() {

            // Print statement
            System.out.println(
                    "print() in superclass is called");
        }
    }

    public static class SubClass extends SuperClass {

        // Method of inner class
        static void print() {

            // print statement
            System.out.println(
                    "print() in subclass is called");
        }
    }

// Method of main class
// Main driver method
    public static void main(String[] args) {

        // Creating objects of static inner classes
        // inside main() method
        SuperClass A = new SuperClass();
        SuperClass B = new SubClass();

        SuperClass.print();
        SubClass.print();
        // Calling method over above objects
        A.print();
        B.print();
    }
}