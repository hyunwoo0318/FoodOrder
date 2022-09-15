package hyunwoo.FoodService.domain;

public enum MemberClass {
    OWNER("점주"),
    CUSTOMER("고객");

    private final String description;

    public String getDescription() {
        return description;
    }

    MemberClass(String description) {
        this.description = description;
    }
}
