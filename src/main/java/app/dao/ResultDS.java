package app.dao;

public class ResultDS {
    private String dishName;
    private boolean kitchenMade;

    public ResultDS(String dishName, boolean kitchenMade) {
        this.dishName = dishName;
        this.kitchenMade = kitchenMade;
    }

    public String getDishName() {
        return dishName;
    }
    public void setDishName(String dishName) {
        this.dishName = dishName;
    }
    public boolean isKitchenMade() {
        return kitchenMade;
    }
    public void setKitchenMade(boolean kitchenMade) {
        this.kitchenMade = kitchenMade;
    }

    @Override
    public String toString() {
        return "ResultDS{" +
                "dishName='" + dishName + '\'' +
                ", kitchenMade=" + kitchenMade +
                '}';
    }
}
