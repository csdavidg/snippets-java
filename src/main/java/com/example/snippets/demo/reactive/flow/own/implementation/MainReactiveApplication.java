package com.example.snippets.demo.reactive.flow.own.implementation;

import com.example.snippets.demo.reactive.flow.own.implementation.processors.TempProcessor;
import com.example.snippets.demo.reactive.flow.own.implementation.subscribers.TempSubscriber;
import com.example.snippets.demo.reactive.flow.own.implementation.subscriptions.TempSubscription;

import java.util.concurrent.Flow;

public class MainReactiveApplication {

    public static void main(String[] args) {
        /*TempProcessor tempProcessor = new TempProcessor();
        tempProcessor.subscribe(new TempSubscriber());
        getTemperatures("Colombia").subscribe(tempProcessor);*/

        getCelsiusTemperatures("Colombia").subscribe(new TempSubscriber());

        getTemperatures("New York").subscribe(new TempSubscriber());
    }

    private static Flow.Publisher<TempInfo> getTemperatures(final String town) {
        /*new Flow.Publisher<TempInfo>() {
            @Override
            public void subscribe(Flow.Subscriber<? super TempInfo> subscriber) {
                subscriber.onSubscribe(new TempSubscription(subscriber, town));
            }
        };*/
        return (subscriber) -> subscriber.onSubscribe(new TempSubscription(subscriber, town));
    }

    public static Flow.Publisher<TempInfo> getCelsiusTemperatures(String town) {
        return tempSubscriber -> {
            TempProcessor processorSubscriber = new TempProcessor();
            processorSubscriber.subscribe(tempSubscriber);
            processorSubscriber.onSubscribe(new TempSubscription(processorSubscriber, town));
        };
    }



}
