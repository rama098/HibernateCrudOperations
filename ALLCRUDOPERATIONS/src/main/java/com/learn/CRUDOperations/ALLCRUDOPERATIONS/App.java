package com.learn.CRUDOperations.ALLCRUDOPERATIONS;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
    	Scanner scan=null;
       Configuration con=new Configuration().configure();
       SessionFactory sf=con.buildSessionFactory();
       Session  session=sf.openSession();
      
       
       StudentDetails dt=null;
       
       while(true)
       {
    	   scan=new Scanner(System.in);
    	   System.out.println("press 1-->for create");
    	   System.out.println("press 2-->for delete");
    	   System.out.println("press 3-->for update");
    	   System.out.println("press 4-->for fetch");
    	   System.out.println("press other number for exit");
    	   
    	   System.out.println("Enter your choice");
    	   
    	   int choice=scan.nextInt();
    	   
    	   switch(choice)
    	   {
    	   case 1:create(session,dt,scan);
    	   break;
    	   case 2:delete(session,dt,scan);
    	   break;
    	   case 3:update(session,dt,scan);
    	   break;
    	   case 4: fetch(session,dt,scan);
    	   break;
    	   
    	   default :System.out.println("Enter valid number");
    	   System.exit(0);
    	   }
       }
    }
    public static void create(Session ss,StudentDetails dt,Scanner scan)
    {
    	Transaction tr= ss.beginTransaction();
    	
    	System.out.println("Enter Student id");
    	int id=scan.nextInt();
    	System.out.println("Enter student name");
    	String name=scan.next();
    	System.out.println("enter age of "+name);
    	int age=scan.nextInt();
    	System.out.println("Enter marks of  "+name);
    	float marks=scan.nextFloat();
    	
    	System.out.println("Enter email of "+name);
    	String emial=scan.next();
    	
    	dt=new StudentDetails(id,name,age,marks,emial);
    	ss.save(dt);
    	
    	tr.commit();
    }
    public static void delete(Session session,StudentDetails dt,Scanner scan)
    {
    	Transaction tr=session.beginTransaction();
    	
    	tr=session.beginTransaction();
    	
    	System.out.println("Enter student id");
    	int id=scan.nextInt();
    	
    	dt=session.get(StudentDetails.class,id);
    	
    	session.delete(dt);
    	tr.commit();
    }
    public static void update(Session session,StudentDetails dt,Scanner scan)
    {
    	
    	Transaction tr=session.beginTransaction();
    	
    	System.out.println("Enter student id");
        int id=scan.nextInt();    	
    	dt=session.get(StudentDetails.class, id);
    	
    	
    	 System.out.println("Enter what you want update in this id "+id);
    	 
    	 String choice=scan.next();
    	
    	 switch(choice)
    	 {
    	 case "age": System.out.println("Enter updated age");
    		          int age=scan.nextInt();
    		          dt.setS_age(age);
    		          session.save(dt);    		          
    		          tr.commit();
    		          System.out.println("updated");
    		          break;
    	 case "name":System.out.println("Enter updated name");
    		         String name=scan.next();
    		         dt.setS_name(name);
    		         session.save(dt);
    		         tr.commit();
    		         System.out.println("updated");
    		         break;
    	 
    	 case "email": System.out.println("Enter updated email");
    		           String email=scan.next();
    		           dt.setS_email(email);
    		           session.save(dt);
    		           tr.commit();
    		           System.out.println("updated");
    		           break;
    	 case "marks":System.out.println("Enter updated marks");
    		          float marks=scan.nextFloat();
    		          dt.setS_marks(marks);
    		          session.save(dt);
    		          tr.commit();
    		          System.out.println("updated");
    		          break;
    	 default:System.out.println("your enter invalid update option");
    	 System.exit(0);      
    	 }  
    }
    public static void fetch(Session session,StudentDetails dt,Scanner scan)
    {	
    	Transaction tr=session.beginTransaction();
    	System.out.println("Enter id of student");
    	int id=scan.nextInt();
    	 dt=session.get(StudentDetails.class,id);
    	 System.out.println(dt);
    	tr.commit();
    }
}
