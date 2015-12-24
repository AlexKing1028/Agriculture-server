package agriculture.E_Model;

/**
 * Created by redrock on 15/12/23.
 */
public class Manufacturer extends BaseModel{
    int mid;
    String mname;
    String introduction;

    public Manufacturer(int mid, String mname, String introduction) {
        this.mid = mid;
        this.mname = mname;
        this.introduction = introduction;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
