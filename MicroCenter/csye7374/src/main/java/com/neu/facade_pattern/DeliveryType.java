package com.neu.facade_pattern;

public enum DeliveryType {
	HOME_DELIVERY, // Represents home delivery option
    IN_STORE_PICKUP;// Represents in-store pickup option
	
	 /**
     * Retrieves the DeliveryType based on the input string.
     * 
     * @param input The input string indicating the delivery type.
     * @return The corresponding DeliveryType value.
     */

    public static DeliveryType getDeliveryType(String s) {
        DeliveryType result = null;
        switch(s.toLowerCase()) {
            case "delivery":
                result = DeliveryType.HOME_DELIVERY;
                break;
            case "pickup":
                result = DeliveryType.IN_STORE_PICKUP;
                break;
            default:
                result = DeliveryType.IN_STORE_PICKUP; // Default to in-store pickup if input is unrecognized
                break;
        }
        return result;
    }
}
