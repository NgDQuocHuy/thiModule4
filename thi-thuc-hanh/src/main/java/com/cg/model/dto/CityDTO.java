package com.cg.model.dto;

import com.cg.model.City;
import com.cg.model.Country;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class CityDTO {

    private String id;

    @NotBlank(message = "Vui lòng nhập tên thành phố.")
    @Length(min = 3, max = 45, message = "Thấp nhất là 1 ký tự, nhiều nhất 45 ký tự")
    private String cityName;

    @NotBlank(message = "Vui lòng nhập diện tích")
    @Pattern(regexp = "^[0-9]+$", message = "Diện tích phải là số.")
    @Min(message = "Diện tích thấp nhất là 1m2", value = 1)
    private String area;

    @NotBlank(message = "Dân số không được để trống!")
    @Pattern(regexp = "^[0-9]+$", message = "Dân số phải là số.")
    @Min(message = "Dân số thấp nhất là 10 người", value = 10)
    private String population;

    @NotBlank(message = "GDP không được để trống!")
    @Pattern(regexp = "^[0-9]+$", message = "GDP phải là số.")
    @Min(message = "GDP thấp nhất là 1", value = 1)
    private String gdp;

    @NotBlank(message = "Vui lòng nhập giới thiệu.")
    @Length(min = 10, max = 100, message = "Mô tả thấp nhất là 10 ký tự, nhiều nhất là 100 ký tự")
    private String description;

    private CountryDTO country;

    public CityDTO(Long id, String cityName, Double area, Long population, Long gdp, String description, Country country) {
        this.id = id.toString();
        this.cityName = cityName;
        this.area = area.toString();
        this.population = population.toString();
        this.gdp = gdp.toString();
        this.description = description;
        this.country = country.toCountryDTO();
    }

    public City toCity() {
        return new City()
                .setId(Long.parseLong(id))
                .setCityName(cityName)
                .setArea(Double.parseDouble(area))
                .setPopulation(Long.parseLong(population))
                .setGdp(Long.parseLong(gdp))
                .setDescription(description)
                .setCountry(country.toCountry());
    }
}
