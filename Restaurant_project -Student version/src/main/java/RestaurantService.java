import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();
    private Object restaurantNotFoundException;

    public Restaurant findRestaurantByName(String restaurantName) throws restaurantNotFoundException
    {
        // Searches for and returns the restaurant matching the input string.
        Restaurant foundRestaurant = null;
        boolean bRestaurantFound = false;

        for ( Restaurant res : restaurants)
        {
            if (res.getName().equals(restaurantName)) {
                foundRestaurant = res;
                bRestaurantFound = true;
                break;
            }
        }

        if ( bRestaurantFound == false)
            throw new restaurantNotFoundException(restaurantName);

        return foundRestaurant;
    }


    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException {
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
        restaurants.remove(restaurantToBeRemoved);
        return restaurantToBeRemoved;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
}
