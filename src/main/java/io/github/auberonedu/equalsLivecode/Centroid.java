package io.github.auberonedu.equalsLivecode;

public class Centroid {
    private int r;
    private int c;
    private String name;
    
    public Centroid(int r, int c, String name) {
        this.r = r;
        this.c = c;
        this.name = name;
    }

    public int getR() {
        return r;
    }

    public int getC() {
        return c;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + r;
        result = prime * result + c;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Centroid other = (Centroid) obj;
        if (r != other.r)
            return false;
        if (c != other.c)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    
    // @Override
    // // allowed to access private fields of different objects in the same class
    // public boolean equals(Object o) {
    //     if (o == null) return false; // checking if o is null -- false
    //     if (getClass() != o.getClass()) return false; // checking if o is not a Centroid -- false

    //     Centroid other = (Centroid) o; // casting o as a Centroid

    //     // compare fields
    //     if(r != other.r) return false;
    //     if(c != other.c) return false;
    //     if(name == null){
    //         if (other.name == null) return true;
    //         if (other.name != null) return false;
    //     }
    //     if(!name.equals(other.name)) return false;

    //     return true;

    // }
}
