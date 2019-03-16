package org.ua.bryl.utils;

import java.util.LinkedHashMap;
import java.util.Map;
/**
 * Created by olegbryl 15/08/2018.
 */

public class Book_Category_List {

    public Map< String, String > categories = new LinkedHashMap<>();

    public Book_Category_List() {
        categories.put("Other", "Other...");
        categories.put("School Supplies", "School Supplies");
        categories.put("Book", "Book");
        categories.put("Accessories", "Accessories");
        categories.put("Sound system", "Sound system");
        categories.put("Musical instruments", "Musical instruments");
        categories.put("Computer / Electronics", "Computer / Electronics");
        categories.put("Cell phones / tablets", "Cell phones / tablets");
        categories.put("Home", "Home");
        categories.put("Furniture", "Furniture");
    }

    public Map<String, String> getCategory_List() {
        return categories;
    }

    public void addMapValue(String key, String value) {
        this.categories.put(key, value);
    }
}
