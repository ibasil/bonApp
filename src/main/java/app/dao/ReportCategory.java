package app.dao;

public class ReportCategory {

    private String categoryName;
    private Long numberOrders;
    private double totalSum;

    public ReportCategory() {

    }

    public ReportCategory(String categoryName, Long numberOrders, double totalSum) {
        this.categoryName = categoryName;
        this.numberOrders = numberOrders;
        this.totalSum = totalSum;
    }

    public Long getNumberOrders() {
        return numberOrders;
    }
    public void setNumberOrders(Long numberOrders) {
        this.numberOrders = numberOrders;
    }
    public double getTotalSum() {
        return totalSum;
    }
    public void setTotalSum(double totalSum) {
        this.totalSum = totalSum;
    }
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "ReportCategory{" +
                "categoryName='" + categoryName + '\'' +
                ", numberOrders=" + numberOrders +
                ", totalSum=" + totalSum +
                '}';
    }
}
