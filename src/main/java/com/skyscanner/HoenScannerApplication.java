package com.skyscanner;
/*

package com.skyscanner;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.ArrayList; import java.util.List;
@Path("/search")
@Consumes (MediaType.APPLICATION_JSON) @Produces (MediaType.APPLICATION_JSON)
public class SearchResource {
2 usages
List<SearchResult> searchResults;
public SearchResource (List<SearchResult> searchResults) { this.searchResults = searchResults; }
@POST
public List<SearchResult> search (@NotNull @Valid Search search) {
List<SearchResult> response = new ArrayList<~>();
for (SearchResult result: searchResults) {
}
if (result.getCity().equals(search.getCity())) {
}
response.add(result);
return response;
}
}
 */

import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;

public class HoenScannerApplication extends Application<HoenScannerConfiguration> {

    public static void main(final String[] args) throws Exception {
        new HoenScannerApplication().run(args);
    }

    @Override
    public String getName() {
        return "hoen-scanner";
    }

    @Override
    public void initialize(final Bootstrap<HoenScannerConfiguration> bootstrap) {

    }

    
@Override
public void run(final HoenScannerConfiguration configuration, final Environment environment) throws IOException { ObjectMapper mapper = new ObjectMapper();
    List<SearchResult> carResults = Arrays.asList(
        mapper.readValue(
            getClass().getClassLoader().getResource(name: "rental_cars.json"),
            SearchResult[].class
            )
    );
    
    List<SearchResult> hotelResults = Arrays.asList(
        mapper.readValue(
            getClass().getClassLoader().getResource(name: "hotels.json"),
            SearchResult[].class
        )
    );
    List<SearchResult> searchResults = new ArrayList<>();
    searchResults.addAll(carResults);
    searchResults.addAll(hotelResults);
    final SearchResource resource = new SearchResource(searchResource);
    environment.jersey().register(resource);

}
