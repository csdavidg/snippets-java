package com.example.snippets.demo.reactive.flow.rxjava;

import com.example.snippets.demo.reactive.flow.own.implementation.TempInfo;
import com.example.snippets.demo.reactive.flow.rxjava.observers.TempObserver;
import io.reactivex.Observable;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static java.util.stream.Collectors.toList;

public class MainReactiveApplicationUsingJavaRX {

    public static void main(String[] args) {
        Observable<TempInfo> observable = getTemperature("New York");
        observable.blockingSubscribe(new TempObserver());

        Observable<TempInfo> observables = getCelsiusTemperatures(
                "New York", "Chicago", "San Francisco");
        observables.blockingSubscribe(new TempObserver());
    }

    public static Observable<TempInfo> getTemperature(String town) {
        return Observable.create(emitter ->
                Observable.interval(1, TimeUnit.SECONDS)
                        .subscribe(i -> {
                            if (!emitter.isDisposed()) {
                                if (i >= 5) {
                                    emitter.onComplete();
                                } else {
                                    try {
                                        emitter.onNext(TempInfo.fetch(town));
                                    } catch (Exception e) {
                                        emitter.onError(e);
                                    }
                                }
                            }
                        }));
    }

    public static Observable<TempInfo> getCelsiusTemperature(String town) {
        //The work that the map function does in the Observable class (RXJava) is analogous to the one that a Processor does (Java 9 Flow API)
        return getTemperature(town)
                .map(temp -> new TempInfo(temp.getTown(),
                        (temp.getTemp() - 32) * 5 / 9));
    }

    public static Observable<TempInfo> getCelsiusTemperatures(String... towns) {
        return Observable.merge(Arrays.stream(towns)
                .map(MainReactiveApplicationUsingJavaRX::getCelsiusTemperature)
                .collect(toList()));
    }

    public static Observable<TempInfo> getNegativeTemperature(String town) {
        return getCelsiusTemperature(town)
                .filter(temp -> temp.getTemp() < 0);
    }
}
