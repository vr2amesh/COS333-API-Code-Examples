public class AllUndergrads {
    public static void main(String[] args) {
        ReqLib reqLib = new ReqLib();

        try {
            String response = reqLib.getAllUndergrads();
            System.out.println(response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}