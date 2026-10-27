package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class VehicleInventoryApp {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        Vehicle car = new Vehicle(101121L, "Ford Explorer", "Red", 45000, 13500.0);

        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
        vehicles = new ArrayList<Vehicle>();

        vehicles.add(new Vehicle(101122L, "Toyota Camry", "Blue", 60000, 11000.0));

        vehicles.add(car);

        for (Vehicle currentVehicle : vehicles) {
            System.out.println(currentVehicle.getColor());
        }

        for (Vehicle currentVehicle : vehicles) {
            System.out.println(currentVehicle.getColor());
        }

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
            // Removed: int userInteger = Integer.parseInt(userInput);

            switch (userInput) {
                case "1" -> {
                    for (Vehicle currentVehicle : vehicles) {
                        currentVehicle.display();
                    }
                }
                case "2" -> {
                    System.out.print("Enter make/model to search for: ");
                    String searchmakeModel = myScanner.nextLine();
                    for (Vehicle currentVehicle : vehicles) {
                        if (currentVehicle.getMakeModel().equalsIgnoreCase(searchmakeModel)) {
                            System.out.printf("VIN: %d, Make/Model: %s, Color: %s, Mileage: %d, Price: %.2f%n",
                                    currentVehicle.getVehicleId(),
                                    currentVehicle.getMakeModel(),
                                    currentVehicle.getColor(),
                                    currentVehicle.getOdometerReading(),
                                    currentVehicle.getPrice());
                        }
                    }
                }
                case "3" -> {
                    System.out.print("Enter minimum price: ");
                    double minPrice = myScanner.nextDouble();

                    System.out.print("Enter maximum price: ");
                    double maxPrice = myScanner.nextDouble();

                    // Consume the leftover newline from nextDouble() to prevent issues
                    // if we add a loop later, though currently safe without one.
                    myScanner.nextLine();

                    for (Vehicle currentVehicle : vehicles) {
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

                    for (Vehicle currentVehicle : vehicles) {
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

                    Vehicle newCar = new Vehicle(id, makeModel, color, odometerReading, price);
                    vehicles.add(newCar);
                    System.out.println("Vehicle added successfully!");
                }
                case "6" -> System.out.println("Quit.");
                default -> System.out.println("Invalid command.");
            }
        }
    }
}

