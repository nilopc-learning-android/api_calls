package com.nilportugues.simplewebapi.users.interactors;

import com.nilportugues.simplewebapi.shared.interactors.UseCase;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;

public class UserPokemonList extends UseCase {

    @Override
    protected Observable buildUseCaseObservable() {
        return Observable.create(
            new Observable.OnSubscribe<List>() {

                @Override
                public void call(Subscriber<? super List> subscriber) {
                    ArrayList<String> pokemon = new ArrayList<>();
                    pokemon.add("Bulbasaur");
                    pokemon.add("Charmander");
                    pokemon.add("Squirtle");


                    subscriber.onNext(pokemon);
                    subscriber.onCompleted();
                }
            }
        );
    }
}
