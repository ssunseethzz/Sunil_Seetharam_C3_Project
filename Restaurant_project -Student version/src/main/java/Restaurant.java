import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private String location;
    public LocalTime openingTime;
    public LocalTime closingTime;
    private List<Item> menu = new ArrayList<Item>();

    public Restaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        this.name = name;
        this.location = location;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    public boolean isRestaurantOpen() {
        // Returns a boolean: whether the restaurant is open or not.
        LocalTime currentTime;
        currentTime = getCurrentTime();
        if ( (currentTime.isAfter(this.openingTime))  && (currentTime.isBefore(this.closingTime)) ) {
            return true;
        }
        else {
            return false;
        }
    }

    public LocalTime getCurrentTime(){ return  LocalTime.now(); }

    public List<Item> getMenu() {
        // Returns the list of items in the menu.
        return (this.menu);
    }

    private Item findItemByName(String itemName){
        for(Item item: menu) {
            if(item.getName().equals(itemName))
                return item;
        }
        return null;
    }

    public void addToMenu(String name, int price) {
        Item newItem = new Item(name,price);
        menu.add(newItem);
    }
    
    public void removeFromMenu(String itemName) throws itemNotFoundException {

        Item itemToBeRemoved = findItemByName(itemName);
        if (itemToBeRemoved == null)
            throw new itemNotFoundException(itemName);

        menu.remove(itemToBeRemoved);
    }
    public void displayDetails(){
        System.out.println("Restaurant:"+ name + "\n"
                +"Location:"+ location + "\n"
                +"Opening time:"+ openingTime +"\n"
                +"Closing time:"+ closingTime +"\n"
                +"Menu:"+"\n"+getMenu());

    }

    public String getName() {
        return name;
    }

    public int getOrderValue(List<String> itemNames) {
        int totalOrderValue = 0;
        return totalOrderValue;
    }

//    public int getOrderValue(List<String> itemNames) {
//
//        int totalOrderValue = 0;
//        Item item;
//
//        for ( String name : itemNames )
//        {
//            item = findItemByName(name);
//            totalOrderValue += item.getPrice();
//        }
//
//        return totalOrderValue;
//    }

}
