package agriculture.E_Model;

/**
 * Created by redrock on 15/12/23.
 */
public class CommodityItem extends BaseModel{
    int cid;
    String cname;
    String breifinfo;
    String imageUrl;

    public CommodityItem(int cid, String cname, String breifinfo, String imageUrl) {
        this.cid = cid;
        this.cname = cname;
        this.breifinfo = breifinfo;
        this.imageUrl = imageUrl;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getBreifinfo() {
        return breifinfo;
    }

    public void setBreifinfo(String breifinfo) {
        this.breifinfo = breifinfo;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
