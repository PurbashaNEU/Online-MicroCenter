package com.neu;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum ProductCategory {
	// Enumeration of product categories
	Laptop,
	Cellphone,
	SmartWatch,
	Tablet,
	Television,
	Camera;
	
	// Returns a list of all product category names as strings
    public static List<String> getBookCategoryList(){
        return Stream.of(ProductCategory.values()).map(ProductCategory::name).collect(Collectors.toList());
    }
    
 // Returns an array of all product category names as strings
    public static String[] getBookCategoryArray() {
        return Arrays.stream(ProductCategory.values()).map(ProductCategory::name).toArray(String[]::new);
    }
    
 // Converts a string to the corresponding ProductCategory enum value
    public static ProductCategory getProductCategory(String s) {
		ProductCategory result = null;
    	switch(s.toLowerCase()) {
    	case "laptop":
    		result = ProductCategory.Laptop;
    		break;
	    case "cellphone":
	    	result = ProductCategory.Cellphone;
	    	break;
		case "smartwatch":
			result = ProductCategory.SmartWatch;
			break;
		case "tablet":
			result = ProductCategory.Tablet;
			break;
		case "television":
			result = ProductCategory.Television;
			break;
		default:
			result = ProductCategory.Camera;
			break;
		}
    	return result;
    }
}
