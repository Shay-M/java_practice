import model.UrlBuilder;

public class BuilderDesignPattern {
    public static void main(String[] args) {

        UrlBuilder.Builder builder = new UrlBuilder.Builder();
        builder.hostname("dhfgh").port("fsdf");
        UrlBuilder urlBuilder = builder.build();

    }
}