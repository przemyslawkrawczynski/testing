package pl.pk.testing.qc.collections.adv.maps;

import java.util.Objects;

public class Principal {

    private String principalName;

    public Principal(String principalName) {
        this.principalName = principalName;
    }

    public String getPrincipalName() {
        return principalName;
    }

    public void setPrincipalName(String principalName) {
        this.principalName = principalName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Principal principal = (Principal) o;
        return Objects.equals(getPrincipalName(), principal.getPrincipalName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPrincipalName());
    }
}
