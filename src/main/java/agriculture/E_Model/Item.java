package agriculture.E_Model;

/**
 * Created by REDROCK on 12/9/2015.
 */
public class Item {
    protected String title;
    protected int type;


    protected Item(String title, int type){
        this.title=title;
        this.type=type;
    }

    public String getTitle() {
        return title;
    }

    public int getType() {
        return type;
    }

    public final static class SimpleItem extends Item{
        private String info;
        public SimpleItem(String title, String info){
            super(title, 1);
            this.info=info;
        }

        public String getInfo() {
            return info;
        }
    }

    public final static class BreifPictureItem extends Item{
        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public String getImgSrc() {
            return imgSrc;
        }

        public void setImgSrc(String imgSrc) {
            this.imgSrc = imgSrc;
        }

        private String info;
        private String imgSrc;
        public BreifPictureItem(String title, String info, String imgSrc){
            super(title, 2);
            this.info=info;
            this.imgSrc=imgSrc;
        }
    }
}
