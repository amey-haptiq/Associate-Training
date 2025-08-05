package org.example;
import java.sql.*;

public class Product {
     int productId;
     String productName;
     int productPrice;
     public void displayProducts(){
         try{
             Class.forName("com.mysql.cj.jdbc.Driver");

             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","amey@123");
             System.out.println("Connected successfully");
             PreparedStatement ps=con.prepareStatement("select product.product_id,category.category,product.pname,product.price from product join category on  product.product_id=category.product_id limit 2 offset 0");
             ResultSet res=ps.executeQuery();
             while(res.next()){
                 int id=res.getInt("product_id");
                 String pname=res.getString("pname");
                 int price=res.getInt("price");
                 String category=res.getString("category");
                 System.out.println("Id:"+id+" Product Name:"+pname+" Price:"+price+" category:"+category);

             }

         } catch (SQLException e) {
             throw new RuntimeException(e);
         } catch (ClassNotFoundException e) {
             throw new RuntimeException(e);
         }
     }
     public void insertRecords(int id,String productName,int price,String category){
         try{
             Class.forName("com.mysql.cj.jdbc.Driver");

             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","amey@123");

             PreparedStatement ps=con.prepareStatement("insert into product(product_id,pname,price) values(?,?,?)");
             ps.setInt(1,id);
             ps.setString(2,productName);
             ps.setInt(3,price);
             ps.executeUpdate();
             System.out.println("Inserted in product");
             PreparedStatement ps1=con.prepareStatement("insert into category(product_id,category) values(?,?)");
             ps1.setInt(1,id);
             ps1.setString(2,category);

             ps1.executeUpdate();

             System.out.println("Inserted in category");
         }catch(Exception e){

         }
     }

     public void deleteRecord(int id){
         try{
             Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","amey@123");
             PreparedStatement ps=con.prepareStatement("delete  from category where product_id=?");
             ps.setInt(1,id);

             ps.executeUpdate();
             System.out.println("Deleted category ");

             PreparedStatement ps1=con.prepareStatement("delete  from product where product_id=?");
             ps1.setInt(1,id);

             ps1.executeUpdate();
             System.out.println("Deleted product ");


         }
         catch(Exception e){
             System.out.println(e);
         }
     }

     public void showTransactionDetails(){
         try{
             Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","amey@123");
             PreparedStatement ps=con.prepareStatement("select p.pname,p.price,t.transaction_date,t.items_sold from product p join transaction t on p.product_id=t.product_id");
             ResultSet rs=ps.executeQuery();
             while(rs.next()){
                 String pname=rs.getString("pname");
                 int price=rs.getInt("price");
                 Date tdate=rs.getDate("transaction_date");
                 int isold=rs.getInt("items_sold");
                 System.out.println("Product name:"+pname+" Price:"+price+" Transaction Date:"+tdate+" Items Sold:"+isold);
             }
         }catch(Exception e){

         }
     }

}
