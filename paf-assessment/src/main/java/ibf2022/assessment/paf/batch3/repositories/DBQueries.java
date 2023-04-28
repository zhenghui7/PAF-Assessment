package ibf2022.assessment.paf.batch3.repositories;

public class DBQueries {
    public static final String GET_BEER_STYLE = """
        SELECT s.id, s.style_name AS Style, COUNT(b.style_id) AS Beer_Count
        FROM styles AS s
        LEFT JOIN beers AS b
        ON s.id = b.style_id
        GROUP BY s.id, s.style_name
        ORDER BY Beer_Count DESC, Style ASC;
            """;
    public static final String GET_BREWERIES = """
        SELECT b.name as beerName, b.descript as beerDescription, b.id as beerId, b.brewery_id as breweryId, br.name as breweryName
        FROM beers AS b
        LEFT JOIN breweries AS br
        ON b.brewery_id = br.id
        WHERE b.style_id = ?
        ORDER BY beerName ASC;
            """;
    public static final String GET_BREWERY_BY_ID = "select * from breweries where id=?;";
            
    public static final String GET_NAME_DESCRIPT_BY_ID = """
        SELECT *
        from beers
        where brewery_id = ?
        ORDER BY name ASC;
            """;

            

    
    

}
