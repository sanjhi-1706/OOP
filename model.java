package Hello;

public class model {

    public static String modelOfCategory(String category) {
        switch (category.toUpperCase()) {
            case "SUV":
                return "TATA SAFARI";
            case "SEDAN":
                return "TATA INDIGO";
            case "ECONOMY":
                return "TATA INDICA";
            case "MINI":
                return "TATA NANO";
            default:
                return "Category not available. Please choose SUV, SEDAN, ECONOMY, or MINI.";
        }
    }

    public static void main(String[] args) {
        // Example usage
        String category = "SUV";
        String model = modelOfCategory(category);
        System.out.println("The model available in the category " + category + " is: " + model);
        
        category = "SEDAN";
        model = modelOfCategory(category);
        System.out.println("The model available in the category " + category + " is: " + model);
        
        category = "LUXURY"; // example of an invalid category
        model = modelOfCategory(category);
        System.out.println("The model available in the category " + category + " is: " + model);
    }
}


