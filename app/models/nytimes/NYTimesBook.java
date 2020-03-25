package models.nytimes;

import java.util.List;

public class NYTimesBook {

    private String age_group;
    private String amazon_product_url;
    private String article_chapter_link;
    private String author;
    private String book_image;
    private Integer book_image_width;
    private Integer book_image_height;
    private String book_review_link;
    private String contributor;
    private String contributor_note;
    private String created_date;
    private String description;
    private String first_chapter_link;
    private Double price;
    private String primary_isbn10;
    private String primary_isbn13;
    private String publisher;
    private Integer rank;
    private Integer rank_last_week;
    private String sunday_review_link;
    private String title;
    private String updated_date;
    private Integer weeks_on_list;
    private List<NYTimesBuyLinks> buy_links;

    public String getAge_group() {
        return age_group;
    }

    public void setAge_group(String age_group) {
        this.age_group = age_group;
    }

    public String getAmazon_product_url() {
        return amazon_product_url;
    }

    public void setAmazon_product_url(String amazon_product_url) {
        this.amazon_product_url = amazon_product_url;
    }

    public String getArticle_chapter_link() {
        return article_chapter_link;
    }

    public void setArticle_chapter_link(String article_chapter_link) {
        this.article_chapter_link = article_chapter_link;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBook_image() {
        return book_image;
    }

    public void setBook_image(String book_image) {
        this.book_image = book_image;
    }

    public Integer getBook_image_width() {
        return book_image_width;
    }

    public void setBook_image_width(Integer book_image_width) {
        this.book_image_width = book_image_width;
    }

    public Integer getBook_image_height() {
        return book_image_height;
    }

    public void setBook_image_height(Integer book_image_height) {
        this.book_image_height = book_image_height;
    }

    public String getBook_review_link() {
        return book_review_link;
    }

    public void setBook_review_link(String book_review_link) {
        this.book_review_link = book_review_link;
    }

    public String getContributor() {
        return contributor;
    }

    public void setContributor(String contributor) {
        this.contributor = contributor;
    }

    public String getContributor_note() {
        return contributor_note;
    }

    public void setContributor_note(String contributor_note) {
        this.contributor_note = contributor_note;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFirst_chapter_link() {
        return first_chapter_link;
    }

    public void setFirst_chapter_link(String first_chapter_link) {
        this.first_chapter_link = first_chapter_link;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPrimary_isbn10() {
        return primary_isbn10;
    }

    public void setPrimary_isbn10(String primary_isbn10) {
        this.primary_isbn10 = primary_isbn10;
    }

    public String getPrimary_isbn13() {
        return primary_isbn13;
    }

    public void setPrimary_isbn13(String primary_isbn13) {
        this.primary_isbn13 = primary_isbn13;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getRank_last_week() {
        return rank_last_week;
    }

    public void setRank_last_week(Integer rank_last_week) {
        this.rank_last_week = rank_last_week;
    }

    public String getSunday_review_link() {
        return sunday_review_link;
    }

    public void setSunday_review_link(String sunday_review_link) {
        this.sunday_review_link = sunday_review_link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(String updated_date) {
        this.updated_date = updated_date;
    }

    public Integer getWeeks_on_list() {
        return weeks_on_list;
    }

    public void setWeeks_on_list(Integer weeks_on_list) {
        this.weeks_on_list = weeks_on_list;
    }

    public List<NYTimesBuyLinks> getBuy_links() {
        return buy_links;
    }

    public void setBuy_links(List<NYTimesBuyLinks> buy_links) {
        this.buy_links = buy_links;
    }
}
