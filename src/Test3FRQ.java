import java.util.ArrayList;

public class Test3FRQ {

    public class Seat

    {
        private boolean available;
        private int tier;

        public Seat(boolean isAvail, int tierNum)
        {
            available = isAvail;
            tier = tierNum;
        }

        public boolean isAvailable()
        {  return available;  }

        public int getTier()
        {  return tier;  }

        public void setAvailability(boolean isAvail)
        {  available = isAvail;  }
    }

    public class Theater {
        private Seat[][] theaterSeats;

        public Theater(int seatsPerRow, int tier1Rows, int tier2Rows)
        {
            theaterSeats = new Seat[seatsPerRow][tier1Rows+tier2Rows];
            for(int i = 0; i < tier1Rows+tier2Rows; i++){
                for(int k = 0; k < seatsPerRow; k++){
                    if(i < tier1Rows)
                        theaterSeats[k][i] = new Seat(true, 1);
                    else
                        theaterSeats[k][i] = new Seat(true, 2);
                }
            }
        }

        public boolean reassignSeat(int fromRow, int fromCol, int toRow, int toCol){
            if((theaterSeats[fromRow][fromCol].getTier( ) <= theaterSeats[toRow][toCol].getTier( )) && (theaterSeats[toRow][toCol].isAvailable( ))){
                theaterSeats[fromRow][fromCol].setAvailability(true);
                theaterSeats[toRow][toCol].setAvailability(false);
                return true;
            }
            return false;}

    }
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
