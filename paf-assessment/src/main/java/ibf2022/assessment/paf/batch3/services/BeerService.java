package ibf2022.assessment.paf.batch3.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibf2022.assessment.paf.batch3.models.Beer;
import ibf2022.assessment.paf.batch3.models.Brewery;
import ibf2022.assessment.paf.batch3.models.OrderDetails;
import ibf2022.assessment.paf.batch3.models.Style;
import ibf2022.assessment.paf.batch3.repositories.BeerRepository;
import ibf2022.assessment.paf.batch3.repositories.OrderRepository;

@Service
public class BeerService {

	@Autowired
	BeerRepository beerRepository;
	@Autowired
	OrderRepository orderRepository;
	
	// DO NOT CHANGE THE METHOD'S NAME OR THE RETURN TYPE OF THIS METHOD
	public String placeOrder(OrderDetails orderDetails) {
		// TODO: Task 5 
		
		orderRepository.insertOrder(orderDetails);
		
		return "";
	}


	public List<Style> getStyles() {
		return beerRepository.getStyles();
	}

    public List<Beer> getBreweriesByBeer(Integer styleId) {
        return beerRepository.getBreweriesByBeer(styleId);
    }

    public Optional<Brewery> getBeersFromBrewery(Integer breweryId) {
        return beerRepository.getBeersFromBrewery(breweryId);
    }

    public List<Beer> getBrewBeerList(Integer breweryId) {
        return beerRepository.getBrewBeerList(breweryId);
    }

}
