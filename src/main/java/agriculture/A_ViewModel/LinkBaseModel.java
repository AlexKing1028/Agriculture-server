package agriculture.A_ViewModel;

/**
 * Created by redrock on 15/12/20.
 */
public abstract class LinkBaseModel {

    Link link;

    public abstract Link getLink();

    public void setLink(Link link) {
        this.link = link;
    }
}
