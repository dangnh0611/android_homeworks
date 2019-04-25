package dangnh.homework.e.currencyconverter;

/**
 * @author: dangnh
 * Item of a spinner row, contains an image and a description
 */
public class Item {
    private int img;
    private String txt;

    public Item(int img, String txt) {
        this.img = img;
        this.txt = txt;
    }

    public int getImg() {
        return this.img;
    }

    public String getTxt() {
        return this.txt;
    }
}
