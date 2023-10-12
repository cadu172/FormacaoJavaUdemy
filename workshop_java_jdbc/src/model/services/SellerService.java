package model.services;

import java.util.List;

import model.dao.DAOFactory;
import model.dao.SellerDAOJDBC;
import model.entities.Seller;

public class SellerService {
	
	private SellerDAOJDBC sellerDAO = (SellerDAOJDBC) DAOFactory.createSellerDAO();
	
	public List<Seller> findAll() {
		return sellerDAO.findAll();		
	}
	
	public void saveOrUpdate(Seller seller) {
		if ( seller == null ) {
			throw new IllegalStateException("seller was null on SellerService.saveOrUpdate");
		}
		
		if ( seller.getId() == null ) {
			sellerDAO.insert(seller);
		}
		else {
			sellerDAO.update(seller);
		}
	}
	
	public void remove(Seller seller) {
		
		if ( seller == null ) {
			throw new IllegalStateException("SellerService.remove -> seller was null");
		}
		
		sellerDAO.deleteById(seller.getId());
				
	} 

}
