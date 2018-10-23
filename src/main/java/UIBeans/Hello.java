package UIBeans;

import javax.inject.Named;

@Named
public class Hello {

    final public String world = "Hello World!";

    public String getworld() {
        return world;
    }
}