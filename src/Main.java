public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Андреев Андрей Андреевич", "Бухгалтер", "+79998887766", 30000, 25);
        employees[1] = new Employee("Вадимов Вадим Вадимович", "Инженер", "+75634567765", 40000, 27);
        employees[2] = new Employee("Иванов Иван Иванович", "Начальник отдела", "88005553535", 80000, 30);
        employees[3] = new Employee("Сергеев Сергей Сергеевич", "Консультант", "+79106885544", 30000, 25);
        employees[4] = new Employee("Alex Sandro", "Футболист", "+79999999999", 20000000, 33);
    }

}

class Employee {
    public String fullName;
    public String jobTitle;
    public String phoneNumber;
    public int salary;
    public int age;

    public Employee(String fullName, String jobTitle, String phoneNumber, int salary, int age) {
        this.fullName = fullName;
        this.jobTitle = jobTitle;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void printInfo() {
        System.out.println("Сотрудник: " + this.fullName + "\n" + "Должность: " + this.jobTitle + "\n" +
                "Телефон: " + this.phoneNumber + "\n" + "Зарплата: " + this.salary + "\n" + "Возраст: " + this.age);
    }
}

class Park {
    public String name;
    Attraction attraction;

    public class Attraction {
        public int workingHours;
        public int price;
    }
}