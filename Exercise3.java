import java.util.Random;

 class Exercise3 {
    public String name;
    public String job;
    public int[] scores;
    public int numOfScore;

    // Constructor
    public Exercise3(String name, String job) {
        this.name = name;
        this.job = job;
        this.numOfScore = 0;
        this.scores = new int[10];
    }

    // Copy constructor
    public Exercise3(Exercise3 someOne) {
        this.name = someOne.name;
        this.job = someOne.job;
        this.numOfScore = someOne.numOfScore;
        this.scores = new int[someOne.scores.length];
        System.arraycopy(someOne.scores, 0, this.scores, 0, someOne.scores.length);
    }

    // Getter and Setter methods
    public String getJob() {
        return this.job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getScores() {
        return this.scores;
    }

    public boolean addGrade(int score) {
        for (int i = 0; i < this.scores.length; i++) {
            if (this.scores[i] == 0) {
                this.scores[i] = score;
                this.numOfScore++; // Increment numOfScore
                return true; // Exits the method and the loop
            }
        }
        return false; // Returns false if no zero was found
    }
    
    public double computeAvg() {
        if (numOfScore == 0) return 0.0; // Avoid division by zero

        int sum = 0;
        for (int i = 0; i < numOfScore; i++) {
            sum += this.scores[i];
        }
        return (double) sum / numOfScore;
    }

    public boolean compareAvg(Exercise3 other) {
        return this.computeAvg() > other.computeAvg();
    }

    public void print() {
        System.out.print("The name of the student is " + this.name +
                         ", works in " + this.job + 
                         ". Their grades are: ");
        
        // Print scores
        for (int i = 0; i < this.scores.length; i++) {
            if (this.scores[i] != 0) {
                System.out.print(this.scores[i] + " ");
            }
        }
        System.out.println();
    }

    // Main method to test the class
    public static void main(String[] args) {
        Random r = new Random();

        Exercise3[] students = new Exercise3[3];
        students[0] = new Exercise3("avi", "workout");
        students[1] = new Exercise3("adam", "R&D");
        students[2] = new Exercise3("dana", "psychologic");

        for (int i = 0; i < students.length; i++) {
            for (int j = 0; j < 10; j++) {
                students[i].addGrade(r.nextInt(100)+ 1);
            }
            students[i].print();
            System.out.println("Average: " + students[i].computeAvg());
        }

        double maxAvg = Double.MIN_VALUE;
        int maxAvgIndex = 0;

        for (int i = 0; i < students.length; i++) {
            if (students[i].computeAvg() > maxAvg) {
                maxAvg = students[i].computeAvg();
                maxAvgIndex = i;
            }
        }

        // Print the student with the highest average
        System.out.println("Student with the highest average:");
        students[maxAvgIndex].print();
        System.out.println("Average: " + students[maxAvgIndex].computeAvg());
    }
}
