import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        String cityFilepath = "C:\\Users\\Geri\\OneDrive\\Asztali gép\\OrszagVaros\\varosok.txt";
        String countryFilepath = "C:\\Users\\Geri\\OneDrive\\Asztali gép\\OrszagVaros\\Country.txt";

        String isoCode = "bel";
        String continentName = "South America";

        List<String> countryLines = WorldStatistics.readTxt(countryFilepath);
        List<String> cityLines = WorldStatistics.readTxt(cityFilepath);

        List<City> cities = new ArrayList<>();
        List<Country> countries = new ArrayList<>();

        for (String countryLine : countryLines) {
            countries.add(new Country(countryLine));
        }
        for (String cityLine : cityLines) {
            cities.add(new City(cityLine));
        }

        WorldStatistics worldCountries = new WorldStatistics(countries);

        for (var v : countries) {
            v.setCities(cities);
        }

        for (var country : countries) {
            for (City city : cities) {
                if (country.getCodeName().equals(city.getCountryCode())) {
                    city.setHomeCountry(country);
                }
            }
        }


        System.out.println(worldCountries.findCountryByISoCode(isoCode));

        for (var country : countries) {
            System.out.println("Orszag: " + country.getName() + " rural population: " + country.getRuralPopulation());
        }

        System.out.println(worldCountries.getCountriesOfContinent("Asia"));

        System.out.println(worldCountries.getCitiesOfCountry(isoCode));

        System.out.println(worldCountries.countAhmeds());

        System.out.println(worldCountries.getPopularFirstLetter());

        System.out.println(worldCountries.lastIndependentCountryCode());

        System.out.printf("%.2f\n", cities.get(300).getPopulationPercentage());
        System.out.println(cities.get(300).getHomeCountry().getName());

        for (var city : cities) {
            System.out.printf("%.2f", city.getPopulationPercentage());
            System.out.print(" %\n");
        }


        System.out.println(worldCountries.getCountries().get(35).getPopulationDensity());

    }
}