package efs.task.reflection.json;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.math.BigDecimal;
import java.util.Date;

/**
 * TODO: Użyj tu odpowiednich adnotacji z biblioteki Jackson
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({"ProductID", "ProductName", "ProductPrice", "DateOfProduction","DateOfExpiry"})
public class ProductDTO {
    @JsonProperty("ProductID")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;

    @JsonProperty("ProductName")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;

    @JsonProperty("ProductPrice")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BigDecimal price;

    @JsonProperty("DateOfExpiry")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date expiryDate;

    @JsonProperty("DateOfProduction")
    @JsonFormat(pattern = "yyyy-MM-dd@HH:mm:ss")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date productionDate;

    @JsonIgnore
    public Long getId() {
        return id;
    }

    @JsonIgnore
    public void setId(Long id) {
        this.id = id;
    }

    @JsonIgnore
    public String getName() {
        return name;
    }

    @JsonIgnore
    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public BigDecimal getPrice() {
        return price;
    }

    @JsonIgnore
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @JsonIgnore
    public Date getProductionDate() {
        return productionDate;
    }

    @JsonIgnore
    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    @JsonIgnore
    public Date getExpiryDate() {
        return expiryDate;
    }

    @JsonIgnore
    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", productionDate=" + productionDate +
                ", expiryDate=" + expiryDate +
                '}';
    }
}
