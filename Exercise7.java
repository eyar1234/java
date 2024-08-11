class RailroadCar{
    private int sqm;
    private int currentUsers;
    private int maxUsers;
    
    public RailroadCar(int sqm, int maxUsers){
        this.sqm = sqm;
        this.maxUsers = maxUsers;
        this.currentUsers = 0;
    }

    public RailroadCar(int sqm, int maxUsers, int currentUsers){
        this.sqm = sqm;
        this.maxUsers = maxUsers;
        this.currentUsers = currentUsers;
    }

    public RailroadCar(RailroadCar other){
        this(other.sqm, other.maxUsers, other.currentUsers);
    }
    // setters
    public void setCurrentUsers(int currentUsers){
        if(currentUsers > 0){
            this.currentUsers = currentUsers;
        }else System.err.println("the number of the users can not be negative");
    }
    public void setMaxUsers(int maxUsers){
        this.maxUsers = maxUsers;
    }
    public void setSqm(int sqm){
        if(sqm > 0){
            this.sqm = sqm;

        }
        else System.err.println("the sqm can not be negative");
    }
    //getters
    public int getCurrentUsers(){
        return this.currentUsers;
    }
    public int getMaxUsers(){
        return this.maxUsers;
    }
    public int getSqm(){
        return this.sqm;
    }

    public boolean hasSpace(int amount) {
        if (amount + this.currentUsers <= this.maxUsers) {
            System.err.println("The people can use the train.");
            return true;
        } else {
            System.err.println("There is not enough space in this train.");
            return false;
        }
    }

    public boolean addPassengers(int amount){
        if(this.hasSpace(amount)) {
            this.currentUsers += amount;
            return true;
        } else {
            System.err.println("there is no space");
            return false;
        }
        
    }
    


    public void print(){
        System.err.println( "sqm:" + this.sqm + " max users: " + this.maxUsers + " currunt user: " + this.currentUsers);
    }

}

class Train{
   private int maxSpeed;
   private String driverName;
   private RailroadCar[] cars;
   private int numOfCars;

   private final int MAX_CARS = 10;

    public Train(String driverName, int maxSpeed){
        this.driverName = driverName;
        this.maxSpeed= maxSpeed;
       this.cars = new RailroadCar[MAX_CARS];
        numOfCars = 0;
    }
    public String getDriverNameAndSpeed(){
        return "name:" +  this.driverName + " speed:" + this.maxSpeed ;
    }

    public boolean addCar(RailroadCar car){
        if(this.numOfCars < MAX_CARS){
            this.cars[this.numOfCars] = new RailroadCar(car);
            this.numOfCars ++;
            numOfCars++;
            return true;

        } else return false;
    }

    public boolean addCar(int sqm, int maxUsers){
        return this.addCar(new RailroadCar(sqm,maxUsers));
    }

    public int numOfPassengers(){
        int sum = 0;
        for(int i = 0; i< numOfCars; i++){
            sum += cars[i].getCurrentUsers();
        }
        return sum;
    }

    public RailroadCar maxPassengers(){
        int maxPassengers = Integer.MIN_VALUE;
        int maxPassengersIndex = 0;
        for(int i = 0; i<numOfCars; i++){
            if(cars[i].getCurrentUsers() < maxPassengers){
                maxPassengers = cars[i].getCurrentUsers();
                maxPassengersIndex = i;
            }

        }
        return cars[maxPassengersIndex];
    }

    public int addPassengers(int amount) {
        for (int i = 0; i < numOfCars; i++) {
            if (cars[i].hasSpace(amount)) {
                cars[i].addPassengers(amount);
                return i + 1;
            }
        }
        return 0;  
    }
    public RailroadCar[] freeCars(int amount) {
        int freeCars=0;
        for(int i=0;i<numOfCars;i++) {
            if(cars[i].hasSpace(amount)) freeCars++;
        }
        RailroadCar[] result = new RailroadCar[freeCars];
        int resultIndex=0;
        for(int i=0;i<numOfCars;i++) {
            if(cars[i].hasSpace(amount)) {
                result[resultIndex] = new RailroadCar(cars[i]);
                resultIndex++;
            }
        }
        return result;
    }

}

class Exercise7 {
    public static void main(String[] args){
        System.err.println("start:");
        Train first = new Train("dogy", 1000);

        System.err.println(first.numOfPassengers());
    }
    
}
