package NJPO;

import java.util.ArrayList;

public class Catalog extends Component {
        protected ArrayList<Component> fileSystem = new ArrayList<>();

        public Catalog(String name){
                super(name);
        }

        public void add(Component comp){
                comp.parent = this;
                fileSystem.add(comp);
        }

        @Override
        public Component cd(String nameCat) {
                for (Component s : fileSystem) {
                      if (s.name.equals(nameCat)) {
                            return s;
                      }
               }
                System.out.println("Nie odnalezionio sciezki");
                return this;
        }

        @Override
        public void dir(){
                for(Component s: fileSystem){
                        System.out.println("    " + s.name + s.type);
                }
        }
}
