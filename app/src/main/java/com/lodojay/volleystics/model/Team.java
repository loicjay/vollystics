/**
 *  Copyright (c) 2016, Loïc, Dominique, Jean-Pierre Jay. All rights reserved.
 */
package com.lodojay.volleystics.model;

import java.util.ArrayList;
import static java.util.Collections.unmodifiableList;
import java.util.List;
import static java.util.Objects.requireNonNull;

/**
 * Created by ljay on 15/10/2016.
 */

public class Team {
    public final long id;
    public final String name;
    public final List<Player> players;

    private Team(long id, String name) {
        this.id = id;
        this.name = requireNonNull(name);
        this.players = new ArrayList<>();
    }

    public void addPlayer(Player.Builder player) {
        players.add(player.team(this).build());
    }
    public static class Builder {

        private long id;
        private String name;

        private Builder(long id, String name) {
            this.id = id;
            this.name = name;
        }
        public static Builder create(String name) {
            return new Builder(-1, name);
        }
        public static Builder restore(long id,String name) {
            return new Builder(id, name);
        }

        public Team build() {

            return new Team(id, name);
        }
    }
}
