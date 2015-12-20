package agriculture.A_ViewModel;

/**
 * Created by redrock on 15/12/20.
 */
public class ViewUserDetail extends LinkBaseModel{
    long userid;
    String username;
    String phone;
    String email;

    public long getUserid() {
        return userid;
    }

    public String getUsername() {
        return username;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public ViewUserDetail(long userid, String username, String phone, String email) {
        this.userid = userid;
        this.username = username;
        this.phone = phone;
        this.email = email;
        link=new Link("self", "/user/"+userid);
    }
}
