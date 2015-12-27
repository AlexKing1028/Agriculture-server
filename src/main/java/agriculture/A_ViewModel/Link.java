package agriculture.A_ViewModel;

/**
 * Created by redrock on 15/12/20.
 */
public class Link {
    String rel;
    String herf;

    public String getRel() {
        return rel;
    }

    public String getHerf() {
        return herf;
    }

    public Link(String rel, String herf) {

        this.rel = rel;
        this.herf = herf;
    }
}
