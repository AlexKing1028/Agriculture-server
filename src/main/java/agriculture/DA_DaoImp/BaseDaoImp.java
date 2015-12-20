package agriculture.DA_DaoImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.sql.DataSource;

/**
 * Created by redrock on 15/12/18.
 */
public abstract class BaseDaoImp extends JdbcDaoSupport{

    @Autowired
    public void dataSource(DataSource dataSource){
        super.setDataSource(dataSource);
    }
}
