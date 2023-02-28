import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Country {

    private String codeName;
    private String name;
    private String continent;
    private String region;
    private double area;
    private int yearOfIndependence;
    private int population;
    private String headOfCountry;
    private List<City> cities;


    public Country(String line) {
        String[] splitLine = line.split(",");
        this.codeName = splitLine[0];
        this.name = splitLine[1];
        this.continent = splitLine[2];
        this.region = splitLine[3];
        this.area = Double.parseDouble(splitLine[4]);
        this.yearOfIndependence = splitLine[5].equals("NULL") ? 0 : Integer.parseInt(splitLine[5]);
        this.population = Integer.parseInt(splitLine[6]);
        if (splitLine.length >= 8) {
            this.headOfCountry = splitLine[7];
        } else {
            this.headOfCountry = "unknown";
        }
    }

    public double getRuralPopulation() {
        if (cities.size() == 0) {
            return -1;
        }
        double sumCityPopulations = 0;

        for (var city : cities) {
            sumCityPopulations += city.getPopulation();
        }
        return population-sumCityPopulations;
    }

    public double getPopulationDensity() {
        if (population == 0 || area == 0) {
            return -1;
        }
        return population / area;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Country{");
        sb.append("codeName='").append(codeName).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", continent='").append(continent).append('\'');
        sb.append(", region='").append(region).append('\'');
        sb.append(", field=").append(area);
        sb.append(", yearOfIndependence=").append(yearOfIndependence);
        sb.append(", population=").append(population);
        sb.append(", headOfCountry='").append(headOfCountry).append('\'');
        sb.append(", cities=").append(cities);
        sb.append('}');
        return sb.toString();
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getYearOfIndependence() {
        return yearOfIndependence;
    }

    public void setYearOfIndependence(int yearOfIndependence) {
        this.yearOfIndependence = yearOfIndependence;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getHeadOfCountry() {
        return headOfCountry;
    }

    public void setHeadOfCountry(String headOfCountry) {
        this.headOfCountry = headOfCountry;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        List<City> cityList = new ArrayList<>();
        for (var v : cities) {
            if (Objects.equals(v.getCountryCode(), this.codeName)) {
                cityList.add(v);
            }
        }
        this.cities = cityList;
    }



}
