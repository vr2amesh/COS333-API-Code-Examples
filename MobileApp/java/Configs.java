public class Configs {

    private String consumer_key;
    private String consumer_secret;
    private String access_token;
    private String base_url;
    private String course_courses;
    private String course_terms;
    private String dining_locations;
    private String dining_events;
    private String dining_menu;
    private String places_open;
    private String events_events;
    private String refresh_token_url;
    
    public Configs() {
        this.consumer_key = "M8QxiCMNux9eIoINvQ96la7kbb0a";
        this.consumer_secret = "bG0jFnzEhdM3sfUlhBwRrZBpW6Ua";
        this.access_token = "MzFkNjRhNzEtNTRiNS0zNDkyLThiNDUtMjg5ZGVlODRhMDI1OmNvczMzM19zcHIyMDIwQGNhcmJvbi5zdXBlcg";
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