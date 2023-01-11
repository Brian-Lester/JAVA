public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready ";
        String displayTotalMessage = "Your total is $";
        
        // Menu variables (add yours below)
        double mochaPrice = 1500.123;
        double dripCoffee = 2000.5671;
        double superLatte = .0001;
        double awesomeCap = 139.111111111;
    
        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";
    
        // Order completions (add yours below)
        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = false;
        boolean isReadyOrder3 = false;
        boolean isReadyOrder4 = false;

        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        System.out.println(customer1 + pendingMessage);
        System.out.println(isReadyOrder4 ? customer4 + readyMessage + displayTotalMessage + superLatte : customer4 + pendingMessage);

        if(isReadyOrder2)
            System.out.println(customer2 + readyMessage + displayTotalMessage + (superLatte + superLatte));
        else 
            System.out.println(customer2 + pendingMessage);
        System.out.println(customer3 + " thanks for coming back you poor sucker you owe us $ " + (superLatte - dripCoffee));
    }
}