package ibf2022.assessment.paf.batch3.repositories;

import java.util.UUID;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import ibf2022.assessment.paf.batch3.models.OrderDetails;

@Repository
public class OrderRepository {
    @Autowired
    MongoTemplate mongoTemplate;

    // TODO: Task 5
    public void insertOrder(OrderDetails orderDetails) {

        String orderId = UUID.randomUUID().toString().substring(0, 8);
        orderDetails.setOrderId(orderId);

        Document doc = new Document();
        doc = Document.parse(orderDetails.toJSONInsert().toString());
        Document newDoc = mongoTemplate.insert(doc, "reviews");

    }

}
