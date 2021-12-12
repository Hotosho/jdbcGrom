public class Test {
    private long id;
    private String city;
    private int cash;

    public Test(long id, String city, int cash) {
        this.id = id;
        this.city = city;
        this.cash = cash;
    }

    public long getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public int getCash() {
        return cash;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", cash=" + cash +
                '}';
    }
}
