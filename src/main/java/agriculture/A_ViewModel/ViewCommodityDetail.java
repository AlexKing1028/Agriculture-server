package agriculture.A_ViewModel;

/**
 * Created by redrock on 15/12/27.
 */
public class ViewCommodityDetail extends LinkBaseModel {
    int cid;
    String cname;
    String imageurl;
    String briefinfo;
    String detailinfo;
    ViewManufacturerInfo manufacturerInfo;

    public ViewCommodityDetail(int cid, String cname, String imageurl, String briefinfo, String detailinfo, ViewManufacturerInfo manufacturerInfo) {
        this.cid = cid;
        this.cname = cname;
        this.imageurl = imageurl;
        this.briefinfo = briefinfo;
        this.detailinfo = detailinfo;
        this.manufacturerInfo = manufacturerInfo;
        link = new Link("self", "/commodity/" + cid);
    }

    public int getCid() {
        return cid;
    }

    public String getCname() {
        return cname;
    }

    public String getImageurl() {
        return imageurl;
    }

    public String getBriefinfo() {
        return briefinfo;
    }

    public ViewManufacturerInfo getManufacturerInfo() {
        return manufacturerInfo;
    }

    @Override
    public Link getLink() {
        return link;
    }

    public String getDetailinfo() {
        return detailinfo;
    }
}
