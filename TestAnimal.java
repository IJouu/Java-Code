public class TestAnimal {
    public static void pushAllAnimal(Animal2[] list) {
        for (int i = 0; i < list.length; i++) {
            list[i].move();
        }
    }
    
    public static void main(String[] argv) {
        /*Animal2 a = new Animal2();
        // reference of parent's type can point to sub class object
        // polymorphism(¦h«¬)
        Animal2 b = new Dog();
        // if the method actually called is determined by
        // (1)reference type : non - virtual function
        // (2)object type : virtual function; by java
        a.move();
        b.move();
        b = new FlyDog();
        b.move();*/
        Animal2[] l = new Animal2[]{new FlyDog(), new Dog(), new Animal2(), new OldFish()};
        pushAllAnimal(l);
    }
}