package tree.service;

import java.util.List;

import tree.dao.CountryDaoIf;
import tree.model.Country;

public class CountryService {
	
	private final CountryDaoIf countryDao;
	
	public CountryService(CountryDaoIf aCountryDao) 
	{
		this.countryDao = aCountryDao;
	}
	
	public void addCountry(Country aCountry) 
	{
		countryDao.save(aCountry);
	}
	
	public void updateCountry(Country aCountry)
	{
		countryDao.update(aCountry);
	}
	
	public void deleteCountry(Country aCountry)
	{
		countryDao.delete(aCountry);
	}
	
	public Country findCountry(Long aCountryId)
	{
		return countryDao.findById( aCountryId );
	}
	
	public List<Country> findAllCountries()
	{
		return countryDao.findAll();
	}
}
