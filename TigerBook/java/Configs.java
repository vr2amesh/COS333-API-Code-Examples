public class Configs {

  public String key;
  public String username;
  public String agent;
  public String base_url;
  public String all_undergrads;

  public Configs() {
      this.key = "fcdc328dcf3deba5dd40fb7e95c07cb8";
      this.username = "cos333_spr2020";
      this.agent = "cos333APIcodeExamples";
      this.base_url = "https://tigerbook.herokuapp.com";
      this.all_undergrads = "/api/v1/undergraduates";
  }

  public static void main(String[] args) {
    Configs configs = new Configs();
    System.out.println(configs.key);
  }
}
