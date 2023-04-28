package ibf2022.assessment.paf.batch3.models;

import jakarta.json.Json;
import jakarta.json.JsonObjectBuilder;
import jakarta.json.JsonValue;

public class Order {
    private int beerId;
    private int quantity;
    
    public Order() {
    }

    public int getBeerId() {
        return beerId;
    }

    public void setBeerId(int beerId) {
        this.beerId = beerId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order [beerId=" + beerId + ", quantity=" + quantity + "]";
    }

    public JsonObjectBuilder toJSONObjectBuilder() {
        return Json.createObjectBuilder()
                    .add("beerId", this.beerId)
                    .add("quantity", this.quantity);
    }

    
}
