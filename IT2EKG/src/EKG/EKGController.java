package EKG;

public class EKGController implements EKGListener{

    public static void main(String[] args) {
        EKGSimulator generator = new EKGSimulator();
        EKGController ekgController = new EKGController();
        new Thread(generator).start();
        generator.register(ekgController);

    }

    @Override
    public void notify(EKGData data){
        System.out.println("Got Data" + data.getSample());
    }
}
