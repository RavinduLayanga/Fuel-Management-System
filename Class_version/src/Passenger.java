public class Passenger {
    private String Firstname=null;
    private String Secondname=null;
    private String VehicleNum=null;
    private int FuelLiters=0;

//setters

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public void setSecondname(String secondname) {
        Secondname = secondname;
    }

    public void setVehicleNum(String vehicleNum) {
        VehicleNum = vehicleNum;
    }

    public void setFuelLiters(int fuelLiters) {
        FuelLiters = fuelLiters;
    }


//getters

    public String getFirstname() {
        return Firstname;
    }

    public String getSecondname() {
        return Secondname;
    }

    public String getVehicleNum() {
        return VehicleNum;
    }

    public int getFuelLiters() {
        return FuelLiters;
    }


}

