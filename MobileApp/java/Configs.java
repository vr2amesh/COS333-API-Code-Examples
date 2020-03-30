public class Configs {

    public String consumer_key;
    public String consumer_secret;
    public String access_token;
    public String base_url;
    public String course_courses;
    public String course_terms;
    public String dining_locations;
    public String dining_events;
    public String dining_menu;
    public String places_open;
    public String events_events;
    public String refresh_token_url;
    
    public Configs() {
        this.consumer_key = "M8QxiCMNux9eIoINvQ96la7kbb0a";
        this.consumer_secret = "bG0jFnzEhdM3sfUlhBwRrZBpW6Ua";
        this.access_token = "ZmFjNTdiN2UtY2VmYS0zZDRjLTgxZGYtOTk4MGNmM2MxZjE2OmNvczMzM19zcHIyMDIwQGNhcmJvbi5zdXBlcg==";
        this.base_url = "https://api.princeton.edu:443/mobile-app/1.0.0";
        this.course_courses = "/courses/courses";
        this.course_terms = "/courses/terms";
        this.dining_locations = "/dining/locations";
        this.dining_events = "/dining/events";
        this.dining_menu = "/dining/menu";
        this.places_open = "/places/open";
        this.events_events = "/events/events";
        this.refresh_token_url = "https://api.princeton.edu:443/token";
    }
    public static void main(String[] args) {
        Configs configs = new Configs();
        System.out.println(configs.consumer_key);
        System.out.println(configs.consumer_secret);
        System.out.println(configs.dining_events);
        System.out.println(configs.refresh_token_url);
    }
}