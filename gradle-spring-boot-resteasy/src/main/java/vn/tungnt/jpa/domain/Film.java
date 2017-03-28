package vn.tungnt.jpa.domain;

// Generated 17 Apr, 2015 4:50:05 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Film generated by hbm2java
 */
@Entity
@Table(name = "film", catalog = "sakila")
public class Film implements java.io.Serializable {

	private Short filmId;
	private Language languageByOriginalLanguageId;
	private Language languageByLanguageId;
	private String title;
	private String description;
	private Date releaseYear;
	private byte rentalDuration;
	private BigDecimal rentalRate;
	private Short length;
	private BigDecimal replacementCost;
	private String rating;
	private String specialFeatures;
	private Date lastUpdate;
	private Set<FilmActor> filmActors = new HashSet<FilmActor>(0);
	private Set<FilmCategory> filmCategories = new HashSet<FilmCategory>(0);
	private Set<Inventory> inventories = new HashSet<Inventory>(0);

	public Film() {
	}

	public Film(Language languageByLanguageId, String title,
			byte rentalDuration, BigDecimal rentalRate,
			BigDecimal replacementCost, Date lastUpdate) {
		this.languageByLanguageId = languageByLanguageId;
		this.title = title;
		this.rentalDuration = rentalDuration;
		this.rentalRate = rentalRate;
		this.replacementCost = replacementCost;
		this.lastUpdate = lastUpdate;
	}

	public Film(Language languageByOriginalLanguageId,
			Language languageByLanguageId, String title, String description,
			Date releaseYear, byte rentalDuration, BigDecimal rentalRate,
			Short length, BigDecimal replacementCost, String rating,
			String specialFeatures, Date lastUpdate, Set<FilmActor> filmActors,
			Set<FilmCategory> filmCategories, Set<Inventory> inventories) {
		this.languageByOriginalLanguageId = languageByOriginalLanguageId;
		this.languageByLanguageId = languageByLanguageId;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.rentalDuration = rentalDuration;
		this.rentalRate = rentalRate;
		this.length = length;
		this.replacementCost = replacementCost;
		this.rating = rating;
		this.specialFeatures = specialFeatures;
		this.lastUpdate = lastUpdate;
		this.filmActors = filmActors;
		this.filmCategories = filmCategories;
		this.inventories = inventories;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "film_id", unique = true, nullable = false)
	public Short getFilmId() {
		return this.filmId;
	}

	public void setFilmId(Short filmId) {
		this.filmId = filmId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "original_language_id")
	public Language getLanguageByOriginalLanguageId() {
		return this.languageByOriginalLanguageId;
	}

	public void setLanguageByOriginalLanguageId(
			Language languageByOriginalLanguageId) {
		this.languageByOriginalLanguageId = languageByOriginalLanguageId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "language_id", nullable = false)
	public Language getLanguageByLanguageId() {
		return this.languageByLanguageId;
	}

	public void setLanguageByLanguageId(Language languageByLanguageId) {
		this.languageByLanguageId = languageByLanguageId;
	}

	@Column(name = "title", nullable = false)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "description", length = 65535)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "release_year", length = 0)
	public Date getReleaseYear() {
		return this.releaseYear;
	}

	public void setReleaseYear(Date releaseYear) {
		this.releaseYear = releaseYear;
	}

	@Column(name = "rental_duration", nullable = false)
	public byte getRentalDuration() {
		return this.rentalDuration;
	}

	public void setRentalDuration(byte rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	@Column(name = "rental_rate", nullable = false, precision = 4)
	public BigDecimal getRentalRate() {
		return this.rentalRate;
	}

	public void setRentalRate(BigDecimal rentalRate) {
		this.rentalRate = rentalRate;
	}

	@Column(name = "length")
	public Short getLength() {
		return this.length;
	}

	public void setLength(Short length) {
		this.length = length;
	}

	@Column(name = "replacement_cost", nullable = false, precision = 5)
	public BigDecimal getReplacementCost() {
		return this.replacementCost;
	}

	public void setReplacementCost(BigDecimal replacementCost) {
		this.replacementCost = replacementCost;
	}

	@Column(name = "rating", length = 5)
	public String getRating() {
		return this.rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	@Column(name = "special_features", length = 54)
	public String getSpecialFeatures() {
		return this.specialFeatures;
	}

	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_update", nullable = false, length = 19)
	public Date getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "film")
	public Set<FilmActor> getFilmActors() {
		return this.filmActors;
	}

	public void setFilmActors(Set<FilmActor> filmActors) {
		this.filmActors = filmActors;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "film")
	public Set<FilmCategory> getFilmCategories() {
		return this.filmCategories;
	}

	public void setFilmCategories(Set<FilmCategory> filmCategories) {
		this.filmCategories = filmCategories;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "film")
	public Set<Inventory> getInventories() {
		return this.inventories;
	}

	public void setInventories(Set<Inventory> inventories) {
		this.inventories = inventories;
	}

}