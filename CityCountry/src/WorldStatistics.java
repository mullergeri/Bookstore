import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public final class WorldStatistics {
    private final List<Country> countries;

    public WorldStatistics(List<Country> countries) {
        this.countries = countries;
    }


    public static List<String> readTxt(String filepath) throws IOException {
        List<String> lines = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filepath));
        while (br.ready()) {
            String line = br.readLine();
            lines.add(line);
        }
        return lines;
    }

    public Country findCountryByISoCode(String isoCode) {
        Country countryFound = null;
        for (var country : countries) {
            if (country.getCodeName().equals(isoCode.toUpperCase())) {
                countryFound = country;
            }
        }
        if (countryFound == null) {
            System.out.println("invalid country code.");
            return null;
        }
        return countryFound;
    }

    public List<String> getCountriesOfContinent(String continentName) {
        List<String> countryCodes = new ArrayList<>();
        for (var country : countries) {
            if (country.getContinent().equals(continentName)) {
                countryCodes.add(country.getCodeName());
            }
        }
        if (countryCodes.size() == 0) {
            System.out.println("nincs ilyen kontinens, vagy üres :).");
        }
        return countryCodes;
    }

    public Set<String> getCitiesOfCountry(String countryCode) {
        Set<String> citiesOfTheCountry = new HashSet<>();

        for (var country : countries) {
            if (country.getCodeName().equals(countryCode.toUpperCase())) {
                for (City city : country.getCities()) {
                    citiesOfTheCountry.add(city.getName());
                }
            }
        }
        return citiesOfTheCountry;
    }

    public int countAhmeds() {
        int counter = 0;
        for (var country : countries) {
            if (
                    country.getHeadOfCountry().toLowerCase().contains("ahmed")
                            || country.getHeadOfCountry().toLowerCase().contains("hamad")
                            || country.getHeadOfCountry().toLowerCase().contains("ahmad")
            ) {
                counter++;
            }
        }
        return counter;
    }

    public String getPopularFirstLetter() {

        List<Character> characterList = new ArrayList<>();
        for (char i = 'A'; i <= 'Z'; i++) {
            characterList.add(i);
        }

        String popularFirstLetter = "";

        int counter;
        int currentHighest = 0;

        for (Character character : characterList) {
            counter = 0;
            for (var country : countries) {
                if (country.getCodeName().charAt(0) == character) {
                    counter++;
                }
            }
            if (currentHighest < counter) {
                currentHighest = counter;
                popularFirstLetter = String.valueOf(character);
            }
        }
        return popularFirstLetter;
    }

    public String lastIndependentCountryCode() {
        String countryCode = "";
        int lastIndependentYear = Integer.MIN_VALUE;

        for (var country : countries) {
            if (country.getYearOfIndependence() != 0) {
                if (country.getYearOfIndependence() > lastIndependentYear) {
                    lastIndependentYear = country.getYearOfIndependence();
                    countryCode = country.getCodeName();
                }
            }
        }
        return countryCode;
    }

    public List<Country> countries() {
        return countries;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (WorldStatistics) obj;
        return Objects.equals(this.countries, that.countries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countries);
    }

    @Override
    public String toString() {
        return "WorldStatistics[" +
                "countries=" + countries + ']';
    }


    public List<Country> getCountries() {
        return countries;
    }
}
