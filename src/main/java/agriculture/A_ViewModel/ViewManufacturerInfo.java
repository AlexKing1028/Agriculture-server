package agriculture.A_ViewModel;

/**
 * Created by redrock on 15/12/27.
 */
public class ViewManufacturerInfo extends LinkBaseModel{
    @Override
    public Link getLink() {
        return link;
    }

    int mid;
    String mname;
    String introduction;

    public ViewManufacturerInfo(int mid, String mname, String introduction) {
        this.mid = mid;
        this.mname = mname;
        this.introduction = introduction;
        link=new Link("self", "/manufacturer/"+mid);
    }

    public int getMid() {
        return mid;
    }

    public String getMname() {
        return mname;
    }

    public String getIntroduction() {
        return introduction;
    }
}
