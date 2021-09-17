package logical;

import pojo.Customer;

import java.util.HashMap;

public class LogicalLayer {
    HashMap<String, Customer> customerMap = new HashMap<>();
    public void storeData(Customer object)
    {
        customerMap.put(object.getEmail(),object);
    }

    public HashMap<String, Customer> getCustomerMap() {
        return customerMap;
    }
}
