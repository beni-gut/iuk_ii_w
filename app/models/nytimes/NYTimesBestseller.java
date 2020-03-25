package models.nytimes;

public class NYTimesBestseller {

    private String status;
    private String copyright;
    private Integer num_results;
    private NYTimesBestsellerResults results;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public Integer getNum_results() {
        return num_results;
    }

    public void setNum_results(Integer num_results) {
        this.num_results = num_results;
    }

    public NYTimesBestsellerResults getResults() {
        return results;
    }

    public void setResults(NYTimesBestsellerResults results) {
        this.results = results;
    }
}
