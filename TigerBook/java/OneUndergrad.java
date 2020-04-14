public class OneUndergrad {
    public static void main(String[] args) {
        ReqLib reqLib = new ReqLib();

        try {
            /*
                Please put the netid you need for the
                parameter
            */
            String response = reqLib.getOneUndergrad("vramesh");
            System.out.println(response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}