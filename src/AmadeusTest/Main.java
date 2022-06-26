package AmadeusTest;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
//        System.out.println(1 << 2);
//
//        int i = 0;
//        System.out.println(i++);

        Person person = new Person("Ab", new Date());
        person = new Person("xsx", new Date());
        System.out.println(person.getName());

//        Dog sammy = new Dog("Sammy");
//        Cat smokey = new Cat("Smokey");
//        System.out.println(Application.getAnimalName(sammy));
//        System.out.println(Application.getAnimalName(smokey));
//
//        int[] num = {1, 6, 4, 8, 2};
//        System.out.println(SmallestInterval.findSmallestInterval(num));
    }
}
