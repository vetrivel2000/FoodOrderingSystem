import logical.LogicalLayer;
import pojo.Customer;
import pojo.Food;
import pojo.Hotel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class OrderRunner {
    static ArrayList<Food> foods = new ArrayList<>();
    static  ArrayList<Hotel> hotels = new ArrayList<>();
    static  Scanner scan = new Scanner(System.in);
    static int totalAmount=0;
    public static void main(String[] args)
    {
        LogicalLayer logical=new LogicalLayer();
        foods.add(new Food("Sandwich",100));
        foods.add(new Food("Pizza",70));
        foods.add(new Food("FriedRice",110));
        foods.add(new Food("Falooda",140));
        hotels.add(new Hotel("Aarya Bhavan",foods));
        hotels.add(new Hotel("Priyam Restaurant",foods));
        hotels.add(new Hotel("Raju NightFoods",foods));
        ArrayList<Customer>customers= new ArrayList<>();
        int option;
        do {
            System.out.println("1.SignUp\n2.Login\n3.Exit");
            option=scan.nextInt();
            switch (option)
            {
                case 1:
                {
                    System.out.println("Enter name");
                    String name = scan.next();
                    System.out.println("Enter age");
                    int age = scan.nextInt();
                    System.out.println("Enter email");
                    String email=scan.next();
                    System.out.println("Enter password");
                    String passWord= scan.next();
                    System.out.println("Confirm password");
                    String confirmPassWord=scan.next();
                    if(!(passWord.equals(confirmPassWord)))
                    {
                        System.out.println("Not matched");
                        return;
                    }
                    if(passWord.length()<8 || passWord.length()>12)
                    {
                        System.out.println("Length must between 8 to 12");
                        return;
                    }
                    System.out.println("Enter mobileNumber");
                    String mobileNumber=scan.next();
                    Customer object = new Customer();
                    object.setMobileNumber(mobileNumber);
                    object.setName(name);
                    object.setAge(age);
                    object.setEmail(email);
                    object.setPassWord(passWord);
                    System.out.println("Successfully created");
                    customers.add(object);
                    logical.storeData(object);
                    break;
                }
                case 2:
                {
                    System.out.println("Enter email");
                    String email=scan.next();
                    System.out.println("Enter password");
                    String passWord= scan.next();
                    HashMap<String ,Customer> customerData=logical.getCustomerMap();
                    Customer customer=customerData.get(email);
                    String originalPassWord=customer.getPassWord();
                    if(!(passWord.equals(originalPassWord)))
                    {
                        System.out.println("WrongCredentials");
                        return;
                    }
                    System.out.println("Successfully Logged in");
                    int choice;
                    do {
                        System.out.println("1.SearchByHotel\n2.SearchByFood\n3.Cart");
                        choice=scan.nextInt();
                        switch (choice)
                        {
                            case 1:
                            {
                                searchByHotel();
                                break;
                            }
                            case 2:
                            {
                                searchByFood();
                                break;
                            }
                            case 3:
                            {
                                System.out.println("Your total order amount is:"+totalAmount);
                                break;
                            }
                        }
                    }while (choice<4);
                    break;
                }
            }
        }while (option<3);
    }
    public static void searchByHotel()
    {
        for (Hotel hotel:hotels)
        {
            System.out.println(hotel);
        }
        System.out.println("Enter HotelName:");
        String name = scan.next();
        for(Food food:foods)
        {
            System.out.println(food);
        }
        scan.nextLine();
        System.out.println("Enter the food you want order");
        String foodName=scan.next();
        for(Food food:foods)
        {
            if(food.getFoodName().equals(foodName))
                totalAmount+= food.getPrice();
        }
    }
    public static void searchByFood()
    {
        for(Food food:foods)
        {
            System.out.println(food);
        }
        System.out.println("Enter the food you want order");
        String foodName=scan.next();
        for(Food food:foods)
        {
            if(food.getFoodName().equals(foodName))
                totalAmount+= food.getPrice();
        }
    }
}
