package hyunwoo.FoodService.domain;

import lombok.Data;

@Data
public class Review {
    private String id;
    private String comment;

    public Review() {
    }

    public Review(String id, String comment) {
        this.id = id;
        this.comment = comment;
    }
}
