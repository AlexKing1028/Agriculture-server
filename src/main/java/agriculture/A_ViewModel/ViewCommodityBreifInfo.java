package agriculture.A_ViewModel;

/**
 * Created by redrock on 15/12/27.
 */
public class ViewCommodityBreifInfo extends TypeInfoBaseModel{
    int cid;
    final int type = 2;
    String cname;
    String breifInfo;
    String imageURL;

    @Override
    public Link getLink(){
        return link;
    }

    @Override
    public int getType() {
        return type;
    }

    public int getCid() {
        return cid;
    }

    public String getCname() {
        return cname;
    }

    public String getBreifInfo() {
        return breifInfo;
    }

    public String getImageURL() {
        return imageURL;
    }

    public ViewCommodityBreifInfo(int cid, String cname, String breifInfo, String imageURL) {
        this.cid = cid;
        this.cname = cname;
        this.breifInfo = breifInfo;
        this.imageURL = imageURL;
        link=new Link("detail", "/commodity/"+cid);
    }
}
