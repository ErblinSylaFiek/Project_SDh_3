public class Main {
    public static void main(String[] args) throws Exception {

        Thread serverThread = new Thread(() -> {
            try {
                Server.main(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        serverThread.start();

        Thread.sleep(1000);

        Client.main(null);
    }
}
