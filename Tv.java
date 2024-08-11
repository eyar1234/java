public class Tv {
    private String chanel;
    private int volume;
    public boolean on;

    public Tv() {
        this.on = false;
    }
    // set the chanel
    public void setChanel(String chanel){
        this.chanel = chanel;
    }
    // get the chanel
    public String getChanel(){
        return this.chanel;
    }
    // set volume
    public void setVolume(int volume){
        if(volume < 0) {
            volume = 0;
        }else {
            this.volume += volume;
        }
    }
    // get volume
    public int getVolume(){
        return this.volume;
    }
    // turn on / off
    public void turn(boolean Situation) {
        this.on = Situation;
    }
    // get if the tv is on or off
    public boolean getOn(){
        return this.on;
    }

    public void changeVolume(int amount) {
        if(this.volume - amount >= 0) {
            this.volume += amount;

        }
    }
    public void print() {
        System.err.println("your chanel is " + this.chanel + " , the volume is " + this.volume + " and the tv is on" );
    }
    
    public static void main(String[] args){
        Tv noa,inbar,adi;
        noa = inbar = adi = new Tv();
        noa.turn(true);
        noa.setChanel("logi");
        noa.setVolume(5);

        // what is the situation of the tv of inbar?
        inbar.print();
        // inbar change the chanel to hop
        inbar.setChanel("hop");
        // inbar change the volume
        inbar.setVolume(3);
        noa.print();
        // adi turn of the tv
        adi.turn(false);
        adi.print();

    }
}
