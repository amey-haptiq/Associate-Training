package org.example;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
      Product product=new Product();
      product.insertRecords(1,"Samsung A30",30000,"mobile");
      product.insertRecords(2,"Motorola g84",20000,"mobile");
      product.insertRecords(3,"John Jacobs",1800,"glassframe");
      product.insertRecords(4,"Nutella",280,"grocery");
      product.displayProducts();
      product.deleteRecord(1);
      product.displayProducts();
      product.showTransactionDetails();
    }
}