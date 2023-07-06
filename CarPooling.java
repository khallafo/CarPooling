
package car.pooling;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author comp
 */
/**A user defined exception class*/
 class exption extends Exception{
public exption(String msg) {
super(msg);
}
}
        
/** A class for all passenger functions*/
 abstract class passengers {
   protected ticket Ticket;
   ArrayList<ticket>tickets;
    boolean subscriber;
    String complaint;
   
    
   public passengers(){
  tickets=new ArrayList<>();
   }
   //abstract method 
   public abstract void reserveticket(car car);
   //final method 
   public final void search_route(String from,String to){
        boolean found =false;
        for(String String :routes.from)
          if(String .equals(from))
          for(String d : routes.to)
             if(d.equals(to))
               found = true;  
       if (found) {
           System.out.println("there is availble route ");
       }
       else{ System.out.println("the route does not exist");
 }
       
   
   }
   //final method 
   public final void input_search(){
      System.out.println("Enter your destination in this type : start end");
       Scanner input  = new Scanner(System.in);
       String input1 = input.next();
       String input3 = input.next();
        boolean found =false;
        for(String String :routes.from)
          if(String .equals(input1))
          for(String d : routes.to)
             if(d.equals(input3))
               found = true;  
       if (found) {
           System.out.println("there is availble route ");
   }
   }
   //final method
   public final void subscriber(){
     boolean x =false; /**boolean variable check if there is error here or not*/
     try{
     if(subscriber==true){ //this is mean that you are already subscriber
         x=true;
        throw new exption("you already  subscriber passenger" );
     }
     }
     catch(exption ex){
     System.out.println("Error : " +ex.getMessage());
     }
     if(!x){
      int price = 100;
       System.out.println("please, Enter your Age : ");
       Scanner input = new Scanner(System.in);
       int age = input.nextInt();
       if(age < 18){
          System.out.println("Sorry, you are underage");
                   }
       System.out.println("please, Enter the number of trips : ");
       Scanner input2 = new Scanner(System.in);
       int num_trips = input.nextInt();
       if(num_trips < 2){
        System.out.println("Sorry, you should subscribe atleast 3 trips :  ");
       }
       else{System.out.println("subscribtion fees is : " +price*num_trips/2);
       System.out.println(" Congrate, now you enjoy 50% discount ");
       }
     }
   }
   //final method 
   public final void non_subscriberpassenger(){
     boolean x =false; /**boolean variable check if there is error here or not*/
     try{
     if(subscriber==false){//this is mean that you are already unsubscriber
         x=true;
        throw new exption("Note, you already un subscriber passenger");
     }
     }
     catch(exption ex){
     System.out.println("Error : " +ex.getMessage());
     }
     if(!x){
         subscriber=Ticket.is_sub=false;
         System.out.println("unsubscribed process Done ! ");    
}
   }
   //final method 
   public final void complain(String c1)
   {
    boolean x=false;
    try{
    if(c1.equals("")){
    x=true;
    throw new IOException("let us know if you have any issues "); //IO Exception
    }    
    }
    catch(IOException ex){
       System.out.println(" Error : "+ ex.getMessage());
    }
    if(!x){
       
        this.complaint=c1;
        System.out.println(" we recieved your complain and will work on it soon ");
 
    }
  }
}
////////////////////////////////////////////////////////////////////////////////
/** child that represent subscribers and inherit from passengers class*/
  class subscriber extends passengers{
  public subscriber(){
  subscriber=true;
  
  }
 @Override
 public void reserveticket(car car){
  Ticket=new ticket(car);
  tickets.add(Ticket);
  
  
  if (subscriber=true)
      Ticket.is_sub=true;
      
  else {
      Ticket.is_sub=false;
  }
 System.out.println("your ticket reserved successfully , and you enjoy 50% discount");
 }
 
}

/** child that represent non subscribers and inherit from passengers class*/
 class nonsubscriber extends passengers{
 public nonsubscriber(){ 
 subscriber=false;
 }
 @Override
 public void reserveticket(car car){
  Ticket=new ticket(car);
  tickets.add(Ticket);
  if (subscriber=true)
      Ticket.is_sub=true;
  else 
      Ticket.is_sub=false;
 System.out.println("your ticket reserved successfully ");
 }
}

/**
 *
 * @author comp
 */
public class CarPooling {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        passengers p=new nonsubscriber();
        passengers p1=new subscriber();
         
       passengers passengers[]=new passengers[4];/**creating array of passengers*/
       passengers[0]=new subscriber();
       passengers[1]=new subscriber();
       passengers[2]=new nonsubscriber();
       passengers[3]=new nonsubscriber();
      
       ArrayList<routes>route=new ArrayList<>();/**array of routes*/
       routes routee;
       
       routee=new routes("cairo", "giza");
       route.add(routee);
       routee=new routes("aswan", "auxor");
       route.add(routee);
       routee=new routes("qalub", "shubra");
       route.add(routee);
       routee=new routes("opera", "ampaba");
       route.add(routee);
      
       ArrayList<car>cars=new ArrayList<>(); /**array of cars*/
       car car;
       
       car =new car(7, "khaled", 10, route.get(0));
       cars.add(car);
       car =new car(6, "ahmed", 8, route.get(1));
       cars.add(car);
       car =new car(5, "ibrahem", 12, route.get(2));
       cars.add(car);
       car =new car(4, "mohamed", 10, route.get(3));
       cars.add(car);
       
       System.out.println("car avalible :");
       cars.forEach((carr) -> {
           carr.display_info();
        });
          for(int i=0; i < 50;++i){
        System.out.print((i==49)?"\n":"=");
          }
     //test 1 :
     passengers[0].reserveticket(cars.get(0));
     passengers[0].Ticket.display();
     passengers[0].subscriber();//user defined exception
     
     for(int i=0; i < 50;++i){
        System.out.print((i==49)?"\n":"=");}
     
     //test 2 :
     passengers[1].search_route("opera","ampaba");
     passengers[1].search_route("aswan","luxor");
     passengers[1].complain("last trip was so bad");
     passengers[1].subscriber();//user defined exception
     passengers[1].complain("");// java defined exception
     
     for(int i=0; i < 50;++i){
        System.out.print((i==49)?"\n":"=");}
     
     //test 3 :
     passengers[2].search_route("cairo","giza");
     passengers[2].complain("last trip was so bad");
     passengers[2].complain("");// java defined exception
     
     for(int i=0; i < 50;++i){
        System.out.print((i==49)?"\n":"=");}
    
     
     p.input_search();
     
     
//          boolean flage=true;
//          while(flage){
//          System.out.println(" press [1] to search for  Routes \n "
//                  + "press [2] to Reserve ticket \n press [3] to subscribe "
//                  + "\n press [4] to unsubscribe"
//                  + "\n press [5] to complain or make review "
//                  + "\n press [6] to display car info ");
//       Scanner input=new Scanner(System.in);
//       int choice =input.nextInt();
//          switch(choice){
//              case 1:
//                   p.search_route();
//                   break;
//              case 2:
//                  p.search_route();
//                  p.reserveticket(car);
//                  break;
//              case 3:
//                  p.subscriber();
//                  break;
//              case 4:
//                  p.non_subscriberpassenger();
//                  break;
//              case 5:
//                  p.complain();
//                  break;
//              case 6:
//                  car.display_info();
//                  break;
//          default:
//             System.out.println("Invalid Choice");
//       
//        }    
//           System.out.println("if you wanna do another process press 'y' or 'n'to cancel : ");
//        Scanner input7=new Scanner(System.in);
//        String c =input7.next();
//        if(c.endsWith("y")){
//            continue;
//        }
//        else{break;
//                }
//        
//}
    }
        
}
  


/** A class for route details*/
 class routes{
private String startdestination;
private String enddestination;
public static ArrayList<String>from=new ArrayList<String>();/**array for start location*/
public static ArrayList<String>to=new ArrayList<String>();

/**default constructor
 * @param startlocation
 * @param endlocation
 */
public routes(String startlocation,String endlocation){
    this.startdestination=startlocation;
    this.enddestination=endlocation;
    from.add(startlocation);
    to.add(endlocation);
}

     //final method
    /**@return Returns car start location*/
    public final String getStartdestination() {
        return startdestination;
    }
    //final method
    /**@return Returns car end location*/
    public final String getEnddestination() {
        return enddestination;
    }
}
////////////////////////////////////////////////////////////////////////////////
    /** A class for car info*/
  class car 
{
    final  int code;
    private static int counter = 0;
    private final routes route;
    final int  num_of_trips_perday;
    int maximum_capacity;
    String drive_name;
    
    /**
     * @param Returns number of trips
     * @param drive name
     * @param routes
     */
    
    public car(int num_of_trips,String drivename,int capacity,routes route){
    this.code=counter;
    this.drive_name=drivename;
    this.maximum_capacity=capacity;
    this.num_of_trips_perday=num_of_trips;
    this.route=route;
    counter++;
    }    

    public int getcounter(){
        return counter;
    }
    
    public int getCode() {
        return code;
    }

    public routes getRoute() {
        return route;
    }

    public int getNum_of_trips_perday() {
        return num_of_trips_perday;
    }

    public int getMaximum_capacity() {
        return maximum_capacity;
    }

    public String getDrive_name() {
        return drive_name;
    }
    /** show car details*/
    public void display_info(){
    System.out.println("car code : " + code + "\t route  from "
            + route.getStartdestination()+ " to  " +"\t"+route.getEnddestination() +
            "\t capacity per trip : " + maximum_capacity + "\t driver name :" + drive_name);
    }
      
}
////////////////////////////////////////////////////////////////////////////////
 /** A class for ticket details */ 
  class ticket 
  {
    private  car car;
    private  int ticket_ID;
    private static int count =0;
    boolean  is_sub;
    static float discount;
    int price= 100;
/**
 * @param car
 */
    public ticket(car car){
    this.car=car;
    count++;
    ticket_ID=count;
    }
    
    public void ticket_cost(){
    if(is_sub){
    price -=price*0.5; //calculated data member
    }
    else{price=100; 
    }
   }
    /**show ticket details*/
    public void display(){
      ticket_cost();
    System.out.println(" ticket : " +ticket_ID+"\n"+"\t car ID :"+car.code+"\troute(from  "+
            car.getRoute().getStartdestination()+ " to\t"+car.getRoute().getEnddestination()+")"+
            "\t driver name : "+car.getDrive_name()+"\t price : "+price); 
            
    
    }
  }