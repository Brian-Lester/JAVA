import java.util.ArrayList;

public class CafeUtil {

    public int getStreakGoal(int num){
        int total=0;
        for (int i = 0; i <= num; i++){
                total += i;
            if (i == num){
                return total;
            }
        }
        return 0;
    }

    public double getOrderTotal(double[] prices) {
        double total = 0;
        for (double price: prices) {
            total+= price;
        }
        return total;
    }
    public void displayMenu(ArrayList<String> menuItems){
        int num = -1;
        for (String item : menuItems){
            num++;
            System.out.println(num + " " + item);
        }
    }
    public void addCustomer(ArrayList<String> customers){
        System.out.println("Please enter your name:");
        String userName = System.console().readLine();
        customers.add(userName);
        System.out.println("Hello " + userName);
        System.out.println("There are " + customers.size() + " customers ahead of you");
        for ( String customer: customers){
            System.out.print(" " +customer +",");
        }

    }
}

