class ParkingSystem {
 int[] park;
    public ParkingSystem(int big, int medium, int small) {
        park = new int[]{big, medium, small};
    }
    public boolean addCar(int carType) {
        if(park[carType-1] != 0){
            park[carType-1]--;
            return true;
        }
        return false;
        
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */