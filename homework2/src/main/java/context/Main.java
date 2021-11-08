package context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("context");
        System.out.println("Cart management: \n add id (add product in cart)\n delete id (delete product from cart)\n show (show cart)\n " +
                "end (close program)\n new (new cart)\n Products:");
        ProductRepository productRepository = context.getBean(ProductRepository.class);
        productRepository.showAll();
        Cart cart = context.getBean(Cart.class);
        while (true) {
            System.out.println("Chose action");
            String str = scanner.nextLine();

            if (str.startsWith("add")) {    //add
                String[] subStr = str.split(" ");
                if (subStr.length > 1) {
                    cart.add(Long.parseLong(subStr[1]));
                } else {
                    System.out.println("Uncorrected Data");
                }

            } else if (str.startsWith("remove")) {  //remove
                String[] subStr = str.split(" ");
                if (subStr.length > 1) {
                    cart.remove(Long.parseLong(subStr[1]));
                } else {
                    System.out.println("Uncorrected Data");
                }

            } else if (str.startsWith("show")) { //show
                cart.show();

            } else if (str.startsWith("end")) { //exit
                break;

            } else if (str.startsWith("new")) { //new cart
                cart = context.getBean(Cart.class);

            } else {
                System.out.println("Uncorrected request");
            }

        }
        context.close();
    }
}
