package Model;

public class Card_Info {
    private String id, password;
    private int balnace;

    public Long getCart_number() {
        return cart_number;
    }

    public void setCart_number(Long cart_number) {
        this.cart_number = cart_number;
    }

    private Long cart_number;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBalnace() {
        return balnace;
    }

    public void setBalnace(int balnace) {
        this.balnace = balnace;
    }

    public Card_Info(){
        super();
    }

    public Card_Info(String id, String password, int balnace, long cart_number){
        super();
        this.id = id;
        this.password =password;
        this.balnace = balnace;
        this.cart_number =cart_number;
    }
}
