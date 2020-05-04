package NJPO;

public abstract class Component {
    protected String name = "";
    protected String type = "";
    protected Catalog parent;

    public Component(String name){
        this.name = name;
    }

    public abstract Component cd(String nameCat);
    public abstract void dir();

}
