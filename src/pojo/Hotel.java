package pojo;

import java.util.ArrayList;

public class Hotel {
    private String hotelName;
    private ArrayList<Food> foods=new ArrayList<>();

    public Hotel(String hotelName, ArrayList<Food> foods) {
        this.hotelName = hotelName;
        this.foods = foods;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public ArrayList<Food> getFoods() {
        return foods;
    }

    public void setFoods(ArrayList<Food> foods) {
        this.foods = foods;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelName='" + hotelName + '\'' +
                '}';
    }
}
