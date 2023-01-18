
public class OrsersTest {
    public static void main(String[] args){
        
        Items item1 = new Items("coffee",1);
        Items item2 = new Items("Latte",2.5);
        Items item3 = new Items("Mocha",4.99);
        Items item4 = new Items("SuperExpresso",11.9);

        Orders order1 = new Orders("Cindhuri", 0, false, null);
        Orders order2 = new Orders("Jimmy", 0, false, null);
        Orders order3 = new Orders("noah", 0, false, null);
        Orders order4 = new Orders("Sam", 0, false, null);
        
        System.out.println(order4.addItem(item1));
        System.out.println(order3.addItem(item4));
        System.out.println(order4.addItem(item2));
        System.out.println(order1.isReady(true));
        System.out.println(order4.addItem(item2));
        System.out.println(order4.addItem(item2));
        System.out.println(order2.isReady(true));
    }
    
}
