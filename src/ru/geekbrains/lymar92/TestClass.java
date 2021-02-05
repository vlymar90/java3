package ru.geekbrains.lymar92;

public class TestClass {
    @BeforeSuite
    public void begin() {
        System.out.println("Инициализация компонентов");
    }

    @Test(value = 5)
    public void testOne() {
       System.out.println("Выполненние testOne");
   }

   @Test(value = 2)
    public void testTwo() {
        System.out.println("Выполненние testTwo");
    }

    @Test(value = 7)
    public void testThree() {
        System.out.println("Выполненние testThree");
    }

    @Test(value = 4)
    public void testFor() {
        System.out.println("Выполненние testFor");
    }

    @Test(value = 5)
    public void testFive() {
        System.out.println("Выполненние testFive");
    }

    @AfterSuite
    public void EndTest() {
        System.out.println("Завершение тестирования");
    }
}
