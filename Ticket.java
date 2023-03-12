import java.util.ArrayList;
import java.util.*;
public class Ticket {
    private int row;
    private int seat;
    private double price;
    private Person person;
    ArrayList<Ticket> ticketList = new ArrayList<Ticket>();

    public Ticket(int row, int seat, double price, Person person) {
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }

    // Getters and setters for each attribute
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    public void print() {
        System.out.println("Person Name: " + person.getName());
        System.out.println("Person Surname: " + person.getSurname());
        System.out.println("Person Email: " + person.getEmail());
        System.out.println("Row: " + row);
        System.out.println("Seat: " + seat);
        System.out.println("Price: " + price);
    }
    // public static void buy_ticket(int[][][] theater) {
    //     // ask for row and seat
    //     // check that the seat is available
    //     // record the seat as occupied
        
    //     // ask for Person information
    //     Scanner sc = new Scanner(System.in);
    //     System.out.println("Enter your name:");
    //     String name = sc.nextLine();
    //     System.out.println("Enter your surname:");
    //     String surname = sc.nextLine();
    //     System.out.println("Enter your email:");
    //     String email = sc.nextLine();
        
    //     // create new ticket object and add to ticketList
    //     Ticket ticket = new Ticket(row, seat, price, new Person(name, surname, email));
    //     ticketList.add(ticket);
        
    //     // print ticket information and total price
    //     print_ticket_information(ticket);
    // }
    // public static void cancel_ticket(int[][][] theater) {
    //     // ask for row and seat
    //     // check that the seat is occupied
    //     // record the seat as available
        
    //     // find the ticket in ticketList and remove it
    //     for (Ticket ticket : ticketList) {
    //         if (ticket.getRow() == row && ticket.getSeat() == seat) {
    //             ticketList.remove(ticket);
    //             System.out.println("Ticket cancelled successfully.");
    //             return;
    //         }
    //     }
        
    //     // if ticket not found
    //     System.out.println("Ticket not found.");
    // }
        
}
