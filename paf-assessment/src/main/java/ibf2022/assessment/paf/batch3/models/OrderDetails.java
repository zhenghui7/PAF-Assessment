package ibf2022.assessment.paf.batch3.models;

import java.util.LinkedList;
import java.util.List;

import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObjectBuilder;

public class OrderDetails {
    private String orderId;
    private Long date;
    private int breweryId;
    private List<Order> order = new LinkedList<>();
    
    public OrderDetails() {
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public int getBreweryId() {
        return breweryId;
    }

    public void setBreweryId(int breweryId) {
        this.breweryId = breweryId;
    }

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "OrderDetails [orderId=" + orderId + ", date=" + date + ", breweryId=" + breweryId + ", order=" + order
                + "]";
    }

    public JsonObjectBuilder toJSONInsert() {
        
        JsonArrayBuilder JsArr = Json.createArrayBuilder();
		for (Order o : order) {
			JsArr.add(o.toJSONObjectBuilder());
		}

        return Json.createObjectBuilder()
                .add("orderId", this.orderId)
                .add("date", this.date)
                .add("breweryId", this.breweryId)
                .add("orders", JsArr);
    }

    
    
}
