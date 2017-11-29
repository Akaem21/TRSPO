package Lab2;
abstract class Pet {
    void voice() {
 }}
class Snake extends Pet {
    void voice() {
        System.out.println("Шшш-ш-ш");}}
class Dog extends Pet {
    void voice() {
        System.out.println("Гав-гав");}}
class MadDog extends Dog {
    void voice() {
        System.out.println("Ррр-р-р");}}
class Cat extends Pet {
    void voice() {
        System.out.println("Мяу-мяу");}}
class Fish extends Pet {
    void voice() {
        System.out.println("~(o.o)~");}}
public class Abstract {
    public static void main(String[] args) {
        Snake snake = new Snake();
        snake.voice();
        Dog boni = new Dog();
        boni.voice();
        MadDog richard = new MadDog();
        richard.voice();
        Cat naum = new Cat();
        naum.voice();
        Fish nemo = new Fish();
        nemo.voice();}}
