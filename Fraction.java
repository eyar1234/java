public class Fraction {
    public int counter;
    public int denominator;
    public double shever;

    public Fraction(int counter, int denominator) {
        if (denominator == 0) {
        System.out.println("Denominator must be greater than 0");
        }
        this.counter = counter;
        this.denominator = denominator;
        this.shever = (double) counter / denominator; // Calculate shever as a double
    }

    public String setValues(int counter, int denominator) {
        if (denominator > 0) {
            this.counter = counter;
            this.denominator = denominator;
            this.shever = (double) counter / denominator; // Recalculate shever
            return "(" + counter + ", " + denominator + ")";
        } else {
            return "Denominator must be greater than 0";
        }
    }

    public double realValue() {
        return (double) counter / denominator;
    }

    public void add(Fraction other) {
        int newCounter;
        int newDenominator;
        
        if (this.denominator == other.denominator) {
            // If denominators are the same, simply add the counters
            newCounter = this.counter + other.counter;
            newDenominator = this.denominator;
        } else {
            // Find a common denominator and adjust the counters accordingly
            newDenominator = this.denominator * other.denominator;
            newCounter = (this.counter * other.denominator) + (other.counter * this.denominator);
        }
        
        this.counter = newCounter;
        this.denominator = newDenominator;
        this.shever = (double) newCounter / newDenominator;
    }
    public static Fraction add(Fraction f1,Fraction f2) {
        int newCount,newDenominator;
        newDenominator = f1.denominator*f2.denominator;
        newCount = f1.counter*f2.denominator + f1.denominator*f2.counter;
        return new Fraction(newCount,newDenominator);
    }
    public void simplify(){
        if(this.counter > 1) {
            for(int i = 2; i< this.denominator ; i++) {
                while(this.denominator % i == 0 && this.counter % i == 0 ) {
                    this.denominator /= i;
                    this.counter /= i;
                } 
            }
        }
    }
    public void print(){
        System.err.println("the counter is " +  this.counter 
        + " and the denominator is " + this.denominator + " and the shever is " + this.shever);
    }

    public static void main(String[] args) {
        Fraction adam = new Fraction(8, 16);
        Fraction avi = new Fraction(2, 8);
        // before simplify
        System.err.println("before simplify");
        adam.print();
        avi.print();
        // after simplify
        System.err.println("after simplify");
        adam.simplify();
        avi.simplify();

        adam.print();
        avi.print();

        // add one to other
        avi.add(adam);
        avi.simplify();
        avi.print();


    }
}
