package org.ua.bryl.utils;

import java.util.LinkedHashMap;
import java.util.Map;
/**
 * Created by olegbryl 15/08/2018.
 */

public class Book_Category_List {

    public Map< String, String > categories = new LinkedHashMap<>();

    public Book_Category_List() {
        categories.put("Detective", "Detective...");
        categories.put("Drama", "Drama");
        categories.put("Historical novel", "Historical novel");
        categories.put("Fantasy", "Fantasy");
        categories.put("The horrors", "The horrors");
        categories.put("Scientific literature", "Scientific literature");
        categories.put("Children's literature", "Children's literature");
        categories.put("Everything for the kitchen", "Everything for the kitchen");
        categories.put("For home", "For home");
        categories.put("Magazines", "Magazines");
    }

    public Map<String, String> getCategory_List() {
        return categories;
    }

    public void addMapValue(String key, String value) {
        this.categories.put(key, value);
    }
}
