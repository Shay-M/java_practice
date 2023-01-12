package bundle.out;

public class UserBundleOut implements OutputBundle {
    @Override
    public void writeText(final String line) {
        System.out.println(line);

    }
}
