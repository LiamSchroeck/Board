public class Utilities {
    public static void pause(int millis){
        try{
            Thread.sleep(millis);
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static int parseInt(String s, int ifInvalid){
        try{
            return Integer.parseInt(s);
        }catch(Exception e){
            return ifInvalid;
        }
    }
}
