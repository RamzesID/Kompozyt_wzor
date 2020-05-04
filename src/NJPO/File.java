package NJPO;

public class File extends Component {

    public File(String name, String type) {
        super(name);
        this.type = type;
}

    @Override
    public Component cd(String nameCat) {
        return this;
    }

    @Override
    public void dir() {
    }

}
