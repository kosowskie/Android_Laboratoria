package pl.kosowski.Lab4;


public class Drink {
    private String name; private String description; private int imageResourceId;
    public static final Drink[] drinks = {
            new Drink("Latte", "adsffasafsdfad", R.drawable.latte),
            new Drink("Cappuccino", "dasfasafsadsfafsd", R.drawable.cappuccino),
            new Drink("Filter", "fdafdafadadfafdafd", R.drawable.filter)
    };

    private Drink(String name, String description, int imageResourceId) {
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String toString() {
        return this.name;
    }
}
