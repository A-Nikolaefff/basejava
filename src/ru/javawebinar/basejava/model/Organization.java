package ru.javawebinar.basejava.model;

import java.util.List;
import java.util.Objects;

public class Organization {
    private final Link site;
    private final List<Position> positions;

    public Organization(Link site, List<Position> positions) {
        this.site = site;
        this.positions = positions;
    }

    public Link getSite() {
        return site;
    }

    public List<Position> getPositions() {
        return positions;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Position position : positions) {
            sb.append(position).append("\n");
        }
        return site.toString() + "\n" + sb;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return Objects.equals(site, that.site) && Objects.equals(positions, that.positions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(site, positions);
    }
}
