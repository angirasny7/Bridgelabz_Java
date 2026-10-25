
package Inheritance;

// Superclass
class Animal {
    String name;
    int age;

    Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void makeSound() {
        System.out.println("Animal makes a sound.");
    }

    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

// Subclass Dog
class Dog extends Animal {
    Dog(String name, int age) {
        super(name, age);
    }

    @Override
    void makeSound() {
        System.out.println(name + " says: Woof! Woof!");
    }
}

// Subclass Cat
class Cat extends Animal {
    Cat(String name, int age) {
        super(name, age);
    }

    @Override
    void makeSound() {
        System.out.println(name + " says: Meow! Meow!");
    }
}

// Subclass Bird
class Bird extends Animal {
    Bird(String name, int age) {
        super(name, age);
    }

    @Override
    void makeSound() {
        System.out.println(name + " says: Tweet! Tweet!");
    }
}

// Main class
public class AnimalDemo {
    public static void main(String[] args) {
        Animal dog = new Dog("Bruno", 3);
        Animal cat = new Cat("Kitty", 2);
        Animal bird = new Bird("Tweety", 1);

        dog.displayInfo();
        dog.makeSound();

        System.out.println();

        cat.displayInfo();
        cat.makeSound();

        System.out.println();

        bird.displayInfo();
        bird.makeSound();
    }
}
