package eshopping.domain;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.NotEmpty;
import eshopping.domain.Customer;

@Entity
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class ShippingAddress implements Serializable {
	
	private static final long serialVersionUID = 989191150380037359L;


	@Id
	@GeneratedValue
	private int shippingAddressId;
	@NotEmpty(message="The street name must not be null")
	private String streetName;
	private String apartmentNumber;
	@NotEmpty(message="The city name must not be null")
	private String city;
	@NotEmpty(message="The state name must not be null")
	private String state;
	@NotEmpty(message="The country name must not be null")
	private String country;
	@NotEmpty(message="The zip code must not be null")
	@Pattern(regexp="[0-9]+", message="Wrong zip!")
	private String zipCode;
	
	@OneToOne
    @JoinColumn(name="customer_id")
	private Customer customer;
	
    public int getShippingAddressId() {
        return shippingAddressId;
    }

    public void setShippingAddressId(int shippingAddressId) {
        this.shippingAddressId = shippingAddressId;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "ShippingAddress{" +
                "streetName='" + streetName + '\'' +
                ", apartmentNumber='" + apartmentNumber + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
	
	

}
