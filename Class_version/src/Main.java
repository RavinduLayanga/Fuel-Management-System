import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    //for waiting list
    public static ArrayList<String> waitfirstname = new ArrayList<String>();
    public static ArrayList<String> waitsecondname = new ArrayList<String>();
    public static ArrayList<String> waitvehinumber = new ArrayList<String>();
    public static ArrayList<Integer> waitnumlitre = new ArrayList<Integer>();

    //for sorting
    public static String[][] pump1 = new String[6][4];
    public static String[][] pump2 = new String[6][4];
    public static String[][] pump3 = new String[6][4];
    public static String[][] pump4 = new String[6][4];
    public static String[][] pump5 = new String[6][4];

    //for minimum customer pump
    public static int Len1 = 0;
    public static int Len2 = 0;
    public static int Len3 = 0;
    public static int Len4 = 0;
    public static int Len5 = 0;
    public static int[] min = new int[5];

    //for fuel income and stock
    public static int Fuelstock=6600;
    public  static  float income1;
    public  static  float income2;
    public  static  float income3;
    public  static  float income4;
    public  static  float income5;


    public static void main(String[] args) {
        //creating queues arrays
        FuelQueue pump1 = new FuelQueue();
        FuelQueue pump2 = new FuelQueue();
        FuelQueue pump3 = new FuelQueue();
        FuelQueue pump4 = new FuelQueue();
        FuelQueue pump5 = new FuelQueue();
        FuelQueue[] queueslist = {pump1, pump2, pump3, pump4, pump5};
        //creating menu
        loop:
        while (true) {
            //printing menu list
            System.out.println("\nPlease choose your selection.\n" +
                    "\t100 or VFQ: View all Fuel Queues.\n" +
                    "\t101 or VEQ: View all Empty Queues.\n" +
                    "\t102 or ACQ: Add customer to a Queue.\n" +
                    "\t103 or RCQ: Remove a customer from a Queue.\n" +
                    "\t104 or PCQ: Remove a served customer.\n" +
                    "\t105 or VCS: View Customers Sorted in alphabetical order.\n" +
                    "\t106 or SPD: Store Program Data into file.\n" +
                    "\t107 or LPD: Load Program Data from file.\n" +
                    "\t108 or STK: View Remaining Fuel Stock.\n" +
                    "\t109 or AFS: Add Fuel Stock.\n" +
                    "\t110 or IFQ: Income Of Each Fuel Queue.\n"+
                    "\t999 or EXT: Exit the Program.");

            //creating scanner

            Scanner input = new Scanner(System.in);
            //getting inputs for menu selections
            System.out.print("Please enter your selection code : ");
            String choice = input.nextLine();
            //checking selections
            switch (choice) {
                case "100":
                case "VFQ":
                    ViewAllQueues(queueslist); //calling ViewAllQueues method
                    break;
                case "101":
                case "VEQ":
                    ViewAllEmptyQueues(queueslist); //calling ViewAllEmptyQueues method
                    break;
                case "102":
                case "ACQ":
                    AddCustomerToaQueue(input, queueslist); //calling AddCustomerToaQueue method
                    break;
                case "103":
                case "RCQ":
                    RemoveFromQueue(input, queueslist); //calling RemoveFromQueue method
                    break;
                case "104":
                case "PCQ":
                    RemoveServedCustomer(input,queueslist); //calling RemoveServedCustomer  method
                    break;
                case "105":
                case "VCS":

                   Sorting(); //calling Sorting method

                    break;
                case "106":
                case "SPD":
                    StoreDataInToFile(queueslist); //calling StoreDataInToFile method
                    break;
                case "107":
                case "LPD":
                    LoadDataFromFile(); //calling LoadDataFromFile method
                    break;
                case "108":
                case "STK":
                    System.out.println("\t\tRemaining Fuel Stock. \n" +
                            "\t Remaining Fuel Stock : " + Fuelstock+ "\n"); // display remaining fuel stock
                    break;
                case "109":
                case "AFS":
                    AddFuelStock(input); //calling AddFuelStock method

                    break;

                case "110":
                case "IFQ":
                    IncomeOfFuelQueue();//calling income of fuel method

                    break;
                case "999":
                case "EXT":
                    System.out.println("\tExit the Program.Thank You!"); //ending program
                    break loop;

                default:
                    System.out.println("\tWrong Code Try Again!"); //display message for wrong selections
            }

        }
    }

    //method for view all queues
    public static void ViewAllQueues(FuelQueue[] queueslist) {
        //print first pump queue
        System.out.println("\n------Pump 01------");
        for (int i = 0; i < 6; i++) {
            if (queueslist[0].personlist[i].getFirstname() == null) {
                System.out.println("\n\t Person " + (i + 1) + "\nFirst Name  :- Empty");
            } else {
                System.out.println("\n\t Person " + (i + 1) + "\nFirst Name  :- " + queueslist[0].personlist[i].getFirstname());
            }
            if (queueslist[0].personlist[i].getSecondname() == null) {
                System.out.println("Second Name :- Empty");
            } else {
                System.out.println("Second Name :- " + queueslist[0].personlist[i].getSecondname());
            }
            if (queueslist[0].personlist[i].getVehicleNum() == null) {
                System.out.println("Vehicle.No  :- Empty");
            } else {
                System.out.println("Vehicle.No  :- " + queueslist[0].personlist[i].getVehicleNum());
            }
            if (queueslist[0].personlist[i].getFuelLiters() == 0) {
                System.out.println("No.of Liters:- 0");
            } else {
                System.out.println("No.of Liters:- " + queueslist[0].personlist[i].getFuelLiters());
            }
        }
        //print second pump queue
        System.out.println("\n------Pump 02-------");
        for (int i = 0; i < 6; i++) {
            if (queueslist[1].personlist[i].getFirstname() == null) {
                System.out.println("\n\t Person " + (i + 1) + "\nFirst Name  :- Empty");
            } else {
                System.out.println("\n\t Person " + (i + 1) + "\nFirst Name  :- " + queueslist[1].personlist[i].getFirstname());
            }
            if (queueslist[1].personlist[i].getSecondname() == null) {
                System.out.println("Second Name :- Empty");
            } else {
                System.out.println("Second Name :- " + queueslist[1].personlist[i].getSecondname());
            }
            if (queueslist[1].personlist[i].getVehicleNum() == null) {
                System.out.println("Vehicle.No  :- Empty");
            } else {
                System.out.println("Vehicle.No  :- " + queueslist[1].personlist[i].getVehicleNum());
            }
            if (queueslist[1].personlist[i].getFuelLiters() == 0) {
                System.out.println("No.of Liters:- 0");
            } else {
                System.out.println("No.of Liters:- " + queueslist[1].personlist[i].getFuelLiters());
            }
        }
        //print third pump queue
        System.out.println("\n------Pump 03-------");
        for (int i = 0; i < 6; i++) {
            if (queueslist[2].personlist[i].getFirstname() == null) {
                System.out.println("\n\t Person " + (i + 1) + "\nFirst Name  :- Empty");
            } else {
                System.out.println("\n\t Person " + (i + 1) + "\nFirst Name  :- " + queueslist[2].personlist[i].getFirstname());
            }
            if (queueslist[2].personlist[i].getSecondname() == null) {
                System.out.println("Second Name :- Empty");
            } else {
                System.out.println("Second Name :- " + queueslist[2].personlist[i].getSecondname());
            }
            if (queueslist[2].personlist[i].getVehicleNum() == null) {
                System.out.println("Vehicle.No  :- Empty");
            } else {
                System.out.println("Vehicle.No  :- " + queueslist[2].personlist[i].getVehicleNum());
            }
            if (queueslist[2].personlist[i].getFuelLiters() == 0) {
                System.out.println("No.of Liters:- 0");
            } else {
                System.out.println("No.of Liters:- " + queueslist[2].personlist[i].getFuelLiters());
            }
        }
        //print fourth pump queue
        System.out.println("\n------Pump 04-------");
        for (int i = 0; i < 6; i++) {
            if (queueslist[3].personlist[i].getFirstname() == null) {
                System.out.println("\n\t Person " + (i + 1) + "\nFirst Name  :- Empty");
            } else {
                System.out.println("\n\t Person " + (i + 1) + "\nFirst Name  :- " + queueslist[3].personlist[i].getFirstname());
            }
            if (queueslist[3].personlist[i].getSecondname() == null) {
                System.out.println("Second Name :- Empty");
            } else {
                System.out.println("Second Name :- " + queueslist[3].personlist[i].getSecondname());
            }
            if (queueslist[3].personlist[i].getVehicleNum() == null) {
                System.out.println("Vehicle.No  :- Empty");
            } else {
                System.out.println("Vehicle.No  :- " + queueslist[3].personlist[i].getVehicleNum());
            }
            if (queueslist[3].personlist[i].getFuelLiters() == 0) {
                System.out.println("No.of Liters:- 0");
            } else {
                System.out.println("No.of Liters:- " + queueslist[3].personlist[i].getFuelLiters());
            }
        }
        //print fifth pump queue
        System.out.println("\n------Pump 05-------");
        for (int i = 0; i < 6; i++) {
            if (queueslist[4].personlist[i].getFirstname() == null) {
                System.out.println("\n\t Person " + (i + 1) + "\nFirst Name  :- Empty");
            } else {
                System.out.println("\n\t Person " + (i + 1) + "\nFirst Name  :- " + queueslist[4].personlist[i].getFirstname());
            }
            if (queueslist[4].personlist[i].getSecondname() == null) {
                System.out.println("Second Name :- Empty");
            } else {
                System.out.println("Second Name :- " + queueslist[4].personlist[i].getSecondname());
            }
            if (queueslist[4].personlist[i].getVehicleNum() == null) {
                System.out.println("Vehicle.No  :- Empty");
            } else {
                System.out.println("Vehicle.No  :- " + queueslist[4].personlist[i].getVehicleNum());
            }
            if (queueslist[4].personlist[i].getFuelLiters() == 0) {
                System.out.println("No.of Liters:- 0");
            } else {
                System.out.println("No.of Liters:- " + queueslist[4].personlist[i].getFuelLiters());
            }
        }
    }

    //method for view empty queues
    public static void ViewAllEmptyQueues(FuelQueue[] queueslist) {
        //for pump1
        int count = 0;
        System.out.println("\n----Pump 01 Empty Queues----\n ");
        for (int i = 0; i < 6; i++) {
            if (queueslist[0].personlist[i].getFirstname() == null) { //check empty queues
                count += 1;
                System.out.println("Person " + (i + 1) + " is Empty");
            }
        }
        if (count == 0) {
            System.out.println("Pump 01 All Queues are Full.");
        }

        //for pump 02
        int count1 = 0;
        System.out.println("\n----Pump 02 Empty Queues----\n ");
        for (int i = 0; i < 6; i++) {
            if (queueslist[1].personlist[i].getFirstname() == null) { //check empty queues
                count1 += 1;
                System.out.println("Person " + (i + 1) + " is Empty");
            }
        }
        if (count1 == 0) {
            System.out.println("Pump 02 All Queues are Full.");
        }

        //for pump 03
        int count2 = 0;
        System.out.println("\n----Pump 03 Empty Queues----\n ");
        for (int i = 0; i < 6; i++) {
            if (queueslist[2].personlist[i].getFirstname() == null) { //check empty queues
                count2 += 1;
                System.out.println("Person " + (i + 1) + " is Empty");
            }
        }
        if (count2 == 0) {
            System.out.println("Pump 03 All Queues are Full.");
        }

        //for pump 04
        int count3 = 0;
        System.out.println("\n----Pump 04 Empty Queues----\n ");
        for (int i = 0; i < 6; i++) {
            if (queueslist[3].personlist[i].getFirstname() == null) { //check empty queues
                count3 += 1;
                System.out.println("Person " + (i + 1) + " is Empty");
            }
        }
        if (count3 == 0) {
            System.out.println("Pump 04 All Queues are Full.");
        }

        //for pump 05
        int count4 = 0;
        System.out.println("\n----Pump 05 Empty Queues----\n ");
        for (int i = 0; i < 6; i++) {
            if (queueslist[4].personlist[i].getFirstname() == null) { //check empty queues
                count4 += 1;
                System.out.println("Person " + (i + 1) + " is Empty");
            }
        }
        if (count4 == 0) {
            System.out.println("Pump 05 All Queues are Full.");
        }
    }

    //method for add customer to queues
    public static void AddCustomerToaQueue(Scanner input, FuelQueue[] queueslist) {

        //getting inputs for add customer
        try{
           System.out.print("\n\tEnter Your First Name       : ");
           String f_name = input.nextLine();
           System.out.print("\tEnter Your Second Name      : ");
           String s_name = input.nextLine();
           System.out.print("\tEnter Your Vehicle Number   : ");
           String v_number = input.nextLine();
           System.out.print("\tEnter No of Liters Required : ");
               int nu_liters = input.nextInt();

               //check pumps are full if pumps full info list add customer to waiting list
        if(queueslist[4].personlist[5].getFirstname()!=null){
            waitfirstname.add(f_name);
            waitsecondname.add(s_name);
            waitvehinumber.add(v_number);
            waitnumlitre.add(nu_liters);
            System.out.println("\tAll pumps are full! info added to waiting list.. ");
        }

        //check what pump have minimum person count

        int count = 0;
        int holder;
        min[0] = Len1;
        min[1] = Len2;
        min[2] = Len3;
        min[3] = Len4;
        min[4] = Len5;
        boolean Loop = true;
        //array set to the minimum to largest
        while (Loop) {
            if(min[0]>min[1]){
                holder = min[0];
                min[0] = min[1];
                min[1] = holder;
            }
            if(min[1]>min[2]){
                holder = min[2];
                min[2] = min[1];
                min[1] = holder;
            }
            if(min[2]>min[3]){
                holder = min[2];
                min[2] = min[3];
                min[3] = holder;
            }if(min[3]>min[4]){
                holder = min[3];
                min[3] = min[4];
                min[4] = holder;
            }
            count++;
            if (25== count) {
                Loop = false;
            }

        }

        if(Len1 == min[0]){
            for(int i=0;i<6;i++ ){
                if(queueslist[0].personlist[i].getFirstname()==null){
                    assert queueslist[0].personlist[i] != null;
                    queueslist[0].personlist[i].setFirstname(f_name);
                    queueslist[0].personlist[i].setSecondname(s_name);
                    queueslist[0].personlist[i].setVehicleNum(v_number);
                    queueslist[0].personlist[i].setFuelLiters(nu_liters);
                    System.out.println("\tSuccessfully added customer to Pump 1 location "+(i+1) );

                    pump1[i][0] =  (queueslist[0].personlist[i].getFirstname());
                    pump1[i][1] =  (queueslist[0].personlist[i].getSecondname());
                    pump1[i][2] =  (queueslist[0].personlist[i].getVehicleNum());
                    pump1[i][3] = String.valueOf((queueslist[0].personlist[i].getFuelLiters()));
                    Len1+=1;
                    break;
                }
            }
        } else if (Len2 == min[0]) {
            for(int i=0;i<6;i++ ){
                if(queueslist[1].personlist[i].getFirstname()==null){
                    assert queueslist[1].personlist[i] != null;
                    queueslist[1].personlist[i].setFirstname(f_name);
                    queueslist[1].personlist[i].setSecondname(s_name);
                    queueslist[1].personlist[i].setVehicleNum(v_number);
                    queueslist[1].personlist[i].setFuelLiters(nu_liters);
                    System.out.println("\tSuccessfully added customer to Pump 2 location "+(i+1) );


                    pump2[i][0] =  (queueslist[1].personlist[i].getFirstname());
                    pump2[i][1] =  (queueslist[1].personlist[i].getSecondname());
                    pump2[i][2] =  (queueslist[1].personlist[i].getVehicleNum());
                    pump2[i][3] = String.valueOf((queueslist[1].personlist[i].getFuelLiters()));
                    Len2+=1;
                    break;
                }
            }

        }else if (Len3 == min[0]) {
            for(int i=0;i<6;i++ ){
                if(queueslist[2].personlist[i].getFirstname()==null){
                    assert queueslist[2].personlist[i] != null;
                    queueslist[2].personlist[i].setFirstname(f_name);
                    queueslist[2].personlist[i].setSecondname(s_name);
                    queueslist[2].personlist[i].setVehicleNum(v_number);
                    queueslist[2].personlist[i].setFuelLiters(nu_liters);
                    System.out.println("\tSuccessfully added customer to Pump 3 location "+(i+1) );

                    pump3[i][0] =  (queueslist[2].personlist[i].getFirstname());
                    pump3[i][1] =  (queueslist[2].personlist[i].getSecondname());
                    pump3[i][2] =  (queueslist[2].personlist[i].getVehicleNum());
                    pump3[i][3] = String.valueOf((queueslist[2].personlist[i].getFuelLiters()));
                    Len3+=1;
                    break;
                }
            }

        }else if (Len4 == min[0]) {
            for(int i=0;i<6;i++ ){
                if(queueslist[3].personlist[i].getFirstname()==null){
                    assert queueslist[3].personlist[i] != null;
                    queueslist[3].personlist[i].setFirstname(f_name);
                    queueslist[3].personlist[i].setSecondname(s_name);
                    queueslist[3].personlist[i].setVehicleNum(v_number);
                    queueslist[3].personlist[i].setFuelLiters(nu_liters);
                    System.out.println("\tSuccessfully added customer to Pump 4 location "+(i+1) );

                    pump4[i][0] =  (queueslist[3].personlist[i].getFirstname());
                    pump4[i][1] =  (queueslist[3].personlist[i].getSecondname());
                    pump4[i][2] =  (queueslist[3].personlist[i].getVehicleNum());
                    pump4[i][3] = String.valueOf((queueslist[3].personlist[i].getFuelLiters()));
                    Len4+=1;
                    break;
                }
            }

        }else if (Len5 == min[0]) {
            for(int i=0;i<6;i++ ){
                if(queueslist[4].personlist[i].getFirstname()==null){
                    assert queueslist[4].personlist[i] != null;
                    queueslist[4].personlist[i].setFirstname(f_name);
                    queueslist[4].personlist[i].setSecondname(s_name);
                    queueslist[4].personlist[i].setVehicleNum(v_number);
                    queueslist[4].personlist[i].setFuelLiters(nu_liters);
                    System.out.println("\tSuccessfully added customer to Pump 5 location "+(i+1) );

                    pump5[i][0] = (queueslist[4].personlist[i].getFirstname());
                    pump5[i][1] = (queueslist[4].personlist[i].getSecondname());
                    pump5[i][2] = (queueslist[4].personlist[i].getVehicleNum());
                    pump5[i][3] = String.valueOf((queueslist[4].personlist[i].getFuelLiters()));
                    Len5+=1;
                    break;
                }
            }
        }
        }catch(Exception e){
            System.out.println("Error! Wrong inputs.");
        }
    }

    //methods for remove customer
    public static void RemoveFromQueue(Scanner input, FuelQueue[] queueslist) {

        try {
            //getting input
            System.out.print("\tPlease enter the  Pump number the customer  should remove : ");
            int Pumpnum = input.nextInt();
            System.out.print("\tWhat place you need remove customer from Pump " + Pumpnum + " : ");
            int Queuenum = input.nextInt()-1;

            //check if entered position empty

            if (queueslist[Pumpnum - 1].personlist[Queuenum - 1].getFirstname() == null) {
                System.out.println("\nThis pump is Empty!");
            } else {
                if (Pumpnum - 1 == 0) {
                    Len1 -= 1;
                } else if (Pumpnum - 1 == 1) {
                    Len2 -= 1;
                } else if (Pumpnum - 1 == 2) {
                    Len3 -= 1;
                } else if (Pumpnum - 1 == 3) {
                    Len4 -= 1;
                } else if (Pumpnum - 1 == 4) {
                    Len5 -= 1;
                }
                //remove entered place customer
                queueslist[Pumpnum - 1].personlist[Queuenum].setFirstname(null);
                queueslist[Pumpnum - 1].personlist[Queuenum].setSecondname(null);
                queueslist[Pumpnum - 1].personlist[Queuenum].setVehicleNum(null);
                queueslist[Pumpnum - 1].personlist[Queuenum].setFuelLiters(0);

                //re arrange pump places
                for (int i = Queuenum; i < 6; i++) {
                    queueslist[Pumpnum - 1].personlist[i].setFirstname(queueslist[Pumpnum - 1].personlist[i + 1].getFirstname());
                    queueslist[Pumpnum - 1].personlist[i].setSecondname(queueslist[Pumpnum - 1].personlist[i + 1].getSecondname());
                    queueslist[Pumpnum - 1].personlist[i].setVehicleNum(queueslist[Pumpnum - 1].personlist[i + 1].getVehicleNum());
                    queueslist[Pumpnum - 1].personlist[i].setFuelLiters(queueslist[Pumpnum - 1].personlist[i + 1].getFuelLiters());
                }
                queueslist[Pumpnum - 1].personlist[5].setFirstname(null);
                queueslist[Pumpnum - 1].personlist[5].setSecondname(null);
                queueslist[Pumpnum - 1].personlist[5].setVehicleNum(null);
                queueslist[Pumpnum - 1].personlist[5].setFuelLiters(0);
            }

            System.out.println("\tCustomer removed from Pump " + Pumpnum + " Place " + Queuenum);
        } catch (Exception e) {
            System.out.println("Error! Wrong input.");
        }
    }

    //method for remove served customer
    public static void RemoveServedCustomer(Scanner input, FuelQueue[] queueslist) {
        //getting inputs
        try{
        System.out.print("\tPlease enter which pump the customer should remove : ");
        int pump = input.nextInt();
        //remove first customer from chosen pump
        if (pump == 1 || pump == 2 || pump == 3 || pump == 4 || pump == 5) {
            //remove fuel from fuel stock
            Fuelstock=Fuelstock-(queueslist[pump - 1].personlist[0].getFuelLiters());
            //for find the each fuel pump income
            if(pump==1){
                income1=+(queueslist[pump - 1].personlist[0].getFuelLiters());
            } else if(pump==2){
                income2=+(queueslist[pump - 1].personlist[0].getFuelLiters());
            } else if(pump==3){
                income3=+(queueslist[pump - 1].personlist[0].getFuelLiters());
            } else if(pump==4){
                income4=+(queueslist[pump - 1].personlist[0].getFuelLiters());
            } else{
                income5=+(queueslist[pump - 1].personlist[0].getFuelLiters());
            }

            //remove first person in the pump
            queueslist[pump - 1].personlist[0].setFirstname(null);
            queueslist[pump - 1].personlist[0].setSecondname(null);
            queueslist[pump - 1].personlist[0].setVehicleNum(null);
            queueslist[pump - 1].personlist[0].setFuelLiters(0);
            System.out.println("\tSuccessfully Removed Served customer from Pump "+pump);

            //replace other customers
            for (int i = 0; i < 5; i++) {
                queueslist[pump - 1].personlist[i].setFirstname(queueslist[pump - 1].personlist[i + 1].getFirstname());
                queueslist[pump - 1].personlist[i].setSecondname(queueslist[pump - 1].personlist[i + 1].getSecondname());
                queueslist[pump - 1].personlist[i].setVehicleNum(queueslist[pump - 1].personlist[i + 1].getVehicleNum());
                queueslist[pump - 1].personlist[i].setFuelLiters(queueslist[pump - 1].personlist[i + 1].getFuelLiters());
            }
            //replace null value with last position
            queueslist[pump - 1].personlist[5].setFirstname(null);
            queueslist[pump - 1].personlist[5].setSecondname(null);
            queueslist[pump - 1].personlist[5].setVehicleNum(null);
            queueslist[pump - 1].personlist[5].setFuelLiters(0);

                //after removed customer get new customer from waiting list if have
            for(int i=0;i<6;i++){
                if(queueslist[pump-1].personlist[i].getFirstname()==null && waitfirstname.size() !=0){
                    queueslist[pump-1].personlist[i].setFirstname(waitfirstname.get(0));
                    queueslist[pump-1].personlist[i].setSecondname(waitsecondname.get(0));
                    queueslist[pump-1].personlist[i].setVehicleNum(waitvehinumber.get(0));
                    queueslist[pump-1].personlist[i].setFuelLiters(waitnumlitre.get(0));
                    waitfirstname.remove(0);
                    waitsecondname.remove(0);
                    waitvehinumber.remove(0);
                    waitnumlitre.remove(0);
                    break;
                }
            }

        }   else {
            System.out.println("\nWrong Pump number!");
        }

    }catch(Exception e){
            System.out.println("Error! Wrong input.");
        }
    }

    //method for pump income
    public static void IncomeOfFuelQueue(){
        System.out.println("\n\tIncome of each Fuel\n");
        System.out.println("\n\tPump 1 Income :- Rs."+income1*430);//print and calculate pump1 income
        System.out.println("\n\tPump 2 Income :- Rs."+income2*430);//print and calculate pump2 income
        System.out.println("\n\tPump 3 Income :- Rs."+income3*430);//print and calculate pump3 income
        System.out.println("\n\tPump 4 Income :- Rs."+income4*430);//print and calculate pump4 income
        System.out.println("\n\tPump 5 Income :- Rs."+income5*430);//print and calculate pump5 income

    }


    //method for sorting
    public static void Sorting() {
            //for pump1
            System.out.println("\n\tSorted Pump 01\n");
            String[] hold;
            for (int i = 0; i < 6; i++) {
                for (int j = i + 1; j < 6; j++) {
                    if(pump1[i][0] == null || pump1[j][0] ==null ){
                        continue;
                    }else {
                        if (Arrays.toString(pump1[i]).compareTo(Arrays.toString(pump1[j])) > 0) {
                            hold = pump1[i];
                            pump1[i] = pump1[j];
                            pump1[j] = hold;
                        }
                    }
                }
            }
            //print after sort
            for (int i=0; i<6; i++){
                System.out.println("Person "+(i+1)+":-"+Arrays.toString(pump1[i]));
            }
            //for pump2
            System.out.println("\n\tSorted Pump 02\n");
            String[] hold2;
            for (int i = 0; i < 6; i++) {
                for (int j = i + 1; j < 6; j++) {
                    if(pump2[i][0] == null || pump2[j][0] ==null ){
                        continue;
                    }else {
                        if (Arrays.toString(pump2[i]).compareTo(Arrays.toString(pump2[j])) > 0) {
                            hold2 = pump2[i];
                            pump2[i] = pump2[j];
                            pump2[j] = hold2;
                        }
                    }
                }

            }
        //print after sort
            for (int i=0; i<6; i++) {
                System.out.println("Person "+(i+1)+":-"+Arrays.toString(pump2[i]));

            }
        //for pump3
            System.out.println("\n\tSorted Pump 03\n");
            String[] hold3;
            for (int i = 0; i <6; i++) {
                for (int j = i + 1; j <6; j++){
                    if(pump3[i][0] == null || pump3[j][0] ==null ){
                        continue;
                    }else {
                        if (Arrays.toString(pump3[i]).compareTo(Arrays.toString(pump3[j])) > 0) {
                            hold3 =pump3[i];
                            pump3[i] = pump3[j];
                            pump3[j] = hold3;
                        }
                    }
                }

            }
        //print after sort
            for (int i=0; i<6; i++) {
                System.out.println("Person "+(i+1)+":-"+Arrays.toString(pump3[i]));

            }
        //for pump4
            System.out.println("\n\tSorted Pump 04\n");
            String[] hold4;
            for (int i = 0; i <6; i++) {
                for (int j = i + 1; j <6; j++) {
                    if(pump4[i][0] == null || pump4[j][0] ==null ){
                        continue;
                    }else {
                        if (Arrays.toString(pump4[i]).compareTo(Arrays.toString(pump4[j])) > 0) {
                            hold4 = pump4[i];
                            pump4[i] = pump4[j];
                            pump4[j] = hold4;
                        }
                    }
                }
            }
        //print after sort
            for (int i=0; i<6; i++) {
                System.out.println("Person "+(i+1)+":-"+Arrays.toString(pump4[i]));

            }
        //for pump5
            System.out.println("\n\tSorted Pump 05\n");
            String[] hold5;
            for (int i = 0; i <6; i++) {
                for (int j = i + 1; j <6; j++) {
                    if(pump5[i][0] == null || pump5[j][0] ==null ){
                        continue;
                    }else {
                        if (Arrays.toString(pump5[i]).compareTo(Arrays.toString(pump5[j])) > 0) {
                            hold5 = pump5[i];
                            pump5[i] = pump5[j];
                            pump5[j] = hold5;
                        }
                    }
                }

            }
        //print after sort
            for (int i = 0; i <6; i++) {
                System.out.println("Person "+(i+1)+":-"+Arrays.toString(pump5[i]));
            }
    }

    //method for store data to file
    public static void StoreDataInToFile(FuelQueue[] queueslist) {
        try {
            //write file
            File datafile=new File("Program data file.txt");
            FileWriter dataWriter = new FileWriter(datafile);
            PrintWriter dataprint=new PrintWriter(datafile);
            //print pump 3 details
            dataprint.print("\n\n---------Pump 01---------\n\n");
            for (int i = 1; i <= 6; i++) {
                if (queueslist[0].personlist[i - 1].getFirstname() == null) {
                    dataprint.print("\n\n--Person " + i + " --"+"\n\n\tFirst Name  :- Empty");
                } else {
                    dataprint.print("\n\nPerson " + i + " --"+ "\n\n\tFirst Name  :- " + queueslist[0].personlist[i - 1].getFirstname());
                }
                if (queueslist[0].personlist[i - 1].getSecondname() == null) {
                    dataprint.print("\n\tSecond Name :- Empty");
                } else {
                    dataprint.print("\n\tSecond Name :- " + queueslist[0].personlist[i - 1].getSecondname());
                }
                if (queueslist[0].personlist[i - 1].getSecondname() == null) {
                    dataprint.print("\n\tVehicle NO  :- Empty");
                } else {
                    dataprint.print("\n\tVehicle NO  :- " + queueslist[0].personlist[i - 1].getSecondname());
                }
                if (queueslist[0].personlist[i - 1].getSecondname() == null) {
                    dataprint.print("\n\tNo.of Liters:- 0");
                } else {
                    dataprint.print("\n\tNo.of Liters:- " + queueslist[0].personlist[i - 1].getSecondname());
                }
            }
            //print pump 2 details
            dataprint.print("\n\n---------Pump 02---------\n\n");
            for (int i = 1; i <= 6; i++) {
                if (queueslist[1].personlist[i - 1].getFirstname() == null) {
                    dataprint.print("\n\n--Person " + i + " --"+"\n\n\tFirst Name  :- Empty");
                } else {
                    dataprint.print("\n\nPerson " + i + " --"+ "\n\n\tFirst Name  :- " + queueslist[1].personlist[i - 1].getFirstname());
                }
                if (queueslist[1].personlist[i - 1].getSecondname() == null) {
                    dataprint.print("\n\tSecond Name :- Empty");
                } else {
                    dataprint.print("\n\tSecond Name :- " + queueslist[1].personlist[i - 1].getSecondname());
                }
                if (queueslist[1].personlist[i - 1].getSecondname() == null) {
                    dataprint.print("\n\tVehicle NO  :- Empty");
                } else {
                    dataprint.print("\n\tVehicle NO  :- " + queueslist[1].personlist[i - 1].getSecondname());
                }
                if (queueslist[1].personlist[i - 1].getSecondname() == null) {
                    dataprint.print("\n\tNo.of Liters:- 0");
                } else {
                    dataprint.print("\n\tNo.of Liters:- " + queueslist[1].personlist[i - 1].getSecondname());
                }
            }
            //print pump 3 details
            dataprint.print("\n\n---------Pump 03---------\n\n");
            for (int i = 1; i <= 6; i++) {
                if (queueslist[2].personlist[i - 1].getFirstname() == null) {
                    dataprint.print("\n\n--Person " + i + " --"+"\n\n\tFirst Name  :- Empty");
                } else {
                    dataprint.print("\n\nPerson " + i + " --"+ "\n\n\tFirst Name  :- " + queueslist[2].personlist[i - 1].getFirstname());
                }
                if (queueslist[2].personlist[i - 1].getSecondname() == null) {
                    dataprint.print("\n\tSecond Name :- Empty");
                } else {
                    dataprint.print("\n\tSecond Name :- " + queueslist[2].personlist[i - 1].getSecondname());
                }
                if (queueslist[2].personlist[i - 1].getSecondname() == null) {
                    dataprint.print("\n\tVehicle NO  :- Empty");
                } else {
                    dataprint.print("\n\tVehicle NO  :- " + queueslist[2].personlist[i - 1].getSecondname());
                }
                if (queueslist[2].personlist[i - 1].getSecondname() == null) {
                    dataprint.print("\n\tNo.of Liters:- 0");
                } else {
                    dataprint.print("\n\tNo.of Liters:- " + queueslist[2].personlist[i - 1].getSecondname());
                }
            }
            //print pump 4 details
            dataprint.print("\n\n---------Pump 04---------\n\n");
            for (int i = 1; i <= 6; i++) {
                if (queueslist[3].personlist[i - 1].getFirstname() == null) {
                    dataprint.print("\n\n--Person " + i + " --"+"\n\n\tFirst Name  :- Empty");
                } else {
                    dataprint.print("\n\nPerson " + i + " --"+ "\n\n\tFirst Name  :- " + queueslist[3].personlist[i - 1].getFirstname());
                }
                if (queueslist[3].personlist[i - 1].getSecondname() == null) {
                    dataprint.print("\n\tSecond Name :- Empty");
                } else {
                    dataprint.print("\n\tSecond Name :- " + queueslist[3].personlist[i - 1].getSecondname());
                }
                if (queueslist[3].personlist[i - 1].getSecondname() == null) {
                    dataprint.print("\n\tVehicle NO  :- Empty");
                } else {
                    dataprint.print("\n\tVehicle NO  :- " + queueslist[3].personlist[i - 1].getSecondname());
                }
                if (queueslist[3].personlist[i - 1].getSecondname() == null) {
                    dataprint.print("\n\tNo.of Liters:- 0");
                } else {
                    dataprint.print("\n\tNo.of Liters:- " + queueslist[3].personlist[i - 1].getSecondname());
                }
            }
            //print pump 5 details
            dataprint.print("\n\n---------Pump 05---------\n\n");
            for (int i = 1; i <= 6; i++) {
                if (queueslist[4].personlist[i - 1].getFirstname() == null) {
                    dataprint.print("\n\n--Person " + i + " --"+"\n\n\tFirst Name  :- Empty");
                } else {
                    dataprint.print("\n\nPerson " + i + " --"+ "\n\n\tFirst Name  :- " + queueslist[4].personlist[i - 1].getFirstname());
                }
                if (queueslist[4].personlist[i - 1].getSecondname() == null) {
                    dataprint.print("\n\tSecond Name :- Empty");
                } else {
                    dataprint.print("\n\tSecond Name :- " + queueslist[4].personlist[i - 1].getSecondname());
                }
                if (queueslist[4].personlist[i - 1].getSecondname() == null) {
                    dataprint.print("\n\tVehicle NO  :- Empty");
                } else {
                    dataprint.print("\n\tVehicle NO  :- " + queueslist[4].personlist[i - 1].getSecondname());
                }
                if (queueslist[4].personlist[i - 1].getSecondname() == null) {
                    dataprint.print("\n\tNo.of Liters:- 0");
                } else {
                    dataprint.print("\n\tNo.of Liters:- " + queueslist[4].personlist[i - 1].getSecondname());
                }
            }
                dataWriter.close();
                dataprint.close();

                System.out.println("Successfully Store Program Data into file.");//printe message file is created .


        } catch (IOException e) {
            System.out.println("Error IOException is : " + e);
        }
    }

    //method for load data from file
    public static void LoadDataFromFile () {
        //load data from file
        try {
            File datafile = new File("Program data file.txt");
            Scanner fileReader = new Scanner(datafile);
            while (fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                System.out.println(data);
            }
            fileReader.close();
        } catch (IOException e) {
            System.out.println("Error IOException is : " + e);
        }
    }

    //method for  add fuel stock
    public static void AddFuelStock (Scanner input){
        try{
        System.out.println("\tAdd Fuel Stock");
        //getting inputs
        System.out.print("Enter new Adding Fuel volume in Litres : ");
        int newstock = input.nextInt();
        Fuelstock= Fuelstock + newstock; //update fuel stock
        System.out.println("New Fuel Stock : " + Fuelstock + " Litres\n");
        }catch(Exception e){
            System.out.println("Error! Wrong input.");
        }
    }
}

