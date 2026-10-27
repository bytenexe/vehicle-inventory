package com.pluralsight;

import java.util.Scanner;

public class VehicleInventoryApp {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        Vehicle[] cars = new Vehicle[20];

        // Initialize arrays for 6 cars
        cars[0] = new Vehicle(101121, "Ford Explorer", "Red", 45000, 13500);
        cars[1] = new Vehicle(101122, "Toyota Camry", "Blue", 60000, 11000);
        cars[2] = new Vehicle(101123, "Chevrolet Malibu", "Black", 50000, 9700);
        cars[3] = new Vehicle(101124, "Honda Civic", "White", 70000, 7500);
        cars[4] = new Vehicle(101125, "Subaru Outback", "Green", 55000, 14500);
        cars[5] = new Vehicle(101126, "Jeep Wrangler", "Yellow", 30000, 16000);

        // Add and display menu prompt
        String menuPrompt = """
                What do you want to do?
                1 - List all vehicles
                2 - Search by make/model
                3 - Search by price range
                4 - Search by color
                5 - Add a vehicle
                6 - Quit
                Enter your command:""";

        while (true) {
            System.out.print(menuPrompt);
            String userInput = myScanner.nextLine();
            int spotsFilled = getFilledSpots(cars);

            switch (userInput) {
                case "1" -> {
                    for (int i = 0; i < spotsFilled; i++) {
                        cars[i].display();
                    }
                }
                case "2" -> {
                    System.out.print("Enter make/model to search for: ");
                    String searchmakeModel = myScanner.nextLine();

                    for (int i = 0; i < spotsFilled; i++) {
                        if (cars[i].getMakeModel().equalsIgnoreCase(searchmakeModel)) {
                            System.out.printf("VIN: %d, Make/Model: %s, Color: %s, Mileage: %d, Price: %.2f%n",
                                    cars[i].getVehicleId(),
                                    cars[i].getMakeModel(),
                                    cars[i].getColor(),
                                    cars[i].getOdometerReading(),
                                    cars[i].getPrice());
                        }
                    }
                }
                case "3" -> {
                    System.out.print("Enter minimum price: ");
                    double minPrice = myScanner.nextDouble();

                    System.out.print("Enter maximum price: ");
                    double maxPrice = myScanner.nextDouble();

                    myScanner.nextLine();

                    for (Vehicle currentVehicle : cars) {
                        double price = currentVehicle.getPrice();
                        if (price >= minPrice && price <= maxPrice) {
                            System.out.printf("Make/Model: %s, Price: %.2f%n",
                                    currentVehicle.getMakeModel(),
                                    currentVehicle.getPrice());
                        }
                    }
                }
                case "4" -> {
                    System.out.print("Enter color to search for: ");
                    String searchColor = myScanner.nextLine();

                    for (Vehicle currentVehicle : cars) {
                        if (currentVehicle.getColor().equalsIgnoreCase(searchColor)) {
                            System.out.printf("Make/Model: %s, Color: %s%n",
                                    currentVehicle.getMakeModel(),
                                    currentVehicle.getColor());
                        }
                    }
                }
                case "5" -> {
                    System.out.print("Enter vehicle ID: ");
                    String idInput = myScanner.nextLine();
                    long id = Long.parseLong(idInput);

                    System.out.print("Enter Make/Model: ");
                    String makeModel = myScanner.nextLine();

                    System.out.print("Enter Color: ");
                    String color = myScanner.nextLine();

                    System.out.print("Enter Mileage: ");
                    String odometerInput = myScanner.nextLine();
                    int odometerReading = Integer.parseInt(odometerInput);

                    System.out.print("Enter Price: ");
                    String priceInput = myScanner.nextLine();
                    double price = Double.parseDouble(priceInput);

                    cars[spotsFilled] = new Vehicle(id, makeModel, color, odometerReading, price);
                    System.out.println("Vehicle added successfully!");
                }
                case "6" -> {
                    System.out.println("Quit.");
                    return;
                }
                default -> System.out.println("Invalid command.");
            }
        }
    }

    // Static method for the for loops to add new cars + return when ran through
    public static int getFilledSpots(Vehicle[] cars) {
        int filled = 0;
        for (Vehicle car : cars) {
            if (car != null) {
                filled++;
            }
        }
        return filled;
    }
}

