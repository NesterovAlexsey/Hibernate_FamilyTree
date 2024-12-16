package tree.service;

import java.util.List;

import org.hibernate.Session;

import tree.dao.CountryDaoIf;
import tree.model.Country;

public class CountryService {
	
	private final CountryDaoIf countryDao;
	
	public CountryService(CountryDaoIf aCountryDao) 
	{
		this.countryDao = aCountryDao;
	}
	
	public void addCountry(Country aCountry, Session aSession) 
	{
		countryDao.save(aCountry, aSession);
	}
	
	public void updateCountry(Country aCountry)
	{
		countryDao.update(aCountry);
	}
	
	public void deleteCountry(Country aCountry)
	{
		countryDao.delete(aCountry);
	}
	
	public Country findCountry(Long aCountryId, Session aSession)
	{
		return countryDao.findById( aCountryId, aSession );
	}
	
	public List<Country> findAllCountries( Session aSession )
	{
		return countryDao.findAll( aSession );
	}
}
