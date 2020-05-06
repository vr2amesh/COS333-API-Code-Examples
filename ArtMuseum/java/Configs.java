public class Configs {

    public String base_url;
    public String objects;
    public String makers;
    public String packages;
    public String search;

    public Configs() {
        this.base_url = "https://data.artmuseum.princeton.edu";
        this.objects = "/objects/";
        this.makers = "/makers/";
        this.packages = "/packages/";
        this.search = "/search";
    }

    public static void main(String[] args) {
        Configs configs = new Configs();
        System.out.println(configs.base_url);
    }
}