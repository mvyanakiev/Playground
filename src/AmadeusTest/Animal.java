package AmadeusTest;

abstract class Animal {
    protected String name;

    String getName() {
        return this.name;
    }
}

class Dog extends Animal {
    Dog(String name) {
        this.name = name;
    }
}

class Cat extends Animal {
    Cat(String name) {
        this.name = name;
    }
}

class Application {

    static String getAnimalName(Animal a) {
        String name = null;
        if (a instanceof Dog) {
            name = ((Dog) a).getName();
        } else if (a instanceof Cat) {
            name = ((Cat) a).getName();
        }

        return name;
    }
}
