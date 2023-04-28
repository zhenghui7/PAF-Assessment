package ibf2022.assessment.paf.batch3.repositories;

import static ibf2022.assessment.paf.batch3.repositories.DBQueries.*;

import java.security.spec.RSAPrivateCrtKeySpec;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import ibf2022.assessment.paf.batch3.models.Beer;
import ibf2022.assessment.paf.batch3.models.Brewery;
import ibf2022.assessment.paf.batch3.models.Style;

@Repository
public class BeerRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;


	// DO NOT CHANGE THE SIGNATURE OF THIS METHOD
	public List<Style> getStyles() {
		// TODO: Task 2
		SqlRowSet rs = jdbcTemplate.queryForRowSet(GET_BEER_STYLE);
		
		List<Style> styleList = new ArrayList<>();
		while (rs.next()) {
			styleList.add(Style.convertFromSqlRowSet(rs));
		}
		return styleList;
	}
		
	// DO NOT CHANGE THE METHOD'S NAME OR THE RETURN TYPE OF THIS METHOD
	public List<Beer> getBreweriesByBeer(Integer styleId) {
		// TODO: Task 3	
		SqlRowSet rs = jdbcTemplate.queryForRowSet(GET_BREWERIES, styleId);

		List<Beer> beerList = new ArrayList<>();
		while (rs.next()) {
			beerList.add(Beer.convertFromSqlRowSet(rs));
		}
		return beerList;
	}

	// DO NOT CHANGE THE METHOD'S NAME OR THE RETURN TYPE OF THIS METHOD
	public Optional<Brewery> getBeersFromBrewery(Integer breweryId) {
		// TODO: Task 4

		SqlRowSet rs = jdbcTemplate.queryForRowSet(GET_BREWERY_BY_ID, breweryId);
		List<Brewery> brewery = new ArrayList<>();
		
		while (rs.next()) {
            brewery.add(Brewery.createFromRs(rs));
        }

		if (brewery.isEmpty()) {
            return Optional.empty();
        }
        Brewery foundBrewery = brewery.get(0);
        return Optional.of(foundBrewery);
	}

	public List<Beer> getBrewBeerList(Integer breweryId) {

		SqlRowSet rs = jdbcTemplate.queryForRowSet(GET_NAME_DESCRIPT_BY_ID, breweryId);

		List<Beer> brewBeerList = new ArrayList<>();
		while (rs.next()) {
			brewBeerList.add(Beer.BeerListfromSqlRs(rs));
		}
		return brewBeerList;
	}
}
