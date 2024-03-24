import java.util.ArrayList;

public class Neighborhood {
    private final ArrayList<Neighbor> neighborhood;

    public Neighborhood(){
        this.neighborhood=new ArrayList<>();
    }

    // Method to add a neighbor to the neighborhood
    public void addNeighbor(Neighbor neighbor){
        neighborhood.add(neighbor);
    }

    // Method to remove a neighbor from the neighborhood
    public void removeNeighbor(Neighbor neighbor){
        for (Neighbor neigh : neighborhood){
            if (neigh.equals(neighbor)){
                neighborhood.remove(neigh);
                break;
            }
        }
    }

    public ArrayList<Neighbor> getNeighborhood() {
        return neighborhood;
    }

    // Method to find the neighbor with the minimum objective function value
    public Neighbor findNeighborMinValue (int currentMinValue){
        Neighbor neighborFound = null;
        int value = currentMinValue;
        for (Neighbor neighbor : neighborhood){
            int neighborValue = neighbor.getSolution().getObjFunValue();
            if (neighborValue<currentMinValue && neighborValue<value){
                value = neighborValue;
                neighborFound=neighbor;
            }
        }
        // If no neighbor is found with a value less than the current minimum,
        // select the neighbor with the overall minimum value
        if (neighborFound==null){
            int minValue = currentMinValue*2; //Initializing with a maximum high value
            for (Neighbor neighbor : neighborhood) {
                int neighborValue = neighbor.getSolution().getObjFunValue();
                if (neighborValue < minValue) {
                    minValue = neighborValue;
                    neighborFound = neighbor;
                }
            }
        }
        return neighborFound;
    }

    // Override equals method to compare Neighborhood objects
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Neighborhood neighborhoodO = (Neighborhood) o;
        for (int i=0; i< neighborhood.size();i++){
            if (!neighborhood.get(i).equals(neighborhoodO.getNeighborhood().get(i))){
                return false;
            }
        }
        return true;
    }
}
