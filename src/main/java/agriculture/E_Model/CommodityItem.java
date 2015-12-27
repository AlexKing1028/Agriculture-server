package agriculture.E_Model;

/**
 * Created by redrock on 15/12/23.
 */
public class CommodityItem extends BaseModel{
    int cid;
    String cname;
    String briefinfo;
    String imageUrl;

    public CommodityItem(int cid, String cname, String briefinfo, String imageUrl) {
        this.cid = cid;
        this.cname = cname;
        this.briefinfo = briefinfo;
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

    public String getBriefinfo() {
        return briefinfo;
    }

    public void setBriefinfo(String briefinfo) {
        this.briefinfo = briefinfo;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
