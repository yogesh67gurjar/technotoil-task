package com.yogeshandroid.machinetest.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Country {
    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("countries")
    @Expose
    private List<Countries> countries;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<Countries> getCountries() {
        return countries;
    }

    public void setCountries(List<Countries> countries) {
        this.countries = countries;
    }


    public class Countries {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("country_id")
        @Expose
        private String countryId;
        @SerializedName("country_ISD")
        @Expose
        private String countryISD;
        @SerializedName("country_code")
        @Expose
        private String countryCode;
        @SerializedName("country_name")
        @Expose
        private String countryName;
        @SerializedName("file")
        @Expose
        private String file;
        @SerializedName("country_currency")
        @Expose
        private String countryCurrency;
        @SerializedName("is_active")
        @Expose
        private Integer isActive;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("recommendation")
        @Expose
        private String recommendation;
        @SerializedName("is_visible")
        @Expose
        private String isVisible;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getCountryId() {
            return countryId;
        }

        public void setCountryId(String countryId) {
            this.countryId = countryId;
        }

        public String getCountryISD() {
            return countryISD;
        }

        public void setCountryISD(String countryISD) {
            this.countryISD = countryISD;
        }

        public String getCountryCode() {
            return countryCode;
        }

        public void setCountryCode(String countryCode) {
            this.countryCode = countryCode;
        }

        public String getCountryName() {
            return countryName;
        }

        public void setCountryName(String countryName) {
            this.countryName = countryName;
        }

        public String getFile() {
            return file;
        }

        public void setFile(String file) {
            this.file = file;
        }

        public String getCountryCurrency() {
            return countryCurrency;
        }

        public void setCountryCurrency(String countryCurrency) {
            this.countryCurrency = countryCurrency;
        }

        public Integer getIsActive() {
            return isActive;
        }

        public void setIsActive(Integer isActive) {
            this.isActive = isActive;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public String getRecommendation() {
            return recommendation;
        }

        public void setRecommendation(String recommendation) {
            this.recommendation = recommendation;
        }

        public String getIsVisible() {
            return isVisible;
        }

        public void setIsVisible(String isVisible) {
            this.isVisible = isVisible;
        }

    }
}
