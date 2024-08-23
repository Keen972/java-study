package upcasting;

class Animal {
	void makeSound() {
		System.out.println("Some generic animal sound");
	}
}

class Dog extends Animal {
	@Override
	void makeSound() {
		System.out.println("Bark");
	}

	void fetch() {
		System.out.println("Dog is fetching the ball");
	}
}

class Cat extends Animal {
	@Override
	void makeSound() {
		System.out.println("Meow");
	}

	void scratch() {
		System.out.println("Cat is scratching");
	}
}

public class 예제 {
	public static void main(String[] args) {
		Dog dog = new Dog();
		Cat cat = new Cat();

		Animal animal1 = dog;
		Animal animal2 = cat;

		animal1.makeSound();
		animal2.makeSound();

		Animal[] zoo = { new Dog(), new Cat(), new Dog() };

		for (Animal animal : zoo) {
			animal.makeSound();
		}

	}
}
