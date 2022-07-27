package com.cdackolkata.common;

import java.util.Date;
import org.hibernate.Session;
import com.cdackolkata.persistence.HibernateUtil;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Maven + Hibernate One-to-One example + MySQL");
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        session.beginTransaction();
        
        Stock stock = new Stock();
        
        stock.setStockCode("4717");
        stock.setStockName("CDACKolkata");
     
        StockDetail stockDetail = new StockDetail();
        stockDetail.setCompName("CDACKolkata");
        stockDetail.setCompDesc("Best R&D Training Institute");
        stockDetail.setListedDate(new Date());
        
        stock.setStockDetail(stockDetail);
        stockDetail.setStock(stock);
        
        session.save(stock);

        session.getTransaction().commit();
        
        
    }
}
