import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Part_one {
    public static int TotalFuel = 6600;
    public static void main(String[] args) {
        //creating queues arrays
        String[] pump1 = new String[6];
        String[] pump2 = new String[6];
        String[] pump3 = new String[6];
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
                    System.out.println("\n\t\tAll Fuel Queues");
                    System.out.println("\n\tFirst Pomp Fuel Queues\n");
                    ViewAllQueues(pump1); //calling ViewAllQueues method
                    System.out.println("\n\tSecond Pomp Fuel Queues.\n");
                    ViewAllQueues(pump2); //calling ViewAllQueues method
                    System.out.println("\n\tThird Pomp Fuel Queues.\n ");
                    ViewAllQueues(pump3); //calling ViewAllQueues method
                    break;
                case "101":
                case "VEQ":
                    ViewAllEmptyQueues(pump1, pump2, pump3); //calling ViewAllEmptyQueues method
                    break;
                case "102":
                case "ACQ":
                    AddCustomerToaQueue(input, pump1, pump2, pump3); //calling AddCustomerToaQueue method
                    break;
                case "103":
                case "RCQ":
                    RemoveFromQueue(input, pump1, pump2, pump3); //calling RemoveFromQueue method
                    break;
                case "104":
                case "PCQ":
                    RemoveServedCustomer(input, pump1, pump2, pump3); //calling RemoveServedCustomer  method
                    break;
                case "105":
                case "VCS":
                    System.out.println("\n\tPump 1 Sorted Customer name list.");
                    Sorting(pump1); //calling Sorting method
                    System.out.println("\n\tPump 2 Sorted Customer name list.");
                    Sorting(pump2); //calling Sorting method
                    System.out.println("\n\tPump 3 Sorted Customer name list.");
                    Sorting(pump3); //calling Sorting method
                    break;
                case "106":
                case "SPD":
                    StoreDataInToFile(pump1, pump2, pump3); //calling StoreDataInToFile method
                    break;
                case "107":
                case "LPD":
                    LoadDataFromFile(); //calling LoadDataFromFile method
                    break;
                case "108":
                case "STK":
                    System.out.println("\t\tRemaining Fuel Stock. \n" +
                            "\t Remaining Fuel Stock : " + TotalFuel + "\n"); // display remaining fuel stock
                    break;
                case "109":
                case "AFS":
                    AddFuelStock(input); //calling AddFuelStock method

                    break;
                case "999":
                case "EXT":
                    System.out.println("Exit the Program."); //ending program
                    break loop;

                default:
                    System.out.println("Wrong Code Try Again!"); //display message for wrong selections
            }
        }
    }

    //method for view all queues
    public static void ViewAllQueues(String[] Queue) {
        //print all array queues
        for (int i = 1; i <= Queue.length; i++) {
            if (Queue[i - 1] == null) { // condition check array null or not
                System.out.println(i + ". Empty");
            } else {
                System.out.println(i + "." + Queue[i - 1]);
            }
        }

    }

    //method for view empty queues
    public static void ViewAllEmptyQueues(String[] Que_1, String[] Que_2, String[] Que_3) {
        int count = 0;
        //check first pump has empty queues
        for (String i : Que_1) {
            if (i == null) {
                System.out.println("\n\tFirst Pump Empty Queues\n");
                count += 1;
                break;
            }
        }
        if (count == 1) {
            for (int i = 1; i <= Que_1.length; i++) {
                if (Que_1[i - 1] == null) { //for print array and replace null to empty
                    System.out.println(i + ". Empty");
                } else {
                    System.out.println(i + ". " + Que_1[i - 1]);
                }
            }
        }
        //check second pump has empty queues
        int count2 = 0;
        for (String i : Que_2) {
            if (i == null) {
                System.out.println("\n\tSecond Pump Empty Queues\n\n");
                count2 += 1;
                break;
            }
        }
        if (count2 == 1) {
            for (int i = 1; i <= Que_2.length; i++) {
                if (Que_2[i - 1] == null) { //for print array and replace null to empty
                    System.out.println(i + ". Empty");
                } else {
                    System.out.println(i + ". " + Que_2[i - 1]);
                }
            }
        }
        int count3 = 0;
        //check third pump has empty queues
        for (String i : Que_3) {
            if (i == null) {
                System.out.println("\n\tThird Pump Empty Queues\n");
                count3 += 1;
                break;
            }
        }
        if (count3 == 1) {
            for (int i = 1; i <= Que_3.length; i++) {
                if (Que_3[i - 1] == null) { //for print array and replace null to empty
                    System.out.println(i + ". Empty");
                } else {
                    System.out.println(i + ". " + Que_3[i - 1]);
                }
            }
        }
    }

    //method for add customer to queues
    public static void AddCustomerToaQueue(Scanner input, String[] Que_1, String[] Que_2, String[] Que_3) {
        int count = 0;
        String addcustomer = "0";
        //getting input for pum selection
        System.out.print("Select what Pump do you need to add customer : ");
        addcustomer = input.nextLine();
        //check selections
        switch (addcustomer) {
            case "1":
                for (int a = 0; a < Que_1.length; a++) {
                    if (Que_1[a] == null) { //check queues empty or not
                        //getting inputs
                        System.out.print("Enter customer Name :");
                        String customernamer = input.next();
                        Que_1[a] = customernamer; //add name to array
                        System.out.println("Add " + customernamer + " to Pump " + addcustomer);
                        //remove 10L from stock
                        TotalFuel=TotalFuel-10;

                        //check fuel stock = 500
                        if (TotalFuel == 500) {
                            System.out.println(" Warning! Fuel Stock reach 500 Litres");
                        }
                        break;
                    } else {
                        count += 1;
                    }
                }
                if (count == 6) { //if pump is full give message
                    System.out.println("You Entered pump " + addcustomer + " is Full.\n" +
                            "Select another Pump ");
                }
                break;
            case "2":
                for (int a = 0; a < Que_2.length; a++) {
                    if (Que_2[a] == null) {//check queues empty or not
                        //getting inputs
                        System.out.print("Enter customer Name :");
                        String customernamer = input.next();
                        Que_2[a] = customernamer;//add name to array
                        System.out.println("Add " + customernamer + " to Pump " + addcustomer);
                        //remove 10L from stock
                        TotalFuel=TotalFuel-10;

                        //check fuel stock = 500
                        if (TotalFuel == 500) {
                            System.out.println(" Warning! Fuel Stock reach 500 Litres");
                        }
                        break;
                    } else {
                        count += 1;
                    }
                }
                if (count == 6) { //if pump is full give message
                    System.out.println("You Entered pump " + addcustomer + " is Full.\n" +
                            "Select another Pump ");
                }
                break;
            case "3":
                for (int a = 0; a < Que_3.length; a++) {
                    if (Que_3[a] == null) {//check queues empty or not
                        //getting inputs
                        System.out.print("Enter customer Name :");
                        String customernamer = input.next();
                        Que_3[a] = customernamer;//add name to array
                        System.out.println("Add " + customernamer + " to Pump " + addcustomer);
                        //remove 10L from stock
                        TotalFuel = TotalFuel - 10;

                        //check fuel stock = 500
                        if (TotalFuel == 500) {
                            System.out.println(" Warning! Fuel Stock reach 500 Litres");
                        }
                        break;
                    } else {
                        count += 1;
                    }
                }
                if (count == 6) { //if pump is full give message
                    System.out.println("You Entered pump " + addcustomer + " is Full.\n" +
                            "Select another Pump ");
                }
                break;
            default:
                System.out.println("Wrong answer try again! ");//  print message for wrong selection


        }
    }

    //methods for remove customer
    public static void RemoveFromQueue(Scanner input, String[] Que_1, String[] Que_2, String[] Que_3) {
        //getting inputs
        System.out.print("Please enter the  Pump number the customer  should remove : ");
        int Pumpnum = input.nextInt();
        System.out.print("What location you need remove customer from Pump " + Pumpnum + " : ");
        int Queuenum = input.nextInt();

        //check selection
        switch (Pumpnum) {
            case 1:
                Que_1[Queuenum - 1] = null; //remove customer from array
                TotalFuel = TotalFuel + 10; //add 10 L to the stock
                System.out.println("Successfully removed customer from Pump 1 Queue "+Queuenum );
                break;
            case 2:
                Que_2[Queuenum - 1] = null; //remove customer from array
                TotalFuel = TotalFuel + 10; //add 10 L to the stock
                System.out.println("Successfully removed customer from Pump 2 Queue "+Queuenum);
                break;
            case 3:
                Que_3[Queuenum - 1] = null; //remove customer from array
                TotalFuel = TotalFuel + 10; //add 10 L to the stock
                System.out.println("Successfully removed customer from Pump 2 Queue "+Queuenum);
                break;
            default:
                System.out.println("Wrong Pump Number!");//message for wrong inputs
                break;
        }
    }

    //method for remove served customer
    public static void RemoveServedCustomer(Scanner input, String[] Que_1, String[] Que_2, String[] Que_3) {
        //getting inputs
        System.out.print("Please enter which pump the customer should remove. : ");
        int Pumpnum = input.nextInt();
        switch (Pumpnum) {
            case 1:
                int empty=0;
                for(String i:Que_1){
                    if(i==null){ // check  pump is empty or not
                        empty+=1;
                    }
                }
                if(empty==6){
                    System.out.println("This Pump is empty !");
                }else{
                    //remove first name from array
                System.out.println("Removed "+Que_1[0]+" From pump 1.");
                    Que_1[0]=null;
                    Que_1[0]=Que_1[1];
                    Que_1[1]=Que_1[2];
                    Que_1[2]=Que_1[3];
                    Que_1[3]=Que_1[4];
                    Que_1[4]=Que_1[5];
                    Que_1[5]=null;
                }

                break;
            case 2:
                int empty2=0;
                for(String i:Que_2){
                    if(i==null){ // check  pump is empty or not
                        empty2+=1;
                    }
                }
                if(empty2==6){
                    System.out.println("This Pump is empty !");
                }else{
                    //remove first name from array
                    System.out.println("Removed "+Que_2[0]+" From pump 1.");
                    Que_2[0]=null;
                    Que_2[0]=Que_2[1];
                    Que_2[1]=Que_2[2];
                    Que_2[2]=Que_2[3];
                    Que_2[3]=Que_2[4];
                    Que_2[4]=Que_2[5];
                    Que_2[5]=null;
                }
                break;

            case 3:
                int empty3=0;
                for(String i:Que_3){
                    if(i==null){ // check  pump is empty or not
                        empty3+=1;
                    }
                }
                if(empty3==6){
                    System.out.println("This Pump is empty !");
                }else{
                    //remove first name from array
                    System.out.println("Removed "+Que_3[0]+" From pump 1.");
                    Que_3[0]=null;
                    Que_3[0]=Que_3[1];
                    Que_3[1]=Que_3[2];
                    Que_3[2]=Que_3[3];
                    Que_3[3]=Que_3[4];
                    Que_3[4]=Que_3[5];
                    Que_3[5]=null;
                }
                break;
            default:
                System.out.println("Wrong Queue Number!");
                break;

        }


    }

    //method for sorting
    public static void Sorting(String[] queue){
        for(int i=0;i<queue.length;i++){
            for(int j=i+1;j<queue.length;j++){
                if(queue[i]==null || queue[j]==null){
                    continue;
                }else{
                    if(queue[i].compareToIgnoreCase(queue[j])>0){ //compare
                        String holder = queue[i];
                        queue[i]=queue[j];
                        queue[j]=holder;
                    }
                }
            }
        }
        for(int k=0;k<queue.length;k++){
            if(queue[k]==null){
                System.out.println("\t"+(k+1)+". Empty");
            }else{
                System.out.println("\t"+(k+1)+". "+queue[k]);
                }
            }
    }

    //method for store data to file
    public static void StoreDataInToFile(String[] Que_1,String[] Que_2,String[] Que_3) {
        try{
            //write file
            FileWriter dataWriter=new FileWriter("Program data file.txt");
            dataWriter.write("\n-------Queue 01-------\n\n");
            for(int i=1;i<=Que_1.length;i++){
                if(Que_1[i-1]==null){
                    dataWriter.write("\t"+i+". Empty\n");
                }else{
                    dataWriter.write("\t"+i+". "+Que_1[i-1]+"\n");
                }
            }
            dataWriter.write("\n-------Queue 02-------\n\n");
            for(int i=1;i<=Que_2.length;i++){
                if(Que_2[i-1]==null){
                    dataWriter.write("\t"+i+". Empty\n");
                }else{
                    dataWriter.write("\t"+i+". "+Que_2[i-1]+"\n");
                }
            }
            dataWriter.write("\n-------Queue 03-------\n\n");
            for(int i=1;i<=Que_3.length;i++){
                if(Que_3[i-1]==null){
                    dataWriter.write("\t"+i+". Empty\n");
                }else{
                    dataWriter.write("\t"+i+". "+Que_3[i-1]+"\n");
                }
            }
            dataWriter.close();
            System.out.println("Successfully Store Program Data into file.");//printe message file is created .
        }
        catch (IOException e){
            System.out.println("An error occurred.");

        }
    }

    //method for load data from file
    public static void LoadDataFromFile(){
        //load data from file
        try{
            File datafile= new  File("Program data file.txt");
            Scanner fileReader = new Scanner(datafile);
            while(fileReader.hasNextLine()){
                String data= fileReader.nextLine();
                System.out.println(data);
            }
            fileReader.close();
        }catch (IOException e){
            System.out.println("Error IOException is : "+e);
        }
    }

    //method for  add fuel stock
    public static void AddFuelStock(Scanner input){
        System.out.println("\tAdd Fuel Stock");
        //getting inputs
        System.out.print("Enter new Adding Fuel volume in Litres : ");
        int newstock=input.nextInt();
        TotalFuel=TotalFuel+newstock;; //update fuel stock
        System.out.println("New Fuel Stock : "+TotalFuel+" Litres\n");
    }

}

