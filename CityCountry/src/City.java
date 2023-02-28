public class City {

    private String name;
    private String countryCode;
    private int population;

    private Country homeCountry;


    public City(String line) {
        String[] splitLine = line.split(",");
        this.name = splitLine[0];
        this.countryCode = splitLine[1];
        this.population = Integer.parseInt(splitLine[2]);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("City{");
        sb.append("name='").append(name).append('\'');
        sb.append(", countryCode='").append(countryCode).append('\'');
        sb.append(", population=").append(population);
        sb.append('}');
        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getPopulationPercentage() {
        if (population == 0 || getHomeCountry().getPopulation() == 0) {
            return -1;
        }
        return (double) population / getHomeCountry().getPopulation() * 100;
    }

    public Country getHomeCountry() {
        return homeCountry;
    }

    public void setHomeCountry(Country homeCountry) {
        this.homeCountry = homeCountry;
    }
}
