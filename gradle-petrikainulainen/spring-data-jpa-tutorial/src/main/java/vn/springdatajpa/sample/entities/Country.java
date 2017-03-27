package vn.springdatajpa.sample.entities;

// Generated 17 Apr, 2015 4:50:05 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Country generated by hbm2java
 */
@Entity
@Table(name = "country")
public class Country implements java.io.Serializable {

	private Short countryId;
	private String country;
	private Date lastUpdate;
	private Set<City> cities = new HashSet<City>(0);

	public Country() {
	}

	public Country(String country, Date lastUpdate) {
		this.country = country;
		this.lastUpdate = lastUpdate;
	}

	public Country(String country, Date lastUpdate, Set<City> cities) {
		this.country = country;
		this.lastUpdate = lastUpdate;
		this.cities = cities;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "country_id", unique = true, nullable = false)
	public Short getCountryId() {
		return this.countryId;
	}

	public void setCountryId(Short countryId) {
		this.countryId = countryId;
	}

	@Column(name = "country", nullable = false, length = 50)
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_update", nullable = false, length = 19)
	public Date getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "country")
	public Set<City> getCities() {
		return this.cities;
	}

	public void setCities(Set<City> cities) {
		this.cities = cities;
	}

}
