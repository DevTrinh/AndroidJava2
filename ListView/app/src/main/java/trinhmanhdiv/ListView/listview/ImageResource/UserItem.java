package trinhmanhdiv.ListView.listview.ImageResource;

public class UserItem {

    private String name;
    private int srcImage;

    public UserItem(String name, int srcImage){
        this.name = name;
        this.srcImage = srcImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSrcImage() {
        return srcImage;
    }

    public void setSrcImage(int srcImage) {
        this.srcImage = srcImage;
    }
}
