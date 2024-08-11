class Person {
    private String name;
    private long id;
    private int age;

    // Constructor with default age
    public Person(String name, long id, int age) {
        this.name = (name != null && !name.isEmpty()) ? name : "John Doe";
        this.id = id;
        this.age = age;
    }

    // Overloaded constructor with default age
    public Person(String name, long id) {
        this(name, id, 30);
    }

    // Getters
    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Method to add a year to age
    public void addYear() {
        this.age++;
    }

    // Method to compare age
    public boolean isBigger(Person other) {
        return this.age > other.age;
    }

    // Main method to demonstrate functionality
    public static void main(String[] args) {
        Person adam = new Person("adam ben tov", 3432423, 24);
        Person adi = new Person("adi ben tovim", 123456789);

        adam.addYear();
        adi.addYear();

        if (adam.isBigger(adi)) {
            System.out.println("adam is bigger than adi");
        } else {
            System.out.println("adi is bigger then adam" );
        }
    }
}


