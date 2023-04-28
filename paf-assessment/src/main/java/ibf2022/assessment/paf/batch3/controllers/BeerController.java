package ibf2022.assessment.paf.batch3.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ibf2022.assessment.paf.batch3.models.Beer;
import ibf2022.assessment.paf.batch3.models.Brewery;
import ibf2022.assessment.paf.batch3.models.OrderDetails;
import ibf2022.assessment.paf.batch3.models.Style;
import ibf2022.assessment.paf.batch3.services.BeerService;

@Controller
@RequestMapping
public class BeerController {
	@Autowired
	BeerService beerService;
	
	//TODO Task 2 - view 0
	@GetMapping (path ="/") 
	public String loadHomePage (Model model) {
		List<Style> returnStyles = beerService.getStyles();

		model.addAttribute("styles", returnStyles);
		return "view0";
	}
	
	//TODO Task 3 - view 1
	@GetMapping (path = "/beer/style/{styleId}")
	public String getBreweriesPage (@PathVariable Integer styleId, @RequestParam String styleName, Model model) {

		List<Beer> beerList = beerService.getBreweriesByBeer(styleId);

		if (beerList.isEmpty()) {
			model.addAttribute("display", true);
            return "view1";
        }
		model.addAttribute("styleName", styleName);
		model.addAttribute("beerList", beerList);
		return "view1";
	}

	//TODO Task 4 - view 2
	@GetMapping (path = "/beer/brewery/{breweryId}")
	public String getBreweryDetails (@PathVariable Integer breweryId, @RequestParam String breweryName, Model model) {

		Optional<Brewery> brewery = beerService.getBeersFromBrewery(breweryId);

		if (brewery.isEmpty()) {
			model.addAttribute("display", true);
            return "view2";
        }
		model.addAttribute("breweryName", breweryName);
		model.addAttribute("breweryInfo", brewery.get());

		List<Beer> brewBeerList = beerService.getBrewBeerList(breweryId);
		
		model.addAttribute("BrewBeerList", brewBeerList);

		return "view2";
	}

	//TODO Task 5 - view 2, place order
	@PostMapping (path = "/brewery/{styleId}/order" , consumes = "application/x-www-form-urlencoded") 
	public String placeOrder( @RequestBody MultiValueMap<String, String> requestParams ,  @PathVariable Integer breweryId, Model model) {

		// retrieve Order datas from the post and add to OrderDetails
		OrderDetails orderDetails = new OrderDetails();

		Optional<Brewery> brewery = beerService.getBeersFromBrewery(breweryId);

		String placedOrder = beerService.placeOrder(orderDetails);



		return null;
	}

}
