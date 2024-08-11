class Worker {
    private String name;
    private int experienceYears;
    private int salary;
    private int age;

    // Constructor
    public Worker(String name, int experienceYears, int salary, int age) {
        this.name = name;
        this.experienceYears = experienceYears;
        this.salary = salary;
        this.age = age;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Add Bonus
    public void addBonus(int amount) {
        this.salary += amount;
    }

    // Print worker details
    public void print() {
        System.out.println("The name of the worker is " + this.name +
                           ", he has " + this.experienceYears + 
                           " years of experience. His salary is about " + 
                           this.salary + " and he is " + this.age + 
                           " years old.");
    }

    // Main method
    public static void main(String[] args) {
        Worker[] workers = new Worker[3];
        workers[0] = new Worker("adam", 2, 15000, 25);
        workers[1] = new Worker("adi", 4, 47000, 27);
        workers[2] = new Worker("avi", 2, 55000, 32);

        // Find the worker with the highest salary
        int maxSalary = workers[0].getSalary();
        int maxSalaryIndex = 0;

        for (int i = 1; i < workers.length; i++) {
            if (workers[i].getSalary() > maxSalary) {
                maxSalary = workers[i].getSalary();
                maxSalaryIndex = i;
            }
        }

        System.out.println("The employee with the highest salary is:");
        workers[maxSalaryIndex].print();

        // Find the oldest worker and add bonus
        int maxAge = Integer.MIN_VALUE;
        int maxAgeIndex = 0;

        for (int i = 0; i < workers.length; i++) {
            if (workers[i].getAge() > maxAge) {
                maxAge = workers[i].getAge();
                maxAgeIndex = i;
            }
        }

        System.out.println("The oldest worker is:");
        workers[maxAgeIndex].print();
        workers[maxAgeIndex].addBonus(1200);
        System.out.println("Oldest worker with bonus is:");
        workers[maxAgeIndex].print();
    }
}
