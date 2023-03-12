
import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Theatre {
    private static final int ROW1_SEATS = 12;
    private static final int ROW2_SEATS = 16;
    private static final int ROW3_SEATS = 20;
    private static int[][] seats = new int[3][];
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Ticket> tickets = new ArrayList<>();

    public static void main(String[] args) {
        seats[0] = new int[ROW1_SEATS]; // Row 1 with 12 seats
        seats[1] = new int[ROW2_SEATS]; // Row 2 with 16 seats
        seats[2] = new int[ROW3_SEATS]; // Row 3 with 20 seats

        // Initialize all seats to be free
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                seats[i][j] = 0;
            }
        }
        System.out.println("------------------------------");
        System.out.println("Welcome to the New Theatre");

        int choice = -1;
        while (choice != 0) {
            printMenu();
            System.out.print("Enter option: ");
            choice = scanner.nextInt();
            handleMenuOption(choice);
        }

        System.out.println("Goodbye!");
    }

    private static void printMenu() {
        System.out.println("------------------------------");
        System.out.println("Please select an option:");
        System.out.println("1) Buy a ticket");
        System.out.println("2) Print seating area");
        System.out.println("3) Cancel ticket");
        System.out.println("4) List available seats");
        System.out.println("5) Save to file");
        System.out.println("6) Load from file");
        System.out.println("7) Print ticket information and total price");
        System.out.println("8) Sort tickets by price");
        System.out.println("0) Quit");
    }

    private static void handleMenuOption(int choice) {
        switch (choice) {
            case 0:
                System.out.println("Thank you for visit");
                System.exit(0);
                // Quit program
                break;
            case 1:
                buy_ticket(seats, tickets);
                // buy_ticket(seats);
                // Buy a ticket
                break;
            case 2:
                print_seating_area(seats);
                // Print seating area
                break;
            case 3:
                cancel_ticket(seats);
                // Cancel ticket
                break;
            case 4:
                show_available();
                // List available seats
                break;
            case 5:
                save(seats);
                // Save to file
                break;
            case 6:
                load();
                // Load from file
                break;
            case 7:
                show_tickets_info();
                // Print ticket information and total price
                break;
            case 8:
                sort_tickets(tickets);
                // Sort tickets by price
                break;
            default:
                System.out.println("Invalid option, please try again.");
        }
    }
    public static void buy_ticket(int[][] seatArray, ArrayList<Ticket> tickets) {
        Scanner input = new Scanner(System.in);
    
        // ask for row and seat number
        System.out.print("Enter row number: ");
        int rowNum = input.nextInt();
        System.out.print("Enter seat number: ");
        int seatNum = input.nextInt();
    
        // check if row and seat number are valid
        if (rowNum < 1 || rowNum > 3 || seatNum < 1 || seatNum > 20) {
            System.out.println("Invalid row or seat number.");
            return;
        }
    
        // check if the seat is already occupied
        if (seatArray[rowNum-1][seatNum-1] == 1) {
            System.out.println("The seat is already occupied.");
            return;
        }
    
        // ask for person's information
        System.out.print("Enter name: ");
        String name = input.next();
        System.out.print("Enter surname: ");
        String surname = input.next();
        System.out.print("Enter email: ");
        String email = input.next();
    
        // calculate ticket price based on the row number
        int price = 10;
        if (rowNum == 2) {
            price = 20;
        } else if (rowNum == 3) {
            price = 30;
        }
    
        // mark the seat as occupied in the seatArray
        seatArray[rowNum-1][seatNum-1] = 1;
    
        // create a new Ticket object and add it to the ArrayList
        Person person = new Person(name, surname, email);
        Ticket ticket = new Ticket(rowNum, seatNum, price, person);
        tickets.add(ticket);
    
        System.out.println("Ticket purchased successfully.");
    }
    

    public static void print_seating_area(int[][] seats) {
        // Print the stage
        System.out.println("      ***********");
        System.out.println("      * STAGE *");
        System.out.println("      ***********");

        // Print the seats
        for (int row = 0; row < seats.length; row++) {
            if (row == 0) {
                    System.out.print("     ");
            } else if (row == 1) {
                    System.out.print("   ");
            } else if (row == 2) {
                    System.out.print(" ");
            }
            for (int seat = 0; seat < seats[row].length; seat++) {
                if (row == 0) {
                    if (seat == 6) {
                        System.out.print(" ");
                    }
                } else if (row == 1) {
                    if (seat == 8) {
                        System.out.print(" ");
                    }
                } else if (row == 2) {
                    if (seat == 10) {
                        System.out.print(" ");
                    }
                }

                if (seats[row][seat] == 0) {
                    System.out.print("O");
                } else {
                    System.out.print("X");
                }
            }
            System.out.print(" ");
            System.out.println();
        }
    }

    public static void cancel_ticket(int[][] seats) {
        Scanner input = new Scanner(System.in);

        // Ask the user for the row and seat numbers
        System.out.print("Enter row number: ");
        int row = input.nextInt() - 1; // Subtract 1 to convert to 0-indexed array
        System.out.print("Enter seat number: ");
        int seat = input.nextInt() - 1; // Subtract 1 to convert to 0-indexed array

        // Check that the row and seat numbers are valid
        if (row < 0 || row >= seats.length || seat < 0 || seat >= seats[row].length) {
            System.out.println("Invalid row or seat number.");
            return;
        }

        // Check if the seat is available
        if (seats[row][seat] == 0) {
            System.out.println("Seat is already available.");
            return;
        }

        // Make the seat available
        seats[row][seat] = 0;
        System.out.println("Ticket cancelled successfully.");
    }

    public static void show_available() {
        for (int row = 0; row < seats.length; row++) {
            System.out.print("Seats available in row " + (row + 1) + ": ");
            for (int seat = 0; seat < seats[row].length; seat++) {
                if (seats[row][seat] == 0) {
                    System.out.print((seat + 1) + " ");
                }
            }
            System.out.println();
        }
    }

    public static void save(int[][] seats) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("seats.txt"));
            for (int i = 0; i < seats.length; i++) {
                for (int j = 0; j < seats[i].length; j++) {
                    writer.write(seats[i][j] + " ");
                }
                writer.newLine();
            }
            writer.close();
            System.out.println("Seats saved to file.");
        } catch (IOException e) {
            System.out.println("Error saving seats to file: " + e.getMessage());
        }
    }
    public static void load() {
                try {
                    File file = new File("seats.txt");
                    Scanner scanner = new Scanner(file);
        
                    // Load row 1
                    String[] row1 = scanner.nextLine().split(",");
                    for (int i = 0; i < row1.length; i++) {
                        seats[0][i] = Integer.parseInt(row1[i]);
                    }
        
                    // Load row 2
                    String[] row2 = scanner.nextLine().split(",");
                    for (int i = 0; i < row2.length; i++) {
                        seats[1][i] = Integer.parseInt(row2[i]);
                    }
        
                    // Load row 3
                    String[] row3 = scanner.nextLine().split(",");
                    for (int i = 0; i < row3.length; i++) {
                        seats[2][i] = Integer.parseInt(row3[i]);
                    }
        
                    System.out.println("Seats loaded from file.");
                    scanner.close();
                } catch (FileNotFoundException e) {
                    System.out.println("Error: seats file not found.");
                }
            }
    // public static void load() {
    //     try {
    //         File file = new File("seats.txt");
    //         Scanner scanner = new Scanner(file);

    //         // Load row 1
    //         String[] row1 = scanner.nextLine().split(",");
    //         for (int i = 0; i < row1.length; i++) {
    //             seats[0][i] = Integer.parseInt(row1[i]);
    //         }

    //         // Load row 2
    //         String[] row2 = scanner.nextLine().split(",");
    //         for (int i = 0; i < row2.length; i++) {
    //             seats[1][i] = Integer.parseInt(row2[i]);
    //         }

    //         // Load row 3
    //         String[] row3 = scanner.nextLine().split(",");
    //         for (int i = 0; i < row3.length; i++) {
    //             seats[2][i] = Integer.parseInt(row3[i]);
    //         }

    //         System.out.println("Seats loaded from file.");
    //         scanner.close();
    //     } catch (FileNotFoundException e) {
    //         System.out.println("Error: seats file not found.");
    //     }
    // }
    public static void show_tickets_info() {
        double total_price = 0;
        System.out.println("Ticket information:");
        for (Ticket t : tickets) {
            t.print();
            total_price += t.getPrice();
        }
        System.out.println("Total price of all tickets: £" + total_price);
    }
    public static void sort_tickets(ArrayList<Ticket> tickets) {
        // sort tickets by price in ascending order
        Collections.sort(tickets, new Comparator<Ticket>() {
            @Override
            public int compare(Ticket t1, Ticket t2) {
                return Double.compare(t1.getPrice(), t2.getPrice());
            }
        });
    
        // print the sorted tickets information
        System.out.println("Sorted Tickets by Price:");
        for (Ticket ticket : tickets) {
            ticket.print();
        }
    }
}
