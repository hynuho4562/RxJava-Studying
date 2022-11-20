package com.hyun.rxjava_studying.ch01;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableEmitter;
import io.reactivex.rxjava3.core.FlowableOnSubscribe;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class _L11_FlowableSample {
    public static void main(String[] args) throws Exception {
        Flowable<String> flowable =
                Flowable.create(new FlowableOnSubscribe<String>() {
                    @Override
                    public void subscribe(@NonNull FlowableEmitter<String> emitter) throws Throwable {
                        String[] dataArray = { "Hello, World!", "안녕, RxJava!"};

                        for (String data: dataArray) {
                            if (emitter.isCancelled()) {
                                return;
                            } else {
                                emitter.onNext(data);
                            }

                            emitter.onComplete();
                        }
                    }
                }, BackpressureStrategy.BUFFER);

        flowable.observeOn(Schedulers.computation())
                .subscribe(new Subscriber<String>() {

                    private Subscription subscription;

                    @Override
                    public void onSubscribe(Subscription subscription) {
                        this.subscription = subscription;

                        this.subscription.request(1);
                    }

                    @Override
                    public void onNext(String data) {
                        String threadName = Thread.currentThread().getName();

                        System.out.println(threadName + ": " + data);

                        this.subscription.request(1);
                    }

                    @Override
                    public void onError(Throwable error) {
                        error.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        String threadName = Thread.currentThread().getName();
                        System.out.println(threadName + ": 완료");
                    }
                });

        Thread.sleep(500L);
    }
}
