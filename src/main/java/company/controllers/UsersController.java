package company.controllers;

public class UsersController {


    public class StudentController {

//        //initialize scanner
//        private  Scanner sc = new Scanner(System.in);
//        private PreparedStatement ps;
//        private ResultSet rs;
//
//        //METHOD TO GET/READ INVENTORY BY ID/NAME
//        public  boolean getProductById(){
//            //ask user for data
//            System.out.println("Please enter product ID: ");
//            int id = sc.nextInt();
//
////            System.out.println("Enter name of the product: ");
////            String name = sc.next();
//
//
//            //UPDATE WITH CORRECT QUERY FROM DB//
//            try {
//                ps = getConnection().prepareStatement("SELECT * FROM inventory WHERE id = " + id);
//                rs = ps.executeQuery();
//
//                //define var to temporarily hold each field in the result set.
//                int id, price;
//                String name;
//
//                //instantiate the student objet to return at the end of the method execution
//                Inventory inventory = new Inventory();
//
//                //loop through the result set and add the necessary values in the inventory object
//                while (rs.next()) {
//                    id = rs.getInt("id");
//                    name = rs.getString("name");
//                    price = rs.getInt("price");
//                    inventory.setName(name);
//                    inventory.setId(id);
//                    inventory.setPrice(price);
//                }
//                return inventory;
//
//            } catch (SQLException e) {
//                e.printStackTrace();
//                return null;
//            }
//        }
//
//
//
//        //METHOD TO GET/READ CUSTOMERS BY ID/NAME
//
//        public static boolean getCustomerById(){
//            //ask user for data
//            System.out.println("Please enter customer ID: ");
//            int id = sc.nextInt();
//
////            System.out.println("Enter name of the customer: ");
////            String name = sc.next();
//
//
//            //UPDATE WITH CORRECT QUERY FROM DB//
//            try {
//                ps = getConnection().prepareStatement("SELECT * FROM customers WHERE id = " + id);
//                rs = ps.executeQuery();
//
//                //define var to temporarily hold each field in the result set.
//                int id;
//                String name;
//
//                //instantiate the student objet to return at the end of the method execution
//                Customer customer = new Customer();
//
//                //loop through the result set and add the necessary values in customer object
//                while (rs.next()) {
//                    id = rs.getInt("id");
//                    name = rs.getString("name");
//                    customer.setName(name);
//                    customer.setId(id);
//                }
//                return customer;
//
//            } catch (SQLException e) {
//                e.printStackTrace();
//                return null;
//            }
//        }
   }
}
