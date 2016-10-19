/**
 * Copyright (c) 2016, Loïc, Dominique, Jean-Pierre Jay. All rights reserved.
 */
package com.lodojay.volleystics.model;

import static java.util.Objects.requireNonNull;

/**
 * Created by ljay on 15/10/2016.
 */
public class Player {
    public enum Role {HITTER, SETTER, MIDDLE_BLOCKER, LIBERO}

    public final long id;
    public final String name;
    public final Role role;
    public final Team team;


    private Player(long id, String name, Role role, Team team) {
        this.id = id;
        this.name = requireNonNull(name);
        this.role = requireNonNull(role);
        this.team = requireNonNull(team);
    }

    public static class Builder {

        private long id;
        private String name;
        private Role role;
        private Team team;

        private Builder(long id, String name, Role role) {
            this.name = name;
            this.role = role;
        }

        public static Builder create(String name, Role role) {
            return new Builder(-1, name, role);
        }

        public static Builder restore(long id, String name, Role role) {
            return new Builder(id, name, role);
        }

        public Builder team(Team team) {
            this.team = team;
            return this;
        }

        public Player build() {
            return new Player(-1, name, role, team);
        }
    }
}
