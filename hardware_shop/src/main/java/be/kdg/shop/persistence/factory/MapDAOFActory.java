package be.kdg.shop.persistence.factory;

import be.kdg.shop.persistence.dao.impl.MapStockDAO;
import be.kdg.shop.persistence.dao.impl.MapUserDAO;
import be.kdg.shop.persistence.dao.interfaces.StockDAO;
import be.kdg.shop.persistence.dao.interfaces.UserDAO;

public class MapDAOFActory extends DAOFactory
{

    @Override
    public UserDAO getUserDAO()
    {
        return new MapUserDAO();
    }

    @Override
    public StockDAO getStockDAO()
    {
        return new MapStockDAO();
    }

}
