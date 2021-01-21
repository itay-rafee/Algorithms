package _02_ParkingProblem;

public class ParkingProblem {
    static DoubleCycleLinkedList parking = new DoubleCycleLinkedList();
    static Node currentNode;
    static boolean flag;
    static int count;
    static char oldSign, newSign;
    static int steps;

    public ParkingProblem() {
        parking = parking.buildLinkedList();
        currentNode = parking.getHead().getNext();
        flag = true;
        count = 1;
        oldSign = 'V';
        newSign = 'W';
    }

    // calculate the number of the cars
    public static int calcCars() {
        while (flag) {
            if (currentNode.getData() != oldSign) {
                currentNode = currentNode.getNext();
                count++;
            }
            else {
                currentNode.setData(newSign);
                steps = count;
                while (steps > 0) {
                    currentNode = currentNode.getPrev();
                    steps--;
                }
                if (currentNode.getData() == newSign) flag = false;
                else {
                    count = 1;
                    currentNode = parking.getHead().getNext();
                }
            }
        }
        return count;
    }

    // check the trues
    public static int calcCarsPointers(){
        int result = 1;
        Node nodeForward = parking.getHead().getNext();
        Node headNode = parking.getHead();
        while(nodeForward != headNode) {
            nodeForward = nodeForward.getNext();
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        new ParkingProblem();
        System.out.println("number of cars = " +
                ParkingProblem.calcCars());
        System.out.println("DCLL : " +
                ParkingProblem.parking.toString());
//**************************************************
        System.out.println();
        System.out.println("number of cars = " +
                ParkingProblem.calcCarsPointers());
    }
}
