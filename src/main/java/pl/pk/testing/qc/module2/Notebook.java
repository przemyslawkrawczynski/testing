package pl.pk.testing.qc.module2;

public class Notebook {

    public int weight; //?
    public int price;
    public int year;

    public Notebook(int weight, int price, int year) {
        this.weight = weight;
        this.price = price;
        this.year = year;
    }

    public String checkPrice() {

        String cheapInformation;

        if (this.price < 600) {
            cheapInformation = "this notebook is very cheap.";
        } else if (this.price < 1001) {
            cheapInformation = "The price is good";
        } else {
            cheapInformation = "This notebook is expensive.";
        }

        return cheapInformation;
    }

    public String prepareOpinion() {

        String opinion;

        if (this.price < 600 && this.year > 2019) {
            opinion = "this notebook is very cheap.";
        } else if (this.price < 1000 && this.year > 2018) {
            opinion = "The price is good";
        } else {
            opinion = "This notebook is expensive.";
        }

        return opinion;
    }


}
