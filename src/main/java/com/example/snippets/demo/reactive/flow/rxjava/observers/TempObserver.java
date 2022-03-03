package com.example.snippets.demo.reactive.flow.rxjava.observers;

import com.example.snippets.demo.reactive.flow.own.implementation.TempInfo;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class TempObserver implements Observer<TempInfo> {

    @Override
    public void onComplete() {
        System.out.println("Done!");
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("Got problem: " + throwable.getMessage());
    }

    @Override
    public void onSubscribe(Disposable disposable) {
    }

    @Override
    public void onNext(TempInfo tempInfo) {
        System.out.println(tempInfo);
    }
}