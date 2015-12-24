package agriculture.E_Model;

/**
 * Created by redrock on 15/12/23.
 */
public class Commodity extends CommodityItem {
    String detailInfo;
    Manufacturer manufacturer;

    public String getDetailInfo() {
        return detailInfo;
    }

    public void setDetailInfo(String detailInfo) {
        this.detailInfo = detailInfo;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Commodity(int cid, String cname, String breifinfo, String imageUrl, String detailInfo, Manufacturer manufacturer) {
        super(cid, cname, breifinfo, imageUrl);
        this.detailInfo = detailInfo;
        this.manufacturer = manufacturer;
    }
}
