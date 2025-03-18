package comt.est_server.testserver.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collection;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Document(collection = "products")
public class Product implements Serializable{
    @Indexed(unique = true)
    private String title;
    private Double price;
    private String description;
    private String category;
    private String image;
    private RatingDTO rating;

    // Getters and setters

    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RatingDTO {
        private Double rate;
        private Integer count;

        // Getters and setters
//        public RatingDTO() {}
//
//        public RatingDTO(double rate, int count) {
//            this.rate = rate;
//            this.count = count;
//        }
//
//        public double getRate() { return rate; }
//        public int getCount() { return count; }
    }
}

